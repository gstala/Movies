package com.stala.grzegorz.lab2.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.View;
import android.widget.ImageView;

import com.stala.grzegorz.lab2.Models.Actor;
import com.stala.grzegorz.lab2.Models.Movie;
import com.stala.grzegorz.lab2.Adapters.MoviesAdapter;
import com.stala.grzegorz.lab2.R;
import com.stala.grzegorz.lab2.Adapters.RecyclerTouchListener;
import com.stala.grzegorz.lab2.Adapters.SwipeHelper;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    public static List<Movie> movieList = new ArrayList<>();
    private List<Actor> allActors = new ArrayList<>();
    private List<Integer> allMovieImages = new ArrayList<>();
    private RecyclerView recyclerView;
    private MoviesAdapter mAdapter;
    public static int currentMovie;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        mAdapter = new MoviesAdapter(movieList);
        LinearLayoutManager moviesLayoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, true);
        moviesLayoutManager.setStackFromEnd(true);
        recyclerView.setLayoutManager(moviesLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);
        prepareMovieData();
        recyclerView.setHasFixedSize(true);
        recyclerView.setItemViewCacheSize(20);
        recyclerView.setDrawingCacheEnabled(true);
        recyclerView.setDrawingCacheQuality(View.DRAWING_CACHE_QUALITY_HIGH);
        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(getApplicationContext(), recyclerView, new RecyclerTouchListener.ClickListener() {
            @Override
            public void onClick(View view, int position) {
                Movie movie = movieList.get(position);
                currentMovie = position;
                startSecondActivity(position);
            }

            @Override
            public void onLongClick(View view, int position) {
                ImageView im = (ImageView) view.findViewById(R.id.eyeImageView);
                if (im.getVisibility() == View.INVISIBLE) {
                    im.setVisibility(View.VISIBLE);
                } else {
                    im.setVisibility(View.INVISIBLE);
                }
            }
        }));
        ItemTouchHelper.Callback callback = new SwipeHelper(mAdapter);
        ItemTouchHelper helper = new ItemTouchHelper(callback);
        helper.attachToRecyclerView(recyclerView);
    }

    private void startSecondActivity(int position) {
        Movie movie = movieList.get(position);
        Intent intent = new Intent(this, MovieInfoActivity.class);
        Bundle bundle = new Bundle();
        bundle.putInt("index", position);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    private void prepareMovieData() {

        allActors.add(new Actor("Sylwester Stallone",R.drawable.stallone_image));
        allActors.add(new Actor("Al Pacino",R.drawable.pacino_image));
        allActors.add(new Actor("Natalie Portman",R.drawable.portman_image));
        allActors.add(new Actor("Liam Neeson",R.drawable.neeson_image));
        allActors.add(new Actor("Matthew McConaughey",R.drawable.mcconaughay_image));
        allActors.add(new Actor("Ewan McGregor",R.drawable.mcgregor_image));
        allActors.add(new Actor("Marion Cotillard",R.drawable.cotillard_image));
        allActors.add(new Actor("Christian Bale",R.drawable.bale_image));

        allMovieImages.add(R.drawable.raiders);
        allMovieImages.add(R.drawable.panda);
        allMovieImages.add(R.drawable.sw);

        Movie movie = new Movie("Mad Max: Fury Road", "Action & Adventure", "2015");
        movieList.add(movie);

        movie = new Movie("Inside Out", "Animation, Kids & Family", "2015");
        movieList.add(movie);

        movie = new Movie("Star Wars: Episode VII - The Force Awakens", "Action", "2015");
        movieList.add(movie);

        movie = new Movie("Shaun the Sheep", "Animation", "2015");
        movieList.add(movie);

        movie = new Movie("The Martian", "Science Fiction & Fantasy", "2015");
        movieList.add(movie);

        movie = new Movie("Mission: Impossible Rogue Nation", "Action", "2015");
        movieList.add(movie);

        movie = new Movie("Up", "Animation", "2009");
        movieList.add(movie);

        movie = new Movie("Star Trek", "Science Fiction", "2009");
        movieList.add(movie);

        movie = new Movie("The LEGO Movie", "Animation", "2014");
        movieList.add(movie);

        movie = new Movie("Iron Man", "Action & Adventure", "2008");
        movieList.add(movie);

        movie = new Movie("Aliens", "Science Fiction", "1986");
        movieList.add(movie);

        movie = new Movie("Chicken Run", "Animation", "2000");
        movieList.add(movie);

        movie = new Movie("Back to the Future", "Science Fiction", "1985");
        movieList.add(movie);

        movie = new Movie("Raiders of the Lost Ark", "Action & Adventure", "1981");
        movieList.add(movie);

        movie = new Movie("Goldfinger", "Action & Adventure", "1965");
        movieList.add(movie);

        movie = new Movie("Guardians of the Galaxy", "Science Fiction & Fantasy", "2014");
        movieList.add(movie);

        Random random = new Random();
        for (Movie m : movieList) {
            m.setDesc(getResources().getString(R.string.desc));
            while(m.getActors().size()<3)
            {
                Actor actor = allActors.get(random.nextInt(allActors.size()));
                if (!m.getActors().contains(actor))
                    m.addActor(actor);
            }
            while(m.getImages().size()<6)
            {
                m.addImage(allMovieImages.get(random.nextInt(allMovieImages.size())));
            }
        }
        mAdapter.notifyDataSetChanged();
    }
}
