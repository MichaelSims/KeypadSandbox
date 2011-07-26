package com.example.msims.keypad;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class HostFragment extends Fragment {

    private TextView warpMeToHalifax;

    @Override
    public void onAttach(final Activity activity) {
        super.onAttach(activity);
        Log.e("flubber", "I was attached");
    }

    @Override
    public View onCreateView(final LayoutInflater inflater, final ViewGroup container, final Bundle savedInstanceState) {
        View layout = inflater.inflate(R.layout.host_fragment, container, false);

        warpMeToHalifax = (TextView) layout.findViewById(R.id.warpMeToHalifax);
        warpMeToHalifax.setOnClickListener(new View.OnClickListener() {
            public void onClick(final View view) {
                promptForAnyPlayPinBeforeExecuting(getFragmentManager(), new Runnable() {
                    public void run() {
                        warpMeToHalifax.setText("OMG YOU DID IT YOU ARE THE BEST!!");
                    }
                });
            }
        });
        return layout;
    }

    public static void promptForAnyPlayPinBeforeExecuting(final FragmentManager fragmentManager, final Runnable runnable) {
        PinKeypadFragment fragment = new PinKeypadFragment();
        Bundle bundle = new Bundle();
        bundle.putString(PinKeypadFragment.Arguments.pinToMatchAgainst.toString(), "8675"); //TODO get a real PIN, not a fake one :-P
        fragment.setArguments(bundle);

        fragment.setPinVerifiedListener(new PinKeypadFragment.PinVerifiedListener() {
            public void onPinVerified() {
                runnable.run();
            }
        });

        FragmentTransaction ft = fragmentManager.beginTransaction();
        ft.addToBackStack(null);
        fragment.show(ft, "dialog");
    }

}
