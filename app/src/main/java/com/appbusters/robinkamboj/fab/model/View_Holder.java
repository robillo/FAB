package com.appbusters.robinkamboj.fab.model;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.appbusters.robinkamboj.fab.R;

/**
 * Created by robinkamboj on 28/11/16.
 */

public class View_Holder extends RecyclerView.ViewHolder{

    CardView cv;
    TextView title;
    TextView description;
    ImageView imageView;

    View_Holder(View viewItem){
        super(viewItem);
        cv= (CardView) viewItem.findViewById(R.id.cardView);
        title= (TextView) viewItem.findViewById(R.id.title);
        description= (TextView) viewItem.findViewById(R.id.description);
        imageView= (ImageView) viewItem.findViewById(R.id.imageView);
    }
}
