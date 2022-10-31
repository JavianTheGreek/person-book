package com.application.model;

import java.util.*;

public class Activity {
    private String firstName;
    private String lastName;
    private String[] activity;

    public Activity(){
        this.firstName = "";
        this.lastName = "";
        this.activity = new String[]{};
    }

    public Activity(String firstName, String lastName, String[] activity) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.activity = activity;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String[] getActivity() {
        return activity;
    }

    public void setActivity(String[] activity) {
        this.activity = activity;
    }
}
