package com.example.changeapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class DashboardFragment extends Fragment {

    //a list to store all the categories
    List<Categories> categoriesList;

    //a list to store all the surveys
    List<AllSurveys> allSurveysList;

    //the recyclerview
    RecyclerView recyclerView;
    RecyclerView allSurveysRecyclerView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View myView = inflater.inflate(R.layout.fragment_dashboard, container, false);

        //getting the recyclerview from xml
        recyclerView = myView.findViewById(R.id.horizontalRecyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));

        //initializing the productlist
        categoriesList = new ArrayList<>();


        //adding some items to our list
        categoriesList.add(
                new Categories(
                        R.drawable.ic_category_all,
                        "See All",
                        R.color.white));

        categoriesList.add(
                new Categories(
                        R.drawable.ic_health,
                        "Health",
                        R.color.light_red));

        categoriesList.add(
                new Categories(
                        R.drawable.ic_politics,
                        "Politics",
                        R.color.orange));

        categoriesList.add(
                new Categories(
                        R.drawable.ic_business,
                        "Business",
                        R.color.primary));



        //creating recyclerview adapter
        CategoriesAdapter adapter = new CategoriesAdapter(getActivity(), categoriesList);

        //setting adapter to recyclerview
        recyclerView.setAdapter(adapter);

        //############################################
        //All surveys recycler view

        //getting the recyclerview from xml
        allSurveysRecyclerView = myView.findViewById(R.id.allSurveysRecyclerView);
        allSurveysRecyclerView.setHasFixedSize(true);
        allSurveysRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

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
        AllSurveysAdapter allSurveysAdapter = new AllSurveysAdapter(getActivity(), allSurveysList);

        //setting adapter to recyclerview
        allSurveysRecyclerView.setAdapter(allSurveysAdapter);


        // Inflate the layout for this fragment
        return myView;

    }
}

