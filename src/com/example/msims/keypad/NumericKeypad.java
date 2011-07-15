package com.example.msims.keypad;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.RelativeLayout;

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

    private void init(Context context) {
        final LayoutInflater layoutInflater = LayoutInflater.from(context);
        layoutInflater.inflate(R.layout.numeric_keypad, this, true);
    }

}
