package com.stala.grzegorz.lab2.Activities;

import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.os.Bundle;

import com.stala.grzegorz.lab2.Adapters.PageAdapter;
import com.stala.grzegorz.lab2.R;

import junit.framework.Assert;

public class MovieInfoActivity extends FragmentActivity {

    private ViewPager viewpager;
    private Bundle bundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_info);

        bundle = getIntent().getExtras();
        viewpager = (ViewPager) findViewById(R.id.pager);
        PageAdapter padapter = new PageAdapter(getSupportFragmentManager(), bundle);
        viewpager.setAdapter(padapter);
    }

    public void onSaveInstanceState(Bundle outState) {
        outState.putInt("currentItem", viewpager.getCurrentItem());
    }

    public void onRestoreInstanceState(Bundle inState) {
        viewpager.setCurrentItem(inState.getInt("currentItem", 0));
    }

}
