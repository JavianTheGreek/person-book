package com.application.model;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class Person {
    private String firstName;
    private String lastName;
    private String telephone;
    private String email;
    private String community;
    private String school;
    private String employer;
    private char privacy;
    private String activity;

    public static Random rand = new Random();


    //Default Constructor
    public Person(){
        this.firstName = "";
        this.lastName = "";
        this.telephone = "";
        this.email = "";
        this.community = "";
        this.school = "";
        this.employer = "";
        this.privacy = 'N';
        this.activity = "";
    }

    //Primary Constructor
    public Person(String firstName, String lastName, String telephone, String email, String community, String school, String employer, char privacy, String activity) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.telephone = telephone;
        this.email = email;
        this.community = community;
        this.school = school;
        this.employer = employer;
        this.privacy = privacy;
        this.activity = activity;
    }

    //Copy Constructor
    public Person(Person obj) {
        this.firstName = obj.firstName;
        this.lastName = obj.lastName;
        this.telephone = obj.telephone;
        this.email = obj.email;
        this.community = obj.community;
        this.school = obj.school;
        this.employer = obj.employer;
        this.privacy = obj.privacy;
        this.activity = obj.activity;
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

    public char getPrivacy() {
        return privacy;
    }

    public void setPrivacy(char privacy) {
        this.privacy = privacy;
    }

    public String getActivity() {
        return activity;
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }

    @Override
    public String toString() {
        return "First Name: " + firstName +
                " <*> Last Name: " + lastName +
                "\nTelephone: " + telephone +
                " <*> Email: " + email +
                "\nCommunity: " + community +
                " <*> School: " + school +
                "\nEmployer='" + employer +
                " <*> Privacy: " + privacy +
                "\n ---Activity/Activities--- \n"
                + activity + "\n";
    }

    public static void readFromFiles(ArrayList<Person> personList) throws IOException {
//String fileConcat = "../person-book-main/AoA/";
        try {
            String file1 = "SamplefilePersons2022Oct31text.csv";
            String file2 = "SamplefileActivities2022Oct31text.csv";
            Scanner reader = new Scanner(new File(file1));
            reader.useDelimiter(",|\n");
            List<String> lines = Files.readAllLines(Path.of(file2));

            System.out.println("Populating objects with data from person file...");

            while (reader.hasNext()) {
                Person person = new Person();

                person.setFirstName(reader.next());
                String firstName = person.firstName;
                person.setLastName(reader.next());
                String lastName = person.lastName;
                person.setTelephone(reader.next());
                person.setEmail(reader.next());
                person.setCommunity(reader.next());
                person.setSchool(reader.next());
                person.setEmployer(reader.next());
                person.setPrivacy(reader.next().charAt(0));

                String activityForObj = "";
                for (String line : lines) {
                    if (line.contains(firstName) && line.contains(lastName)) {
                        String[] activityFromFile = line.split(",");
                        activityForObj = activityForObj + activityFromFile[2] + "\n";
                        person.setActivity(activityForObj);
                    }
                }

                personList.add(person);

                if(!reader.hasNextLine())
                {
                    break;
                }
            }

            System.out.println("List has been populated.");
            reader.close();

        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }

//return personList;
    }

}

