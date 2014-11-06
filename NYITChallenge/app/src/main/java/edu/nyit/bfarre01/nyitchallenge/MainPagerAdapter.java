package edu.nyit.bfarre01.nyitchallenge;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class MainPagerAdapter extends FragmentPagerAdapter {
    public MainPagerAdapter(FragmentManager fm) {
        super(fm);
    }
    private static int num_pages = 3;

    @Override
    public android.support.v4.app.Fragment getItem(int position) {
        switch (position) {
            case 0: // Fragment # 0 - This will show FirstFragment
                return TrendingFragment.newInstance(0, "Page # 1");
            case 1: // Fragment # 0 - This will show FirstFragment different title
                return FeedFragment.newInstance(1, "Page # 2");
            case 2: // Fragment # 1 - This will show SecondFragment
                return ChallengesFragment.newInstance(2, "Page # 3");
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return num_pages;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "TRENDING";
            case 1:
                return "FEED";
            case 2:
                return "CHALLENGE";
            default:
                return null;
        }
    }
}
