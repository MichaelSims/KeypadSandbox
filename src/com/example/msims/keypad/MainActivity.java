package com.example.msims.keypad;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends FragmentActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.add(new PinKeypadFragment(), null);
        ft.commit();
    }

}
