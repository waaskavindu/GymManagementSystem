package com.company;

import com.company.Add.Add;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import javax.swing.*;
import java.util.Scanner;

public class MyGymManager extends Application {
    public static String ToSort;

    @Override
    public void start(Stage primaryStage) throws Exception {
        Scanner sc = new Scanner(System.in);
        ToSort="No";
        System.out.println("*************OPTIONS****************");
        System.out.println("Enter number 1 to Add new member");
        System.out.println("Enter number 2 to delete a member");
        System.out.println("Enter number 3 to sort the member list");
        System.out.println("Enter number 4 to print the member list");
        System.out.println("Enter number 5 to save them in text file");
        System.out.println("Enter number 6 to open the search member");
        System.out.println("Enter number 7 to view member details");
        String ans =sc.nextLine();
        int choice=Integer.parseInt(ans);
        switch (choice){
            case 1://add member
                Add.add();
                break;
            case 2://delete member
                Delete.delete();
                break;
            case 3://sort
                ToSort="yes";//error*******
                Print.print();
                break;
            case 4://print
                Print.print();
                break;
            case 5://save in textfile
                Save.save();
                break;
            case 6://open GUI search
                SearchDetails.search();
                break;
            case 7://open gui view
                ViewDetails.view();
                break;
            default:
                System.out.println("Invalid Input.\\nPlease enter a valid option");

        }
    }
}
