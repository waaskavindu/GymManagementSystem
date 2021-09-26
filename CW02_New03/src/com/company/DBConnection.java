package com.company;

import com.mongodb.DB;
import com.mongodb.MongoClient;

public class DBConnection {
    public static DB database;
    public static MongoClient mongoClient =new MongoClient("localhost",27017);
    public static void setDatabase(){
        database = mongoClient.getDB("Gym");
        database.createCollection("Members",null);

    }

}
