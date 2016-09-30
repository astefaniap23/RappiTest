package com.example.aportillo.rappitest.views;


import android.support.v7.widget.RecyclerView;
import android.view.ContextMenu;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.aportillo.rappitest.R;



/**
 * Created by aportillo on 27/09/2016.
 */
public class CardViewHolder extends RecyclerView.ViewHolder implements View.OnCreateContextMenuListener, View.OnClickListener {

    public TextView vText;
    public ImageView vImageView;

    public CardViewHolder(View itemView) {
        super(itemView);
        vText =(TextView)itemView.findViewById(R.id.text);
        vImageView = (ImageView)itemView.findViewById(R.id.imageView);
     }

    @Override
    public void onClick(View v) {

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {

    }
}
