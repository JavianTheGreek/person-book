
package com.application.model;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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

    //Default Constructor
    public Person(){
        firstName = null;
        lastName = null;
        telephone = null;
        email = null;
        community = null;
        school = null;
        employer = null;
        privacy = 'N';
        activity = "";
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

    public char isPrivacy() {
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
        return  "First Name:    " + firstName +
                "\nLast Name:   " + lastName +
                "\nTelephone:   " + telephone +
                "\nEmail:       " + email +
                "\nCommunity:   " + community +
                "\nSchool:      " + school +
                "\nEmployer:    " + employer +
                "\nPrivacy:     " + privacy +
                "\n     ---Activity/Activities---    \n" + activity +
                "\n";
    }

    public static void readFromFiles(ArrayList<Person> personList) throws IOException {
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
                        activityForObj = activityForObj + activityFromFile[2] +  "\n";
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
            System.out.println("Size of list = " + personList.size());//Displays the size of the personList
            reader.close();

        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
    }

    public static void userCreateFile(ArrayList<Person> personArrayList) throws IOException {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the filename you want to use for Person File.: ");
        String fileName = input.nextLine();
        fileName = fileName + ".csv";

        System.out.print("Enter the filename you want to use for Activity File.: ");
        String fileName2 = input.nextLine();
        fileName2 = fileName2 + ".csv";

        boolean isFileCreated1 = false;  // set isFileCreated1 to false.
        boolean isFileCreated2 = false;  // set isFileCreated2 to false.

        try {
            File file = new File(fileName);
            File file2 = new File(fileName2);

            isFileCreated1 = file.createNewFile();
            isFileCreated2 = file2.createNewFile();

            if (file.createNewFile() && file2.createNewFile()) {
                System.out.println("A file was created.");
            } else {
                System.out.println("The file is already there.");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (NullPointerException ex){
            ex.printStackTrace();
        }
        String fileLocator = "\nfileLocator -> " + fileName;
        String fileLocator2 = "fileLocator -> " + fileName2;
        System.out.println(fileLocator);
        System.out.println(fileLocator2);

        readFromSelectedFiles(personArrayList, fileName, fileName2);

    }

    public static void readFromSelectedFiles(ArrayList<Person> personList, String file1, String file2) throws IOException {
        try {
            Scanner reader = new Scanner(new File(file1));
            reader.useDelimiter(",|\n");
            List<String> lines = Files.readAllLines(Path.of(file2));

            System.out.println("Populating objects with data from person and Activity file...");

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
                        activityForObj = activityForObj + activityFromFile[2] +  "\n";
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
    }
}
