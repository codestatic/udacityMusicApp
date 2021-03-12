package com.example.udacitymusicapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.LinearLayoutCompat;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class ShopActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop);

// Array list of Genres
        String[] genres = new String[6];
        genres[0] = "Dance & Electronic";
        genres[1] = "Pop";
        genres[2] = "Metal";
        genres[3] = "Rock";
        genres[4] = "Hip Hop";
        genres[5] = "Chill";

// Finding view list
        LinearLayoutCompat shopView = (LinearLayoutCompat) findViewById(R.id.shop_list);

        for (int index = 0; index <6; index++) {
            TextView genreView = new TextView(this);
            genreView.setText(genres[index]);
            shopView.addView(genreView);
        }

        /**
// Array adapter
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, genres );

// display array list
    listView.setAdapter(adapter);
*/
// Bottom navigation bar
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

        bottomNavigationView.setSelectedItemId(R.id.shop_button);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.shop_button:
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
