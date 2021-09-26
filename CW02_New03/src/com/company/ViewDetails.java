package com.company;

import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.UncheckedIOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ViewDetails{
    public static AnchorPane ViewPane;
    public static TableView Table;
    public static TableColumn<ModelForView,String>columnID;
    public static TableColumn<ModelForView,String> columnFirst;
    public static TableColumn<ModelForView,String> columnLast;
    public static TableColumn<ModelForView,String> columnType;
    public static TableColumn<ModelForView,String> columnSchool;
    public static TableColumn<ModelForView,String> columnDate;
    public static TableColumn<ModelForView,String> columnAge;

    public static void initialize(){
        columnID.setCellValueFactory(new PropertyValueFactory<>("ID"));
        columnFirst.setCellValueFactory(new PropertyValueFactory<>("FirstName"));
        columnLast.setCellValueFactory(new PropertyValueFactory<>("LastName"));
        columnType.setCellValueFactory(new PropertyValueFactory<>("Type"));
        columnSchool.setCellValueFactory(new PropertyValueFactory<>("SchoolName"));
        columnAge.setCellValueFactory(new PropertyValueFactory<>("Age"));
        columnDate.setCellValueFactory(new PropertyValueFactory<>("Date"));

        display();
    }
    public static void display(){
        //initialize();
        ObservableList<ModelForView>mainList= FXCollections.observableArrayList();
        DBConnection.setDatabase();
        DBCollection View=DBConnection.database.getCollection("Members");
        DBCursor cheque=View.find();
        for (DBObject count:cheque) {
            ModelForView value=new ModelForView();
            value.setID((String) count.get("ID"));
            value.setFirstName((String) count.get("FirstName"));
            value.setLastName((String) count.get("LastName"));
            value.setType((String)count.get("Type"));
            value.setSchool((String)count.get("SchoolName"));
            value.setAge((Integer) count.get("Age"));
            value.setDate((String)count.get("Time"));
            mainList.add(value);
        }
        Table.setItems(mainList);
    }
    public static void view() {
        ViewPane = SearchDetails.createAnchorPane(1033.0, 739.0);
        Table = SearchDetails.createTableView(1033.0, 639.0);
        columnID = SearchDetails.createTableColumn("ID", 155.5);
        columnFirst = SearchDetails.createTableColumn("FirstName", 155.0);
        columnLast = SearchDetails.createTableColumn("LastName", 155.0);
        columnType = SearchDetails.createTableColumn("MemberType", 155.0);
        columnDate = SearchDetails.createTableColumn("Date", 155.0);
        columnSchool = SearchDetails.createTableColumn("School", 155.0);
        columnAge = SearchDetails.createTableColumn("Age", 155.0);


        Table.getColumns().add(columnID);
        Table.getColumns().add(columnFirst);
        Table.getColumns().add(columnLast);
        Table.getColumns().add(columnType);
        Table.getColumns().add(columnDate);
        Table.getColumns().add(columnSchool);
        Table.getColumns().add(columnAge);


        ViewPane.getChildren().add(Table);

        Stage stage = new Stage();
        stage.setTitle("Member Details");
        Scene scene = new Scene(ViewPane, 1033.0, 639.0);
        stage.setScene(scene);
        stage.show();
        initialize();
    }

}
