package com.appbusters.robinkamboj.fab.ui;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.appbusters.robinkamboj.fab.R;
import com.appbusters.robinkamboj.fab.adapter.RecyclerViewAdapter;
import com.appbusters.robinkamboj.fab.model.Data;

import java.util.ArrayList;
import java.util.List;

import static com.appbusters.robinkamboj.fab.R.anim.fab_close;
import static com.appbusters.robinkamboj.fab.R.anim.fab_open;
import static com.appbusters.robinkamboj.fab.R.anim.rotate_backward;
import static com.appbusters.robinkamboj.fab.R.anim.rotate_forward;
import static com.appbusters.robinkamboj.fab.R.id.fab;
import static com.appbusters.robinkamboj.fab.R.id.fabL1;
import static com.appbusters.robinkamboj.fab.R.id.fabL2;
import static com.appbusters.robinkamboj.fab.R.id.fabR1;
import static com.appbusters.robinkamboj.fab.R.id.fabR2;

public class Level1 extends AppCompatActivity {

    FloatingActionButton fab,fabL1,fabL2,fabR1,fabR2;
    private Animation rotate_forward;
    private Animation rotate_backward;
    private Animation fab_open;
    private Animation fab_close;
    private boolean FabClosed=true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level1);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        fab = (FloatingActionButton) findViewById(R.id.fab);
        fabL1 = (FloatingActionButton) findViewById(R.id.fabL1);
        fabL2 = (FloatingActionButton) findViewById(R.id.fabL2);
        fabR1 = (FloatingActionButton) findViewById(R.id.fabR1);
        fabR2 = (FloatingActionButton) findViewById(R.id.fabR2);
        fab_open= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fab_open);
        fab_close= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fab_close);
        rotate_forward= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.rotate_forward);
        rotate_backward= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.rotate_backward);
        Animation fab_close_initial = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fab_close_initial);
        fabL1.startAnimation(fab_close_initial);
        fabL2.startAnimation(fab_close_initial);
        fabR1.startAnimation(fab_close_initial);
        fabR2.startAnimation(fab_close_initial);

        List<Data> data= fillWithData();
        RecyclerView recyclerView= (RecyclerView) findViewById(R.id.recyclerview);
        RecyclerViewAdapter adapter= new RecyclerViewAdapter(data, getApplication());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                animateFab();
            }
        });
    }

    private void animateFab() {

        if(FabClosed){
            fab.startAnimation(rotate_forward);
            fabL1.startAnimation(fab_open);
            fabR1.startAnimation(fab_open);
            fabL2.startAnimation(fab_open);
            fabR2.startAnimation(fab_open);
            FabClosed=false;
        }
        else{
            fab.startAnimation(rotate_backward);
            fabL1.startAnimation(fab_close);
            fabR1.startAnimation(fab_close);
            fabL2.startAnimation(fab_close);
            fabR2.startAnimation(fab_close);
            FabClosed=true;
        }
    }

    public List<Data> fillWithData() {
        List<Data> data= new ArrayList<>();

        data.add(new Data(getResources().getString(R.string.app_name), "Following the destruction of Metropolis, Batman embarks on a personal vendetta against Superman ", R.mipmap.ic_launcher));
        data.add(new Data(getResources().getString(R.string.app_name), "X-Men: Apocalypse is an upcoming American superhero film based on the X-Men characters that appear in Marvel Comics ", R.mipmap.ic_launcher));
        data.add(new Data("Captain America: Civil War", "A feud between Captain America and Iron Man leaves the Avengers in turmoil.  ", R.mipmap.ic_launcher));
        data.add(new Data("Kung Fu Panda 3", "After reuniting with his long-lost father, Po  must train a village of pandas", R.mipmap.ic_launcher));
        data.add(new Data(getResources().getString(R.string.app_name), "Following the destruction of Metropolis, Batman embarks on a personal vendetta against Superman ", R.mipmap.ic_launcher));
        data.add(new Data(getResources().getString(R.string.app_name), "X-Men: Apocalypse is an upcoming American superhero film based on the X-Men characters that appear in Marvel Comics ", R.mipmap.ic_launcher));
        data.add(new Data("Captain America: Civil War", "A feud between Captain America and Iron Man leaves the Avengers in turmoil.  ", R.mipmap.ic_launcher));
        data.add(new Data("Kung Fu Panda 3", "After reuniting with his long-lost father, Po  must train a village of pandas", R.mipmap.ic_launcher));

        return data;
    }
}
