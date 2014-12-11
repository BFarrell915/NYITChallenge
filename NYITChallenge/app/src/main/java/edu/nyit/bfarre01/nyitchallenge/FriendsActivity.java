package edu.nyit.bfarre01.nyitchallenge;

import android.app.Activity;
import android.app.ListActivity;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class FriendsActivity extends ListActivity {
    private List<ListViewItem> mItems;        // ListView items list

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_friends);

        // initialize the items list
        mItems = new ArrayList<ListViewItem>();
        Resources resources = getResources();

        mItems.add(new ListViewItem(resources.getDrawable(R.drawable.ic_user_pizza), getString(R.string.friend1), getString(R.string.completed1)));
        mItems.add(new ListViewItem(resources.getDrawable(R.drawable.ic_user_gingerbread), getString(R.string.friend2), getString(R.string.completed2)));
        mItems.add(new ListViewItem(resources.getDrawable(R.drawable.ic_user_leaf), getString(R.string.friend3), getString(R.string.completed3)));

        // initialize and set the list adapter
        setListAdapter(new ListViewAdapter(this, mItems));

        getActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.friends, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        switch (item.getItemId()) {
            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        // retrieve theListView item
        ListViewItem item = mItems.get(position);

        // do something
        Toast.makeText(this, item.title, Toast.LENGTH_SHORT).show();
    }
}
