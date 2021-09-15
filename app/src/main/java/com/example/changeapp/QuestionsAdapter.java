package com.example.changeapp;

import android.content.Context;
import android.content.res.ColorStateList;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class QuestionsAdapter extends RecyclerView.Adapter<QuestionsAdapter.ViewHolder> {

    List<Questions> questionsList = new ArrayList<>();
    private Context context;

    private RadioGroup lastCheckedRadioGroup = null;

    public QuestionsAdapter(List<Questions> questionsList1, Context ctx) {
        questionsList = questionsList1;
        context = ctx;
    }

    @NonNull
    @Override
    public QuestionsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_questions, parent, false);

        QuestionsAdapter.ViewHolder viewHolder = new QuestionsAdapter.ViewHolder(view);
        return viewHolder;

    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        Questions questionsModel = questionsList.get(position);
        holder.question.setText(questionsModel.getQuestion());

        int id = (position+1)*100;

        for(String answer : questionsModel.getAnswersList()){

            RadioButton rb = new RadioButton(QuestionsAdapter.this.context);
            rb.setBackground(ContextCompat.getDrawable(context, R.drawable.questions_radio_background));
            rb.setId(id++);
            rb.setText(answer);

            ColorStateList colorStateList = new ColorStateList(
                    new int[][]
                            {
                                    new int[]{-android.R.attr.state_checked}, // Disabled
                                    new int[]{android.R.attr.state_checked}   // Enabled
                            },
                    new int[]
                            {
                                    R.color.white, // disabled
                                    R.color.white   // enabled
                            }
            );
//
//            ColorStateList colorStateText = new ColorStateList(
//                    new int[][]
//                            {
//                                    new int[]{-android.R.attr.state_checked}, // Disabled
//                                    new int[]{android.R.attr.state_checked}   // Enabled
//                            },
//                    new int[]
//                            {
//                                    R.color.primary_dark, // disabled
//                                    R.color.white   // enabled
//                            }
//            );
//
            rb.setButtonTintList(colorStateList);
//
//            rb.setTextColor(colorStateText);

            RadioGroup.LayoutParams params = new RadioGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            rb.setLayoutParams(params);
            rb.setPadding(0, 0, 30, 0);

            holder.answersGroup.addView(rb);
        }

    }

    @Override
    public int getItemCount() {
        return questionsList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView question;
        public RadioGroup answersGroup;

        public ViewHolder(View view) {
            super(view);
            question = (TextView) view.findViewById(R.id.txt_question);
            answersGroup = (RadioGroup) view.findViewById(R.id.questions_radio_group);

            answersGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(RadioGroup radioGroup, int i) {
                    //since only one package is allowed to be selected
                    //this logic clears previous selection
                    //it checks state of last radiogroup and
                    // clears it if it meets conditions
                    if (lastCheckedRadioGroup != null
                            && lastCheckedRadioGroup.getCheckedRadioButtonId()
                            != radioGroup.getCheckedRadioButtonId()
                            && lastCheckedRadioGroup.getCheckedRadioButtonId() != -1) {
                        lastCheckedRadioGroup.clearCheck();

                        Toast.makeText(QuestionsAdapter.this.context,
                                "Radio button clicked " + radioGroup.getCheckedRadioButtonId(),
                                Toast.LENGTH_SHORT).show();

                    }
                    lastCheckedRadioGroup = radioGroup;

                }
            });
        }
    }

}
