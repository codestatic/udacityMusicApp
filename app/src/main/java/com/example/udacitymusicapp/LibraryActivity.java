package com.example.udacitymusicapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class LibraryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_library);

// Array list of music in library
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

        ListView listView = (ListView) findViewById(R.id.library_list);

        listView.setAdapter(adapter);

        // Set a click listener on that View
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                LibrarySongs currentSong = (LibrarySongs) parent.getItemAtPosition(position);
                String Artist = currentSong.getArtistName();
                String Title = currentSong.getSongTitle();
                Intent intent = new Intent(LibraryActivity.this, NowPlayingActivity.class);
                intent.putExtra("Artist", Artist);
                intent.putExtra("Title", Title);
                startActivity(intent);
            }
        });

        // Bottom navigation bar
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

        bottomNavigationView.setSelectedItemId(R.id.library_button);

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
