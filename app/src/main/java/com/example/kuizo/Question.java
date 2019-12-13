package com.example.kuizo;

public class Question {
    private int id;
    private String Text;
    private Boolean Answer;


    public Question(int id, String text, Boolean answer) {
        this.id = id;
        Text = text;
        Answer = answer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return Text;
    }

    public void setText(String text) {
        Text = text;
    }

    public Boolean getAnswer() {
        return Answer;
    }

    public void setAnswer(Boolean answer) {
        Answer = answer;
    }
}


