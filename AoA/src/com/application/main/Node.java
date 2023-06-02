
package com.application.main;

import com.application.model.Person;

public class Node {
    private Person root;
    private Node leftSubTree;
    private Node rightSubTree;
    private int height;

    public Node(){
        root = new Person();
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
