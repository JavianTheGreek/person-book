package com.application.model;

import java.io.*;
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
//    private Activity activityList;

    //Default Constructor
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

    //Primary Constructor
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

//    public void addActivity(String activity) {
//        activityList.add(activity);
//    }

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


    public static void checkLine() {

    }

//    public void createFile(ArrayList<Person> personList) {
//        try {
//            BufferedWriter writer = new BufferedWriter(new FileWriter(new File("../person-book/AoA/person.txt")));
//            writer.write(String.valueOf(personList));
//            writer.close();
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//    }
//
    public static void readFromPersonFile() throws IOException {
        ArrayList<String> lines = new ArrayList<>();

        BufferedReader file1 = null;
        BufferedReader file2 = null;
        int checkLine = 1;

        try {
            file1 = new BufferedReader(new FileReader("../person-book/AoA/person.txt"));
            file2 = new BufferedReader(new FileReader("../person-book/AoA/activity.txt"));

            String val = file1.readLine();
            String check = file2.readLine();

            boolean areEqual = true;

            while (val != null || check != null) {
                if(val == null || check == null) {
                    areEqual = false;

                    break;
                }
                else if(!val.equalsIgnoreCase(check)) {
                    areEqual = false;
                    break;
                }

                val = file1.readLine();
                check = file2.readLine();
                checkLine++;
            }

            if(areEqual) {
                System.out.println("Two files have same content.");
            }
            else {
                System.out.println("Two files have different content. They differ at line "+checkLine);

                System.out.println("File1 has "+val+" and File2 has "+check+" at line "+checkLine);
            }

//            file1.close();
//
//            file2.close();

//            while (line != null) {
//
//                lines.add(line);
//                line = br.readLine();
//            }
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            assert file1 != null;
            assert file2 != null;
            file1.close();
            file2.close();
        }

    }


}
