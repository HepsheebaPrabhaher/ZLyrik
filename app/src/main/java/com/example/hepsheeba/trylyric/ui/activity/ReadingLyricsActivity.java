package com.example.hepsheeba.trylyric.ui.activity;

import android.content.Intent;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hepsheeba.trylyric.R;
import com.example.hepsheeba.trylyric.util.AppConstants;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collections;

public class ReadingLyricsActivity extends AppCompatActivity {

    private final String TAG = ReadingLyricsActivity.class.getSimpleName();


    /**
     * Old code using raw
     */

//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.list_item);
//
//        Intent intent = getIntent();
//        String songName = intent.getStringExtra("songTitle");
//
//        Log.d(TAG, "onCreate: name" + songName);
//        Field[] fields = R.raw.class.getFields();
//        for (int count = 0; count < fields.length; count++) {
//            Log.d("rawasset", fields[count].getName());
//            final String songsTitle = fields[count].getName();
//
//            Log.d(TAG, "onCreate: title" + songsTitle);
//            if (songName.equalsIgnoreCase(songsTitle)) {
//                try {
//                    // Input stream to read the file
//                    int id = getResources().getIdentifier(songsTitle, "raw", this.getPackageName());
//                    InputStream songOne = getResources().openRawResource(id);
//                    // assigning it to a string
//                    String lyricOne = inputStreamToString(songOne);
//
//                    TextView lyricTextView = (TextView) findViewById(R.id.tv_lyric);
//                    lyricTextView.setText(lyricOne);
//                    lyricTextView.setMovementMethod(new ScrollingMovementMethod());
//                    lyricTextView.setTextIsSelectable(true);
//
//
//                } catch (IOException e) {
//                    Log.e("DEBUG", "InputStreamToString failure");
//                }
//                break;
//            }
//        }
//    }
//
//    private String inputStreamToString(InputStream is) throws IOException {
//        // create a buffer
//        StringBuffer sBuffer = new StringBuffer();
//        DataInputStream dataIO = new DataInputStream(is);
//        String strLine = null;
//
//        while ((strLine = dataIO.readLine()) != null) {
//            sBuffer.append(strLine + "\n");
//
//        }
//        dataIO.close();
//        is.close();
//        return sBuffer.toString();
//    }
//}

    /**
     * New code using assets
     */


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_item);

        Intent intent = getIntent();
        String songName = intent.getStringExtra(AppConstants.SONG_TITLE);
        Log.d(TAG, "name" + songName);

        //Language Category
        String englishCategory = intent.getStringExtra(AppConstants.LANGUAGE_ENGLISH);
        String hindiCategory = intent.getStringExtra(AppConstants.LANGUAGE_HINDI);
        String tamilCategory = intent.getStringExtra(AppConstants.LANGUAGE_TAMIL);
        String teluguCategory = intent.getStringExtra(AppConstants.LANGUAGE_TELUGU);
        String kannadaCategory = intent.getStringExtra(AppConstants.LANGUAGE_KANNADA);
        String malayalamCategory = intent.getStringExtra(AppConstants.LANGUAGE_MALAYALAM);

        //Song Category
        String classicSongCategory = intent.getStringExtra(AppConstants.CATEGORY_CLASSIC);
        String melodySongCategory = intent.getStringExtra(AppConstants.CATEGORY_MELODY);
        String rockSongCategory = intent.getStringExtra(AppConstants.CATEGORY_ROCK);
        String otherSongCategory = intent.getStringExtra(AppConstants.CATEGORY_ALL_SONGS);
        String artistSongCategory = intent.getStringExtra(AppConstants.CATEGORY_ARTIST);


        /**
         * English Song Lyrics
         */

        // Classic
        if ((englishCategory != null) && (englishCategory.equalsIgnoreCase(AppConstants.LANGUAGE_ENGLISH))) {
            if ((classicSongCategory != null) && (classicSongCategory.equalsIgnoreCase(AppConstants.CATEGORY_CLASSIC))) {
                openSongLyrics(AppConstants.LANGUAGE_ENGLISH + "/" + AppConstants.CATEGORY_CLASSIC);
            }

            // Melody
            else if ((melodySongCategory != null) && (melodySongCategory.equalsIgnoreCase(AppConstants.CATEGORY_MELODY))) {
                openSongLyrics(AppConstants.LANGUAGE_ENGLISH + "/" + AppConstants.CATEGORY_MELODY);
            }

            // Rock
            else if ((rockSongCategory != null) && (rockSongCategory.equalsIgnoreCase(AppConstants.CATEGORY_ROCK))) {
                openSongLyrics(AppConstants.LANGUAGE_ENGLISH + "/" + AppConstants.CATEGORY_ROCK);
            }

            //All Songs
            else if ((otherSongCategory != null) && (otherSongCategory.equalsIgnoreCase(AppConstants.CATEGORY_ALL_SONGS))) {
                openSongLyrics(AppConstants.LANGUAGE_ENGLISH + "/" + AppConstants.CATEGORY_ALL_SONGS);
            }

            //Artist
            else if ((artistSongCategory != null) && (artistSongCategory.equalsIgnoreCase(AppConstants.CATEGORY_ARTIST))) {
                Intent artistIntent = new Intent(ReadingLyricsActivity.this, ArtistActivity.class);
                startActivity(artistIntent);
            }
        }

        /**
         * Hindi Song Lyrics
         */

        // Classic
        if ((hindiCategory != null) && (hindiCategory.equalsIgnoreCase(AppConstants.LANGUAGE_HINDI))) {
            if ((classicSongCategory != null) && (classicSongCategory.equalsIgnoreCase(AppConstants.CATEGORY_CLASSIC))) {
                openSongLyrics(AppConstants.LANGUAGE_HINDI + "/" + AppConstants.CATEGORY_CLASSIC);
            }

            // Melody
            else if ((melodySongCategory != null) && (melodySongCategory.equalsIgnoreCase(AppConstants.CATEGORY_MELODY))) {
                openSongLyrics(AppConstants.LANGUAGE_HINDI + "/" + AppConstants.CATEGORY_MELODY);
            }

            //All Songs
            else if ((otherSongCategory != null) && (otherSongCategory.equalsIgnoreCase(AppConstants.CATEGORY_ALL_SONGS))) {
                openSongLyrics(AppConstants.LANGUAGE_HINDI + "/" + AppConstants.CATEGORY_ALL_SONGS);
            }
        }

        /**
         * Tamil Song Lyrics
         */

        // Classic
        if ((tamilCategory != null) && (tamilCategory.equalsIgnoreCase(AppConstants.LANGUAGE_TAMIL))) {
            if ((classicSongCategory != null) && (classicSongCategory.equalsIgnoreCase(AppConstants.CATEGORY_CLASSIC))) {
                openSongLyrics(AppConstants.LANGUAGE_TAMIL + "/" + AppConstants.CATEGORY_CLASSIC);
            }

            // Melody
            else if ((melodySongCategory != null) && (melodySongCategory.equalsIgnoreCase(AppConstants.CATEGORY_MELODY))) {
                openSongLyrics(AppConstants.LANGUAGE_TAMIL + "/" + AppConstants.CATEGORY_MELODY);
            }

            // Rock
            else if ((rockSongCategory != null) && (rockSongCategory.equalsIgnoreCase(AppConstants.CATEGORY_ROCK))) {
                openSongLyrics(AppConstants.LANGUAGE_TAMIL + "/" + AppConstants.CATEGORY_ROCK);
            }

            //All Songs
            else if ((otherSongCategory != null) && (otherSongCategory.equalsIgnoreCase(AppConstants.CATEGORY_ALL_SONGS))) {
                openSongLyrics(AppConstants.LANGUAGE_TAMIL + "/" + AppConstants.CATEGORY_ALL_SONGS);
            }
        }

        /**
         * Telugu Song Lyrics
         */

        // Classic
        if ((teluguCategory != null) && (teluguCategory.equalsIgnoreCase(AppConstants.LANGUAGE_TELUGU))) {
            if ((classicSongCategory != null) && (classicSongCategory.equalsIgnoreCase(AppConstants.CATEGORY_CLASSIC))) {
                openSongLyrics(AppConstants.LANGUAGE_TELUGU + "/" + AppConstants.CATEGORY_CLASSIC);
            }

            // Melody
            else if ((melodySongCategory != null) && (melodySongCategory.equalsIgnoreCase(AppConstants.CATEGORY_MELODY))) {
                openSongLyrics(AppConstants.LANGUAGE_TELUGU + "/" + AppConstants.CATEGORY_MELODY);
            }

            //All Songs
            else if ((otherSongCategory != null) && (otherSongCategory.equalsIgnoreCase(AppConstants.CATEGORY_ALL_SONGS))) {
                openSongLyrics(AppConstants.LANGUAGE_TELUGU + "/" + AppConstants.CATEGORY_ALL_SONGS);
            }
        }

        /**
         * Kannada Song Lyrics
         */

        // Classic
        if ((kannadaCategory != null) && (kannadaCategory.equalsIgnoreCase(AppConstants.LANGUAGE_KANNADA))) {
            if ((classicSongCategory != null) && (classicSongCategory.equalsIgnoreCase(AppConstants.CATEGORY_CLASSIC))) {
                openSongLyrics(AppConstants.LANGUAGE_KANNADA + "/" + AppConstants.CATEGORY_CLASSIC);
            }

            // Melody
            else if ((melodySongCategory != null) && (melodySongCategory.equalsIgnoreCase(AppConstants.CATEGORY_MELODY))) {
                openSongLyrics(AppConstants.LANGUAGE_KANNADA + "/" + AppConstants.CATEGORY_MELODY);
            }

            //All Songs
            else if ((otherSongCategory != null) && (otherSongCategory.equalsIgnoreCase(AppConstants.CATEGORY_ALL_SONGS))) {
                openSongLyrics(AppConstants.LANGUAGE_KANNADA + "/" + AppConstants.CATEGORY_ALL_SONGS);
            }
        }

        /**
         * Malayalam Song Lyrics
         */

        // Classic
        if ((malayalamCategory != null) && (malayalamCategory.equalsIgnoreCase(AppConstants.LANGUAGE_MALAYALAM))) {
            if ((classicSongCategory != null) && (classicSongCategory.equalsIgnoreCase(AppConstants.CATEGORY_CLASSIC))) {
                openSongLyrics(AppConstants.LANGUAGE_MALAYALAM + "/" + AppConstants.CATEGORY_CLASSIC);
            }

            // Melody
            else if ((melodySongCategory != null) && (melodySongCategory.equalsIgnoreCase(AppConstants.CATEGORY_MELODY))) {
                openSongLyrics(AppConstants.LANGUAGE_MALAYALAM + "/" + AppConstants.CATEGORY_MELODY);
            }

            //All Songs
            else if ((otherSongCategory != null) && (otherSongCategory.equalsIgnoreCase(AppConstants.CATEGORY_ALL_SONGS))) {
                openSongLyrics(AppConstants.LANGUAGE_MALAYALAM + "/" + AppConstants.CATEGORY_ALL_SONGS);
            }
        }
    }

    /**
     * Method to list and open the song lyrics belonging to particular language
     * and Song category
     *
     * @param filePath
     */


    public void openSongLyrics(String filePath) {

        final AssetManager assetManager = getAssets();

        Intent intent = getIntent();
        String songName = intent.getStringExtra(AppConstants.SONG_TITLE);

        try {
            // for assets folder add empty string
            String[] filelist = assetManager.list(filePath);
//            String[] filelist = assetManager.list("");

            if (filelist == null) {
                Toast.makeText(getApplicationContext(), "Songs List not available", Toast.LENGTH_SHORT).show();

            } else {
                for (int i = 0; i < filelist.length; i++) {
                    // Get filename of file or directory
                    String fileName = filelist[i].replaceAll(".txt$", "");
                    Log.d(TAG, "secsongname" + fileName);
                    if (songName.equalsIgnoreCase(fileName)) {

                        try {
                            // get input stream for text
                            InputStream is = getAssets().open(filePath + "/" + filelist[i]);

                            Log.d(TAG, "input" + filelist[i]);

                            // check size
                            int size = is.available();
                            // create buffer for IO
                            byte[] buffer = new byte[size];
                            // get data to buffer
                            is.read(buffer);

                            // close stream
                            is.close();
                            // set result to TextView

                            TextView lyricTextView = (TextView) findViewById(R.id.tv_lyric);
                            lyricTextView.setText(new String(buffer));
                            lyricTextView.setMovementMethod(new ScrollingMovementMethod());
                            lyricTextView.setTextIsSelectable(true);
                        } catch (IOException ex) {
                            Log.i(TAG, ex.toString());
                        }
                        break;
                    }

                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


