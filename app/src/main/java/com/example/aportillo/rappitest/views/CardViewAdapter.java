package com.example.aportillo.rappitest.views;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.aportillo.rappitest.R;
import com.example.aportillo.rappitest.models.ListData;

import java.util.List;

/**
 * Created by aportillo on 27/09/2016.
 */
public class CardViewAdapter extends RecyclerView.Adapter<CardViewHolder> {

    private List<ListData> listData;

    public CardViewAdapter(List<ListData> listData) {
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
        holder.vText.setText("Hola Mundo");
    }

    @Override
    public int getItemCount() {
        return 0;
    }
    public static class ContactViewHolder extends RecyclerView.ViewHolder {

        protected TextView vText;


        public ContactViewHolder(View v) {
            super(v);
            vText =  (TextView) v.findViewById(R.id.text);

        }
    }
}
