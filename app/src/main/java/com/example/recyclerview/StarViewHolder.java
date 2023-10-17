package com.example.recyclerview;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import beans.Star;
import service.StarService;

public class StarViewHolder extends RecyclerView.ViewHolder {

    TextView idss;
    ImageView img;
    TextView name;
    RatingBar stars;
    RelativeLayout parent;


    public StarViewHolder(@NonNull View itemView) {
        super(itemView);
        idss = itemView.findViewById(R.id.ids);
        img = itemView.findViewById(R.id.img);
        name = itemView.findViewById(R.id.name);
        stars = itemView.findViewById(R.id.stars);
        parent = itemView.findViewById(R.id.parent);
    }

}



