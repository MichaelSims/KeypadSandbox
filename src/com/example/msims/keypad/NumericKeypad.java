package com.example.msims.keypad;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Map;

public class NumericKeypad extends RelativeLayout {

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
        LayoutInflater.from(context);
        init(context);
    }

    private void init(final Context context) {
        final LayoutInflater layoutInflater = LayoutInflater.from(context);
        layoutInflater.inflate(R.layout.numeric_keypad, this, true);

        final Integer[] buttons = {R.id.keypadZero, R.id.keypadOne, R.id.keypadTwo, R.id.keypadThree, R.id.keypadFour,
                                   R.id.keypadFive, R.id.keypadSix, R.id.keypadSeven, R.id.keypadEight, R.id.keypadNine};

        final OnClickListener listener = new OnClickListener() {
            public void onClick(final View view) {
                final Toast toast = Toast.makeText(context, view.getTag().toString(), Toast.LENGTH_SHORT);
                toast.show();
            }
        };
        for (Integer viewId : buttons) {
            TextView view = (TextView) findViewById(viewId);
            view.setTag(view.getText());
            view.setOnClickListener(listener);
        }
        View backspaceButton = findViewById(R.id.keypadBackspace);
        backspaceButton.setTag("backspace");
        backspaceButton.setOnClickListener(listener);
    }

}
