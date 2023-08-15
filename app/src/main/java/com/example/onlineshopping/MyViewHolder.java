package com.example.onlineshopping;

import android.content.Intent;
import android.graphics.Color;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyViewHolder extends RecyclerView.ViewHolder {

    ImageView imageView,cartLogo;
    TextView name,desc,price;

    TextView cartName,cartDesc,cartPrice;
    ImageView cartImage;
    public MyViewHolder(@NonNull View itemView) {
        super(itemView);

        imageView = itemView.findViewById(R.id.imageView);
        name = itemView.findViewById(R.id.pdtName);
        desc = itemView.findViewById(R.id.pdtDesc);
        price = itemView.findViewById(R.id.pdtPrice);
        cartLogo = itemView.findViewById(R.id.cartLogo);

        cartImage = itemView.findViewById(R.id.cartImageView);
        cartName = itemView.findViewById(R.id.cartPdtName);
        cartDesc = itemView.findViewById(R.id.cartPdtDesc);
        cartPrice = itemView.findViewById(R.id.cartPdtPrice);


        cartLogo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = getAdapterPosition();

                // Handle button click for the specific item at 'position'
                // For example, you can call a method in your activity/fragment
                // to perform the desired action.

                Toast.makeText(v.getContext(), "Cart Clicked!" + String.valueOf(position), Toast.LENGTH_SHORT).show();

            }
        });

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
