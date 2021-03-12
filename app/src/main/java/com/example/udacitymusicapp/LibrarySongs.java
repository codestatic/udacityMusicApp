package com.example.udacitymusicapp;

public class LibrarySongs {

    private String mSongTitle;

    private String mArtistName;

    public LibrarySongs(String songTitle, String artistName) {
        mSongTitle = songTitle;
        mArtistName = artistName;
    }

    public String getSongTitle() {
        return mSongTitle;
    }

    public String getArtistName() {
        return mArtistName;
    }

}
