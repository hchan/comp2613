package ca.bcit.comp2613.coursematerial.javafx;

import java.io.IOException;
import java.net.URL;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import ca.bcit.comp2613.coursematerial.day02.model.Teacher;
import ca.bcit.comp2613.coursematerial.day05.util.TeacherUtil;

public class TeacherController {
	  @FXML
	    private AnchorPane root;

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
	private TextField firstNameTextField;

	@FXML
	private TableColumn<Teacher, String> idColumnName;

	@FXML
	private TextField idTextField;

	@FXML
	private TableColumn<Teacher, String> lastNameColumnName;

	@FXML
	private TextField lastNameTextField;

	@FXML
	private Button newButton;

	@FXML
	private Button saveButton;

	@FXML
	private TableView<Teacher> table;
	
	@FXML
	private Button viewStudentsButton;

	@FXML
	void deleteFired(ActionEvent event) {
		Teacher teacher = getSelectedTeacher();
		table.getItems().remove(teacher);
	}

	@FXML
	void newFired(ActionEvent event) {
		Calendar cal = new GregorianCalendar();
		idTextField.setText(Long.toString(cal.getTime().getTime()));
		firstNameTextField.setText("Enter a First Name");
		lastNameTextField.setText("Enter a Last Name");
	}

	@FXML
	void saveFired(ActionEvent event) {
		Teacher teacher = new Teacher(idTextField.getText(), firstNameTextField.getText(), lastNameTextField.getText());
		table.getItems().add(teacher);
	}
	
	@FXML
	void viewStudentsFired(ActionEvent event) throws IOException {
		System.out.println("HERE");
		FXMLLoader fxmlLoader = new FXMLLoader();		
		Parent student = (Parent) fxmlLoader.load(getClass().getResource("Student.fxml").openStream());
		fxmlLoader.getController(); // TODO
		Scene scene = new Scene(student);
		Stage newStage = new Stage();
		newStage.setScene(scene);
		newStage.show();
	}

	@FXML
	void initialize() {

		populateTable();
		configurTable();
		
	}



	private void configurTable() {
		table.getSelectionModel().getSelectedItems()
				.addListener(new ListChangeListener<Teacher>() {
					
					@Override
					public void onChanged(
							javafx.collections.ListChangeListener.Change<? extends Teacher> change) {
					
						updateDetails();
						// updateSaveButtonState();
					}
				});
	}

	public Teacher getSelectedTeacher() {

		List<Teacher> items = table.getSelectionModel().getSelectedItems();
		if (items.size() == 1) {
			final Teacher teacher = items.get(0);
			return teacher;
		}

		return null;
	}

	public void updateDetails() {
		Teacher teacher = getSelectedTeacher();
		if (teacher != null) {
			idTextField.setText(teacher.getId());
			firstNameTextField.setText(teacher.getFirstName());
			lastNameTextField.setText(teacher.getLastName());
		}
	}

	ObservableList<Teacher> teachers = FXCollections.observableArrayList();

	private void populateTable() {

		idColumnName
				.setCellValueFactory(new PropertyValueFactory<Teacher, String>(
						"id"));
		firstNameColumnName
				.setCellValueFactory(new PropertyValueFactory<Teacher, String>(
						"firstName"));
		lastNameColumnName
				.setCellValueFactory(new PropertyValueFactory<Teacher, String>(
						"lastName"));

		
		teachers.addAll(TeacherUtil.create100RandomTeachers());
		table.setItems(teachers);

	}

}
