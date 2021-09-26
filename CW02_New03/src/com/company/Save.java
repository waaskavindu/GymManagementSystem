package com.company;

import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class Save {
    public static void save() throws FileNotFoundException {
        DBConnection.setDatabase();
        DBCollection table = DBConnection.database.getCollection("Members");
        DBCursor findIterable = table.find();
        PrintWriter out = new PrintWriter("GymMemberDetails.txt");
        System.out.println("*********GYM MEMBER DETAILS********");

        for (DBObject count : findIterable) {
            String ID = (String) count.get("ID");
            String first = (String) count.get("FirstName");
            String last = (String) count.get("LastName");
            String type = (String) count.get("Type");
            String time = (String) count.get("Time");
            out.println("Member ID :" + ID);
            out.println("Member Name :" + first + " " + last);
            out.println("Member Type :" + type);
            out.println("Starting Date :" + time);
            out.println("-------------------------");

        }
        System.out.println("Data Saved Successfully");
        out.close();
    }
}
