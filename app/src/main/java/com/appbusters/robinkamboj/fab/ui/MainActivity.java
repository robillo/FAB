package com.appbusters.robinkamboj.fab.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.appbusters.robinkamboj.fab.R;
import com.appbusters.robinkamboj.fab.adapter.RecyclerViewAdapter;
import com.appbusters.robinkamboj.fab.model.Data;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    FloatingActionButton fab,fabL1,fabL2,fabR1,fabR2;
    private Animation rotate_forward;
    private Animation rotate_backward;
    private Animation fab_open;
    private Animation fab_close;
    private boolean FabClosed=true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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


        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                animateFab();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
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

    public void level1(View view){
        Intent i= new Intent(this, Level1.class);
        startActivity(i);
    }

}
