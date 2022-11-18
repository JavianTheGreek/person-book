package com.application.main;
import com.application.model.Person;
import com.application.model.PersonTree;
import com.sun.tools.javac.Main;

import java.io.*;
import java.util.*;

public class App {

    public static Random rand = new Random();
    public static Scanner in = new Scanner(System.in);
    public static ArrayList<Person> personList = new ArrayList<>();
    public static Person person = new Person();
    public static PersonTree personTree = new PersonTree();

    public static void main(String[] args) throws IOException {

        Person.readFromFiles(personList);
        int size = personList.size();
        System.out.println("Size of list = " + size);

        System.out.println("\nPopulating tree with data from personList...");
        for (int index=0; index<size; index++){

            personTree.insertNode(personList.get(index));
        }

        System.out.println("Tree populated.");

        System.out.println("\n\nThe persons in the list are: \n");

        //Checking number of nodes in tree
        System.out.println("Number of nodes in tree: " + personTree.getTotalNumberOfNodes() + "\n");

        //Checking similarity count between various persons
//        System.out.println(personList.get(0).getFirstName() + " " + personList.get(0).getLastName() +
//                " and " + personList.get(557).getFirstName() + " " + personList.get(557).getLastName() + "...");
//        System.out.println(personTree.getCountCommon(personList.get(0), personList.get(557)));
//
//        System.out.println(personList.get(657).getFirstName() + " " + personList.get(657).getLastName() +
//                " and " + personList.get(8557).getFirstName() + " " + personList.get(8557).getLastName() + "...");
//        System.out.println(personTree.getCountCommon(personList.get(657), personList.get(8557)));
//
//        System.out.println(personList.get(2568).getFirstName() + " " + personList.get(2568).getLastName() +
//                " and " + personList.get(9057).getFirstName() + " " + personList.get(9057).getLastName() + "...");
//        System.out.println(personTree.getCountCommon(personList.get(2568), personList.get(9057)));
//
//        System.out.println(personList.get(19333).getFirstName() + " " + personList.get(19333).getLastName() +
//                " and " + personList.get(5757).getFirstName() + " " + personList.get(5757).getLastName() + "...");
//        System.out.println(personTree.getCountCommon(personList.get(19333), personList.get(5757)));
          System.out.println("\nMaking recommendations...");
          personTree.getRec(personList);



//        System.out.println("\nSearching tree for '" + personList.get(1).getFirstName() + " " + personList.get(1).getLastName() + "'...");
//        personTree.searchData(personList.get(1));
//        System.out.println(personTree.getRoot());

        System.out.println("""
                
                +++ PersonBook +++

                [1] - Upload Files
                [2] - Calculate Degree of Separation
                [3] - Average of Degree of Separation
                
                """);
        System.out.println("Select from above");
        int choice = in.nextInt();
        switch (choice){
            case 1 -> {
                System.out.println("1 selected");
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
    }

    public static void degreeOfSeparation() throws IOException {
        int result = 2, cnt=0;
        String val = "";
        String FirstName = "";
        String LastName = "";
        int size = personList.size();


        while(true){
           try{
               System.out.println("Enter any key to continue (exit to end the program)");
               val = in.next();

               if(!val.equals("exit")) {

                   for(int k=0; k<result; k++){
                           // used for generating the index of two random person from the list.
//                            int getPosition = (int) (Math.random() * personList.size());
//                            System.out.println(personList.get(getPosition + i));


                       for(int i=0; i<size; i++){

//                           System.out.println(personTree.get(result + k).getFirstName()+ " " + personList.get(result + k).getLastName() );
//                           System.out.println("\t-+-Enter Names of the Persons in the file-+-");
//                           System.out.println("Enter First Name: ");
//                           FirstName = in.next();
//                           System.out.println("Enter Last Name: ");
//                           LastName = in.next();
//
//                            if(personList.get(i).getFirstName().contains(FirstName) && personList.get(i).getLastName().contains(LastName)){
//                                System.out.println("\nThe degrees of separation between "+ personList.get(i).getFirstName() + " " + personList.get(i).getLastName() + " and " + personList.get(i).getFirstName() + " " + personList.get(i).getLastName());
//                            }
                        }
                   }

               } else {
                   System.exit(0);
               }
           }catch(Exception e){
               e.printStackTrace();
           }
        }
    }



    private static int genRecommendation(int common) {
        int result = 0;
        for (int i = 0; i <= 2; i++) {
            result = rand.nextInt(common);
            result = rand.nextInt(21000);
        }
        return result;
    }
}



//        for(Person p : personList){
//            System.out.println(p);
//        }

//        ArrayList<Person> people = new ArrayList<>();
//
//        Person p1 = new Person("Shaquille","Brown","8769631478","ShBrown7@gmail.com","Hope Flat","Wolmers High","BNS",'Y',"Buy A Watch");
//        Person p2 = new Person("Javain","Cummings","8769631478","ShBrown7@gmail.com","Hope Flat","Wolmers High","BNS",'Y',"Buys A Watch");
//        Person p3 = new Person("Sam","Brown","8769631478","ShBrown7@gmail.com","Hope Flat","Wolmers High","BNS",'N',"gaming");
////
////
//
//
//        people.add(p1);
//        people.add(p2);
//        people.add(p3);
//        int result = 2;
//
//        System.out.println("Enter ");
//
//        for(int i=0; i < result; i++){
//            int index = (int)(Math.random() * people.size());
//            System.out.println(people.get(index+i));
//
//        }


//                        for(int i=0; i < result; i++) {
//                            // used for generating the index of two random person from the list.
//                            int getPosition = (int) (Math.random() * personList.size());
//                            System.out.println(personList.get(getPosition + i));
//                            System.out.println(getPosition);
//                            System.out.println("\nThe degrees of separation between "+ personList.get(getPosition).getFirstName() + " and " + personList.get(getPosition).getLastName() + "is ");
//                        }

//for(int k=0; k<result; k++){
//        System.out.println("\t-+-Enter Names of the Persons in the file-+-");
////                       System.out.println("Enter First Name: ");
////                       FirstName = in.next();
////                       System.out.println("Enter Last Name: ");
////                       LastName = in.next();
//
//        // used for generating the index of two random person from the list.
//        int getPosition = (int) (Math.random() * personList.size());
//        System.out.println(personList.get(getPosition + i))
//
//        }
//        for(int i=0; i<personList.size(); i++){;
//        if(personList.get(i).getFirstName().contains(FirstName) && personList.get(i).getLastName().contains(LastName)){
//        System.out.println("\nThe degrees of separation between "+ personList.get(i).getFirstName() + " " + personList.get(i).getLastName() + " and " + personList.get(i).getFirstName() + " " + personList.get(i).getLastName());
//        }
//        }
