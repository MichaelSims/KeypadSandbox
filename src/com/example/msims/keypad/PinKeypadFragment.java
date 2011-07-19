package com.example.msims.keypad;

import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

public class PinKeypadFragment extends DialogFragment implements NumericKeypad.KeyPressedListener {

    private static final String PIN_BUFFER_KEY = "pinBuffer";
    private String pinBuffer = "";

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
        return layout;
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
            pinBuffer += key;
        } else if (pinBuffer.length() > 0) { //Handle backspace if pinBuffer isn't empty
            pinBuffer = pinBuffer.substring(0, pinBuffer.length() - 1);
        }
    }
}
