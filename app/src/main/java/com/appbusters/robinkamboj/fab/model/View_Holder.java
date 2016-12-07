package com.appbusters.robinkamboj.fab.model;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.appbusters.robinkamboj.fab.R;
import com.appbusters.robinkamboj.fab.ui.Level1_extended;

/**
 * Created by robinkamboj on 28/11/16.
 */

public class View_Holder extends RecyclerView.ViewHolder implements View.OnClickListener{

    CardView cv;
    Context context;
    public TextView title;
    public TextView description;
    public ImageView imageView;

    public View_Holder(View viewItem){
        super(viewItem);
        cv= (CardView) viewItem.findViewById(R.id.cardView);
        title= (TextView) viewItem.findViewById(R.id.title);
        description= (TextView) viewItem.findViewById(R.id.description);
        imageView= (ImageView) viewItem.findViewById(R.id.imageView);
    }

    @Override
    public void onClick(View view) {
        Intent i= new Intent(context, Level1_extended.class);
        context.startActivity(i);
    }
}
