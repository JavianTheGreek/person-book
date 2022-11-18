package com.application.model;

import java.util.ArrayList;

public class PersonTree {
    private Node root;

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

    private static Node findLCA(Node root, Node node1, Node node2){
        if(root == null){
            return null;
        }else if(root == node1 || root == node2){
            return root;
        }

        Node leftSubTree = findLCA(root.getLeftSubTree(), node1, node2);

        Node rightSubTree = findLCA(root.getRightSubTree(), node1, node2);

        if(leftSubTree != null && rightSubTree != null){
            return root;
        }
        if(leftSubTree == null && rightSubTree == null){
            return null;
        }

        return leftSubTree == null ? rightSubTree : leftSubTree;

    }

    private static int findDistanceBetween(Node root, Node node1, int distance){
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

    public static int findDistanceBetweenLines(Node root, Node node1, Node node2){
        Node lca = findLCA(root, node1, node2);
        int d1 = findDistanceBetween(lca, node1, 0);
        int d2 = findDistanceBetween(lca, node1, 0);
        System.out.println(d1+d2);

        return d1+d2;
    }

    public PersonTree(){
        root = null;
    }

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    //Destroy Tree
    public void destroyTree()
    {
        root = null;
    }

    public boolean isEmpty(){
        if(root == null)
            return true;
        else
            return false;
    }

    public void insertNode(Person data){
        root = insertNode(data, root);
    }

    private int getHeight(Node node)
    {
        return node == null ? -1 : node.height;
    }

    //create maxNode() method to get the maximum height from left and right node
    private int getMaxHeight(int leftNodeHeight, int rightNodeHeight)
    {
        return leftNodeHeight > rightNodeHeight ? leftNodeHeight : rightNodeHeight;
    }

    private Node insertNode(Person data, Node root)
    {
        //check whether the node is null or not
        if (root == null)
            root = new Node(data);
            //insert a node in case when the given data is lesser than the data of the root node
        else if (getCountCommon(data, root.root) == 0)
        {
            root.leftSubTree = insertNode(data, root.leftSubTree);
            if(getHeight(root.leftSubTree) - getHeight(root.rightSubTree) == 2 )
                if(getCountCommon(data, root.leftSubTree.root) == 0)
                    root = rotateWithleftSubTree(root);
                else
                    root = doubleWithleftSubTree(root);
        }
        else if(getCountCommon(data, root.root) > 0)
        {
            root.rightSubTree = insertNode(data, root.rightSubTree);
            if(getHeight(root.rightSubTree) - getHeight(root.leftSubTree) == 2 )
                if(getCountCommon(data, root.rightSubTree.root) > 0)
                    root = rotateWithrightSubTree(root);
                else
                    root = doubleWithrightSubTree(root);
        }
        else
            ;  // if the data is already present in the tree, we will do nothing

        root.height = getMaxHeight(getHeight(root.leftSubTree), getHeight(root.rightSubTree)) + 1;

        return root;

    }

    // creating rotateWithLeftChild() method to perform rotation of binary tree node with left child
    private Node rotateWithleftSubTree(Node node2)
    {
        Node node1 = node2.leftSubTree;
        node2.leftSubTree = node1.rightSubTree;
        node1.rightSubTree = node2;
        node2.height = getMaxHeight( getHeight( node2.leftSubTree ), getHeight( node2.rightSubTree ) ) + 1;
        node1.height = getMaxHeight( getHeight( node1.leftSubTree ), node2.height ) + 1;
        return node1;
    }

    // creating rotateWithrightSubTree() method to perform rotation of binary tree node with right child
    private Node rotateWithrightSubTree(Node node1)
    {
        Node node2 = node1.rightSubTree;
        node1.rightSubTree = node2.leftSubTree;
        node2.leftSubTree = node1;
        node1.height = getMaxHeight( getHeight( node1.leftSubTree ), getHeight( node1.rightSubTree ) ) + 1;
        node2.height = getMaxHeight( getHeight( node2.rightSubTree ), node1.height ) + 1;
        return node2;
    }

    //create doubleWithleftSubTree() method to perform double rotation of binary tree node. This method first rotate the left child with its right child, and after that, node3 with the new left child
    private Node doubleWithleftSubTree(Node node3)
    {
        node3.leftSubTree = rotateWithrightSubTree( node3.leftSubTree );
        return rotateWithleftSubTree( node3 );
    }

    //create doubleWithrightSubTree() method to perform double rotation of binary tree node. This method first rotate the right child with its left child and after that node1 with the new right child
    private Node doubleWithrightSubTree(Node node1)
    {
        node1.rightSubTree = rotateWithleftSubTree( node1.rightSubTree );
        return rotateWithrightSubTree( node1 );
    }

    //create getTotalNumberOfNodes() method to get total number of nodes in the AVL Tree
    public int getTotalNumberOfNodes()
    {
        return getTotalNumberOfNodes(root);
    }
    private int getTotalNumberOfNodes(Node root)
    {
        if (root == null)
            return 0;
        else
        {
            int size = 1;
            size = size + getTotalNumberOfNodes(root.leftSubTree);
            size = size + getTotalNumberOfNodes(root.rightSubTree);
            return size;
        }
    }

    public Person searchData(Person data)
    {
        Person check = new Person();

        if(root == null){
            System.out.println(data.getFirstName() + " was not found.");
            return check;
        }

        if (root.root == data){
            System.out.println(data.getFirstName() + "was found!");
            check = new Person(root.root);
            return check;
        } else {
            if (getCountCommon(root.root, data) == 0){
                root = root.leftSubTree;
                return searchData(data);
            } else if (getCountCommon(root.root, data) > 0){
                root = root.rightSubTree;
                return searchData(data);
            }
        }

        return check;
    }


    // create inorderTraversal() method for traversing AVL Tree in in-order form
    public void inorderTraversal()
    {
        inorderTraversal(root);
    }
    private void inorderTraversal(Node head)
    {
        if (head != null)
        {
            inorderTraversal(head.leftSubTree);
            System.out.print(head.root);
            inorderTraversal(head.rightSubTree);
        }
    }

    // create preorderTraversal() method for traversing AVL Tree in pre-order form
    public void preorderTraversal()
    {
        preorderTraversal(root);
    }
    private void preorderTraversal(Node head)
    {
        if (head != null)
        {
            System.out.print(head.root+" ");
            preorderTraversal(head.leftSubTree);
            preorderTraversal(head.rightSubTree);
        }
    }

    // create postorderTraversal() method for traversing AVL Tree in post-order form
    public void postorderTraversal()
    {
        postorderTraversal(root);
    }

    private void postorderTraversal(Node head)
    {
        if (head != null)
        {
            postorderTraversal(head.leftSubTree);
            postorderTraversal(head.rightSubTree);
            System.out.print(head.root+" ");
        }
    }

    public int calculateDegreeOfSeparation(Node node, ArrayList<Person> personList){
        int position = 0;
        if (node.isEmpty()){
            return 0;
        }else {
            position = calculateLinePosition(node.leftSubTree, personList) + calculateLinePosition(node.rightSubTree, personList) + 1;
            return position;
        }
    }
    private int calculateLinePosition(Node leftSubTree, ArrayList<Person> personList) {
        //left.person
        // right.left.person
        return 1;
    }

    public int getCountCommon(Person personA, Person personB) {
        int countCommon = 0;

        if (personA.getSchool().equals(personB.getSchool())) {
            countCommon += 1;
        }

        if (personA.getCommunity().equals(personB.getCommunity())) {
            countCommon += 1;
        }

        if (personA.getEmployer().equals(personB.getEmployer())) {
            countCommon += 1;
        }

        return countCommon;
    }

}