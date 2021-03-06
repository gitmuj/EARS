package addApplicant;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
//Group 10 - Mujtaba Mohmand

import java.io.File;
import java.io.IOException;

public class AddNewApplicant extends Application {


    public  static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {


        Parent root = FXMLLoader.load(getClass().getResource("add_new_applicant.fxml"));
        primaryStage.setTitle("EARS - Add New Applicant"); // window is called stage
        primaryStage.setScene(new Scene(root, 800, 600)); // content inside window
        primaryStage.show();


    }
}
