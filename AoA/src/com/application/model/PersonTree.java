/*
 * Name: Castin Rowe  ID#:
 * Name: Javian Cummings ID#: 2001946
 * Name:  Jazmin Hayles ID#: 2006754
 * Name:Sydney Chambers  ID#: 2005734
 * */


package com.application.model;

import com.application.main.Node;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Stack;

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

    public void inorderTraversal(Node root) {
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

    // This function returns pointer to LCA of two given values n1 and n2. It also sets
    // d1, d2 and dist if one key is not ancestor of other
    // d1 -. To store distance of n1 from root
    // d2 -. To store distance of n2 from root
    // lvl -. Level (or distance from root) of current node
    // dist -. To store distance between n1 and n2

    static int d1 = -1;
    static int d2 = -1;
    static int dist = 0;

    // Returns height of person P if they are in the tree
    public static int findHeight(Node node, Person P, int height) {
        if (node == null) {
            return -1;
        }
        // If key is present at root, or in left
        // subtree or right subtree, return true;
        if (node.getRoot() == P) {
            return height;
        }

        int h = findHeight(node.getLeftSubTree(), P, height + 1);
        // h not 1 -> 1 else ->
        return (h != -1) ? h : findHeight(node.getRightSubTree(), P, height + 1);
    }

    public static Node findDistUtil(Node node, Person P1, Person P2, int lvl) {

        // Base case
        if (node == null) {
            return null;
        }

        if (node.getRoot() == P1) {
            d1 = lvl;
            return node;
        }
        if (node.getRoot() == P2) {
            d2 = lvl;
            return node;
        }

        // Look for P1 and P2 in left and right subtrees
        Node left_lca = findDistUtil(node.getLeftSubTree(), P1, P2, lvl + 1);
        Node right_lca = findDistUtil(node.getRightSubTree(), P1, P2, lvl + 1);

        // If both of the above calls return Non-null,
        // then one key is present in once subtree and
        // other is present in other, So this node is the LCA
        if (left_lca != null && right_lca != null) {
            dist = (d1 + d2) - 2 * lvl;
            return node;
        }

        // Otherwise check if left subtree
        // or right subtree is LCA
        return (left_lca != null) ? left_lca : right_lca;
    }

    // The main function that returns distance
    // between P1 and P2. This function returns -1
    // if either P1 or P2 is not present in Binary Tree.
    public static int findDistance(Node node, Person P1, Person P2) {
        d1 = -1;
        d2 = -1;
        dist = 0;
        Node lca = findDistUtil(node, P1, P2, 1);

        // If both P1 and P2 were present
        // in Binary Tree, return dist
        if (d1 != -1 && d2 != -1) {
            return dist;
        }

        // If P1 is ancestor of P2, consider
        // P1 as root and find level
        // of P2 in subtree rooted with n1
        if (d1 != -1) {
            dist = findHeight(lca, P2, 0);
            return dist;
        }

        // If P2 is ancestor of P1, consider
        // P2 as root and find level
        // of P1 in subtree rooted with P2
        if (d2 != -1) {
            dist = findHeight(lca, P1, 0);
            return dist;
        }
        return -1;
    }
}



