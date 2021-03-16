package com.example.udacitymusicapp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // recently played tracks
        ArrayList<LibrarySongs> libraryList = new ArrayList<LibrarySongs>();
        libraryList.add(new LibrarySongs("Late Night Drive", "Zeds Dead"));
        libraryList.add(new LibrarySongs("Pressure", "Martin Garrix"));
        libraryList.add(new LibrarySongs("Save Your Tears", "The Weekend"));
        libraryList.add(new LibrarySongs("Test Drive", "Ariana Grande"));
        libraryList.add(new LibrarySongs("Anchor", "Of Mice & Men"));
        libraryList.add(new LibrarySongs("Born For One Thing", "Gojira"));
        libraryList.add(new LibrarySongs("Better Without You", "Evanesence"));
        libraryList.add(new LibrarySongs("Typhoons", "Royal Blood"));
        libraryList.add(new LibrarySongs("What's Next", "Drake"));
        libraryList.add(new LibrarySongs("Life's A Mess II", "Juice WRLD"));
        libraryList.add(new LibrarySongs("Dreams", "Fleetwood Mac"));
        libraryList.add(new LibrarySongs("What's Up", "4 Non Blondes"));

        LibraryAdapter adapter = new LibraryAdapter(this, libraryList);

        ListView listView = (ListView) findViewById(R.id.recently_played);

        listView.setAdapter(adapter);

// quick view of shop categories
        String[] genres = new String[6];
        genres[0] = "Dance & Electronic";
        genres[1] = "Pop";
        genres[2] = "Metal";
        genres[3] = "Rock";
        genres[4] = "Hip Hop";
        genres[5] = "Chill";

        ArrayAdapter<String> songAdapter = new ArrayAdapter<String>(this, R.layout.shop_items, genres);

        ListView shopView = (ListView) findViewById(R.id.home_shop);
        shopView.setAdapter(songAdapter);

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