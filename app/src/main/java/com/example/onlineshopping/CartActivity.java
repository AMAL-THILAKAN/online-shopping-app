package com.example.onlineshopping;

import static com.example.onlineshopping.R.id.nav_item1;
import static com.example.onlineshopping.R.id.nav_item3;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

public class CartActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    TextView name,desc,price;
    ImageView image;
    DrawerLayout drawerLayout;

    NavigationView navigationView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cart_view);

        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        TextView toolbarTitle = findViewById(R.id.toolbar_title);
        toolbarTitle.setText("CART");

        navigationView.bringToFront();

//        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.open_drawer,R.string.close_drawer);
//        drawerLayout.addDrawerListener(toggle);
//        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setCheckedItem(nav_item3);




//        Intent cIntent = getIntent();
//        String n = getIntent().getExtras().getString("name","defaultName");
//        String d = getIntent().getExtras().getString("desc","defaultDesc");
//        String p = getIntent().getExtras().getString("price","defaultPrice");
//        String img = getIntent().getExtras().getString("image","defaultImage");





    }
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        int itemId = menuItem.getItemId();
        if (itemId == nav_item1) {
            Intent homeIntent = new Intent(CartActivity.this,home.class);
            startActivity(homeIntent);
        } else if (itemId == R.id.nav_item2) {
            Intent accInfoIntent = new Intent(CartActivity.this, AccInfoActivity.class);
            startActivity(accInfoIntent);
        } else if (itemId == R.id.nav_item3) {

        } else if (itemId == R.id.nav_item4) {
            Intent signOut = new Intent(CartActivity.this, LoginMainActivity.class);
            startActivity(signOut);
        }
        //drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }



}

