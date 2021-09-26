package com.company.Add;

import com.company.DBConnection;
import com.company.DefaultMember;
import com.mongodb.DBCollection;

import java.util.Scanner;

public class Add {
    public static void add()throws Exception{
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter number 1 for Default member");
        System.out.println("Enter number 2 for Student member");
        System.out.println("Enter number 3 for Over 60 member");
        while(true) {
            System.out.println("Please enter the type of member");
            String input = sc.nextLine();
            String type = input.toLowerCase();
            DBConnection.setDatabase();
            DBCollection table = DBConnection.database.getCollection("Members");
            if (type.equals("1")) {
                AddDefault.addDefault();
                AddDefault.basicDBObject.put("Type", "Default");
                table.insert(AddDefault.basicDBObject);
                break;
            } else if (type.equals("2")) {
                AddDefault.addDefault();
                AddStudent.addStudent();
                AddDefault.basicDBObject.put("Type", "Student");
                table.insert(AddDefault.basicDBObject);
                break;

            } else if (type.equals("3")) {
                AddDefault.addDefault();
                AddOver60.addOver60();
                AddDefault.basicDBObject.put("Type", "Over60");
                table.insert(AddDefault.basicDBObject);
                break;

            } else {
                System.out.println("Invalid Member type.Please re Enter");
            }
        }

    }
}
