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

        findViewById(R.id.warpMeToHalifax).setOnClickListener(new View.OnClickListener() {
            public void onClick(final View view) {
                PinKeypadFragment fragment = new PinKeypadFragment();

                Bundle bundle = new Bundle();
                bundle.putString(PinKeypadFragment.Arguments.pinToMatchAgainst.toString(), "8675");
                fragment.setArguments(bundle);
                
                FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                ft.addToBackStack(null);
                fragment.show(ft, "dialog");
            }
        });
    }

}
