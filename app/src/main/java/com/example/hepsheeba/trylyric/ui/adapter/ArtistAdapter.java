package com.example.hepsheeba.trylyric.ui.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hepsheeba.trylyric.model.ArtistModel;
import com.example.hepsheeba.trylyric.R;
import com.example.hepsheeba.trylyric.ui.activity.SongListActivity;

import java.util.ArrayList;

/**
 * Created by Hepsheeba on 4/25/2017.
 */

public class ArtistAdapter extends RecyclerView.Adapter<ArtistAdapter.ViewHolder> {

    public static final String TAG = ArtistAdapter.class.getSimpleName();

    private ArrayList<ArtistModel> artist;
    private Context context;


    public ArtistAdapter(Context context, ArrayList<ArtistModel> artist) {
        this.context = context;
        this.artist = artist;
    }

    @Override
    public ArtistAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_view_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ArtistAdapter.ViewHolder holder, int position) {
        holder.mArtistName.setText(artist.get(position).getArtist_name());
        holder.mArtistImage.setImageResource(artist.get(position).getArtist_image());

        holder.mArtistImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String artistName = holder.mArtistName.getText().toString();
                Log.d(TAG, "artistclick: " + artistName);
                Intent intent = new Intent(context, SongListActivity.class);
                intent.putExtra("artistname", artistName);

                view.getContext().startActivity(intent);


//                if (name.equals("HemaJohn")) {
//
//                    Intent intent = new Intent(context, SongListActivity.class);
//                    intent.putExtra("hema", "hema");
//
//                    view.getContext().startActivity(intent);
////                    Toast.makeText(context, "Hema", Toast.LENGTH_SHORT).show();
//                } else {
//                    Toast.makeText(context, "Unknown", Toast.LENGTH_SHORT).show();
//
//                }
            }
        });
//        }
    }

    @Override
    public int getItemCount() {
        return artist.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView mArtistName;
        private ImageView mArtistImage;

        public ViewHolder(View itemView) {
            super(itemView);

//            itemView.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    Toast.makeText(context, "Testing...", Toast.LENGTH_SHORT).show();
//
//                }
//            });

            mArtistName = (TextView) itemView.findViewById(R.id.tv_artist_name);
            mArtistImage = (ImageView) itemView.findViewById(R.id.iv_artist);

//            mArtistImage.setOnClickListener(this);
        }

//        @Override
//        public void onClick(View view) {
//
//            int position = getAdapterPosition();
//
//            switch (view.getId()) {
//
//                case R.id.iv_artist:
//
//                    Toast.makeText(context, "position" + position, Toast.LENGTH_SHORT).show();
//                    break;
//            }
//        }
    }
}
