package edu.nyit.bfarre01.nyitchallenge;

import android.app.ActionBar;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;


public class MainActivity extends Activity {

    ActionBar.Tab feedTab, trendingTab, challengeTab;

    Fragment feedFragment = new FeedFragment();
    Fragment trendingFragment = new TrendingFragment();
    Fragment challengeFragment = new ChallengeFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActionBar actionBar = getActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
        actionBar.setDisplayShowTitleEnabled(false);

        feedTab = actionBar.newTab().setText("Feed");
        trendingTab = actionBar.newTab().setText("Trend");
        challengeTab = actionBar.newTab().setText("Chall");

        feedTab.setTabListener(new tabListener(feedFragment));
        trendingTab.setTabListener(new tabListener(trendingFragment));
        challengeTab.setTabListener(new tabListener(challengeFragment));

        actionBar.addTab(feedTab);
        actionBar.addTab(trendingTab);
        actionBar.addTab(challengeTab);
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
