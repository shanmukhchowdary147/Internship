package com.example.internship;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.PictureDrawable;
import android.net.Uri;
import android.util.Base64;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.ahmadrosid.svgloader.SvgLoader;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.model.StreamEncoder;
import com.example.internship.Entity.RoomModel;
import com.squareup.picasso.Picasso;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class AdapterClass extends RecyclerView.Adapter<com.example.internship.AdapterClass.MyViewHolder> {

    List<RoomModel> list;
    Context context;
    public static final String TAG="ShannuZ";

    public AdapterClass(List<RoomModel> list,Context context) {

        this.list = list;
        this.context=context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_holder, viewGroup, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, final int i) {
        myViewHolder.name.setText(list.get(i).getName());
        myViewHolder.capital.setText("Capital:- " + list.get(i).getCapital());
        myViewHolder.region.setText("Region:- " + list.get(i).getRegion());
        myViewHolder.subregion.setText("Sub-Region:- " + list.get(i).getSubregion());
        myViewHolder.population.setText("Population:- " + list.get(i).getLanguages());
        myViewHolder.languages.setText("Language:- " + list.get(i).getLanguages());
        myViewHolder.borders.setText("Borders:- " + list.get(i).getBorders());

        Utils.fetchSvg(context, list.get(i).getFlag(), myViewHolder.flagy);

        Log.i(TAG,list.get(i).getFlag().toString());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView name, capital, region, subregion, population, languages,borders;
        ImageView flagy;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.name);
            capital = itemView.findViewById(R.id.capital);
            region = itemView.findViewById(R.id.region);
            subregion = itemView.findViewById(R.id.subregion);
            population = itemView.findViewById(R.id.population);
            flagy = (ImageView) itemView.findViewById(R.id.flag1);
            languages = itemView.findViewById(R.id.languages);
            borders = itemView.findViewById(R.id.borders);


        }
//        public Bitmap imageFromString(String kv) {
//            String data = kv.substring(kv.indexOf(",") + 1);
//            byte[] imageAsBytes = Base64.decode(data.getBytes(), Base64.DEFAULT);
//            return BitmapFactory.decodeByteArray(imageAsBytes, 0, imageAsBytes.length);
//        }}

}}
