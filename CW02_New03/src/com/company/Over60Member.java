package com.company;

public class Over60Member {
    private static Integer Age;
    public static void setAge(Integer age){
        if(age>=60){
            Age=age;
            System.out.println("Age added successfully");


        }else{
            System.out.println("The age should be over 60");

        }
    }
    public static Integer getAge(){
        return Age;
    }

}
