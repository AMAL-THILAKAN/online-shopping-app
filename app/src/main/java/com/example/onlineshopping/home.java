package com.example.onlineshopping;

import static com.example.onlineshopping.R.id.nav_item1;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ShareCompat;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.List;

public class home extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;
    ActionBarDrawerToggle toggle;

    MyAdapter myAdapter;

    TextView toHome, toAccInfo, toCart, signOut;


    @SuppressLint({"MissingInflatedId", "SetTextI18n"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        toHome = findViewById(R.id.nav_item1);
        toAccInfo = findViewById(R.id.nav_item2);
        toCart = findViewById(R.id.nav_item3);
        signOut = findViewById(R.id.nav_item4);


        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);

        Toast.makeText(getApplicationContext(), "Iam in Home", Toast.LENGTH_SHORT).show();

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        TextView toolbarTitle = findViewById(R.id.toolbar_title);

        toolbarTitle.setText("HOME");

        navigationView.bringToFront();

//        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.open_drawer,R.string.close_drawer);
//        drawerLayout.addDrawerListener(toggle);
//        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setCheckedItem(nav_item1);


        List<Item> items = new ArrayList<>();

        items.add(new Item("Knight Owl (Caldecott Honor Book)",
                "by Christopher Denise (Author)", "RS 1189.53", R.drawable.book1));
        items.add(new Item("The Marvellers (The Conjureverse, 1)",
                "by Dhonielle Clayton (Author))", "RS 750.00", R.drawable.book2));
        items.add(new Item("BEILU Mens Long Sleeve Dress Shirt",
                "Mens shirts", "RS 20655.00", R.drawable.cloth1));
        items.add(new Item("Mens Suit Vests Formal V-Neck Vest Dress",
                "Men's Waistcoat", "price = RS 2561.76", R.drawable.clothe2));
        items.add(new Item("JBL Tune 230NC TWS",
                "True Wireless In-Ear Noise Cancelling Headphones", "RS 8262.00", R.drawable.electronics1));
        items.add(new Item("SAMSUNG Galaxy Watch",
                "smart watch by samsung", "Rs 18873.00", R.drawable.electronics2));
        items.add(new Item("Hydro Flask",
                "Wide Mouth Bottle with Flex Cap", "RS 3674.41", R.drawable.homeapp1));
        items.add(new Item("OVENTE Glass Electric Kettle ",
                "1.5 Liter Borosilicate Glass Fast Boiling", "RS 1239.13", R.drawable.homeapp2));


        RecyclerView recyclerView = findViewById(R.id.recyclerView);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new MyAdapter(getApplicationContext(), items));

    }

    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }

    }

    ;


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

        switch(menuItem.getItemId()) {

            case R.id.nav_item1:
                break;
            case R.id.nav_item2:
                Intent accInfoIntent = new Intent(getApplicationContext(),AccInfoActivity.class);
                startActivity(accInfoIntent);
                break;
            case R.id.nav_item3:
                Intent cartIntent = new Intent(getApplicationContext(),CartActivity.class);
                startActivity(cartIntent);
                break;
            case R.id.nav_item4:
                Intent signOut = new Intent(getApplicationContext(),LoginMainActivity.class);
                startActivity(signOut);
                break;


        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

}
