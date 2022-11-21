package com.application.main;

import com.application.model.Person;
import com.application.model.PersonTree;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class App {
    public static Random rand = new Random();
    public static Scanner in = new Scanner(System.in);
    public static ArrayList<Person> personList = new ArrayList<>();
    public static Person person = new Person();
    public static PersonTree personTree = new PersonTree();

    public static int size = 0;

    public static void main(String[] args) throws IOException {

        Person.readFromFiles(personList);
        size = personList.size();
        System.out.println("Size of list = " + size);

        System.out.println("\nChecking if tree is empty...");
        System.out.print(personTree.isEmpty() + "\n");

        System.out.println("\nPopulating tree with data from personList...");

        for (Person person : personList){
            personTree.insertNode(person);
        }

        System.out.println("Tree populated.");

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
        System.out.print(personTree.isEmpty() + "\n");

        //Checking number of nodes in tree
        System.out.println("\nNumber of nodes in tree: " + personTree.getTotalNumberOfNodes(personTree.getRoot()) + "\n");

        //Conducting a search for a given node in the tree
        System.out.println("\nSearching tree for '" + personList.get(9483).getFirstName() + " " + personList.get(9483).getLastName() + "'...");
        personTree.searchData(personList.get(9483));


        //trying to find the degreeOfSeparation attempt 1
//        System.out.println("\nRoot node is: " + personTree.getRoot().getRoot().getFirstName() + " " + personTree.getRoot().getRoot().getLastName());
//        System.out.println("Left of root node is: " + personTree.getRoot().getLeftSubTree().getRoot().getFirstName() + " "
//                + personTree.getRoot().getLeftSubTree().getRoot().getLastName());
//        System.out.println("Right of root node is: " + personTree.getRoot().getRightSubTree().getRoot().getFirstName() + " "
//                + personTree.getRoot().getRightSubTree().getRoot().getLastName());



        //Recommending to each person the activities of their close contact
//        for(int i=0; i < size; i++){
//            System.out.println("\nMaking recommendations to " + personList.get(i).getFirstName() + " " + personList.get(i).getLastName());
//            personTree.getRec(personList.get(i));
//        }
        for (int j=0; j < size; j++){
            // used for generating the index of two random person from the list.
//            int getPosition = (int) (Math.random() * personList.size());
//            System.out.println("\nSelecting Random persons from the list "+ getPosition + ": " + personList.get(getPosition).getFirstName() + " " + personList.get(getPosition).getLastName());

        }
        PersonTree.findDistance(personTree.getRoot(), personList.get(9483).getFirstName(), personList.get(9483).getLastName());

////        System.out.println("""
////
////                +++ PersonBook +++
////
////                [1] - Upload Files
////                [2] - Calculate Degree of Separation
////                [3] - Average of Degree of Separation
////
////                """);
////        System.out.println("Select from above");
////        int choice = in.nextInt();
////        switch (choice){
////            case 1 -> {
////                System.out.println("1 selected");
////                break;
////            }
////            case 2 -> {
////                degreeOfSeparation();
////                break;
////            }
////            case 3 -> {
////                System.out.println();
////                break;
////            }
////
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
                    while (k < result){
                        // used for generating the index of two random person from the list.
//                        int getPosition = (int) (Math.random() * personList.size());
//                        System.out.println("\nSelecting Random persons from the list "+ getPosition + ": " + personList.get(getPosition).getFirstName() + " " + personList.get(getPosition).getLastName());

                        if(k == 1){
                            for(int i=1; i<result; i++){
                                System.out.println("\n\t-+-Enter Names of the Persons in the file-+-");
                                System.out.println("Enter Person Name " + i +": ");
                                FirstName1 = in.next();
                                LastName1 = in.next();
//                                System.out.println("Enter Person Name " + (i+1) +": ");
//                                FirstName2 = in.next();
//                                LastName2 = in.next();
                                for (int j=0; j < size; j++){
                                    fullName = FirstName1.concat(" ").concat(LastName1);
                                    System.out.print("Full name:"+fullName);
//                                    personTree.searchData(personList.get().getFirstName());
//                                    if (personTree.searchData(personList.get(9483))) {
//                                        System.out.println("\nThe degrees of separation between " + personList.get(j).getFirstName() + " " + personList.get(j).getLastName() + " and " + personList.get(j).getFirstName() + " " + personList.get(j).getLastName() + " is ");
//                                        break;
//                                    }
                                }
                            }

                        }
                        k++;
                    }
//                   for(int t=0; t < size; t++) {
//                       if (personList.get(k).getFirstName().contains(FirstName) && personList.get(k).getLastName().contains(LastName)) {
//                           System.out.println("\nThe degrees of separation between " + personList.get(t).getFirstName() + " " + personList.get(t).getLastName() + " and " + personList.get(t).getFirstName() + " " + personList.get(t).getLastName());
//                       }
//                   }

                } else {
                    System.exit(0);
                }
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }
}

