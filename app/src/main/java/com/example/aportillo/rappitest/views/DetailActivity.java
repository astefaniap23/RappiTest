package com.example.aportillo.rappitest.views;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.view.View;
import android.widget.TextView;

import com.example.aportillo.rappitest.R;
import com.example.aportillo.rappitest.util.UtilImage;
import com.example.aportillo.rappitest.util.constans.RestApi;

public class DetailActivity extends AppCompatActivity {

    TextView textViewDetail;
    //Toolbar toolbar;
    FloatingActionButton fab;
    String value, iconImg, headerTitle, url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            value = (String) getIntent().getSerializableExtra("description");
            iconImg = (String) getIntent().getSerializableExtra("iconImg");
            headerTitle = (String) getIntent().getSerializableExtra(("headerTitle"));
            url = (String) getIntent().getSerializableExtra(("url"));

        }

        loadResources();
        setTitle(headerTitle);

        setSupportActionBar(toolbar);
        textViewDetail.setText((Html.fromHtml(value)));
        fab.setImageDrawable(UtilImage.loadImageFromURL(iconImg));

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intentUrl(url);
            }
        });
            /*getSupportActionBar().setLogo(R.drawable.common_full_open_on_phone);
            getSupportActionBar().setDisplayUseLogoEnabled(true);
          dataChildren.setTitle((String) getIntent().getSerializableExtra("title"));*/

    }

    public void loadResources() {
        textViewDetail = (TextView) findViewById(R.id.textViewDetail);
        fab = (FloatingActionButton) findViewById(R.id.fab);

    }

    public void intentUrl(String mUrl){
        String url = RestApi.BASE_URL_REDDIT+mUrl;
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(url));
        startActivity(i);
    }
}