package com.example.onlineshopping;

import static com.example.onlineshopping.R.id.nav_item1;
import static com.example.onlineshopping.R.id.nav_item2;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

public class AccInfoActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    DrawerLayout drawerLayout;
    Toolbar toolbar;
    NavigationView navigationView;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acc_info);

        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);

//        toolbar = findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);

//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

//        TextView toolbarTitle = findViewById(R.id.toolbar_title);
//
//        toolbarTitle.setText("ABOUT");

        navigationView.bringToFront();

//        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.open_drawer,R.string.close_drawer);
//        drawerLayout.addDrawerListener(toggle);
//        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setCheckedItem(nav_item2);



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
            Intent homeIntent = new Intent(AccInfoActivity.this,home.class);
            startActivity(homeIntent);
        } else if (itemId == R.id.nav_item2) {

        } else if (itemId == R.id.nav_item3) {
            Intent cartIntent = new Intent(AccInfoActivity.this, CartActivity.class);
            startActivity(cartIntent);
        } else if (itemId == R.id.nav_item4) {
            Intent signOut = new Intent(AccInfoActivity.this, LoginMainActivity.class);
            startActivity(signOut);
        }
        //drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }
}

