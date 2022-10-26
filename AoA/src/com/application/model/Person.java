package com.application.model;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

public class Person {
    private String firstName;
    private String lastName;
    private String telephone;
    private String email;
    private String community;
    private String school;
    private String employer;
    private boolean privacy;
    private Activity activityList;

    public Person(){
        this.firstName = null;
        this.lastName = null;
        this.telephone = null;
        this.email = null;
        this.community = null;
        this.school = null;
        this.employer = null;
        this.privacy = true;
    }

    public Person(String firstName, String lastName, String telephone, String email, String community, String school, String employer, boolean privacy) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.telephone = telephone;
        this.email = email;
        this.community = community;
        this.school = school;
        this.employer = employer;
        this.privacy = privacy;
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

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCommunity() {
        return community;
    }

    public void setCommunity(String community) {
        this.community = community;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getEmployer() {
        return employer;
    }

    public void setEmployer(String employer) {
        this.employer = employer;
    }

    public boolean isPrivacy() {
        return privacy;
    }

    public void setPrivacy(boolean privacy) {
        this.privacy = privacy;
    }

    public void addActivity(String activity) {
        activityList.add(activity);
    }

    @Override
    public String toString() {
        return "First Name: " + firstName +
                "Last Name: " + lastName +
                "\nTelephone: " + telephone +
                "Email: " + email +
                "\nCommunity: " + community +
                "School: " + school +
                "\nEmployer='" + employer +
                "Privacy: " + privacy;
    }

    public void writeToPersonFile() throws FileNotFoundException {
        List<String> lines = new ArrayList<String>();
        BufferedReader br = new BufferedReader(new FileReader("fileName"));
        String line = br.readLine();
        while (line != null)
        {
            lines.add(line);
            line = br.readLine();
        }
    }
}
