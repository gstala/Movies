package com.stala.grzegorz.lab2.Fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.stala.grzegorz.lab2.Activities.MainActivity;
import com.stala.grzegorz.lab2.Models.Actor;
import com.stala.grzegorz.lab2.Models.Movie;
import com.stala.grzegorz.lab2.R;

/**
 * Created by Grzegorz on 11.05.2017.
 */

public class MovieActorsDesc extends Fragment{

    private TextView actorTextView1;
    private TextView actorTextView2;
    private TextView actorTextView3;
    private ImageView actorImage1;
    private ImageView actorImage2;
    private ImageView actorImage3;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater
                .inflate(R.layout.fragment_actors_desc, container, false);

        Movie movie = MainActivity.movieList.get(MainActivity.currentMovie);
        actorTextView1 = (TextView)view.findViewById(R.id.actorTextView1);
        actorTextView2 = (TextView)view.findViewById(R.id.actorTextView2);
        actorTextView3 = (TextView)view.findViewById(R.id.actorTextView3);
        actorImage1 = (ImageView)view.findViewById(R.id.actor_circleImage1);
        actorImage2 = (ImageView)view.findViewById(R.id.actor_circleImage2);
        actorImage3 = (ImageView)view.findViewById(R.id.actor_circleImage3);

        Actor a1 = movie.getActors().get(0);
        Actor a2 = movie.getActors().get(1);
        Actor a3 = movie.getActors().get(2);

        actorTextView1.setText(a1.getFullName());
        actorTextView2.setText(a2.getFullName());
        actorTextView3.setText(a3.getFullName());
        actorImage1.setImageResource(a1.getImage());
        actorImage2.setImageResource(a2.getImage());
        actorImage3.setImageResource(a3.getImage());

        return view;
    }

}
