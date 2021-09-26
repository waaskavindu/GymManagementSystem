package com.company.Add;

import com.company.DBConnection;
import com.company.Over60Member;
import com.mongodb.DBCollection;

import java.util.Scanner;

public class AddOver60 {
    public static void addOver60() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            try {
                System.out.println("Please Enter the Age ");
                Integer age = sc.nextInt();
                Over60Member.setAge(age);
                DBConnection.setDatabase();
                DBCollection table = DBConnection.database.getCollection("Members");
                AddDefault.basicDBObject.put("Age", Over60Member.getAge());
                break;
            } catch (Exception e) {
                System.out.println("Invalid age.Age should be a number");

            }
        }
    }
}


