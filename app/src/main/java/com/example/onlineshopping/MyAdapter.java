package com.example.onlineshopping;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {

    Context context;
    List<Item> items;

    public MyAdapter(Context context, List<Item> items) {
        this.context = context;
        this.items = items;
    }



    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.item_view,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.name.setText(items.get(position).getItem_name());
        holder.desc.setText(items.get(position).getDescription());
        holder.price.setText(items.get(position).getPrice());
        holder.imageView.setImageResource(items.get(position).getImage());



    }

    @Override
    public int getItemCount() {
        return  items.size();
    }

public class ViewHolder extends RecyclerView.ViewHolder{

        TextView pdtName,pdtDesc,pdtPrice;
        ImageView pdtImg;
        ImageView cartLogo;



    public ViewHolder(View itemView) {
        super(itemView);

        pdtName = itemView.findViewById(R.id.pdtName);
        pdtDesc= itemView.findViewById(R.id.pdtDesc);
        pdtPrice = itemView.findViewById(R.id.pdtPrice);
        pdtImg = itemView.findViewById(R.id.imageView);

        cartLogo = itemView.findViewById(R.id.cartLogo);



    }

}
}
