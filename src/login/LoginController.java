package login;

import admin.Admin;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.net.URL;
import java.util.Iterator;
import java.util.ResourceBundle;

public class LoginController implements Initializable {
    @FXML Button loginButton;
    @FXML TextField usernameField;
    @FXML PasswordField passwordField;
    @FXML ComboBox typeField;
    @FXML
    Label messageLabel;

    ObservableList<String> options =
            FXCollections.observableArrayList(
                    "admin",
                    "faculty",
                    "HR"
            );



    @Override
    public void initialize(URL location, ResourceBundle resources) {
        typeField.getItems().addAll(options);

        loginButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
               loginCheck();
            }
        });

    }

    void error(){
        messageLabel.setText("Username, password or usertype is incorrect.");
    }

    void adminLogin(){
        //System.out.println("Admin Login ");

        Admin adminLogged = new Admin();

    }

    void facultyLogin(){
        System.out.println("Faculty Login ");
    }
    void hrLogin(){
        System.out.println("HR Login ");
    }
    void loginCheck(){

        String username = usernameField.getText();
        String password = passwordField.getText();
        String type = (String) typeField.getValue();


        try
        {
            FileInputStream file = new FileInputStream(new File("database.xlsx"));

            //Create Workbook instance holding reference to .xlsx file
            XSSFWorkbook users = new XSSFWorkbook(file);

            //Get first/desired sheet from the users
            XSSFSheet sheet = users.getSheetAt(0);

            //Iterate through each rows one by one
            Iterator<Row> rowIterator = sheet.iterator();
            while (rowIterator.hasNext())
            {
                Row row = rowIterator.next();
                //For each row, iterate through all the columns
                Iterator<Cell> cellIterator = row.cellIterator();
                System.out.println(row.getCell(0).getStringCellValue());
                System.out.println(row.getCell(1).getStringCellValue());
                System.out.println(row.getCell(2).getStringCellValue());

                if(!username.equals(row.getCell(0).getStringCellValue())){
                   // error();
                    System.out.println("username incorrect");
                    return;
                }
                if(!password.equals(row.getCell(1).getStringCellValue())){
                    //error();
                    System.out.println("passwrod incorrect");
                    return;
                }
                if(!type.equals((row.getCell(2).getStringCellValue()))){
                    //error();
                    System.out.println("type incorrect");
                    return;
                } else{
                    switch(typeField.toString()){
                        case "admin":
                            adminLogin();
                            break;
                        case "faculty":
                            facultyLogin();
                            break;
                        case "Human Resources":
                            hrLogin();
                            break;
                    }
                }


//                while (cellIterator.hasNext())
//                {
//                    Cell cell = cellIterator.next();
//                    //Check the cell type and format accordingly
//                    switch (cell.getCellType())
//
//                    {
//                        case NUMERIC :
//                            System.out.print(cell.getNumericCellValue() + "t");
//                            break;
//                        case STRING :
//                            System.out.print(cell.getStringCellValue() + "t");
//                            break;
//                    }
//                }
//                System.out.println("");
            }
            file.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }


    void loginDriver(){
        /*intialize database to create admin user */

        LoginDatabase database = new LoginDatabase();
        database.initializeDatabase();
        database.printMap();

    }

//    public void initialize() {}



}