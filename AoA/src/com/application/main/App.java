package com.application.main;

import com.application.model.Person;
import com.application.model.PersonTree;

import java.io.IOException;
import java.util.ArrayList;

public class App {
    public static void main(String[] args) throws IOException {
        ArrayList<Person> personList = new ArrayList<>();
        PersonTree personTree = new PersonTree();

        //Populating ArrayList with records from person and activities files
        Person.readFromFiles(personList);
        int size = personList.size();

        //Populating tree with person records
        System.out.println("\nPopulating tree with data from personList...");
        for (Person person : personList) {
            personTree.insertNode(person);
        }
        System.out.println("Tree populated.");

        //Checking number of nodes in tree
        System.out.println("\nNumber of nodes in tree: " + personTree.getTotalNumberOfNodes(personTree.getRoot()) + "\n");

        //Conducting a search for a given node in the tree
        System.out.println("\nSearching tree for '" + personList.get(9483).getFirstName() + " " + personList.get(9483).getLastName() + "'...");
        personTree.searchData(personList.get(9483));

        //makeRecommendations(personTree, personList);

        System.out.print(findDistance(personTree.getRoot(), personList.get(8999), personList.get(17800)));
    }

    //Recommending to each person the activities of their close contact
    public static void makeRecommendations(PersonTree personTree, ArrayList<Person> personList) {
        int size = personList.size();

        for (int i = 0; i < size; i++) {
            System.out.println("\nMaking recommendations to " + personList.get(i).getFirstName() + " " + personList.get(i).getLastName());
            personTree.getRec(personList.get(i));
        }
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
