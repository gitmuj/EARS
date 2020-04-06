package database;

import addApplicant.Applicant;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.usermodel.Cell;

import javax.imageio.IIOParam;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Iterator;
import java.util.ResourceBundle;

public class ViewDatabaseController implements Initializable {

    public ObservableList<Applicant> applicantList = FXCollections.observableArrayList();

    @FXML
    TableView tableView;
    @FXML
    TableColumn<String,Applicant> applicantIdCol, jobIdCol, firstNameCol, lastNameCol, majorCol, scoreCol;
    @FXML
    TextField applicantIdInput, nameInput;



    

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        tableView.setPlaceholder(new Label("No applicants to display"));

        applicantIdCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        jobIdCol.setCellValueFactory((new PropertyValueFactory<>("jobId")));
        firstNameCol.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        lastNameCol.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        majorCol.setCellValueFactory(new PropertyValueFactory<>("major"));
        scoreCol.setCellValueFactory(new PropertyValueFactory<>("overallScore"));

        TableView.TableViewSelectionModel<Applicant> selectionModel = tableView.getSelectionModel();
        selectionModel.setSelectionMode(SelectionMode.SINGLE);
        ObservableList<Applicant> selectedItems = selectionModel.getSelectedItems();


        intializeDatabase();
        onSearch();
        selectApplicant();


    }


    public void intializeDatabase() {
        String excelFilePath = "database.xlsx";

        try {
            FileInputStream inputStream = new FileInputStream(new File(excelFilePath));
            Workbook workbook = WorkbookFactory.create(inputStream);

            Sheet sheet = workbook.getSheet("Applicants");

            Iterator<Row> rows     = sheet.rowIterator ();

            while (rows.hasNext ())
            {
                Row row = rows.next ();
                if(row.getRowNum()==0){
                    continue; //just skip the rows if row number is 0 or 1
                }

                Applicant applicant = new Applicant();
                for(Cell cell : row){
                    switch(cell.getColumnIndex()){
                        case 0:
                            applicant.setId((int)cell.getNumericCellValue());
                            break;
                        case 1:
                            applicant.setJobId((int)cell.getNumericCellValue());
                            break;
                        case 2:
                            applicant.setFirstName((cell.getStringCellValue()));
                            break;
                        case 3:
                            applicant.setLastName(cell.getStringCellValue());
                            break;
                        case 4:
                            applicant.setAddress(cell.getStringCellValue());
                            break;
                        case 5:
                            applicant.setEmail(cell.getStringCellValue());
                            break;
                        case 6:
                            applicant.setPhoneNumber(cell.getStringCellValue());
                            break;
                        case 7:
                            applicant.setMajor(cell.getStringCellValue());
                            break;
                        case 8:
                            applicant.setSchool(cell.getStringCellValue());
                            break;
                        case 9:
                            applicant.setLastRole(cell.getStringCellValue());
                            break;
                        case 10:
                            applicant.setOrganization(cell.getStringCellValue());
                            break;
                        case 11:
                            applicant.setYearsOfExp((int)cell.getNumericCellValue());
                            break;
                        case 12:
                            applicant.setEducationScore((int)cell.getNumericCellValue());
                            break;
                        case 13:
                            applicant.setExperienceScore((int)cell.getNumericCellValue());
                            break;
                        case 14:
                            applicant.setSkillScore((int)cell.getNumericCellValue());
                            break;
                        case 15:
                            applicant.setCommunicationScore((int)cell.getNumericCellValue());
                            break;
                        case 16:
                            applicant.setComments((cell.getStringCellValue()));
                            break;
                        case 17:
                            applicant.setAttachmentPath(cell.getStringCellValue());
                            break;
                    } // end switch


                } // end for

                applicant.setOverallScore();
                applicantList.add(applicant);


            } // end while loop


            inputStream.close();

            FileOutputStream outputStream = new FileOutputStream("database.xlsx");
            workbook.write(outputStream);
            workbook.close();
            outputStream.close();

        } catch (EncryptedDocumentException | IOException ex) {
            ex.printStackTrace();
        }

        tableView.setItems(applicantList);
    } // end function


    public void selectApplicant(){
        tableView.setRowFactory(tv -> {
            TableRow<Applicant> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if (event.getClickCount() == 2 && (! row.isEmpty()) ) {

                    Applicant applicant = row.getItem();

                    try {
                        //Load second scene
                        FXMLLoader loader = new FXMLLoader(getClass().getResource("/database/view_applicant.fxml"));
                        Parent root = loader.load();

                        //Get controller of scene2
                        ViewApplicantController scene2Controller = loader.getController();

                        scene2Controller.firstName.setText(applicant.getFirstName());
                        scene2Controller.lastName.setText(applicant.getLastName());
                        scene2Controller.addressField.setText(applicant.getAddress());
                        scene2Controller.phonenumField.setText(applicant.getPhoneNumber());
                        scene2Controller.emailField.setText(applicant.getEmail());
                        scene2Controller.majorField.setText(applicant.getMajor());
                        scene2Controller.schoolField.setText(applicant.getSchool());
                        scene2Controller.roleField.setText(applicant.getLastRole());
                        scene2Controller.organizationField.setText(applicant.getOrganization());
                        scene2Controller.yearsExpField.setText(""+applicant.getYearsOfExp());
                        scene2Controller.educationScore.setText(""+applicant.getEducationScore());
                        scene2Controller.skillScore.setText(""+applicant.getSkillScore());
                        scene2Controller.communicationScore.setText(""+applicant.getCommunicationScore());
                        scene2Controller.expScore.setText(""+applicant.getExperienceScore());
                        scene2Controller.commentsField.setText(applicant.getComments());
                        scene2Controller.jobId.setText(""+applicant.getJobId());



                        //Show scene 2 in new window
                        Stage stage = new Stage();
                        stage.setScene(new Scene(root));
                        stage.setTitle("View Applicant " +applicant.getFirstName() +" " + applicant.getLastName());
                        stage.show();
                    } catch (IOException ex) {
                        System.err.println(ex);
                    }
                }


            });
            return row;
        });
    } // end select applicant

    public void onSearch(){

        // 1. Wrap the ObservableList in a FilteredList (initially display all data).
        FilteredList<Applicant> filteredData = new FilteredList<>(applicantList, p -> true);

      //  2. Set the filter Predicate whenever the filter changes.

        nameInput.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(applicant -> {
                // If filter text is empty, display all applicants.
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }

                // Compare first name and last name of every person with filter text.
                String lowerCaseFilter = newValue.toLowerCase();

                if (applicant.getFirstName().toLowerCase().contains(lowerCaseFilter)) {
                    return true; // Filter matches first name.
                } else if (applicant.getLastName().toLowerCase().contains(lowerCaseFilter)) {
                    return true; // Filter matches last name.
                }
                return false; // Does not match.
            });
        });

        applicantIdInput.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(applicant -> {
                // If filter text is empty, display all applicants.
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }

                // Compare first name and last name of every person with filter text.


                if ((applicant.getId() == Integer.parseInt(newValue)))
                    return true; // Filter matches id

                return false; // Does not match.
            });
        });


        SortedList<Applicant> sortedData = new SortedList<>(filteredData);
        sortedData.comparatorProperty().bind(tableView.comparatorProperty());
        tableView.setItems(sortedData);




    } // end function

    public void runViewApplication() throws IOException {
        Stage applicantStage = new Stage();
        FXMLLoader loader = new FXMLLoader();
        try {
            Pane applicantRoot = (Pane) loader.load(getClass().getResource("/database/view_applicant.fxml").openStream());
            Scene scene = new Scene(applicantRoot);
            applicantStage.setScene(scene);
            applicantStage.setTitle("EARS - Applicant");

            applicantStage.show();


        } catch (IOException e) {
            e.printStackTrace();
        }


    } // end func




}
