package com.example.onlineshopping;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CartViewHolder extends RecyclerView.ViewHolder {

    TextView cartName,cartDesc,cartPrice;
    ImageView cartImage;

    public CartViewHolder(@NonNull View itemView) {
        super(itemView);


        cartImage = itemView.findViewById(R.id.cartImageView);
        cartName = itemView.findViewById(R.id.cartPdtName);
        cartDesc = itemView.findViewById(R.id.cartPdtDesc);
        cartPrice = itemView.findViewById(R.id.cartPdtPrice);

    }
}
