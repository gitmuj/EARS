package login;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class AddUser implements Initializable {
    @FXML
    Label usernameField, passwordField;

    @FXML
    ComboBox usertypeField;
    @FXML
    Button submitbtn, clearbtn;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        ObservableList<String> usertypes =
                FXCollections.observableArrayList(
                        "admin",
                        "faculty"
                );
        usertypeField.getItems().addAll(usertypes);


    }


    public void addUser(){
        String username = usernameField.getText();
        String password = passwordField.getText();
        String usertype = (String)usertypeField.getValue();



    }
}
