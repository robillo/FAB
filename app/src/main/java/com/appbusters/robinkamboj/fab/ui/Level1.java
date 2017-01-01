package com.appbusters.robinkamboj.fab.ui;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
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
        Animation alpha_initial = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.alpha_initial);
        fab.startAnimation(alpha_initial);
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
            fabL1.setVisibility(View.VISIBLE);
            fabL2.setVisibility(View.VISIBLE);
            fabR1.setVisibility(View.VISIBLE);
            fabR2.setVisibility(View.VISIBLE);
            FabClosed=false;
        }
        else{
            fab.startAnimation(rotate_backward);
            fabL1.startAnimation(fab_close);
            fabR1.startAnimation(fab_close);
            fabL2.startAnimation(fab_close);
            fabR2.startAnimation(fab_close);
            fabL1.setVisibility(View.INVISIBLE);
            fabL2.setVisibility(View.INVISIBLE);
            fabR1.setVisibility(View.INVISIBLE);
            fabR2.setVisibility(View.INVISIBLE);
            FabClosed=true;
        }
    }

    public List<Data> fillWithData() {
        List<Data> data= new ArrayList<>();

        String[] TTs= {getString(R.string.oneone),getString(R.string.onetwo),getString(R.string.onethree),
        getString(R.string.onefour),getString(R.string.onefive), getString(R.string.onesix),getString(R.string.oneseven),getString(R.string.oneeight),getString(R.string.onenine),
        getString(R.string.oneten),getString(R.string.oneeleven),getString(R.string.enetwelve),getString(R.string.onethirteen),
        getString(R.string.onefourteen),getString(R.string.fifteen)};

        int i=0;
        for(String x: TTs){
            data.add(new Data(TTs[i], "LEVEL 1 TT " + (i+1), R.drawable.one));
            i++;
        }

        return data;
    }
}
