package com.example.hepsheeba.trylyric.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.hepsheeba.trylyric.R;
import com.example.hepsheeba.trylyric.util.AppConstants;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class SongListActivity extends AppCompatActivity {


    /**
     * Old Code by using raw folder
     */

//    private final Context context = this;
//    private ListView mSongListView;
//    private ArrayAdapter<String> listAdapter;
//    private final String TAG = SongListActivity.class.getSimpleName();
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_song_list);
//
//        mSongListView = (ListView) findViewById(R.id.lv_song_list);
//        ArrayList<String> songList = new ArrayList<String>();
//
//        Field[] fields = R.raw.class.getFields();
//        for (int count = 0; count < fields.length; count++) {
//            Log.d("rawasset", fields[count].getName());
//            final String songsTitle = fields[count].getName();
//            songList.addAll(Collections.singletonList(songsTitle));
//        }
//
//        listAdapter = new ArrayAdapter<String>(this, R.layout.list_item, songList);
//        mSongListView.setAdapter(listAdapter);
//        mSongListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                String value = mSongListView.getItemAtPosition(i).toString();
//                Toast.makeText(context, "Song Title: " + value, Toast.LENGTH_SHORT).show();
//
//                Intent readingLyrics = new Intent(SongListActivity.this, ReadingLyricsActivity.class);
//                readingLyrics.putExtra("songTitle", value);
//                startActivity(readingLyrics);
//            }
//        });
//    }
//}

    /**
     * New Code using asset
     */

    private final Context context = this;
    private ListView mSongListView;
    private ArrayAdapter<String> listAdapter;
    private EditText mInputSearch;

    // Song Category
    public String classic;
    public String melody;
    public String rock;
    public String others;
    public String artist;

    //Language Category
    public String english;
    public String hindi;
    public String tamil;
    public String telugu;
    public String kannada;
    public String malayalam;
    public ArrayList<String> songList = new ArrayList<>();

    private final String TAG = SongListActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_song_list);

        mInputSearch = (EditText) findViewById(R.id.et_inputSearch);
        mSongListView = (ListView) findViewById(R.id.lv_song_list);

        // Intent
        Intent intent = getIntent();

        //Language Category
        english = intent.getStringExtra(AppConstants.KEY_ENGLISH);
        hindi = intent.getStringExtra(AppConstants.KEY_HINDI);
        tamil = intent.getStringExtra(AppConstants.KEY_TAMIL);
        telugu = intent.getStringExtra(AppConstants.KEY_TELUGU);
        kannada = intent.getStringExtra(AppConstants.KEY_KANNADA);
        malayalam = intent.getStringExtra(AppConstants.KEY_MALAYALAM);

        //Song Category
        classic = intent.getStringExtra(AppConstants.KEY_CLASSIC);
        melody = intent.getStringExtra(AppConstants.KEY_MELODY);
        rock = intent.getStringExtra(AppConstants.KEY_ROCK);
        others = intent.getStringExtra(AppConstants.KEY_ALL_SONGS);
        artist = intent.getStringExtra(AppConstants.KEY_ARTIST);

        //Listing English Songs
        if ((english != null) && (english.equalsIgnoreCase(AppConstants.LANGUAGE_ENGLISH))) {
            if ((classic != null) && (classic.equalsIgnoreCase(AppConstants.CATEGORY_CLASSIC))) {
                listSongs(AppConstants.PATH_ENGLISH_CLASSICS);
            } else if ((melody != null) && (melody.equalsIgnoreCase(AppConstants.CATEGORY_MELODY))) {
                listSongs(AppConstants.PATH_ENGLISH_MELODY);
            } else if ((rock != null) && (rock.equalsIgnoreCase(AppConstants.CATEGORY_ROCK))) {
                listSongs(AppConstants.PATH_ENGLISH_ROCK);
            } else if ((others != null) && (others.equalsIgnoreCase(AppConstants.CATEGORY_ALL_SONGS))) {
                listSongs(AppConstants.PATH_ENGLISH_ALL_SONGS);
            } else if ((artist != null) && (artist.equalsIgnoreCase(AppConstants.CATEGORY_ARTIST))) {
                listSongs(AppConstants.PATH_ENGLISH_ARTIST);
            }

        }

        //Listing Tamil Songs
        if ((tamil != null) && (tamil.equalsIgnoreCase(AppConstants.LANGUAGE_TAMIL))) {
            if ((classic != null) && (classic.equalsIgnoreCase(AppConstants.CATEGORY_CLASSIC))) {
                listSongs(AppConstants.PATH_TAMIL_CLASSICS);
            } else if ((melody != null) && (melody.equalsIgnoreCase(AppConstants.CATEGORY_MELODY))) {
                listSongs(AppConstants.PATH_TAMIL_MELODY);

            } else if ((rock != null) && (rock.equalsIgnoreCase(AppConstants.CATEGORY_ROCK))) {
                listSongs(AppConstants.PATH_TAMIL_ROCK);

            } else if ((others != null) && (others.equalsIgnoreCase(AppConstants.CATEGORY_ALL_SONGS))) {
                listSongs(AppConstants.PATH_TAMIL_ALL_SONGS);

            }
        }

        // Listing Telugu Songs
        if ((telugu != null) && (telugu.equalsIgnoreCase(AppConstants.LANGUAGE_TELUGU))) {
            if ((classic != null) && (classic.equalsIgnoreCase(AppConstants.CATEGORY_CLASSIC))) {
                listSongs(AppConstants.PATH_TELUGU_CLASSICS);
            } else if ((melody != null) && (melody.equalsIgnoreCase(AppConstants.CATEGORY_MELODY))) {
                listSongs(AppConstants.PATH_TELUGU_MELODY);

            } else if ((others != null) && (others.equalsIgnoreCase(AppConstants.CATEGORY_ALL_SONGS))) {
                listSongs(AppConstants.PATH_TELUGU_ALL_SONGS);

            }
        }

        // Listing Hindi Songs
        if ((hindi != null) && (hindi.equalsIgnoreCase(AppConstants.LANGUAGE_HINDI))) {
            if ((classic != null) && (classic.equalsIgnoreCase(AppConstants.CATEGORY_CLASSIC))) {
                listSongs(AppConstants.PATH_HINDI_CLASSICS);
            } else if ((melody != null) && (melody.equalsIgnoreCase(AppConstants.CATEGORY_MELODY))) {
                listSongs(AppConstants.PATH_HINDI_MELODY);
            } else if ((others != null) && (others.equalsIgnoreCase(AppConstants.CATEGORY_ALL_SONGS))) {
                listSongs(AppConstants.PATH_HINDI_ALL_SONGS);
            }
        }


        //Listing Kannada Songs
        if ((kannada != null) && (kannada.equalsIgnoreCase(AppConstants.LANGUAGE_KANNADA))) {
            if ((classic != null) && (classic.equalsIgnoreCase(AppConstants.CATEGORY_CLASSIC))) {
                listSongs(AppConstants.PATH_KANNADA_CLASSICS);
            } else if ((melody != null) && (melody.equalsIgnoreCase(AppConstants.CATEGORY_MELODY))) {
                listSongs(AppConstants.PATH_KANNADA_MELODY);
            } else if ((others != null) && (others.equalsIgnoreCase(AppConstants.CATEGORY_ALL_SONGS))) {
                listSongs(AppConstants.PATH_KANNADA_ALL_SONGS);
            }
        }

        //Listing Malayalam Songs
        if ((malayalam != null) && (malayalam.equalsIgnoreCase(AppConstants.LANGUAGE_MALAYALAM))) {
            if ((classic != null) && (classic.equalsIgnoreCase(AppConstants.CATEGORY_CLASSIC))) {
                listSongs(AppConstants.PATH_MALAYALAM_CLASSICS);
            } else if ((melody != null) && (melody.equalsIgnoreCase(AppConstants.CATEGORY_MELODY))) {
                listSongs(AppConstants.PATH_MALAYALAM_MELODY);
            } else if ((others != null) && (others.equalsIgnoreCase(AppConstants.CATEGORY_ALL_SONGS))) {
                listSongs(AppConstants.PATH_MALAYALAM_ALL_SONGS);

            }
        }

        listAdapter = new ArrayAdapter<String>(this, R.layout.list_item, songList);
        mSongListView.setAdapter(listAdapter);
        mSongListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String value = mSongListView.getItemAtPosition(i).toString();
                Log.d(TAG, "value" + value);

                Intent readingLyrics = new Intent(SongListActivity.this, ReadingLyricsActivity.class);
                readingLyrics.putExtra(AppConstants.SONG_TITLE, value);

                //Language Category
                readingLyrics.putExtra(AppConstants.LANGUAGE_ENGLISH, english);
                readingLyrics.putExtra(AppConstants.LANGUAGE_HINDI, hindi);
                readingLyrics.putExtra(AppConstants.LANGUAGE_TAMIL, tamil);
                readingLyrics.putExtra(AppConstants.LANGUAGE_TELUGU, telugu);
                readingLyrics.putExtra(AppConstants.LANGUAGE_KANNADA, kannada);
                readingLyrics.putExtra(AppConstants.LANGUAGE_MALAYALAM, malayalam);

                //Song Category
                readingLyrics.putExtra(AppConstants.CATEGORY_CLASSIC, classic);
                readingLyrics.putExtra(AppConstants.CATEGORY_MELODY, melody);
                readingLyrics.putExtra(AppConstants.CATEGORY_ROCK, rock);
                readingLyrics.putExtra(AppConstants.CATEGORY_ALL_SONGS, others);
                readingLyrics.putExtra(AppConstants.CATEGORY_ARTIST, artist);

                startActivity(readingLyrics);
            }
        });

        mInputSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                SongListActivity.this.listAdapter.getFilter().filter(charSequence);
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }

    public void listSongs(String path) {

        final AssetManager assetManager = getAssets();

        // for assets folder add empty string
        String[] filelist = new String[0];
        try {
            filelist = assetManager.list(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (filelist == null) {
            Toast.makeText(getApplicationContext(), "Songs List not available", Toast.LENGTH_SHORT).show();
        } else {
            for (int i = 0; i < filelist.length; i++) {
                // Get filename of file or directory
                String songName = filelist[i];
                Log.d(TAG, "filename " + songName);
                songList.addAll(Collections.singletonList(songName.replaceAll(".txt$", "")));
            }
        }
    }
}





