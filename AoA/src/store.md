public void getRec(ArrayList<Person> person, int i) {
//        if (!person.get(i).isPrivacy()) {
//            if (getCountCommon(person, i) > 0) {
//                //loop print activities in list
//                for(int j = 0; j < person.size()-1; j++) {
//                    //find person in activity list
//                }
//            }
//        }
//        else {
//            System.out.println(person.get(i).getFirstName() + " has privacy settings enabled.");
//        }
//    }
//
//    //My original idea is to check the size of the person list and calculate the distance
//    //So I would do a random gen to populate the tree with different person
//    //but imma run a test statement to see if that person is already added to the tree
//    //that's just my idea stills
//
//    public int calculateDegreeOfSeparation(Node node, ArrayList<Person> personList){
//        int position = 0;
//        if (node.isEmpty()){
//            return 0;
//        }else {
//            position = calculateLinePosition(node.leftSubTree, personList) + calculateLinePosition(node.rightSubTree, personList) + 1;
//            return position;
//        }
//    }
//
//    private int calculateLinePosition(Node leftSubTree, ArrayList<Person> personList) {
//
//    }
//
//
//
//
//    /*public void insert(Node node, Person person) {
//        //left subtree == nothing in common
//        //right subtree == one or more things in common
////        if (getCountCommon(person) == 0) {
////            if (node.left != null) {
////                insert(node.left, value);
////            } else {
////                System.out.println(" Inserted " + value + " to left of " + node.value);
////                node.left = new Node(value); }
////        } else if (value > node.value) {
////            if (node.right != null) {
////                insert(node.right, value);
////            } else {
////                System.out.println("  Inserted " + value + " to right of "
////                        + node.value);
////                node.right = new Node(value);
////            }
////        }
//    }*/
//
//    public void insertPerson(Node node, Person data){
//        int person = 0;
//        //So for when the tree check the root which is the name
//        //it will increment by 1, so for eg data + 1 and then move to the next node
//        // to check the distance of the specific selected node from the tree
//        if(node.root.isFull()){
//            if(node.leftSubTree.isFull()){
//                insertPerson(node.leftSubTree, data);
//            }else {
//                System.out.println(" Inserted " + data + " to left of " + node.data.getFirstName());
//            }
//        }else if(){
//            if(){
//
//            }else {
//
//            }
//        }
//    }
//
//
//    public int getCountCommon(ArrayList<Person> person, int i) {
//        //compares how many things two persons have in common
//        //with one another
//        int countCommon = 0;
//
//        if (person.get(i).getSchool().equals(person.get(i+1).getSchool())) {
//            countCommon += 1;
//        }
//
//        if (person.get(i).getEmployer().equals(person.get(i+1).getEmployer())) {
//            countCommon += 1;
//        }
//
//        if (person.get(i).getCommunity().equals(person.get(i+1).getCommunity())) {
//            countCommon += 1;
//        }
//
//        return countCommon;
//    }
//
//    /*public int getCountCommon(ArrayList<Person> personA, ArrayList<Person> personB) {
//        //compares how many things two persons have in common
//        //with one another
//        int countCommon = 0;
//
//        if (personA..equals(person.get(i+1).getSchool())) {
//            countCommon += 1;
//        }
//
//        if (person.get(i).getEmployer().equals(person.get(i+1).getEmployer())) {
//            countCommon += 1;
//        }
//
//        if (person.get(i).getCommunity().equals(person.get(i+1).getCommunity())) {
//            countCommon += 1;
//        }
//
//        return countCommon;
//    }*/
//
//}
////        if(data.getFirstName() == node.size){
////            if(node.leftSubTree.isFull()){
////                insertPerson(node.leftSubTree, data);
////            }else {
////                System.out.println(" Inserted " + data + " to left of " + node.data.getFirstName());
////            }
////        }else if(){
////            if(){
////
////            }else {
////
////            }
////        }



//uwgfihojpw//
package com.application.model;

import java.util.ArrayList;

public class PersonTree {

    Person data;
    private PersonTree leftSubTree;
    private PersonTree rightSubTree;

    public PersonTree(ArrayList<Person> personList) {
        this.data = new Person();
        leftSubTree = null;
        rightSubTree = null;
    }
    public boolean isEmpty() {
        return data == null;
    }

    public boolean isFull() {
        return data != null;
    }

    public Person getData() {
        return data;
    }

    public void setData(Person data) {
        this.data = data;
    }

    public PersonTree getLeftSubTree() {
        return leftSubTree;
    }

    public void setLeftSubTree(PersonTree leftSubTree) {
        this.leftSubTree = leftSubTree;
    }

    public PersonTree getRightSubTree() {
        return rightSubTree;
    }

    public void setRightSubTree(PersonTree rightSubTree) {
        this.rightSubTree = rightSubTree;
    }

    private static PersonTree findLCA(PersonTree root, PersonTree node1, PersonTree node2){
        if(root == null){
            return null;
        }else if(root == node1 || root == node2){
            return root;
        }

        PersonTree leftSubTree = findLCA(root.getLeftSubTree(), node1, node2);

        PersonTree rightSubTree = findLCA(root.getRightSubTree(), node1, node2);

        if(leftSubTree != null && rightSubTree != null){
            return root;
        }
        if(leftSubTree == null && rightSubTree == null){
            return null;
        }

        return leftSubTree == null ? rightSubTree: leftSubTree;
    }

    private static int findDistanceBetween(PersonTree root, PersonTree node1, int distance){
        if(root.isEmpty()){
            return -1;
        }
        if(root == node1){
            return distance;
        }

        int d = findDistanceBetween(root.getLeftSubTree(), node1, distance + 1);

        if(d != -1){
            return d;
        }
        d = findDistanceBetween(root.getRightSubTree(), node1, distance + 1);

        return d;
    }

    public static int findDistanceBetweenLines(PersonTree root, PersonTree node1, PersonTree node2){
        PersonTree lca = findLCA(root, node1, node2);
        int d1 = findDistanceBetween(lca, node1, 0);
        int d2 = findDistanceBetween(lca, node1, 0);
        System.out.println(d1+d2);

        return d1+d2;
    }


}

**//
package com.application.model;

import java.util.ArrayList;

public class PersonTree {

    Person data;
    private PersonTree leftSubTree;
    private PersonTree rightSubTree;

    public PersonTree() {
        this.data = new Person();
        leftSubTree = null;
        rightSubTree = null;
    }

    public PersonTree(Person data, PersonTree leftSubTree, PersonTree rightSubTree) {
        this.data = data;
        this.leftSubTree = leftSubTree;
        this.rightSubTree = rightSubTree;
    }

    public boolean isEmpty() {
        return data == null;
    }

    public boolean isFull() {
        return data != null;
    }

    public Person getData() {
        return data;
    }

    public void setData(Person data) {
        this.data = data;
    }

    public PersonTree getLeftSubTree() {
        return leftSubTree;
    }

    public void setLeftSubTree(PersonTree leftSubTree) {
        this.leftSubTree = leftSubTree;
    }

    public PersonTree getRightSubTree() {
        return rightSubTree;
    }

    public void setRightSubTree(PersonTree rightSubTree) {
        this.rightSubTree = rightSubTree;
    }

    
}

//

package com.application.model;

import java.util.ArrayList;

public class PersonTree {

    static class Node {
        private Person root;
        private Node leftSubTree;
        private Node rightSubTree;
        int height;

        public Node(){
            root = new Person();
            leftSubTree = null;
            rightSubTree = null;
            height = 0;
        }

        public Node(String firstName, String lastName, String telephone, String email, String community, String school, String employer, char privacy, String activity){
            root = new Person(firstName, lastName, telephone, email, community, school, employer, privacy, activity);
            leftSubTree = null;
            rightSubTree = null;
            height = 0;
        }

        public Node(Person obj){
            root = obj;
            leftSubTree = null;
            rightSubTree = null;
            height = 0;
        }

        public Person getRoot() {
            return root;
        }

        public void setRoot(Person root) {
            this.root = root;
        }

        public Node getLeftSubTree() {
            return leftSubTree;
        }

        public void setLeftSubTree(Node leftSubTree) {
            this.leftSubTree = leftSubTree;
        }

        public Node getRightSubTree() {
            return rightSubTree;
        }

        public void setRightSubTree(Node rightSubTree) {
            this.rightSubTree = rightSubTree;
        }

        public int getHeight() {
            return height;
        }

        public void setHeight(int height) {
            this.height = height;
        }

        public boolean isEmpty(){
            return root == null;
        }

        public boolean isFull(){
            return root != null;
        }
    }

}

//