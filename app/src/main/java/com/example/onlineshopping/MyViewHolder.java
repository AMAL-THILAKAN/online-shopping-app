package com.example.onlineshopping;

import android.content.Intent;
import android.graphics.Color;
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


//     cartLogo.setOnClickListener(new View.OnClickListener() {
//         @Override
//         public void onClick(View v) {
////DOING THIS NOW
//             Intent cartIntent = new Intent();
//             cartIntent.putExtra("image", String.valueOf(imageView));
//             cartIntent.putExtra("name", String.valueOf(name));
//             cartIntent.putExtra("desc", String.valueOf(name));
//             cartIntent.putExtra("price", String.valueOf(name));
//
//             cartLogo.setBackgroundColor(Color.parseColor("#00FF00"));
//
//         }
//     });


    }
}
