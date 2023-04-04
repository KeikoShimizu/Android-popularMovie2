package com.example.popularmovie;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        ImageView poster = findViewById(R.id.poster_image);
        TextView rating = findViewById(R.id.mRating);
        TextView title = findViewById(R.id.mTitle);
        TextView description = findViewById(R.id.mDescription);

        Bundle bundle = getIntent().getExtras();

        String mTitle = bundle.getString("title");
        String mPoster = bundle.getString("poster");
        String mOverView = bundle.getString("overview");
        Double mRating = bundle.getDouble("rating");

        Picasso.get().load(mPoster).into(poster);
        rating.setText(Double.toString(mRating));
        title.setText(mTitle);
        description.setText(mOverView);
    }
}