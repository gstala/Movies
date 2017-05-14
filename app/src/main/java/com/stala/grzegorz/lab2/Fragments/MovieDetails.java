package com.stala.grzegorz.lab2.Fragments;


import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import com.stala.grzegorz.lab2.Activities.MainActivity;
import com.stala.grzegorz.lab2.Models.Movie;
import com.stala.grzegorz.lab2.R;



/**
 * Created by Grzegorz on 11.05.2017.
 */

public class MovieDetails extends android.support.v4.app.Fragment {

    private TextView descTexView;
    private TextView titleTextView;
    private ImageView movieImageInfo;
    private RatingBar movieRating;
    private int index;

    public void setIndex(int index)
    {
        this.index = index;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater
                .inflate(R.layout.fragment_movie_details, container, false);
        final Movie movie = MainActivity.movieList.get(index);
        descTexView = (TextView) view.findViewById(R.id.descTextView);
        titleTextView = (TextView) view.findViewById(R.id.titleTextView);
        movieImageInfo = (ImageView) view.findViewById(R.id.movieImageInfo);
        movieRating = (RatingBar) view.findViewById(R.id.movieRatingBar);
        movieRating.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                  movie.setGrade(rating);
            }
        });
        descTexView.setText(movie.getDesc());
        titleTextView.setText(movie.getTitle());
        movieImageInfo.setImageResource(movie.getImages().get(0));
        movieRating.setRating(movie.getGrade());

        return view;
    }


    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("index",index);
    }

}
