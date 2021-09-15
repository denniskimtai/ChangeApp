package com.example.changeapp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AllSurveysAdapter extends RecyclerView.Adapter<AllSurveysAdapter.AllSurveysViewHolder> {

    //this context we will use to inflate the layout
    private Context mCtx;

    //we are storing all the products in a list
    private List<AllSurveys> allSurveysList;

    //getting the context and product list with constructor
    public AllSurveysAdapter(Context mCtx, List<AllSurveys> allSurveysList) {
        this.mCtx = mCtx;
        this.allSurveysList = allSurveysList;
    }

    @NonNull
    @Override
    public AllSurveysAdapter.AllSurveysViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        //inflating and returning our view holder
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.layout_all_surveys, null);
        return new AllSurveysViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull AllSurveysViewHolder holder, int position) {


        //getting the product of the specified position
        AllSurveys allSurveys = allSurveysList.get(position);

        //binding the data with the viewholder views
        holder.textViewTitle.setText(allSurveys.getTitle());
        holder.textViewShortDesc.setText(allSurveys.getShortdesc());

        holder.imageView.setImageDrawable(mCtx.getResources().getDrawable(allSurveys.getImage()));

        holder.btnTakeSurvey.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(mCtx, QuestionsActivity.class);
                mCtx.startActivity(intent);

            }
        });


    }

    @Override
    public int getItemCount() {
        return allSurveysList.size();
    }

    class AllSurveysViewHolder extends RecyclerView.ViewHolder {

        TextView textViewTitle, textViewShortDesc;
        ImageView imageView;
        Button btnTakeSurvey;

        public AllSurveysViewHolder(View itemView) {
            super(itemView);

            textViewTitle = itemView.findViewById(R.id.surveyTitle);
            textViewShortDesc = itemView.findViewById(R.id.surveyShortDesc);
            imageView = itemView.findViewById(R.id.surveyImage);
            btnTakeSurvey = itemView.findViewById(R.id.btn_take_survey);
        }
    }

}
