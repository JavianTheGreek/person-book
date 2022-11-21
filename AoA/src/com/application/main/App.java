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

    public static void main(String[] args) throws IOException {

        //Display menu option to user.
        System.out.println("""

                +++ PersonBook +++

                [1] - Upload Files
                [2] - Calculate Degree of Separation
                [3] - Average of Degree of Separation
                [4] - 

                """);
        System.out.println("Select from above");
        int choice = in.nextInt();//takes the users entered value and pass it to the switch statement.
        switch (choice){
            case 1 -> {
                Person.userCreateFile();

                break;
            }
            case 2 -> {
                degreeOfSeparation();
                break;
            }
            case 3 -> {
                System.out.println();
                break;
            }

        }

        //Populating ArrayList with records from person and activities files
        Person.readFromFiles(personList);

        size = personList.size(); // pass the size of the personList to the global attribute
        System.out.println("Size of list = " + size);//Displays the size of the personList

        System.out.println("\nChecking if tree is empty...");
        System.out.print(personTree.isEmpty() + "\n");//Check to see if Binary tree is empty, if empty returns a boolean of true else return false

        int size = personList.size();


        //Populating tree with person records
        System.out.println("\nPopulating tree with data from personList...");
        for (Person person : personList) {
            personTree.insertNode(person);
        }
        System.out.println("Tree populated.");


        //The below traversal code is used to get the similarity between each user.
        System.out.println("\nRoot node is: " + personTree.getRoot().getRoot().getFirstName() + " " + personTree.getRoot().getRoot().getLastName());
        System.out.println("Left of root node is: " + personTree.getRoot().getLeftSubTree().getRoot().getFirstName() + " "
                + personTree.getRoot().getLeftSubTree().getRoot().getLastName());
        System.out.println("Commonality between root node and the one to its left is: " + personTree.getCountCommon(personTree.getRoot().getRoot(),personTree.getRoot().getLeftSubTree().getRoot()));
        System.out.println("Right of root node is: " + personTree.getRoot().getRightSubTree().getRoot().getFirstName() + " "
                + personTree.getRoot().getRightSubTree().getRoot().getLastName());
        System.out.println("Commonality between root node and the one to its right is: " +
                personTree.getCountCommon(personTree.getRoot().getRoot(),personTree.getRoot().getRightSubTree().getRoot()));
        System.out.println("Commonality between node to the right of root node, and the node to its right is: " +
                personTree.getCountCommon(personTree.getRoot().getRightSubTree().getRoot(), personTree.getRoot().getRightSubTree().getRightSubTree().getRoot()));
        System.out.println("Commonality between node to the right of root node, and the node to its left is: " +
                personTree.getCountCommon(personTree.getRoot().getRightSubTree().getRoot(), personTree.getRoot().getRightSubTree().getLeftSubTree().getRoot()));
        System.out.println("Commonality between node to the left of root node, and the node to its right is: " +
                personTree.getCountCommon(personTree.getRoot().getLeftSubTree().getRoot(), personTree.getRoot().getLeftSubTree().getRightSubTree().getRoot()));
        System.out.println("Commonality between node to the left of root node, and the node to its left is: " +
                personTree.getCountCommon(personTree.getRoot().getLeftSubTree().getRoot(), personTree.getRoot().getLeftSubTree().getLeftSubTree().getRoot()));

        System.out.println("\nConfirming that tree is no longer empty...");
        System.out.print(personTree.isEmpty() + "\n");//Check to see if Binary tree is empty, if empty returns a boolean of true else return false


        //Checking number of nodes in tree
        System.out.println("\nNumber of nodes in tree: " + personTree.getTotalNumberOfNodes(personTree.getRoot()) + "\n");

        //Conducting a search for a given node in the tree
        System.out.println("\nSearching tree for '" + personList.get(9483).getFirstName() + " " + personList.get(9483).getLastName() + "'...");
        personTree.searchData(personList.get(9483));


        System.out.print("The degree of separation is " + findDistance(personTree.getRoot(), personList.get(8999), personList.get(17800)));

        //Recommending to each person the activities of their close contact
//        for(int i=0; i < size; i++){
//            System.out.println("\nMaking recommendations to " + personList.get(i).getFirstName() + " " + personList.get(i).getLastName());
//            personTree.getRec(personList.get(i));
//        }


    }
    public static void degreeOfSeparation() throws IOException {
        int result = 2, cnt=0, k=0;
        String input = "";
        String FirstName1 = "";
        String LastName1 = "";
        String FirstName2 = "";
        String LastName2 = "";
        String fullName = "";



        while(true){
            try{
                System.out.println("\nEnter any key to continue (exit to end the program)");
                input = in.next();

                if(!input.equals("exit")) {
                    for(k=0; k<result; k++){
//                        for (int j=0; j < size; j++){
//                            break;
//                        }
                    }
                    while (k < result){
//                        // used for generating the index of two random person from the list.
                        int getPosition = (int) (Math.random() * personList.size());
                        if(k == 1) {
//
                            for(int i=k; i<result; i++){
//                                    System.out.println("\nThe degrees of separation between " + personList.get(j).getFirstName() + " " + personList.get(j).getLastName() + " and " + personList.get(j).getFirstName() + " " + personList.get(j).getLastName() + " is " +
//
                                System.out.println("\n\t-+-Enter Names of the Persons in the file-+-");
                                System.out.println("Enter Person Name " + i +": ");
                                FirstName1 = in.next();
                                LastName1 = in.next();
                                System.out.println("Enter Person Name " + (i+1) +": ");
                                FirstName2 = in.next();
                                LastName2 = in.next();
//
//
                            System.out.println("\nSelecting Random persons from the list "+ getPosition + ": " + personList.get(getPosition).getFirstName() + " " + personList.get(getPosition).getLastName());
                            System.out.println(findDistance(personTree.getRoot(), personList.get(getPosition), personList.get(getPosition)));
//
//
                            }
//
                        }
//
                        k++;
                    }
//                   for(int t=0; t < size; t++) {
//                       if (personList.get(k).getFirstName().contains(FirstName) && personList.get(k).getLastName().contains(LastName)) {
//                           System.out.println("\nThe degrees of separation between " + personList.get(t).getFirstName() + " " + personList.get(t).getLastName() + " and " + personList.get(t).getFirstName() + " " + personList.get(t).getLastName());
//                       }
                   } else {
                    System.exit(0);
                }
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }

        //makeRecommendations(personTree, personList);



    //Recommending to each person the activities of their close contact
    public static void makeRecommendations(PersonTree personTree, ArrayList<Person> personList) {
        int size = personList.size();

        for (int i = 0; i < size; i++) {
            System.out.println("\nMaking recommendations to " + personList.get(i).getFirstName() + " " + personList.get(i).getLastName());
            personTree.getRec(personList.get(i));
        }
    }


}

