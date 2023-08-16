package com.example.onlineshopping;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MyViewHolder extends RecyclerView.ViewHolder {

    ImageView imageView,cartLogo;
    TextView name,desc,price;

    List<Integer> cartItems = new ArrayList<>();


    public MyViewHolder(@NonNull View itemView) {
        super(itemView);

        imageView = itemView.findViewById(R.id.imageView);
        name = itemView.findViewById(R.id.pdtName);
        desc = itemView.findViewById(R.id.pdtDesc);
        price = itemView.findViewById(R.id.pdtPrice);
        cartLogo = itemView.findViewById(R.id.cartLogo);




        cartLogo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = getAdapterPosition();


                cartItems.add(position);

                 Intent cintent = new Intent();
                 cintent.putExtra("cartArray", (cartItems).toString());

               // MyAdapter adapter =new MyAdapter((Context) cartItems, this );


                // Handle button click for the specific item at 'position'
                //                // For example, you can call a method in your activity/fragment
                //                // to perform the desired action.

                Toast.makeText(v.getContext(), "Cart Clicked!" + String.valueOf(position), Toast.LENGTH_SHORT).show();
                cartLogo.setImageResource(R.drawable.icon_selector);
            }
        });




    }
}
