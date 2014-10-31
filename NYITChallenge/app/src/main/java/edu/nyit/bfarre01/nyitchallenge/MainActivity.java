package edu.nyit.bfarre01.nyitchallenge;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.view.Menu;
import android.view.MenuItem;

import edu.nyit.bfarre01.nyitchallenge.R;

public class MainActivity extends FragmentActivity {

    MainPagerAdapter mainPagerAdapter;
    ViewPager mainViewPager;

    //android.app.Fragment feedFragment = new FeedFragment();
    //android.app.Fragment trendingFragment = new TrendingFragment();
    //android.app.Fragment challengeFragment = new ChallengeFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        final ActionBar actionBar = getActionBar();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // ViewPager and its adapters use support library
        // fragments, so use getSupportFragmentManager.
        mainPagerAdapter = new MainPagerAdapter(getSupportFragmentManager());
        mainViewPager = (ViewPager) findViewById(R.id.pager);
        mainViewPager.setAdapter(mainPagerAdapter);

        mainViewPager = (ViewPager) findViewById(R.id.pager);
        mainViewPager.setOnPageChangeListener(
                new ViewPager.SimpleOnPageChangeListener() {
                    @Override
                    public void onPageSelected(int position) {
                        // When swiping between pages, select the
                        // corresponding tab.
                        getActionBar().setSelectedNavigationItem(position);
                    }
                });

        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

        ActionBar.TabListener tabListener = new ActionBar.TabListener() {

            @Override
            public void onTabSelected(ActionBar.Tab tab, android.app.FragmentTransaction fragmentTransaction) {
                mainViewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(ActionBar.Tab tab, android.app.FragmentTransaction fragmentTransaction) {

            }

            @Override
            public void onTabReselected(ActionBar.Tab tab, android.app.FragmentTransaction fragmentTransaction) {
                // nothing
            }
        };

        actionBar.addTab(actionBar.newTab().setText("TRENDING").setTabListener(tabListener));
        actionBar.addTab(actionBar.newTab().setText("FEED").setTabListener(tabListener));
        actionBar.addTab(actionBar.newTab().setText("CHALLENGE").setTabListener(tabListener));
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        switch (item.getItemId()) {
            case R.id.action_settings: {
                Intent intent = new Intent(this, SettingsActivity.class);
                startActivity(intent);
                return true;
            }
            case R.id.action_profile: {
                Intent intent = new Intent(this, ProfileActivity.class);
                startActivity(intent);
                return true;
            }
            case R.id.action_friends: {
                Intent intent = new Intent(this, FriendsActivity.class);
                startActivity(intent);
                return true;
            }
        }

        return super.onOptionsItemSelected(item);
    }
}

