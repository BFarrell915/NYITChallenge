package edu.nyit.bfarre01.nyitchallenge;

import android.app.ActionBar;
import android.app.Fragment;
import android.app.FragmentTransaction;

/**
 * Created by Bryan on 10/25/14.
 */
public class tabListener implements ActionBar.TabListener {
    private Fragment fragment;

    public tabListener(Fragment fragment) {
        this.fragment = fragment;
    }

    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction FT) {
        FT.replace(R.id.fragment_container, fragment);
    }

    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction FT) {
        FT.remove(fragment);
    }

    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction FT) {
        // nothing
    }
}
