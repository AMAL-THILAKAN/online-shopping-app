package com.example.onlineshopping;

import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {

    Context context;
    private List<Item> items;
    private AdapterView.OnItemClickListener listener;;


    public MyAdapter(Context context, List<Item> items) {
        this.context = context;
        this.items = items;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.item_view, parent, false));
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
        return items.size();
    }

    public class Viewholder extends RecyclerView.ViewHolder {

        TextView pdtName, pdtDesc, pdtPrice;
        ImageView pdtImg, cartLogo;

        public Viewholder(View itemView) {

            super(itemView);



            pdtName = itemView.findViewById(R.id.pdtName);
            pdtDesc = itemView.findViewById(R.id.pdtDesc);
            pdtPrice = itemView.findViewById(R.id.pdtPrice);
            pdtImg = itemView.findViewById(R.id.imageView);
            cartLogo = itemView.findViewById(R.id.cartLogo);

//            Log.i("ABCD", (String) pdtName.getText().toString());

//            cartLogo.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//
//                    Toast.makeText(context.getApplicationContext(), pdtName.getText().toString(), Toast.LENGTH_SHORT).show();
//                    cartLogo.setBackgroundColor(Color.parseColor("#00FF00"));
//
//                }
//            });

        }

    }

//    public class ViewHolder extends RecyclerView.ViewHolder {
//
//        TextView pdtName, pdtDesc, pdtPrice;
//        ImageView pdtImg;
//
//        ImageView cartLogo;
//
//        public ViewHolder(View itemView) {
//
//            super(itemView);

//            pdtName = itemView.findViewById(R.id.pdtName);
//            pdtDesc = itemView.findViewById(R.id.pdtDesc);
//            pdtPrice = itemView.findViewById(R.id.pdtPrice);
//            pdtImg = itemView.findViewById(R.id.imageView);
//            Toast.makeText(context.getApplicationContext(), "1 2 3...", Toast.LENGTH_SHORT).show();
//
//            cartLogo.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
////DOING THIS NOW
//                    int position = getAdapterPosition();
//
//
////                    cartLogo.setBackgroundColor(Color.parseColor("#00FF00"));
//
//                }
//            });


//        }
//    }
}
