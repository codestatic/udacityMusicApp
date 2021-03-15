package com.example.udacitymusicapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class NowPlayingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nowplaying);

// get data from array to display song title and artist now playing
        Intent nowPlaying = getIntent();
        nowPlaying.getStringArrayExtra("songTitle");

        TextView songTitleView = findViewById(R.id.song_now_playing_view);

// Bottom navigation bar
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

        bottomNavigationView.setSelectedItemId(R.id.now_playing_button);

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
                        startActivity(new Intent(getApplicationContext()
                                , MainActivity.class));
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.now_playing_button:
                        return true;
                }
                return false;
            }
        });

    }
}
