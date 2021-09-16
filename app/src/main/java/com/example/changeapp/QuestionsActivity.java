package com.example.changeapp;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class QuestionsActivity extends AppCompatActivity {

    private RecyclerView questionsRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions);

        questionsRecyclerView = findViewById(R.id.questionsRecyclerView);

        questionsRecyclerView.setHasFixedSize(true);
        LinearLayoutManager recyclerLayoutManager = new LinearLayoutManager(this);
        questionsRecyclerView.setLayoutManager(recyclerLayoutManager);

//        DividerItemDecoration dividerItemDecoration =
//                new DividerItemDecoration(questionsRecyclerView.getContext(),
//                        recyclerLayoutManager.getOrientation());
//        questionsRecyclerView.addItemDecoration(dividerItemDecoration);

        QuestionsAdapter recyclerViewAdapter = new
                QuestionsAdapter(getPackages(),this);
        questionsRecyclerView.setAdapter(recyclerViewAdapter);

    }

    private List<Questions> getPackages(){
        List<Questions> modelList = new ArrayList<Questions>();

        List<String> priceList = new ArrayList<String>();
        priceList.add("Lorem ipsum dolor sit amet");
        priceList.add("Excepteur sint occaecat");
        priceList.add("deserunt mollit anim id est laborum");
        modelList.add(new Questions("1. Which best describes the role of an MCA today?", priceList));

        priceList = new ArrayList<String>();
        priceList.add("Lorem ipsum dolor sit amet");
        priceList.add("Excepteur sint occaecat");
        priceList.add("deserunt mollit anim id est laborum");
        modelList.add(new Questions("2. HD Movie TV Channels that you use?", priceList));

        priceList = new ArrayList<String>();
        priceList.add("Lorem ipsum dolor sit amet");
        priceList.add("Excepteur sint occaecat");
        priceList.add("deserunt mollit anim id est laborum");
        modelList.add(new Questions("3. How did you hear about this survey?", priceList));

        priceList = new ArrayList<String>();
        priceList.add("Lorem ipsum dolor sit amet");
        priceList.add("Excepteur sint occaecat");
        priceList.add("deserunt mollit anim id est laborum");
        modelList.add(new Questions("4. Which best describes the role of a Governor today?", priceList));


        return modelList;
    }

}