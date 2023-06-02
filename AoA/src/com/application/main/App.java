

package com.application.main;

import com.application.model.Person;
import com.application.model.PersonTree;

import static com.application.model.PersonTree.findDistance;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class App {

    public static Scanner in = new Scanner(System.in);// use to take input from user
    public static ArrayList<Person> personList = new ArrayList<>();// Collection takes a class has the generic.
    public static Person person = new Person(); //
    public static PersonTree personTree = new PersonTree();// PersonTree Object
    public static int size = 0; // initialize size with 0;
    static int choice = 0;

    public static void main(String[] args) throws IOException {

        System.out.println("Upload Persons and Activities files: \n");
        Person.userCreateFile(personList);
        createTree(personList, personTree);

        menu();

        size = personList.size(); // pass the size of the personList to the global attribute
    }

    public static void menu() throws IOException {
        while (choice != 4) {
            System.out.println("""

                    +++ PersonBook +++

                    [1] - Recommendations
                    [2] - Calculate Degree of Separation
                    [3] - Average of Degree of Separation
                    [4] - Exit

                    """);
            System.out.println("Select from above");
            choice = in.nextInt();//takes the users entered value and pass it to the switch statement.
            switch (choice) {
                case 1 -> {
                    makeRecommendations(personTree, personList);
                }
                case 2 -> {
                    degreeOfSeparation(personList, personTree);
                }
                case 3 -> {
                    System.out.println("Calculating of Average Degree of Separation in Process...");
                    avgDegreeOfSeparation(personList, personTree);
                }
                case 4 -> {
                    System.exit(0);
                }
            }

        }

    }

    public static void degreeOfSeparation(ArrayList<Person> personList, PersonTree personTree) throws IOException {
        int size = personList.size();
        int min = 0;
        int max = personList.size() - 1; // 0 -> 19999
        int getPosition1 = (int) (Math.random() * (max - min + 1) + min);
        int getPosition2 = (int) (Math.random() * (max - min + 1) + min);

        String input = "";

        try {
            System.out.println("\nEnter any key to continue (exit to end the program)");
            input = in.next();
            if (!input.equals("exit")) {
                System.out.println("\nSelecting Random persons from the list...");
                System.out.println(getPosition1 + ": " + personList.get(getPosition1).getFirstName() + " "
                        + personList.get(getPosition1).getLastName());
                System.out.println(getPosition2 + ": " + personList.get(getPosition2).getFirstName() + " "
                        + personList.get(getPosition2).getLastName());


                Person P1 = personList.get(getPosition1);
                Person P2 = personList.get(getPosition2);


                System.out.println("Degree of separation between " + P1.getFirstName() + " " + P1.getLastName() +
                        " and " + P2.getFirstName() + " " + P2.getLastName() + " is: " + personTree.findDistance(personTree.getRoot(), P1, P2));

            } else {
                menu();
            }
        } catch (Exception e) {
            System.out.println("Invalid ->" + e.getMessage());
        }
    }

    public static void avgDegreeOfSeparation(ArrayList<Person> personList, PersonTree personTree) throws IOException {
        int n = 0;
        int min = 0;
        int max = personList.size() - 1;



        String input = "";

        try {
            System.out.println("\nEnter any key to continue (exit to end the program)");
            input = in.next();
            if (!input.equals("exit")) {


                int degree, count = 0;
                do {
                    int getPosition1 = (int) (Math.random() * (max - min + 1) + min);
                    int getPosition2 = (int) (Math.random() * (max - min + 1) + min);
                    //System.out.println("\nSelecting Random persons from the list...");
                    //System.out.println(getPosition1 + ": " + personList.get(getPosition1).getFirstName() + " " + personList.get(getPosition1).getLastName());
                    //System.out.println(getPosition2 + ": " + personList.get(getPosition2).getFirstName() + " " + personList.get(getPosition2).getLastName());



                    Person P1 = personList.get(getPosition1);
                    Person P2 = personList.get(getPosition2);
                    //System.out.println("Degree of separation between " + P1.getFirstName() + " " + P1.getLastName() + " and " + P2.getFirstName() + " " + P2.getLastName() + " is: " + personTree.findDistance(personTree.getRoot(), P1, P2));
                    degree = personTree.findDistance(personTree.getRoot(), P1, P2);
                    count = count + degree;
                    n++;
                } while (n < 20000);
                int Avg = count / (20000/2); // Divided by 2 because we are comparing 2 persons in the list
                System.out.println("Avg Degree of separation of 20000 random persons in the list is " + Avg);
            } else {
                menu();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    //Recommending to each person the activities of their close contact
    public static void makeRecommendations(PersonTree personTree, ArrayList<Person> personList) {
        int size = personList.size();

        for (int i = 0; i < size; i++) {
            System.out.println("\nMaking recommendations to " + personList.get(i).getFirstName() + " " + personList.get(i).getLastName());
            personTree.getRec(personList.get(i));
        }
    }

    //Creating the tree
    public static PersonTree createTree(ArrayList<Person> personList, PersonTree personTree) {
        int size = personList.size();

        //Populating tree with person records
        System.out.println("\nPopulating tree with data from personList...");
        for (Person person : personList) {
            personTree.insertNode(person);
        }
        System.out.println("Tree populated.");

        //Checking number of nodes in tree
        System.out.println("Number of nodes in tree: " + personTree.getTotalNumberOfNodes(personTree.getRoot()) + "\n");

        return personTree;
    }

}

