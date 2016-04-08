package com.cts.mybudget;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.Arrays;
import java.util.List;

public class ItemListingActivity extends AppCompatActivity {

    ListView itemsListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_listing);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Resources resources = getResources ();

        String title = resources.getString(R.string.app_name_display) + "-" +
                resources.getString (R.string.title_activity_item_listing);

        setTitle(title);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        itemsListView = (ListView) findViewById (R.id.itemsListView);

        /*ArrayAdapter<CharSequence> itemsAdapter = ArrayAdapter.createFromResource(this, R.array.items,
                android.R.layout.simple_list_item_checked);
*/
        List<CharSequence> itemsData = Arrays.asList(resources.getTextArray(R.array.items));

        MyCustomAdapter myCustomAdapter = new MyCustomAdapter (this, itemsData);

        itemsListView.setAdapter (myCustomAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu (Menu menu) {
        getMenuInflater ().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        switch (id) {
            case R.id.action_settings:
                return true;

            case R.id.search:
                Snackbar.make (itemsListView, "Under Construction", Snackbar.LENGTH_LONG).show ();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
