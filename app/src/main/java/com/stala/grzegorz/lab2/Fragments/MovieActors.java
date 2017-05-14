package com.stala.grzegorz.lab2.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.stala.grzegorz.lab2.R;

/**
 * Created by Grzegorz on 11.05.2017.
 */

public class MovieActors extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater
                .inflate(R.layout.fragment_movie, container, false);
        return view;
    }


}
