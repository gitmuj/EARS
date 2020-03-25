package addApplicant;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.stage.FileChooser;
import org.w3c.dom.Text;


import java.net.URL;
import java.util.ResourceBundle;

public class AddNewApplicantController implements Initializable {

    @FXML
    TextField firstName;
    @FXML
    TextField lastName;
    @FXML
    TextField addressField;
    @FXML
    TextField emailField;
    @FXML
    TextField phonenumField;
    @FXML
    ComboBox degreeCbox;
    @FXML
    TextField majorField;
    @FXML
    TextField schoolField;
    @FXML
    TextField roleField;
    @FXML
    TextField organizationField;
    @FXML
    TextField yearsExpField;
    @FXML
    TextArea commentsField;
    @FXML
    Button addResumeButton;
    @FXML
    Button submitBtn;

    //create a go back to menu button


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        FileChooser fileChooser = new FileChooser();


        ObservableList<String> options =
                FXCollections.observableArrayList(
                        "Highschool",
                        "College Diploma",
                        "Bachelors",
                        "Graduate Studies",
                        "Masters",
                        "Phd"
                );

        degreeCbox.getItems().addAll(options);

        addResumeButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
               //figure out how to have a filechoser popup in teh current stage
            }
        });

        submitBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                //call all tests, if they pass then
                // call the createNewapplicant method ( the new applicant method will return an applicant)
                // have some sucess mesage if submitted.
            }
        });





    }

    // to check if name fields are only letters
    public boolean isString(TextField input){

        String s = input.getText();
        for(int i=0; i < s.length(); i++){
            if(!Character.isLetter(s.charAt(i)))
                return false;
        }

        return true;
    }

    public boolean isDigit(TextField input){

        String s = input.getText();
        for(int i=0; i < s.length(); i++){
            if(!Character.isDigit(s.charAt(i)))
                return false;
        }

        return true;
    }
    // validate email format
    public boolean isEmail(TextField input){
        String email = input.getText();
        final String EMAIL_PATTERN =
                "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

        if (!email.matches(EMAIL_PATTERN)) {
            return false;
        }

        return true;
    }

    public boolean validatePhoneNumber(TextField input) {
        String number = input.getText();
        //validate phone numbers of format "1234567890"
        if (number.matches("\\d{10}")) return true;
            //validating phone number with -, . or spaces
        else if(number.matches("\\d{3}[-\\.\\s]\\d{3}[-\\.\\s]\\d{4}")) return true;
            //validating phone number with extension length from 3 to 5
        else if(number.matches("\\d{3}-\\d{3}-\\d{4}\\s(x|(ext))\\d{3,5}")) return true;
            //validating phone number where area code is in braces ()
        else if(number.matches("\\(\\d{3}\\)-\\d{3}-\\d{4}")) return true;
            //return false if nothing matches the input
        else return false;

    }

    public Applicant createNewApplicant(){

        Applicant newApplicant = new  Applicant();
        newApplicant.setFirstName(firstName.getText());
        newApplicant.setLastName(lastName.getText());
        newApplicant.setAddress(addressField.getText());
        newApplicant.setEmail(emailField.getText());
        newApplicant.setPhoneNumber(phonenumField.getText());
        newApplicant.setMajor(majorField.getText());
        newApplicant.setSchool((schoolField.getText()));
        newApplicant.setLastRole(roleField.getText());
        newApplicant.setOrganzation(organizationField.getText());
        newApplicant.setYearsOfExp(Integer.parseInt(yearsExpField.getText()));
        newApplicant.setComments(commentsField.getText());

        return newApplicant;

    }




}
