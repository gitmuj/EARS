package login;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.*;


public class LoginDatabase<keyset> implements Initializable {

    int numberOfUsers=0;

    public class UserNode{
        String username;
        String password;
        String type;

        // an array list will store the user login credentials based on username, password, and type (admin, or faculty)

        UserNode(String username, String password, String type){
            username = username;
            password = password;
            type = type;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

    }

        //Blank workbook
        XSSFWorkbook workbook = new XSSFWorkbook();

        //Create a blank sheet
        XSSFSheet loginsSheet = workbook.createSheet("Logins");

        //This data needs to be written (Object[])
        Map<String, Object[]> logins = new HashMap<String, Object[]>();





   void addUser( String username, String password, String type ){


        logins.put(username, new Object[]{password, type});



    }

//    void initializeDatabase(){
//       addUser("admin", "password", "admin");
//
//    }



    // Iterate through the hashmap
    public void printMap(){

        //Iterate over data and write to sheet
        Set<String> keyset = logins.keySet();
        int rownum = 0;
        for (String key : keyset)
        {
            Row row = loginsSheet.createRow(rownum++);
            Object [] objArr = logins.get(key);
            Cell usernameCell = row.createCell(0);
            usernameCell.setCellValue(key);
            int cellnum = 1;
            for (Object obj : objArr)
            {
                Cell cell = row.createCell(cellnum++);
                if(obj instanceof String)
                    cell.setCellValue((String)obj);
                else if(obj instanceof Integer)
                    cell.setCellValue((Integer)obj);
            }
        }

        try
        {
            //Write the workbook in file system
            FileOutputStream out = new FileOutputStream(new File("database.xlsx"));
            workbook.write(out);
            out.close();
            System.out.println("Database written successfully on disk.");
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    } // end printMap



    //Add new user
        @FXML
        TextField usernameField, passwordField;

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

            submitbtn.setOnAction(e->{
                onSubmit();
            });

            clearbtn.setOnAction(e->{
                usernameField.setText("");
                passwordField.setText("");
            });


        }

    public void updateUserDatabase(String username, String password, String usertype) {
        String excelFilePath = "database.xlsx";

        try {
            FileInputStream inputStream = new FileInputStream(new File(excelFilePath));
            Workbook workbook = WorkbookFactory.create(inputStream);

            Sheet sheet = workbook.getSheetAt(0);

            Object[][] userData = {
                    {username, password, usertype},
            };

            int rowCount = sheet.getLastRowNum();

            for (Object[] aBook : userData) {
                Row row = sheet.createRow(++rowCount);

                int columnCount = 0;

                Cell cell = row.createCell(columnCount);
//                cell.setCellValue(rowCount);

                for (Object field : aBook) {
                    cell = row.createCell(columnCount++);
                        cell.setCellValue((String) field);
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
            updateUserDatabase(usernameField.getText(), passwordField.getText(), (String)usertypeField.getValue());

        }

}
