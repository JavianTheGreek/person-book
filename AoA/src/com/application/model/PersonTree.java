package com.application.model;

import com.application.main.Node;

public class PersonTree {

    private Node root;

    public PersonTree() {
        root = null;
    }

    public PersonTree(Node root) {
        this.root = root;
    }

    public PersonTree(PersonTree obj) {
        this.root = obj.root;
    }

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    //Destroy Tree
    public void destroyTree() {
        root = null;
    }

    //Checking whether the tree is empty
    public boolean isEmpty() {
        return root == null;
    }

    private int getHeight(Node root) {
        return root == null ? -1 : root.getHeight();
    }

    //Get the maximum height from left and right node
    private int getMaxHeight(int leftNodeHeight, int rightNodeHeight) {
        return leftNodeHeight > rightNodeHeight ? leftNodeHeight : rightNodeHeight;
    }

    public void insertNode(Person data) {
        root = insertNode(data, root);
    }

    public Node insertNode(Person data, Node node) {
        //Checks whether the incoming node is null or not
        if (node == null) {
            return (new Node(data));
        } else if (getCountCommon(data, node.getRoot()) == 0) {
            node.setLeftSubTree(insertNode(data, node.getLeftSubTree()));
        } else if (getCountCommon(data, node.getRoot()) > 0) {
            node.setRightSubTree(insertNode(data, node.getRightSubTree()));
        }

        node.setHeight(getMaxHeight(getHeight(node.getLeftSubTree()), getHeight(node.getRightSubTree())) + 1);

        return node;
    }

    public int getTotalNumberOfNodes(Node root) {
        if (root == null) return 0;
        else {
            int size = 1;
            size = size + getTotalNumberOfNodes(root.getLeftSubTree());
            size = size + getTotalNumberOfNodes(root.getRightSubTree());
            return size;
        }
    }

    public Node searchData(Person data) {
        return searchData(root, data);
    }

    public Node searchData(Node node, Person data) {
        try {
            if (node == null) {
                System.out.println(data.getFirstName() + " was not found.");
            }

            if (node.getRoot() == data) {
                System.out.println(data.getFirstName() + " was found!");
                //System.out.println("Here is their information...\n" + node.getRoot());
                return node;
            } else {
                if (getCountCommon(node.getRoot(), data) == 0) {
                    node = node.getLeftSubTree();
                    return searchData(node, data);
                } else if (getCountCommon(node.getRoot(), data) > 0) {
                    node = node.getRightSubTree();
                    return searchData(node, data);
                }
            }
        } catch (NullPointerException e) {
            System.err.println(e.getMessage());
        }

        return node;
    }

    // Methods for traversing Binary Search Tree inorder
    public void inorderTraversal() {
        inorderTraversal(root);
    }

    private void inorderTraversal(Node root) {
        if (root != null) {
            inorderTraversal(root.getLeftSubTree());
            System.out.print(root.getRoot());
            inorderTraversal(root.getRightSubTree());
        }
    }

    // Methods for preorder traversal of Binary Search Tree
    public void preorderTraversal() {
        preorderTraversal(root);
    }

    private void preorderTraversal(Node root) {
        if (root != null) {
            System.out.print(root.getRoot());
            preorderTraversal(root.getLeftSubTree());
            preorderTraversal(root.getRightSubTree());
        }
    }

    // Methods for postorder traversal of Binary Search Tree
    public void postorderTraversal() {
        postorderTraversal(root);
    }

    private void postorderTraversal(Node root) {
        if (root != null) {
            postorderTraversal(root.getLeftSubTree());
            postorderTraversal(root.getRightSubTree());
            System.out.print(root.getRoot());
        }
    }

    public void getRec(Person data) {
        getRec(searchData(data));
    }

    private void getRec(Node node) {
        String recommendations = "";
        try {
            if (node == null) {
                System.out.println("The given node is null. No recommendations can be made.");
            }

            if (node.getRoot().isPrivacy() == 'N') {
                if (node.getRightSubTree() != null) {
                    if (getCountCommon(node.getRoot(), node.getRightSubTree().getRoot()) > 0) {
                        if (node.getRightSubTree().getRoot().getActivity() != "") {
                            recommendations = recommendations + node.getRightSubTree().getRoot().getActivity();
                            System.out.println(node.getRoot().getFirstName() +
                                    ", here are some things your close contacts are interested in. You might be too: \n" + recommendations);
                        } else {
                            System.out.println("Sorry. No recommendations are avaialble for you, " + node.getRoot().getFirstName() +
                                    ", because  your close contact has no activities listed.");
                        }
                    }
                } else {
                    System.out.println(" We're sorry, " + node.getRoot().getFirstName() +
                            ", but since you have no close contact, we cannot recommend activities to you.");
                }
            } else if (node.getRoot().isPrivacy() == 'Y') {
                System.out.println(node.getRoot().getFirstName() + " " + node.getRoot().getLastName()
                        + " has privacy settings enabled. No recommendations can be made.");
            }
        } catch (NullPointerException e) {
            System.err.println(e.getMessage());
        }
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



