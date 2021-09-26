package com.company.Add;

import com.company.DBConnection;
import com.mongodb.DBCollection;
import org.bson.io.BsonOutput;

import java.util.Scanner;

public class AddStudent {
    public static void addStudent() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            try {
                System.out.println("Please Enter School Name");
                String school = sc.nextLine();
                DBConnection.setDatabase();
                DBCollection table = DBConnection.database.getCollection("Members");
                AddDefault.basicDBObject.put("SchoolName", school);
                System.out.println("Data Added Successfully");
                break;

            } catch (Exception e) {
                System.out.println("Invalid School Name.re Enter the School Name");
            }
        }
    }
}
