package com.example.aportillo.rappitest.views;

import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
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
public class CardViewAdapter extends RecyclerView.Adapter<CardViewHolder> {

    private ArrayList<Children>  listData;
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
    public void onBindViewHolder(CardViewHolder holder, int position) {
        holder.vText.setText(listData.get(position).getDataChildrenList().getTitle());
        if(!(StringUtil.isEmptyOrNull(listData.get(position).getDataChildrenList().getBannerImg().toString()))) {
            holder.vImageView.setImageBitmap(UtilImage.image(listData.get(position).getDataChildrenList().getBannerImg()));
        }else {
            holder.vImageView.setBackgroundResource(R.drawable.rappitest);
        }
        holder.vImageView.setScaleType(ImageView.ScaleType.FIT_XY);
    }

    @Override
    public int getItemCount() {
        return listData.size();
    }
    public static class ContactViewHolder extends RecyclerView.ViewHolder {

        protected TextView vText;


        public ContactViewHolder(View v) {
            super(v);
            vText =  (TextView) v.findViewById(R.id.text);

        }
    }
    public Drawable loadImage(String src, String name){
        return UtilImage.loadImageFromURL(src,name);
    }
}
