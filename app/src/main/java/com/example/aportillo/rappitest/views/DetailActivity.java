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
import com.example.aportillo.rappitest.util.StringUtil;
import com.example.aportillo.rappitest.util.UtilImage;
import com.example.aportillo.rappitest.util.constans.RestApi;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

public class DetailActivity extends AppCompatActivity {

    @InjectView(R.id.textViewDetail)
    TextView textViewDetail;
    @InjectView(R.id.toolbar)
    Toolbar toolbar;
    @InjectView(R.id.fab)
    FloatingActionButton fab;
    String value, iconImg, headerTitle, url, bannerImg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        ButterKnife.inject(this);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            value = (String) getIntent().getSerializableExtra("description");
            iconImg = (String) getIntent().getSerializableExtra("iconImg");
            headerTitle = (String) getIntent().getSerializableExtra(("headerTitle"));
            url = (String) getIntent().getSerializableExtra(("url"));
            bannerImg = (String) getIntent().getSerializableExtra(("bannerImg"));
        }
        setTitle(headerTitle);
        setSupportActionBar(toolbar);
        textViewDetail.setText((Html.fromHtml(value)));
        if (!StringUtil.isEmptyOrNull(iconImg)) {
            fab.setImageDrawable(UtilImage.loadImageFromURL(iconImg));
        } else {
            fab.setBackgroundResource(R.drawable.ic_share_white);
        }
        toolbar.setBackground(UtilImage.loadImageFromURL(bannerImg));
    }

    public void intentUrl(String mUrl) {
        String url = RestApi.BASE_URL_REDDIT + mUrl;
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(url));
        startActivity(i);
    }

    @OnClick(R.id.fab)
    public void fabClick(View view) {
        intentUrl(url);
    }
}