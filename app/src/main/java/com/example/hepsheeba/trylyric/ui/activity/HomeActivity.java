package com.example.hepsheeba.trylyric.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RelativeLayout;

import com.example.hepsheeba.trylyric.R;
import com.example.hepsheeba.trylyric.util.AppConstants;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener {

    private RelativeLayout rltEnglish, rltHindi, rltTamil, rltTelugu, rltKannada, rltMalayalam;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        //Initializing Views
        rltEnglish = (RelativeLayout) findViewById(R.id.rt_english);
        rltHindi = (RelativeLayout) findViewById(R.id.rt_hindi);
        rltTamil = (RelativeLayout) findViewById(R.id.rt_tamil);
        rltTelugu = (RelativeLayout) findViewById(R.id.rt_telugu);
        rltKannada = (RelativeLayout) findViewById(R.id.rt_kannada);
        rltMalayalam = (RelativeLayout) findViewById(R.id.rt_malayalam);

        //Setting click listener for views
        rltEnglish.setOnClickListener(this);
        rltHindi.setOnClickListener(this);
        rltTamil.setOnClickListener(this);
        rltTelugu.setOnClickListener(this);
        rltKannada.setOnClickListener(this);
        rltMalayalam.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.rt_english:
                Intent englishIntent = new Intent(HomeActivity.this, LanguageSpecificActivity.class);
                englishIntent.putExtra(AppConstants.KEY_ENGLISH, AppConstants.LANGUAGE_ENGLISH);
                startActivity(englishIntent);
                break;

            case R.id.rt_hindi:
                Intent hindiIntent = new Intent(HomeActivity.this, LanguageSpecificActivity.class);
                hindiIntent.putExtra(AppConstants.KEY_HINDI, AppConstants.LANGUAGE_HINDI);
                startActivity(hindiIntent);
                break;
            case R.id.rt_tamil:
                Intent tamilIntent = new Intent(HomeActivity.this, LanguageSpecificActivity.class);
                tamilIntent.putExtra(AppConstants.KEY_TAMIL, AppConstants.LANGUAGE_TAMIL);
                startActivity(tamilIntent);
                break;
            case R.id.rt_telugu:
                Intent teluguIntent = new Intent(HomeActivity.this, LanguageSpecificActivity.class);
                teluguIntent.putExtra(AppConstants.KEY_TELUGU, AppConstants.LANGUAGE_TELUGU);
                startActivity(teluguIntent);
                break;
            case R.id.rt_kannada:
                Intent kannadaIntent = new Intent(HomeActivity.this, LanguageSpecificActivity.class);
                kannadaIntent.putExtra(AppConstants.KEY_KANNADA, AppConstants.LANGUAGE_KANNADA);
                startActivity(kannadaIntent);
                break;

            case R.id.rt_malayalam:
                Intent malayalamIntent = new Intent(HomeActivity.this, LanguageSpecificActivity.class);
                malayalamIntent.putExtra(AppConstants.KEY_MALAYALAM, AppConstants.LANGUAGE_MALAYALAM);
                startActivity(malayalamIntent);
                break;
        }


    }
}
