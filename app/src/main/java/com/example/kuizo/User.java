package com.example.kuizo;

public class User {

    private String Username ;
    private String Password ;
    private int NbAnsweredQuestions;
    private int NbCorrectAnswers;

    public User() {
        this.NbAnsweredQuestions=0;
        this.NbCorrectAnswers=0;
    }

    public User(String username, String password, int nbAnsweredQuestions, int nbCorrectAnswers) {
        Username = username;
        Password = password;
        NbAnsweredQuestions = nbAnsweredQuestions;
        NbCorrectAnswers = nbCorrectAnswers;
    }

    public User(String username, String password, String email) {
        Username = username;
        Password = password;

    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public int getNbAnsweredQuestions() {
        return NbAnsweredQuestions;
    }

    public void setNbAnsweredQuestions(int nbAnsweredQuestions) {
        NbAnsweredQuestions = nbAnsweredQuestions;
    }

    public int getNbCorrectAnswers() {
        return NbCorrectAnswers;
    }

    public void setNbCorrectAnswers(int nbCorrectAnswers) {
        NbCorrectAnswers = nbCorrectAnswers;
    }
}
