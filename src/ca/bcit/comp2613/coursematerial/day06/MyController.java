package ca.bcit.comp2613.coursematerial.day06;


import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;







import java.net.URL;
import java.util.ResourceBundle;

import ca.bcit.comp2613.coursematerial.day06.data.Teacher;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TableView.TableViewSelectionModel;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;


public class MyController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button deleteButton;

    @FXML
    private AnchorPane details;

    @FXML
    private TableColumn<Teacher, String> firstNameColumnName;

    @FXML
    private Label firstNameTextField;

    @FXML
    private TableColumn<Teacher, String> idColumnName;

    @FXML
    private TextField idTextField;

    @FXML
    private TableColumn<Teacher, String> lastNameColumnName;

    @FXML
    private Label lastNameTextField;

    @FXML
    private Button newButton;

    @FXML
    private Button saveButton;

    @FXML
    private TableView<Teacher> table;


    @FXML
    void deleteFired(ActionEvent event) {
    }

    @FXML
    void newFired(ActionEvent event) {
    }

    @FXML
    void saveFired(ActionEvent event) {
    }

    @FXML
    void initialize() {
      
        populateTable();
    }

    ObservableList<Teacher> teachers = FXCollections.observableArrayList();
	private void populateTable() {
		
		   idColumnName.setCellValueFactory(new PropertyValueFactory<Teacher, String>("id"));
	        firstNameColumnName.setCellValueFactory(new PropertyValueFactory<Teacher, String>("firstName"));
	        lastNameColumnName.setCellValueFactory(new PropertyValueFactory<Teacher, String>("lastName"));
		
		Teacher teacher = new Teacher("1", "Henry", "Chan");
	
		
		teachers.add(teacher);
		 teacher = new Teacher("2", "Paul", "Mills");
		 teachers.add(teacher);
		table.setItems(teachers);
		
	}

}
