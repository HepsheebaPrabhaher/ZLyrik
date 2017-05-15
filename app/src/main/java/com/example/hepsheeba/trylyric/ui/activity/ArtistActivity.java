package com.example.hepsheeba.trylyric.ui.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.hepsheeba.trylyric.ui.adapter.ArtistAdapter;
import com.example.hepsheeba.trylyric.model.ArtistModel;
import com.example.hepsheeba.trylyric.R;

import java.util.ArrayList;

public class ArtistActivity extends AppCompatActivity {

    private final String artist_names[] = {
            "Hema John",
            "Annie Solomon",
            "Jolly Abraham",
            "John Jebaraj",
            "Benny Dayal",
            "Alwin Thomas"
    };


    private final String artist_images[] = {
            String.valueOf(R.drawable.flower),
            String.valueOf(R.drawable.flower),
            String.valueOf(R.drawable.flower),
            String.valueOf(R.drawable.flower),
            String.valueOf(R.drawable.flower),
            String.valueOf(R.drawable.flower)
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_artist);
        initViews();
    }

    public void initViews() {

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.rv_artist_grid);
        recyclerView.setHasFixedSize(true);

        RecyclerView.LayoutManager artistLayoutManager = new GridLayoutManager(getApplicationContext(), 2);
        recyclerView.setLayoutManager(artistLayoutManager);

        ArrayList<ArtistModel> artistModelArrayList = prepareData();
        ArtistAdapter adapter = new ArtistAdapter(getApplicationContext(), artistModelArrayList);
        recyclerView.setAdapter(adapter);
    }

    private ArrayList<ArtistModel> prepareData() {
        ArrayList<ArtistModel> artistModels = new ArrayList<>();

        for (int i = 0; i < artist_names.length; i++) {
            ArtistModel artistModel = new ArtistModel();
            artistModel.setArtist_name(artist_names[i]);
            artistModel.setArtist_image(Integer.parseInt(artist_images[i]));
            artistModels.add(artistModel);
        }
        return artistModels;
    }
}
