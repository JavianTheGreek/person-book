package com.application.model;

import java.util.*;

public class Activity {
    private ArrayList<String> activityList;

    Activity() {
        activityList = new ArrayList<String>();
    }

    public void setActivityList(ArrayList<String> activityList) {
        this.activityList = activityList;
    }

    public ArrayList<String> getActivityList() {
        return this.activityList;
    }
}
