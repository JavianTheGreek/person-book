package com.application.main;

import com.application.model.Person;
import com.application.model.PersonTree;

import java.io.IOException;
import java.util.ArrayList;

public class App {
    public static void main(String[] args) throws IOException {
        ArrayList<Person> personList = new ArrayList<>();
        PersonTree personTree = new PersonTree();

        Person.readFromFiles(personList);
        int size = personList.size();
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

        //Recommending to a person the activities of their close contact(s)
        System.out.println("\nMaking recommendations to " + personList.get(6889).getFirstName() + " " + personList.get(6889).getLastName());
        personTree.getRec(personList.get(6889));

        //Conducting a search for a given node in the tree
        System.out.println("\nSearching tree for '" + personList.get(6889).getFirstName() + " " + personList.get(6889).getLastName() + "'...");
        personTree.searchData(personList.get(6889));
    }


}
