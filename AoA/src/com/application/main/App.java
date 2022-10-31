package com.application.main;
import com.application.model.Person;

import java.io.*;
import java.util.*;

public class App {

    public static void main(String[] args) throws IOException {
        ArrayList<Person> personList = new ArrayList<>();
        Scanner in = new Scanner(System.in);
//
//        personList.add(new Person("Javian", "Cummings", "8768042159", "javian@gmail.com", "Hope Field", "UTech", "Patty Shop", true));

//        System.out.println("+++ PersonBook +++\n");

//        System.out.println("Enter The Match Target: ");
//        String target = in.nextLine();



        Person.readFromPersonFile();


//        String greeting = "Hello,World";
//        String section[] = greeting.split(",");
//
//        for (String s : section) {
//            System.out.println(s);
//        }

    }
}
