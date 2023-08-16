package com.example.onlineshopping;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CartAdapter extends RecyclerView.Adapter<CartViewHolder> {

    ArrayList<Item> cartArray;
    Context cContext;

    public CartAdapter(Context cContext, ArrayList<Item> cartArray) {

        this.cContext = cContext;
        this.cartArray = cartArray;
    }

    @NonNull
    @Override
    public CartViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return  new CartViewHolder(LayoutInflater.from(cContext).inflate(R.layout.cart_view,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull CartViewHolder holder, int position) {

        holder.cartName.setText(cartArray.get(position).getItem_name());
        holder.cartDesc.setText(cartArray.get(position).getDescription());
        holder.cartPrice.setText(cartArray.get(position).getPrice());
        holder.cartImage.setImageResource(cartArray.get(position).getImage());

    }



    @Override
    public int getItemCount() {
       return cartArray.size();
    }
}
