package com.example.onlineshopping;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class CartActivity extends AppCompatActivity {

    TextView name,desc,price;
    ImageView image;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cart_view);


        @SuppressLint({"MissingInflatedId", "LocalSuppress"})
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        @SuppressLint({"MissingInflatedId", "LocalSuppress"})
        TextView toolbarTitle = findViewById(R.id.toolbar_title);

        toolbarTitle.setText("CART");


        Intent cIntent = getIntent();
        String n = getIntent().getExtras().getString("name","defaultName");
        String d = getIntent().getExtras().getString("desc","defaultDesc");
        String p = getIntent().getExtras().getString("price","defaultPrice");
        String img = getIntent().getExtras().getString("image","defaultImage");





    }
}
