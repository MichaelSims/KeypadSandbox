package com.example.msims.keypad;

import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Checkable;

public class PinKeypadFragment extends DialogFragment implements NumericKeypad.KeyPressedListener {

    public static final  int    PIN_BUFFER_MAX_LENGTH = 4;
    private static final String PIN_BUFFER_KEY        = "pinBuffer";

    private String pinBuffer = "";
    private Checkable[] pinBoxes;

    @Override
    public void onCreate(final Bundle savedInstanceState) {
        Log.e("flubber", "I was created!");
        super.onCreate(savedInstanceState);

        if (savedInstanceState != null) {
            pinBuffer = savedInstanceState.getString(PIN_BUFFER_KEY);
            Log.e("flubber", "pinBuffer is " + pinBuffer);
        }

        /* Disable any automatic styling */
        setStyle(android.app.DialogFragment.STYLE_NO_FRAME, 0);
    }

    @Override
    public View onCreateView(final LayoutInflater inflater, final ViewGroup container, final Bundle savedInstanceState) {
        View layout = inflater.inflate(R.layout.pin_keypad, container, false);

        ((NumericKeypad) layout.findViewById(R.id.keypad)).setKeyPressedListener(this);
        layout.findViewById(R.id.cancelButton).setOnClickListener(new View.OnClickListener() {
            public void onClick(final View view) {
                dismiss();
            }
        });

        pinBoxes = new Checkable[]{(Checkable) layout.findViewById(R.id.pinBoxOne), (Checkable) layout.findViewById(R.id.pinBoxTwo),
                                   (Checkable) layout.findViewById(R.id.pinBoxThree), (Checkable) layout.findViewById(R.id.pinBoxFour)};
        refreshPinBoxesState();

        return layout;
    }

    public void refreshPinBoxesState() {
        for (int i = 0; i < pinBoxes.length; i++) {
            pinBoxes[i].setChecked(i < pinBuffer.length());
        }
    }

    @Override
    public void onSaveInstanceState(final Bundle outState) {
        super.onSaveInstanceState(outState);
        if (pinBuffer != null) {
            outState.putString(PIN_BUFFER_KEY, pinBuffer);
        }
    }

    public void onKeyPressed(final String key) {
        if (key != null) {
            if (pinBuffer.length() < PIN_BUFFER_MAX_LENGTH) {
                pinBuffer += key;
            }
        } else if (pinBuffer.length() > 0) { //Handle backspace if pinBuffer isn't empty
            pinBuffer = pinBuffer.substring(0, pinBuffer.length() - 1);
        }
        refreshPinBoxesState();
    }
}
