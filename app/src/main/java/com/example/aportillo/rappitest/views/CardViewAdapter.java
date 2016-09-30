package com.example.aportillo.rappitest.views;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.aportillo.rappitest.R;
import com.example.aportillo.rappitest.models.Children;
import com.example.aportillo.rappitest.util.StringUtil;
import com.example.aportillo.rappitest.util.UtilImage;

import java.util.ArrayList;

/**
 * Created by aportillo on 27/09/2016.
 */
public class CardViewAdapter extends RecyclerView.Adapter<CardViewHolder> implements View.OnCreateContextMenuListener, View.OnClickListener {

    private ArrayList<Children> listData;
    UtilImage utilBitmap = new UtilImage();

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

        holder.vText.setText(listData.get(position).getDataChildrenList().getTitle());
        if (!(StringUtil.isEmptyOrNull(listData.get(position).getDataChildrenList().getBannerImg().toString())))
            holder.vImageView.setImageBitmap(loadImage(listData.get(position).getDataChildrenList().getBannerImg()));
        holder.vImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), DetailActivity.class);
                intent.putExtra("description", listData.get(position).getDataChildrenList().getDescription());
                intent.putExtra("iconImg",listData.get(position).getDataChildrenList().getIconImg());
                view.getContext().startActivity(intent);

            }
        });

    }

    @Override
    public int getItemCount() {
        return listData.size();
    }

    public Bitmap loadImage(String src) {
        return UtilImage.getImageFromUrl(src);
    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {

    }
}
