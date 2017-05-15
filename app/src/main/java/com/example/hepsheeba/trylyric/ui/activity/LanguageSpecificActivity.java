package com.example.hepsheeba.trylyric.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import com.example.hepsheeba.trylyric.R;
import com.example.hepsheeba.trylyric.util.AppConstants;

public class LanguageSpecificActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnClassics, btnMelody, btnRock, btnArtist, btnOthers;
    private String TAG = LanguageSpecificActivity.class.getSimpleName();

    public String englishLayout;
    public String hindiLayout;
    public String tamilLayout;
    public String teluguLayout;
    public String kannadaLayout;
    public String malayalamLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_language_specific);

        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);

        Intent intent = getIntent();
        englishLayout = intent.getStringExtra(AppConstants.KEY_ENGLISH);
        hindiLayout = intent.getStringExtra(AppConstants.KEY_HINDI);
        tamilLayout = intent.getStringExtra(AppConstants.KEY_TAMIL);
        teluguLayout = intent.getStringExtra(AppConstants.KEY_TELUGU);
        kannadaLayout = intent.getStringExtra(AppConstants.KEY_KANNADA);
        malayalamLayout = intent.getStringExtra(AppConstants.KEY_MALAYALAM);

        initViews();
        setLayoutVisibility();
    }

    /**
     * To initialize needed views
     */
    public void initViews() {

        //Initializing Views
        btnClassics = (Button) findViewById(R.id.btn_classics);
        btnMelody = (Button) findViewById(R.id.btn_melody);
        btnRock = (Button) findViewById(R.id.btn_rock);
        btnArtist = (Button) findViewById(R.id.btn_artist);
        btnOthers = (Button) findViewById(R.id.btn_all_songs);

        //Setting click listener for views
        btnClassics.setOnClickListener(this);
        btnMelody.setOnClickListener(this);
        btnRock.setOnClickListener(this);
        btnArtist.setOnClickListener(this);
        btnOthers.setOnClickListener(this);

    }

    /**
     * Language Specific categories
     */
    public void setLayoutVisibility() {

        if (((englishLayout != null) && (englishLayout.equalsIgnoreCase(AppConstants.LANGUAGE_ENGLISH)))
                || ((tamilLayout != null) && (tamilLayout.equalsIgnoreCase(AppConstants.LANGUAGE_TAMIL)))) {
            btnClassics.setVisibility(View.VISIBLE);
            btnMelody.setVisibility(View.VISIBLE);
            btnRock.setVisibility(View.VISIBLE);
            btnArtist.setVisibility(View.VISIBLE);
            btnOthers.setVisibility(View.VISIBLE);
        }

        if (((kannadaLayout != null) && (kannadaLayout.equalsIgnoreCase(AppConstants.LANGUAGE_KANNADA)))
                || ((teluguLayout != null) && (teluguLayout.equalsIgnoreCase(AppConstants.LANGUAGE_TELUGU)))
                || ((hindiLayout != null) && (hindiLayout.equalsIgnoreCase(AppConstants.LANGUAGE_HINDI)))
                || ((malayalamLayout != null) && (malayalamLayout.equalsIgnoreCase(AppConstants.LANGUAGE_MALAYALAM)))) {
            btnClassics.setVisibility(View.VISIBLE);
            btnMelody.setVisibility(View.VISIBLE);
            btnOthers.setVisibility(View.VISIBLE);

        }
    }


    /**
     * @param view
     */
    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.btn_classics:
                Intent classicIntent = new Intent(LanguageSpecificActivity.this, SongListActivity.class);
                classicIntent.putExtra(AppConstants.KEY_CLASSIC, AppConstants.CATEGORY_CLASSIC);
                classicIntent.putExtra(AppConstants.KEY_ENGLISH, englishLayout);
                classicIntent.putExtra(AppConstants.KEY_HINDI, hindiLayout);
                classicIntent.putExtra(AppConstants.KEY_TAMIL, tamilLayout);
                classicIntent.putExtra(AppConstants.KEY_TELUGU, teluguLayout);
                classicIntent.putExtra(AppConstants.KEY_KANNADA, kannadaLayout);
                classicIntent.putExtra(AppConstants.KEY_MALAYALAM, malayalamLayout);
                startActivity(classicIntent);
                break;

            case R.id.btn_melody:
                Intent melodyIntent = new Intent(LanguageSpecificActivity.this, SongListActivity.class);
                melodyIntent.putExtra(AppConstants.KEY_MELODY, AppConstants.CATEGORY_MELODY);
                melodyIntent.putExtra(AppConstants.KEY_ENGLISH, englishLayout);
                melodyIntent.putExtra(AppConstants.KEY_HINDI, hindiLayout);
                melodyIntent.putExtra(AppConstants.KEY_TAMIL, tamilLayout);
                melodyIntent.putExtra(AppConstants.KEY_TELUGU, teluguLayout);
                melodyIntent.putExtra(AppConstants.KEY_KANNADA, kannadaLayout);
                melodyIntent.putExtra(AppConstants.KEY_MALAYALAM, malayalamLayout);
                startActivity(melodyIntent);
                break;
            case R.id.btn_rock:
                if (((englishLayout != null) && (englishLayout.equalsIgnoreCase(AppConstants.LANGUAGE_ENGLISH)))
                        || ((tamilLayout != null) && (tamilLayout.equalsIgnoreCase(AppConstants.LANGUAGE_TAMIL)))) {
                Intent rockIntent = new Intent(LanguageSpecificActivity.this, SongListActivity.class);
                rockIntent.putExtra(AppConstants.KEY_ROCK, AppConstants.CATEGORY_ROCK);
                rockIntent.putExtra(AppConstants.KEY_ENGLISH, englishLayout);
                rockIntent.putExtra(AppConstants.KEY_HINDI, hindiLayout);
                rockIntent.putExtra(AppConstants.KEY_TAMIL, tamilLayout);
                rockIntent.putExtra(AppConstants.KEY_TELUGU, teluguLayout);
                rockIntent.putExtra(AppConstants.KEY_KANNADA, kannadaLayout);
                rockIntent.putExtra(AppConstants.KEY_MALAYALAM, malayalamLayout);
                startActivity(rockIntent);
                }
                break;
            case R.id.btn_artist:
//                if (((englishLayout != null) && (englishLayout.equalsIgnoreCase(AppConstants.LANGUAGE_ENGLISH)))
//                        || ((tamilLayout != null) && (tamilLayout.equalsIgnoreCase(AppConstants.LANGUAGE_TAMIL)))) {
//                    Intent artistIntent = new Intent(LanguageSpecificActivity.this, ArtistActivity.class);
//                    startActivity(artistIntent);
//                }

                if (((englishLayout != null) && (englishLayout.equalsIgnoreCase(AppConstants.LANGUAGE_ENGLISH)))
                        || ((tamilLayout != null) && (tamilLayout.equalsIgnoreCase(AppConstants.LANGUAGE_TAMIL)))) {
                Intent artistIntent = new Intent(LanguageSpecificActivity.this, SongListActivity.class);
                artistIntent.putExtra(AppConstants.KEY_ARTIST, AppConstants.CATEGORY_ARTIST);
                artistIntent.putExtra(AppConstants.KEY_ENGLISH, englishLayout);
                artistIntent.putExtra(AppConstants.KEY_TAMIL, tamilLayout);
                startActivity(artistIntent);
                }


                break;
            case R.id.btn_all_songs:
                Intent otherIntent = new Intent(LanguageSpecificActivity.this, SongListActivity.class);
                otherIntent.putExtra(AppConstants.KEY_ALL_SONGS, AppConstants.CATEGORY_ALL_SONGS);
                otherIntent.putExtra(AppConstants.KEY_ENGLISH, englishLayout);
                otherIntent.putExtra(AppConstants.KEY_HINDI, hindiLayout);
                otherIntent.putExtra(AppConstants.KEY_TAMIL, tamilLayout);
                otherIntent.putExtra(AppConstants.KEY_TELUGU, teluguLayout);
                otherIntent.putExtra(AppConstants.KEY_KANNADA, kannadaLayout);
                otherIntent.putExtra(AppConstants.KEY_MALAYALAM, malayalamLayout);
                startActivity(otherIntent);
                break;
        }
    }
}
