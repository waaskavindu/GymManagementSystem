package com.company;

import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.security.PublicKey;

public class SearchDetails {
    public static AnchorPane searchPane;
    public static Button btnSearch;
    public static TextField txtSearch;
    public static Label lblID;
    public static Label lblName;
    public static Label lblType;
    public static Label lblSchool;
    public static Label lblAge;
    public static Label lblDate;
    public static String searchID;
    public static String loadID;
    public static String loadFirst;
    public static String loadLast;
    public static String loadType;
    public static String loadSchool;
    public static Integer loadAge;
    public static String loadDate;


    public static void search() {
        searchPane = createAnchorPane(600.0, 500.0);
        btnSearch = createButton("Search", 455.0, 120.0, 77.0, 79.0);
        txtSearch = createTextField("ID to delete", 166.0, 165.0, 238.0, 37.0);
        lblID = createLabel("MemberID ", 174.0, 235.0);
        lblName = createLabel("MemberName ", 174.0, 267.0);
        lblSchool = createLabel("MemberSchool ", 174.0, 297.0);
        lblAge = createLabel("MemberAge ", 174.0, 330.0);
        lblDate = createLabel("Starting Date", 174.0, 360.0);
        lblType = createLabel("Type", 174.0, 390.0);
        searchPane.getChildren().add(lblType);
        searchPane.getChildren().add(btnSearch);
        searchPane.getChildren().add(txtSearch);
        searchPane.getChildren().add(lblID);
        searchPane.getChildren().add(lblName);
        searchPane.getChildren().add(lblAge);
        searchPane.getChildren().add(lblDate);
        searchPane.getChildren().add(lblSchool);


        btnSearch.setOnAction(e ->{
            loadID=txtSearch.getText();
            DBConnection.setDatabase();
            DBCollection IDCheque = DBConnection.database.getCollection("Members");
            DBCursor findIterable = IDCheque.find();
            for (DBObject search : findIterable) {
                searchID = (String) search.get("ID");
                loadFirst=(String) search.get("FirstName");
                loadLast=(String)search.get("LastName");
                loadType=(String)search.get("Type");
                loadDate=(String)search.get("Date");
                loadSchool=(String)search.get("School");
                loadAge=(Integer)search.get("Age");
                if (loadID.equals(searchID)) {
                    lblID.setText("Member ID :"+loadID);
                    lblName.setText("Member Name :"+loadFirst+" "+loadLast);
                    lblType.setText("Member Type :"+loadType);
                    lblDate.setText("Starting Date :"+loadDate);
                    lblAge.setText("Age :"+loadAge);
                    lblSchool.setText("School :"+loadSchool);
                }
            }
        });


            Scene scene = new Scene(searchPane, 600, 500);
            Stage stage = new Stage();
            stage.setTitle("Search Members");
            stage.setScene(scene);
            stage.showAndWait();
    }

    //function to create a button
    public static Button createButton(String Text, Double x, Double y, Double scaleX, Double scaleY) {
        Button btn = new Button(Text);
        btn.setLayoutX(x);
        btn.setLayoutY(y);
        btn.setPrefWidth(scaleX);
        btn.setPrefHeight(scaleY);
        return btn;
    }//function to create a tableView
    public static TableView createTableView(Double width,Double height){
        TableView tblView = new TableView();
        tblView.setPrefWidth(width);
        tblView.setPrefHeight(height);
        return tblView;
    }//function to create tableColumn
    public static TableColumn createTableColumn(String name, Double width){
        TableColumn tblColomn=new TableColumn();
        tblColomn.setText(name);
        tblColomn.setPrefWidth(width);
        return tblColomn;
    }
    public static AnchorPane createAnchorPane(Double width,Double height){
        AnchorPane APane=new AnchorPane();
        APane.setPrefWidth(width);
        APane.setPrefHeight(height);
        return APane;
    }
    public static TextField createTextField(String text,Double x,Double y,Double scaleX,Double scaleY){
        TextField txtField = new TextField();
        txtField.setPromptText(text);
        txtField.setLayoutX(x);
        txtField.setLayoutY(y);
        txtField.setPrefWidth(scaleX);
        txtField.setPrefHeight(scaleY);
        return txtField;
    }
    public static Label createLabel(String promptText,Double x, Double y) {
        Label lbl = new Label(promptText);
        lbl.setLayoutX(x);
        lbl.setLayoutY(y);
        lbl.setStyle("-fx-font-size:20px;-fx-text-fill:black;");
        return lbl;
    }
}

