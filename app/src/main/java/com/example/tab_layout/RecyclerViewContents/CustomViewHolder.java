package com.example.tab_layout.RecyclerViewContents;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tab_layout.R;

public class CustomViewHolder extends RecyclerView.ViewHolder {
    TextView text_title, text_desc;
    ImageView img;
    CardView cardView;
    public CustomViewHolder(@NonNull View itemView) {
        super(itemView);

        //initialize var
        text_title = itemView.findViewById(R.id.textTitle);
        text_desc = itemView.findViewById(R.id.textDesc);
        img = itemView.findViewById(R.id.img_headline);
        cardView = itemView.findViewById(R.id.main_container);
    }
}
