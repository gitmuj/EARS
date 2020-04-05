package addApplicant;


import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.stage.FileChooser;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.w3c.dom.Text;


import javax.swing.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class AddNewApplicantController implements Initializable {

    public int numberOfApplicants=0;
    public ArrayList<Applicant> applicantList = new ArrayList<Applicant>();

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
    @FXML
    TextField listview;
    @FXML
    ComboBox educationCb;
    @FXML
    ComboBox skillsCb;
    @FXML
    ComboBox communicationCb;
    @FXML
    ComboBox experienceCb;
    @FXML
    TextField jobID;


    //create a go back to menu button


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        ObservableList<String> options =
                FXCollections.observableArrayList(
                        "Highschool",
                        "College Diploma",
                        "Bachelors",
                        "Graduate Studies",
                        "Masters",
                        "Phd"
                );
        ObservableList<String> scoreOptions =
                FXCollections.observableArrayList("1","2","3","4","5"
                );

        educationCb.getItems().addAll(scoreOptions);
        experienceCb.getItems().addAll(scoreOptions);
        communicationCb.getItems().addAll(scoreOptions);
        skillsCb.getItems().addAll(scoreOptions);

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
                onSubmit();

            }
        });

        addResumeButton.setOnAction(e->{

                FileChooser fc = new FileChooser();
                //fc.setInitialDirectory();
                fc.getExtensionFilters().addAll(
                        new FileChooser.ExtensionFilter("PDF Files", "*.pdf"),
                        new FileChooser.ExtensionFilter("Word doc", "*.doc", "*.docx"));
                File selectedFile = fc.showOpenDialog(null);

                if(selectedFile != null){
                    listview.setText(selectedFile.getAbsolutePath());
                } else{
                    listview.setText("file is not valid");
                }
                // end addAttachmentACtion

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
        newApplicant.setId(++numberOfApplicants);
        newApplicant.setJobId(Integer.parseInt(jobID.getText()));
        newApplicant.setFirstName(firstName.getText());
        newApplicant.setLastName(lastName.getText());
        newApplicant.setAddress(addressField.getText());
        newApplicant.setEmail(emailField.getText());
        newApplicant.setPhoneNumber(phonenumField.getText());
        newApplicant.setMajor(majorField.getText());
        newApplicant.setSchool((schoolField.getText()));
        newApplicant.setLastRole(roleField.getText());
        newApplicant.setOrganization(organizationField.getText());
        newApplicant.setYearsOfExp(Integer.parseInt(yearsExpField.getText()));
        newApplicant.setEducationScore(Integer.parseInt((String)educationCb.getValue()));
        newApplicant.setExperienceScore(Integer.parseInt((String)experienceCb.getValue()));
        newApplicant.setSkillScore(Integer.parseInt((String)skillsCb.getValue()));
        newApplicant.setCommunicationScore(Integer.parseInt((String)communicationCb.getValue()));
        newApplicant.setComments(commentsField.getText());
        newApplicant.setAttachmentPath(listview.getText());

        applicantList.add(newApplicant);

        return newApplicant;

    }

    public void updateApplicantDatabase(Applicant applicant) {
        String excelFilePath = "database.xlsx";

        try {
            FileInputStream inputStream = new FileInputStream(new File(excelFilePath));
            Workbook workbook = WorkbookFactory.create(inputStream);

            Sheet sheet = workbook.getSheet("Applicants");

            Object[][] applicantData = {
                    {
            applicant.getId(),
            applicant.getJobId(),
            applicant.getFirstName(),
            applicant.getLastName(),
            applicant.getAddress(),
            applicant.getEmail(),
            applicant.getPhoneNumber(),
            applicant.getMajor(),
            applicant.getSchool(),
            applicant.getLastRole(),
            applicant.getOrganization(),
            applicant.getYearsOfExp(),
            applicant.getEducationScore(),
            applicant.getExperienceScore(),
            applicant.getSkillScore(),
            applicant.getCommunicationScore(),
            applicant.getComments(),
            applicant.getAttachmentPath(),
                    }
            };

            int rowCount = sheet.getLastRowNum();

            for (Object[] aBook : applicantData) {
                Row row = sheet.createRow(++rowCount);

                int columnCount = 0;

                Cell cell = row.createCell(columnCount);
//                cell.setCellValue(rowCount);

                for (Object field : aBook) {

                    if (field instanceof String) {
                        cell = row.createCell(columnCount++);
                        cell.setCellValue((String)field);
                    } else if (field instanceof Integer) {
                        cell = row.createCell(columnCount++);
                        cell.setCellValue((Integer) field);
                    }

                }

            }

            inputStream.close();

            FileOutputStream outputStream = new FileOutputStream("database.xlsx");
            workbook.write(outputStream);
            workbook.close();
            outputStream.close();

        } catch (EncryptedDocumentException | IOException ex) {
            ex.printStackTrace();
        }
    } // end update user database

    public void onSubmit(){

        updateApplicantDatabase(createNewApplicant());

    }





}
