package com.example.android.motionlayout;

import android.animation.Animator;
import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {

    private ArrayList list;
    private Context context;

    public CustomAdapter(Context context, ArrayList list){
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        //Inflate the item layout
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_items,viewGroup,false);
        // set the view's size, margins, paddings and layout parameters
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, int position) {
        // set the data in items
        holder.item.setText((CharSequence) list.get(position));
        // implement setOnClickListener event on item view.
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View view) {
                // display a toast with person name on item click
                Toast.makeText(context, (CharSequence) list.get(holder.getAdapterPosition()), Toast.LENGTH_SHORT).show();
                int radius = (int)Math.hypot(view.getWidth()/2,view.getHeight()/2);

                Animator animator = ViewAnimationUtils.createCircularReveal(
                        view,view.getWidth()/2,view.getHeight()/2,0, radius);
                view.setBackgroundColor(Color.GREEN);
                animator.start();
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView item;// init the item view's
        //I am using default access specifier to make construcot
        MyViewHolder(View itemView) {
            super(itemView);
            // get the reference of item view's
            item = (TextView) itemView.findViewById(R.id.textView);
        }
    }
}
