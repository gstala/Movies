package com.stala.grzegorz.lab2.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.stala.grzegorz.lab2.Activities.MainActivity;
import com.stala.grzegorz.lab2.Models.Actor;
import com.stala.grzegorz.lab2.Models.Movie;
import com.stala.grzegorz.lab2.R;

import java.util.List;

/**
 * Created by Grzegorz on 11.05.2017.
 */

public class MovieActorsIm extends android.support.v4.app.Fragment{

    private ImageView actorImageView1;
    private ImageView actorImageView2;
    private ImageView actorImageView3;
    private ImageView actorImageView4;
    private ImageView actorImageView5;
    private ImageView actorImageView6;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater
                .inflate(R.layout.fragment_actors_images, container, false);

        actorImageView1 = (ImageView) view.findViewById(R.id.actor_imageView1);
        actorImageView2 = (ImageView) view.findViewById(R.id.actor_imageView2);
        actorImageView3 = (ImageView) view.findViewById(R.id.actor_imageView3);
        actorImageView4 = (ImageView) view.findViewById(R.id.actor_imageView4);
        actorImageView5 = (ImageView) view.findViewById(R.id.actor_imageView5);
        actorImageView6 = (ImageView) view.findViewById(R.id.actor_imageView6);

        Movie movie = MainActivity.movieList.get(MainActivity.currentMovie);
        List<Integer> images = movie.getImages();
        actorImageView1.setImageResource(images.get(0));
        actorImageView2.setImageResource(images.get(1));
        actorImageView3.setImageResource(images.get(2));
        actorImageView4.setImageResource(images.get(3));
        actorImageView5.setImageResource(images.get(4));
        actorImageView6.setImageResource(images.get(5));

        return view;
    }


}
