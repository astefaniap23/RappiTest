package com.example.aportillo.rappitest.views;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.aportillo.rappitest.R;
import com.example.aportillo.rappitest.models.ListData;

/**
 * Created by aportillo on 27/09/2016.
 */
public class MainActivity extends AppCompatActivity {
    ListData value;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            value = (ListData) getIntent().getSerializableExtra("listData");
        }

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        RecyclerView recList = (RecyclerView) findViewById(R.id.recyclerView);
        recList.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        recList.setLayoutManager(llm);
       /* recList.addOnItemTouchListener(new RecyclerView.OnItemTouchListener() {
                                           @Override
                                           public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {
                                               Log.i("onInterceptTouchEvent"+rv.toString(), e.toString());
                                               return false;
                                           }

                                           @Override
                                           public void onTouchEvent(RecyclerView rv, MotionEvent e) {
                                               Log.i("onTouchEvent"+rv.toString(), e.toString());
                                           }

                                           @Override
                                           public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {
                                               Log.i("disallowIntercept", String.valueOf(disallowIntercept));
                                           }
                                       }

        );*/


        CardViewAdapter ca = new CardViewAdapter(value.getData().getChildrenList());
        recList.setAdapter(ca);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


}
