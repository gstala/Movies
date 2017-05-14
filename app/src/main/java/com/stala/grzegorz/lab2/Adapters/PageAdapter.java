package com.stala.grzegorz.lab2.Adapters;

/**
 * Created by Grzegorz on 11.05.2017.
 */
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.stala.grzegorz.lab2.Fragments.MovieDetails;
import com.stala.grzegorz.lab2.Fragments.MovieActors;

public class PageAdapter extends FragmentPagerAdapter {

    private Bundle bundle;

    public PageAdapter(FragmentManager fm, Bundle bundle) {
        super(fm);
        this.bundle = bundle;
    }

    @Override
    public Fragment getItem(int arg0) {
        switch (arg0) {
            case 0:
                MovieDetails movieDetails = new MovieDetails();
                movieDetails.setIndex(bundle.getInt("index",0));
                return movieDetails;
            case 1:
                return new MovieActors();
            default:
                break;
        }
        return null;
    }

    @Override
    public int getCount() {
        return 2;
    }


}