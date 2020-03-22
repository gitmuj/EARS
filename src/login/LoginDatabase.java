package login;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;


public class LoginDatabase<keyset> {

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

    void initializeDatabase(){
       addUser("admin", "password", "admin");

    }



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



}
