package com.example.aportillo.rappitest.views;

import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.widget.RecyclerView;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.aportillo.rappitest.R;
import com.example.aportillo.rappitest.models.Children;
import com.example.aportillo.rappitest.util.StringUtil;
import com.example.aportillo.rappitest.util.UtilImage;

import java.util.ArrayList;

/**
 * Created by aportillo on 27/09/2016.
 */
public class CardViewAdapter extends RecyclerView.Adapter<CardViewHolder>  {

    private ArrayList<Children> listData;

    public CardViewAdapter(ArrayList<Children> listData) {
        this.listData = listData;
    }

    @Override
    public CardViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.
                from(parent.getContext()).
                inflate(R.layout.cardview_item, parent, false);

        return new CardViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(CardViewHolder holder, final int position) {
        android.view.ViewGroup.LayoutParams layoutParams = holder.vImageView.getLayoutParams();
        holder.vText.setText(listData.get(position).getDataChildrenList().getTitle());
        if (!(StringUtil.isEmptyOrNull(listData.get(position).getDataChildrenList().getBannerImg().toString()))) {
            holder.vImageView.setImageBitmap(loadImage(listData.get(position).getDataChildrenList().getBannerImg()));
            layoutParams.width = ViewGroup.LayoutParams.MATCH_PARENT;
            layoutParams.height = ViewGroup.LayoutParams.MATCH_PARENT;
            holder.vImageView.setLayoutParams(layoutParams);
        }

        holder.vImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), DetailActivity.class);
                intent.putExtra("description", listData.get(position).getDataChildrenList().getDescription());
                intent.putExtra("iconImg",listData.get(position).getDataChildrenList().getIconImg());
                intent.putExtra("headerTitle",listData.get(position).getDataChildrenList().getHeaderTitle());
                intent.putExtra("url",listData.get(position).getDataChildrenList().getUrl());
                intent.putExtra("bannerImg",listData.get(position).getDataChildrenList().getBannerImg());
                view.getContext().startActivity(intent);

            }
        });

        holder.vImageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        if(!(StringUtil.isEmptyOrNull(listData.get(position).getDataChildrenList().getBannerImg().toString())))
            holder.vImageView.setImageBitmap(loadImage(listData.get(position).getDataChildrenList().getBannerImg()));
    }

    @Override
    public int getItemCount() {
        return listData.size();
    }

    public Bitmap loadImage(String src) {
        return UtilImage.getImageFromUrl(src);
    }


}
