package com.company;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;

import java.util.Scanner;

public class Delete {
    public static Boolean IDFound;
    public static void delete() throws Exception {
        Scanner sc=new Scanner(System.in);
        System.out.println("*******DELETE MEMBER********");
        try {
            IDFound = false;
            System.out.println("Please Enter Id need to delete");
            String id = sc.nextLine();
            DefaultMember.setID(id);
            DBConnection.setDatabase();
            DBCollection table = DBConnection.database.getCollection("Members");
            DBCursor findIterable = table.find();
            for (DBObject count : findIterable) {
                String DBID = (String) count.get("ID");
                String enteredID = DefaultMember.getID();
                if (DBID.equals(enteredID)) {
                    String first = (String) count.get("FirstName");
                    String last = (String) count.get("LastName");
                    String type = (String) count.get("Type");
                    BasicDBObject basicDBObject = new BasicDBObject();
                    basicDBObject.put("ID", DefaultMember.getID());
                    table.findAndRemove(basicDBObject);
                    System.out.println("ID that deleted :" + enteredID);
                    System.out.println("Member Name :" + first + " " + last);
                    System.out.println("Member type :" + type);
                    IDFound = true;
                    break;
                }
            }
            if (IDFound) {
                System.out.println("deleted successfully");
            } else {
                System.out.println("Id can not found to delete");
                IDFound = false;
            }
        }catch (Exception e){
            System.out.println("Something went wrong");
        }
    }

}
