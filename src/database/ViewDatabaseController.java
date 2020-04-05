package database;

import addApplicant.Applicant;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.ss.usermodel.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ResourceBundle;

public class ViewDatabaseController implements Initializable {

    public ObservableList<Applicant> applicantList = FXCollections.observableArrayList();

    @FXML
    TableView tableView;
    @FXML
    TableColumn<String,Applicant> applicantIdCol, jobIdCol, firstNameCol, lastNameCol, majorCol, scoreCol;


    

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        applicantIdCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        jobIdCol.setCellValueFactory((new PropertyValueFactory<>("jobId")));
        firstNameCol.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        lastNameCol.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        majorCol.setCellValueFactory(new PropertyValueFactory<>("major"));
        scoreCol.setCellValueFactory(new PropertyValueFactory<>("overallScore"));

        intializeDatabase();


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


}
