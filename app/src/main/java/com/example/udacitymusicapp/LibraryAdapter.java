package com.example.udacitymusicapp;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class LibraryAdapter extends ArrayAdapter<LibrarySongs> {

    public LibraryAdapter(Activity context, ArrayList<LibrarySongs> genres) {
        super(context, 0, genres);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.library_list_items, parent, false);
        }

        LibrarySongs currentLibrarySongs = getItem(position);

        // Find the TextView
        TextView songTextView = (TextView) listItemView.findViewById(R.id.song_title);

        songTextView.setText(currentLibrarySongs.getSongTitle());

        // Find the TextView
        TextView artistTextView = (TextView) listItemView.findViewById(R.id.artist_name);

        artistTextView.setText(currentLibrarySongs.getArtistName());

        return listItemView;

    }
}
