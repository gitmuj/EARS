package database;

import addApplicant.Applicant;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ViewApplicantController{
    //View application UI objects
    @FXML
    Label firstName, lastName, addressField, phonenumField, emailField, degreeField, majorField, schoolField, roleField, organizationField, yearsExpField, educationScore, expScore, skillScore, communicationScore;
    @FXML
    TextArea commentsField;
    @FXML
    Label jobId;



}
