package group;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class DatabaseView {



	public DatabaseView() throws Exception {
		start();
	}




	private VBox setUp() {
		VBox temp = new VBox();
		temp.setSpacing(10);
	
		//adding the search label
		
		Label searchLabel = new Label("Search\n______");
		
		//adding the HBox for department and drop-down
		
		HBox deptBox = new HBox();
		
		deptBox.setSpacing(10);
		deptBox.getChildren().add(new Label("Department"));
		ComboBox deptChoice = new ComboBox();
		deptChoice.setPrefSize(100, 25);
		deptChoice.getItems().add("Computer Science");
		deptChoice.getItems().add("Mathematics");
		deptBox.getChildren().add(deptChoice);
		
		//adding the date and it's fields
		
		HBox dateBox = new HBox();
		dateBox.setSpacing(10);
		
		dateBox.getChildren().add(new Label("Date"));
		TextField minDate = new TextField();
		minDate.setMinSize(100, 25);
		dateBox.getChildren().add(minDate);
		dateBox.getChildren().add(new Label("To"));
		TextField maxDate = new TextField();
		dateBox.getChildren().add(maxDate);
		
		//adding the applicant score and it's fields
		
		HBox appBox = new HBox();
		appBox.setSpacing(10);
		
		appBox.getChildren().add(new Label("Applicant Score (Min)"));
		TextField minApp = new TextField();
		minApp.setPrefSize(100, 25);
		appBox.getChildren().add(minApp);
		
		//adding the job ID and it's field
		
		HBox jobBox = new HBox();
		jobBox.setSpacing(10);
		
		jobBox.getChildren().add(new Label("Job ID"));
		TextField jobField = new TextField();
		jobField.setPrefSize(100, 25);
		jobBox.getChildren().add(jobField);
		
		
		
		//add application ID and it's field and the search button
		
		HBox appIDBox = new HBox();
		appIDBox.setSpacing(10);
		
		appIDBox.getChildren().add(new Label("Application ID"));
		TextField appIDField = new TextField();
		appIDField.setPrefSize(100, 25);
		appIDBox.getChildren().add(appIDField);
		
		Button searchButton = new Button("Search");
		searchButton.setPrefSize(100, 25);
		appIDBox.getChildren().add(searchButton);
			//set on the button being pressed that stuff is read and put into HBox's to show
		
			searchButton.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent e) {
					//IN HERE THE SEARCH NEEDS TO HAPPEN THAT FILLS OUT HBOX'S AND ADDS THEM TO THE VIEW
					
				}
				
			});
			
			
		temp.getChildren().addAll(deptBox, dateBox, appBox, jobBox, appIDBox);
		
		//put the line accross the whole view
		temp.getChildren().add(new Label("____________________________________________________________________" + 
		"_________________________________________________"));	
		//add the labels for all the things
		HBox finalLabels = new HBox();
		finalLabels.setSpacing(30);
		finalLabels.getChildren().add(new Label("Department"));
		finalLabels.getChildren().add(new Label("Job ID"));
		finalLabels.getChildren().add(new Label("Role"));
		finalLabels.getChildren().add(new Label("Applicant"));
		finalLabels.getChildren().add(new Label("Date posted"));
		finalLabels.getChildren().add(new Label("Last viewed"));
		finalLabels.getChildren().add(new Label("Score"));
		
		temp.getChildren().add(finalLabels);
		
		return temp;

	}






	public void start() throws Exception {
		VBox pane = setUp();
		Stage primaryStage = new Stage();
		primaryStage.setWidth(600);
		primaryStage.setHeight(500);
		primaryStage.setResizable(false);
		primaryStage.setTitle("Database view");
		
		primaryStage.setScene(new Scene(pane));
		primaryStage.show();
		
	}

	
	
//
//	public static void main(String[] args) {
//		launch(args);
//	}
	
}
