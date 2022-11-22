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
//        Menu();
        //Display menu option to user.

        menu();

        //Populating ArrayList with records from person and activities files
//        Person.readFromFiles(personList);

        size = personList.size(); // pass the size of the personList to the global attribute
        System.out.println("Size of list = " + size);//Displays the size of the personList

        System.out.println("\nChecking if tree is empty...");
        System.out.print(personTree.isEmpty() + "\n");//Check to see if Binary tree is empty, if empty returns a boolean of true else return false


        //Populating tree with person records
        System.out.println("\nPopulating tree with data from personList...");
        for (Person person : personList) {
            personTree.insertNode(person);
        }
        System.out.println("Tree populated.");


        System.out.println("\nConfirming that tree is no longer empty...");
        System.out.print(personTree.isEmpty() + "\n");//Check to see if Binary tree is empty, if empty returns a boolean of true else return false


        //Checking number of nodes in tree
        System.out.println("\nNumber of nodes in tree: " + personTree.getTotalNumberOfNodes(personTree.getRoot()) + "\n");

        //Conducting a search for a given node in the tree
//        System.out.println("\nSearching tree for '" + personList.get().getFirstName() + " " + personList.get(9483).getLastName() + "'...");
//        personTree.searchData(personList.get(9483));


        System.out.print("The degree of separation is " + findDistance(personTree.getRoot(), personList.get(8999), personList.get(17800)));

        //Recommending to each person the activities of their close contact
//        for(int i=0; i < size; i++){
//            System.out.println("\nMaking recommendations to " + personList.get(i).getFirstName() + " " + personList.get(i).getLastName());
//            personTree.getRec(personList.get(i));
//        }


    }

    public static void menu() throws IOException {
        while (choice != 5) {
            System.out.println("""

                    +++ PersonBook +++

                    [1] - Upload Files
                    [2] - Calculate Degree of Separation
                    [3] - Average of Degree of Separation
                    [4] - Recommendations
                    [5] - Exit

                    """);
            System.out.println("Select from above");
            choice = in.nextInt();//takes the users entered value and pass it to the switch statement.
            switch (choice) {
                case 1 -> {
//                    Person.userCreateFile(personList);
                    Person.readFromFiles(personList);
                    createTree(personList, personTree);
                    break;
                }
                case 2 -> {
                    degreeOfSeparation(personList, personTree);
                    break;
                }
                case 3 -> {
                    //getAverageDOS();
                    System.out.println("Calculating of Average Degree of Separation in Process...");
                   // System.out.println(getAverage(personList)); // pass the list to the new array list
                    break;
                }
                case 4 -> {
                    makeRecommendations(personTree, personList);
                }
                case 5 -> {
                    System.exit(0);
                }
            }

        }

    }

    public static void degreeOfSeparation(ArrayList<Person> personList, PersonTree personTree) throws IOException {
        int size = personList.size();
        int min = 0;
        int max = personList.size() - 1;
        int getPosition1 = (int) (Math.random() * (max - min + 1) + min);
        int getPosition2 = (int) (Math.random() * (max - min + 1) + min);

        String input = "";
        String FirstName1 = "";
        String LastName1 = "";
        String FirstName2 = "";
        String LastName2 = "";

        try {
            System.out.println("\nEnter any key to continue (exit to end the program)");
            input = in.next();
            if (!input.equals("exit")) {
                System.out.println("\nSelecting Random persons from the list...");
                System.out.println(getPosition1 + ": " + personList.get(getPosition1).getFirstName() + " "
                        + personList.get(getPosition1).getLastName());
                System.out.println(getPosition2 + ": " + personList.get(getPosition2).getFirstName() + " "
                        + personList.get(getPosition2).getLastName());

                System.out.println("\n\t-+-Enter Names of the Persons in the file-+-");
                System.out.println("Enter First Person's Name: ");
                FirstName1 = in.next();
                LastName1 = in.next();
                System.out.println("Enter Second Person's Name: ");
                FirstName2 = in.next();
                LastName2 = in.next();

                Person P1 = personList.get(getPosition1);
                Person P2 = personList.get(getPosition2);

                System.out.println("Distance between " + P1.getFirstName() + " " + P1.getLastName() +
                        " and " + P2.getFirstName() + " " + P2.getLastName() + " is: " + personTree.findDistance(personTree.getRoot(), P1, P2));

            }else{
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
        System.out.println("\nNumber of nodes in tree: " + personTree.getTotalNumberOfNodes(personTree.getRoot()) + "\n");

        return personTree;
    }

}

