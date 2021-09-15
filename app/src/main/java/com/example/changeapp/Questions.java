package com.example.changeapp;

import java.util.List;

public class Questions {

    private String question;
    private List<String> answersList;


    public Questions(String question, List<String> answersList) {
        this.question = question;
        this.answersList = answersList;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public List<String> getAnswersList() {
        return answersList;
    }

    public void setAnswersList(List<String> answersList) {
        this.answersList = answersList;
    }
}
