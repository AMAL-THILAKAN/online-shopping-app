package com.example.onlineshopping;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

public class home extends AppCompatActivity {





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);



//        @SuppressLint({"MissingInflatedId", "LocalSuppress"})
//        Toolbar toolbar = findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);

        List<Item> items = new ArrayList<Item>();

        items.add(new Item("Knight Owl (Caldecott Honor Book)",
                "by Christopher Denise (Author)","RS 1189.53",R.drawable.book1));
        items.add(new Item("The Marvellers (The Conjureverse, 1)",
                "by Dhonielle Clayton (Author))","RS 750.00",R.drawable.book2));
        items.add(new Item("BEILU Mens Long Sleeve Dress Shirt",
                "Mens shirts","RS 20655.00",R.drawable.cloth1));
        items.add(new Item("Mens Suit Vests Formal V-Neck Vest Dress",
                "Men's Waistcoat","price = RS 2561.76",R.drawable.clothe2));
        items.add(new Item("JBL Tune 230NC TWS",
                "True Wireless In-Ear Noise Cancelling Headphones","RS 8262.00",R.drawable.electronics1));
        items.add(new Item("SAMSUNG Galaxy Watch",
                "smart watch by samsung","Rs 18873.00",R.drawable.electronics2));
        items.add(new Item("Hydro Flask",
                "Wide Mouth Bottle with Flex Cap","RS 3674.41",R.drawable.homeapp1));
        items.add(new Item("OVENTE Glass Electric Kettle ",
                "1.5 Liter Borosilicate Glass Fast Boiling","RS 1239.13",R.drawable.homeapp2));





        RecyclerView recyclerView = findViewById(R.id.recyclerView);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new MyAdapter(getApplicationContext(),items));

    }
}