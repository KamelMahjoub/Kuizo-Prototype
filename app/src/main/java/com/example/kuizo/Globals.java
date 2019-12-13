package com.example.kuizo;

import java.io.Serializable;

public class Globals implements Serializable {

    public String currentUser;


    public String getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(String currentUser) {
        this.currentUser = currentUser;
    }



}
