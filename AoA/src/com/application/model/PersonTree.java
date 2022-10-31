package com.application.model;

import java.util.ArrayList;

public class PersonTree {
    static class Node {
        private Node leftSubTree;
        private Node rightSubTree;
        Person data;


        public Node(Person data){
            this.data = new Person();
            leftSubTree = null;
            rightSubTree = null;
        }

        public boolean isEmpty(){
            return data == null;
        }

        public boolean isFull(){
            return data != null;
        }
    }

    public void getRec(ArrayList<Person> person, int i) {
        if (!person.get(i).isPrivacy()) {
            if (getCountCommon(person, i) > 0) {
                //loop print activities in list
                for(int j = 0; j < person.size()-1; j++) {
                    //find person in activity list
                }
            }
        }
        else {
            System.out.println(person.get(i).getFirstName() + " has privacy settings enabled.");
        }
    }

    /*public void insert(Node node, Person person) {
        //left subtree == nothing in common
        //right subtree == one or more things in common
        if (getCountCommon(person) == 0) {
            if (node.left != null) {
                insert(node.left, value);
            } else {
                System.out.println(" Inserted " + value + " to left of " + node.value);
                node.left = new Node(value); }
        } else if (value > node.value) {
            if (node.right != null) {
                insert(node.right, value);
            } else {
                System.out.println("  Inserted " + value + " to right of "
                        + node.value);
                node.right = new Node(value);
            }
        }
    }*/

    public void insertPerson(Node node, Person data){
        int person = 0;

        if(data.getFirstName().equals()){
            if(node.leftSubTree.isFull()){
                insertPerson(node.leftSubTree, data);
            }else {
                System.out.println(" Inserted " + data + " to left of " + node.data.getFirstName());
            }
        }else if(){
            if(){

            }else {

            }
        }
    }


    public int getCountCommon(ArrayList<Person> person, int i) {
        //compares how many things two persons have in common
        //with one another
        int countCommon = 0;

        if (person.get(i).getSchool().equals(person.get(i+1).getSchool())) {
            countCommon += 1;
        }

        if (person.get(i).getEmployer().equals(person.get(i+1).getEmployer())) {
            countCommon += 1;
        }

        if (person.get(i).getCommunity().equals(person.get(i+1).getCommunity())) {
            countCommon += 1;
        }

        return countCommon;
    }

    /*public int getCountCommon(ArrayList<Person> personA, ArrayList<Person> personB) {
        //compares how many things two persons have in common
        //with one another
        int countCommon = 0;

        if (personA..equals(person.get(i+1).getSchool())) {
            countCommon += 1;
        }

        if (person.get(i).getEmployer().equals(person.get(i+1).getEmployer())) {
            countCommon += 1;
        }

        if (person.get(i).getCommunity().equals(person.get(i+1).getCommunity())) {
            countCommon += 1;
        }

        return countCommon;
    }*/

}
