package application;
	
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.stage.Stage;
import util.Factory;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;

/**
 * 
 * @author Arkadii Semenov 5833 SI FIT 
 * @summary CS202-DZ08 completed by Arkadii Semenov 5833 SI FIT
 * @description Write a JavaFX application that should enable the entry of students into the Set structure. 
 * It is necessary to create the class Student (attributes are first name, last name and index number) and 
 * appropriate fields for entering attributes as well as a button to add a student to the Set. 
 * In addition, it is necessary to add three more buttons (radioButtons) that should enable printing (in the console) 
 * of all students from the set sorted by first name, last name and index number 
 * (each button returns the result of sorting by a different criterion).
 *
 */
public class Main extends Application {
	private int sorting_index = 0;
	private Set<Student> students;
	
	@Override
	public void start(Stage primaryStage) {
		try {
			this.students = new HashSet<Student>();
			
			GridPane root = new GridPane();
			root.setPadding(new Insets(10));
			root.setHgap(10);
			root.setVgap(10);
			
			int row = 0;
			
			// Adding data
			TextField fn = Factory.addLabeledTextInput(root, "First Name: ", row++);
			TextField ln = Factory.addLabeledTextInput(root, "Last Name: ", row++);
			TextField ind = Factory.addLabeledTextInput(root, "Index: ", row++);
			
			root.add(Factory.button("Add Data", (e) -> {
				String i = ind.getText(), f = fn.getText(), l = ln.getText();
				
				if(i != "" && f != "" && l != "") this.students.add(new Student(f, l, i));
			}), 3, 0);
			
			
			// Sorting data
			Comparator<Student> byIndex = (Student a, Student b) -> a.index.compareTo(b.index);
			Comparator<Student> byFirstName = (Student a, Student b) -> a.firstName.compareTo(b.firstName);
			Comparator<Student> byLastName = (Student a, Student b) -> a.lastName.compareTo(b.lastName);
			
			root.add(Factory.button("Show values", (e) -> {
				List<Student> a = new ArrayList<>(this.students);
				
				switch(this.sorting_index) {
				case 0: Collections.sort(a, byIndex); break;
				case 1: Collections.sort(a, byFirstName); break;
				case 2: Collections.sort(a, byLastName); break;
				}

				for(Student i : a) System.out.println(i);
			}), 3, 1);
			
			
			// Picking sort style
			ToggleGroup tg = new ToggleGroup();
			tg.selectedToggleProperty().addListener((ov) -> {
				RadioButton rb = (RadioButton) tg.getSelectedToggle();
				if(rb != null) {
					this.sorting_index = (Integer) rb.getUserData();
				}
			});
			
			RadioButton[] rbs = Factory.makeRadios(new String[]{
					"Sort by Index", "Sort by First Name", "Sort by Last Name"}, new Integer[]{0, 1, 2});
			Factory.setToggleGroup(tg, rbs);
			Factory.addRadioButtons2Grid(root, row++, rbs);
			
			
			// Set up scene
			Scene scene = new Scene(root, 420, 200);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setTitle("CS202-DZ08 Arkadii Semenov 5833");
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
