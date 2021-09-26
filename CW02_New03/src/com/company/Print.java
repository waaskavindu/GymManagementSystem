package com.company;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;

public class Print {
    public static DBCursor findIterable;
    public static void print() {
        System.out.println("********PRINT*********");
        BasicDBObject basicDBObject=new BasicDBObject("FirstName",1);//ascending order
        DBConnection.setDatabase();
        DBCollection table = DBConnection.database.getCollection("Members");
        if (MyGymManager.ToSort.equals("yes")){
            findIterable=table.find().sort(basicDBObject);
        }else{
            findIterable = table.find();
        }
        for (DBObject count : findIterable){
            String ID = (String) count.get("ID");
            String first=(String) count.get("FirstName");
            String last=(String) count.get("LastName");
            String type=(String) count.get("Type");
            String time=(String) count.get("Time");
            System.out.println("Member ID :"+ID);
            System.out.println("Member Name :"+first+" "+last);
            System.out.println("Member Type :"+type);
            System.out.println("Starting Date :"+time);
            System.out.println("-------------------------");


        }
    }
}
