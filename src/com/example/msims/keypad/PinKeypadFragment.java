package com.example.msims.keypad;

import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

public class PinKeypadFragment extends DialogFragment implements NumericKeypad.KeyPressedListener {

    @Override
    public void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

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

    public void onKeyPressed(final String key) {
        Toast.makeText(getActivity(), key, Toast.LENGTH_SHORT).show();
    }
}
