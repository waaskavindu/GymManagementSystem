package com.company;

public class DefaultMember {
    private static String ID;
    private static String First;
    private static String Last;
    private static String Time;
    //private static String Count;
    public static void setID(String id) throws Exception{
        if(id.length()==5){
            ID=id;
        }else{
            //throw new outOfLength();
            System.out.println("Your Entered "+id.length()+"digits");
            System.out.println("ID only can contain 5 digits");
        }
    }public static String getID(){
        return ID;
    }
    public static void setFirst(String first){
        First=first;
    }
    public static String getFirst(){
        return First;
    }
    public static void setLast(String last){
        Last=last;
    }
    public static String getLast(){
        return Last;
    }
    public static void setTime(String time){
        Time=time;
    }
    public static String getTime(){
        return  Time;
    }

}
