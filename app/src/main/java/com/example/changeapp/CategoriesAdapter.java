package com.example.changeapp;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CategoriesAdapter extends RecyclerView.Adapter<CategoriesAdapter.CategoriesViewHolder> {


    //this context we will use to inflate the layout
    private Context mCtx;

    //we are storing all the products in a list
    private List<Categories> categoriesList;

    //getting the context and product list with constructor
    public CategoriesAdapter(Context mCtx, List<Categories> categoriesList) {
        this.mCtx = mCtx;
        this.categoriesList = categoriesList;
    }

    @NonNull
    @Override
    public CategoriesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        //inflating and returning our view holder
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.layout_horizontal_categories, null);
        return new CategoriesViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull CategoriesViewHolder holder, int position) {

        //getting the product of the specified position
        Categories categories = categoriesList.get(position);

        //binding the data with the viewholder views
        holder.textViewTitle.setText(categories.getTitle());

        holder.imageView.setImageDrawable(mCtx.getResources().getDrawable(categories.getIcon()));

        holder.linearLayout.setBackgroundColor(ContextCompat.getColor(mCtx, categories.getBackgroundColor()));

        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(mCtx, SurveysActivity.class);
                mCtx.startActivity(intent);

            }
        });

        if (position == 0){
            holder.imageView.setColorFilter(ContextCompat.getColor(mCtx, R.color.purple_700), android.graphics.PorterDuff.Mode.SRC_IN);
            holder.textViewTitle.setTextColor(ContextCompat.getColor(mCtx, R.color.purple_700));

        }


    }

    @Override
    public int getItemCount() {

        return categoriesList.size();

    }

    class CategoriesViewHolder extends RecyclerView.ViewHolder {

        TextView textViewTitle;
        ImageView imageView;
        LinearLayout linearLayout;

        public CategoriesViewHolder(View itemView) {
            super(itemView);

            textViewTitle = itemView.findViewById(R.id.txtViewTitle);
            imageView = itemView.findViewById(R.id.img_icon);
            linearLayout = itemView.findViewById(R.id.category_layout);
        }
    }

}
