package com.example.onlineshopping;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyViewHolder extends RecyclerView.ViewHolder {

    ImageView imageView,cartLogo;
    TextView name,desc,price;
    public MyViewHolder(@NonNull View itemView) {
        super(itemView);

        imageView = itemView.findViewById(R.id.imageView);
        name = itemView.findViewById(R.id.pdtName);
        desc = itemView.findViewById(R.id.pdtDesc);
        price = itemView.findViewById(R.id.pdtPrice);
        cartLogo = itemView.findViewById(R.id.cartLogo);


//        cartLogo.setOnClickListener(this);


    }
}
