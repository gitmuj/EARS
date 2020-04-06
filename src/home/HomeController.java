package home;
//Group 10 - Mujtaba Mohmand
//Login information is username: admin, password : password, usertype: admin

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import taf.Job;
import taf.JobScreen;

import javax.swing.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class HomeController implements Initializable {

    @FXML
    Button addApplicationBtn, addNewUserBtn, addJobBtn;

    @FXML
    Button viewDatabasebtn;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        addApplicationBtn.setOnAction(e->{
            try {
                runAddApplicant();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });

        addNewUserBtn.setOnAction(e->{
            try{
                runAddNewUser();
            } catch (IOException ex){
                ex.printStackTrace();
            }
        });

        viewDatabasebtn.setOnAction(e->{
            try {
                runViewDatabase();
            } catch (Exception ex) {
                ex.printStackTrace();
            }

        });

        addJobBtn.setOnAction(e->{
            try {
                runAddJob();
            } catch (Exception ex) {
                ex.printStackTrace();
            }

        });


    }

    public void runAddApplicant() throws IOException {
        Stage applicantStage = new Stage();
        FXMLLoader loader = new FXMLLoader();
        try {
            Pane applicantRoot = (Pane) loader.load(getClass().getResource("/addApplicant/add_new_applicant.fxml").openStream());
            Scene scene = new Scene(applicantRoot);
            applicantStage.setScene(scene);
            applicantStage.setTitle("EARS - Add New addApplicant.Applicant");

            applicantStage.show();


        } catch (IOException e) {
            e.printStackTrace();
        }


    } // end runAddApplicant

    public void runAddNewUser() throws IOException {
        Stage applicantStage = new Stage();
        FXMLLoader loader = new FXMLLoader();
        try {
            Pane applicantRoot = (Pane) loader.load(getClass().getResource("/login/add_user.fxml").openStream());
            Scene scene = new Scene(applicantRoot);
            applicantStage.setScene(scene);
            applicantStage.setTitle("EARS - Add New User");

            applicantStage.show();


        } catch (IOException e) {
            e.printStackTrace();
        }


    } // end runAddNewUser

    public void runViewDatabase() throws Exception {
        Stage applicantStage = new Stage();
        FXMLLoader loader = new FXMLLoader();
        try {
            Pane applicantRoot = (Pane) loader.load(getClass().getResource("/database/view_database.fxml").openStream());
            Scene scene = new Scene(applicantRoot);
            applicantStage.setScene(scene);
            applicantStage.setTitle("EARS - Database View");

            applicantStage.show();


        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void runAddJob(){


        Job db = new Job();
        JobScreen jobScreen = new JobScreen();
        jobScreen.run();

    }
}
