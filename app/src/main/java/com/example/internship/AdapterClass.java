package com.example.internship;

import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.internship.Entity.RoomModel;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class AdapterClass extends RecyclerView.Adapter<com.example.internship.AdapterClass.MyViewHolder> {

    List<RoomModel> list;

    public AdapterClass(List<RoomModel> list)
    {

        this.list=list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_holder,viewGroup,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, final int i) {
        myViewHolder.name.setText(list.get(i).getName());
        myViewHolder.capital.setText("Capital:- "+list.get(i).getCapital());
        myViewHolder.region.setText("Region:- "+list.get(i).getRegion());
        myViewHolder.subregion.setText("Sub-Region:- "+list.get(i).getSubregion());
        myViewHolder.population.setText("Population:- "+list.get(i).getLanguages());
        Picasso.get().load(list.get(i).getFlag()).into(myViewHolder.flagy);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView name,capital,region,subregion,population;
        ImageView flagy;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            name=itemView.findViewById(R.id.name);
            capital=itemView.findViewById(R.id.capital);
            region=itemView.findViewById(R.id.region);
            subregion=itemView.findViewById(R.id.subregion);
            population=itemView.findViewById(R.id.population);
            flagy=itemView.findViewById(R.id.flag1);

        }
    }
}
