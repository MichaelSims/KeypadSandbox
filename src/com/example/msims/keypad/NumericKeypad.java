package com.example.msims.keypad;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class NumericKeypad extends RelativeLayout {

    private KeyPressedListener keyPressedListener;

    public NumericKeypad(final Context context) {
        super(context);
        init(context);
    }

    public NumericKeypad(final Context context, final AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public NumericKeypad(final Context context, final AttributeSet attrs, final int defStyle) {
        super(context, attrs, defStyle);
        init(context);
    }

    private void init(final Context context) {
        final LayoutInflater layoutInflater = LayoutInflater.from(context);
        layoutInflater.inflate(R.layout.numeric_keypad, this, true);

        final Integer[] buttons = {R.id.keypadZero, R.id.keypadOne, R.id.keypadTwo, R.id.keypadThree, R.id.keypadFour,
                                   R.id.keypadFive, R.id.keypadSix, R.id.keypadSeven, R.id.keypadEight, R.id.keypadNine};

        final OnClickListener listener = new OnClickListener() {
            public void onClick(final View view) {
                if (keyPressedListener != null) {
                    keyPressedListener.onKeyPressed(view.getTag() != null ? view.getTag().toString() : null);
                }
            }
        };
        for (Integer viewId : buttons) {
            TextView view = (TextView) findViewById(viewId);
            view.setTag(view.getText());
            view.setOnClickListener(listener);
        }
        View backspaceButton = findViewById(R.id.keypadBackspace);
        backspaceButton.setOnClickListener(listener);
    }

    public void setKeyPressedListener(final KeyPressedListener keyPressedListener) {
        this.keyPressedListener = keyPressedListener;
    }

    public interface KeyPressedListener {
        /**
         * Listener method called when a key is pressed on the keypad
         *
         * @param key The string value of the key pressed, or null if backspace was pressed.
         */
        void onKeyPressed(String key);
    }

}
