package com.appbusters.robinkamboj.fab.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.appbusters.robinkamboj.fab.R;
import com.appbusters.robinkamboj.fab.model.Data;
import com.appbusters.robinkamboj.fab.model.View_Holder;

import java.util.Collections;
import java.util.List;

/**
 * Created by robinkamboj on 28/11/16.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<View_Holder>{

    List<Data> list= Collections.emptyList();
    Context context;

    public RecyclerViewAdapter(List<Data> list, Context context){
        this.list=list;
        this.context=context;
    }

    @Override
    public View_Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        //inflate the layout and initialize the view holder
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.row_layout,parent,false);
        View_Holder holder= new View_Holder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(View_Holder holder, int position) {

        //use the provided View_Holder given in the ocCreateViewHolder to populate the current row in RecyclerView
        holder.title.setText(list.get(position).title);
        holder.description.setText(list.get(position).description);
        holder.imageId.setText(list.get(position).imageId);

        //animate(holder);
    }

    @Override
    public int getItemCount() {
        //return the number of rows the recyclerView will be displaying
        return list.size();
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    //Insert a new row to the recyclerview at a given position
    public  void insert(int position, Data data){
        list.add(position,data);
        notifyItemInserted(position);
    }

    //Delete a row at a given position of the recyclerview
    public void remove(Data data){
        int position= list.indexOf(data);
        list.remove(position);
        notifyItemRemoved(position);
    }

}
