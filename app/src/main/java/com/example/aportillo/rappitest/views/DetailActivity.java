package com.example.aportillo.rappitest.views;

import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.view.View;
import android.widget.TextView;
import com.example.aportillo.rappitest.R;
import com.example.aportillo.rappitest.util.UtilImage;

public class DetailActivity extends AppCompatActivity {

    TextView textViewDetail;
    Toolbar toolbar;
    FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        loadResources();

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String value = (String) getIntent().getSerializableExtra("description");
            String iconImg = (String) getIntent().getSerializableExtra("iconImg");
            fab.setBackgroundDrawable(UtilImage.loadImageFromURL(iconImg));
            toolbar.setTitle("Pba");
            //  toolbar.setLogo();
            textViewDetail.setText((Html.fromHtml(value)));
            /*getSupportActionBar().setLogo(R.drawable.common_full_open_on_phone);
            getSupportActionBar().setDisplayUseLogoEnabled(true);*/
            //   dataChildren.setTitle((String) getIntent().getSerializableExtra("title"));
        }
    }

    public void loadResources() {
        textViewDetail = (TextView) findViewById(R.id.textViewDetail);
    }
}
