package com.example.aportillo.rappitest.views;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.aportillo.rappitest.R;

/**
 * Created by aportillo on 27/09/2016.
 */
public class CardViewHolder extends RecyclerView.ViewHolder {

    public TextView vText;

    public CardViewHolder(View itemView) {
        super(itemView);
        vText =(TextView)itemView.findViewById(R.id.text);
    }
}
