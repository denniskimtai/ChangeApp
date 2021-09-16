package com.example.changeapp;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class SurveysActivity extends AppCompatActivity {

    //a list to store all the surveys
    List<AllSurveys> allSurveysList;

    RecyclerView allSurveysRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_surveys);

        allSurveysRecyclerView = findViewById(R.id.allSurveysRecyclerView);
        allSurveysRecyclerView.setHasFixedSize(true);
        allSurveysRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        //initializing the productlist
        allSurveysList = new ArrayList<>();

        //adding some items to our list
        allSurveysList.add(
                new AllSurveys(
                        "Political Strategy Study",
                        "Take this study and benchmark the current ranking of other politicians in the area",
                        R.drawable.political
                ));

        allSurveysList.add(
                new AllSurveys(
                        "IT Effectiveness in Political Strategy",
                        "Take this study and benchmark the current ranking of other politicians in the area",
                        R.drawable.political
                ));

        allSurveysList.add(
                new AllSurveys(
                        "Study on Online Campaign Effectiveness",
                        "Take this study and benchmark the current ranking of other politicians in the area",
                        R.drawable.political
                ));

        //creating recyclerview adapter
        AllSurveysAdapter allSurveysAdapter = new AllSurveysAdapter(this, allSurveysList);

        //setting adapter to recyclerview
        allSurveysRecyclerView.setAdapter(allSurveysAdapter);

    }
}