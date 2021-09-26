package com.company.Add;

import com.company.DBConnection;
import com.company.DefaultMember;
import com.mongodb.*;

import java.util.Scanner;

public class AddDefault {
    public static Boolean IDFound;
    public static BasicDBObject basicDBObject=new BasicDBObject();

    public static void addDefault() throws Exception{
        Scanner sc = new Scanner(System.in);
        System.out.println("*******ADD MEMBER*********");
        System.out.println("Please enter ID number(It only contain 5 digits)");
        String id = sc.nextLine();
        IDFound = false;
        DefaultMember.setID(id);
        DBConnection.setDatabase();
        DBCollection table = DBConnection.database.getCollection("Members");
        DBCursor findIterable = table.find();
        for (DBObject count : findIterable) {
            String DBId = (String) count.get("ID");
            String enteredID = DefaultMember.getID();
            if (DBId.equals(enteredID)) {
                IDFound = true;
                break;
            }
        }
        if (IDFound) {
            System.out.println("ID already exists.Please re enter");
        } else {
            System.out.println("Enter First Name ");
            String first = sc.nextLine();
            System.out.println("Enter Last Name");
            String last = sc.nextLine();
            System.out.println("Enter Starting date(dd/mm/yy)");
            String time =sc.nextLine();
            DefaultMember.setFirst(first);
            DefaultMember.setLast(last);
            DefaultMember.setTime(time);
            basicDBObject.put("FirstName", DefaultMember.getFirst());
            basicDBObject.put("LastName", DefaultMember.getLast());
            basicDBObject.put("ID", DefaultMember.getID());
            basicDBObject.put("Time", DefaultMember.getTime());
            System.out.println("Data Added Successfully");


        }

    }
}