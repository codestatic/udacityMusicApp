package com.example.udacitymusicapp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

// Bottom navigation bar
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

        bottomNavigationView.setSelectedItemId(R.id.home_button);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.shop_button:
                        startActivity(new Intent(getApplicationContext()
                                , ShopActivity.class));
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.library_button:
                        startActivity(new Intent(getApplicationContext()
                                , LibraryActivity.class));
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.home_button:
                        return true;
                    case R.id.now_playing_button:
                        startActivity(new Intent(getApplicationContext()
                                , NowPlayingActivity.class));
                        overridePendingTransition(0, 0);
                        return true;
                }
                return false;
            }
        });
    }
}