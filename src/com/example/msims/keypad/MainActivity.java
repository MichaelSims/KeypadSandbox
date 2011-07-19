package com.example.msims.keypad;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends Activity implements NumericKeypad.KeyPressedListener {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        NumericKeypad keypad = (NumericKeypad) findViewById(R.id.keypad);
        keypad.setKeyPressedListener(this);
    }

    public void onKeyPressed(final String key) {
        Toast.makeText(this, key, Toast.LENGTH_SHORT).show();
    }
}
