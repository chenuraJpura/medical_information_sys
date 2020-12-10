/*
NAME-MedlifoSystem
VERSION-2.0
TITE-ViewComplain Model
DESCRIPTION-convert the ViewComplainModel swing to txt file
*/
package model;//default package

//importing the external plugging
import controllers.complainsController;
import controllers.userController;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import view.homeAdminGUI;

public class ViewComplainModel {//start the ViewComplainModel class
    public static void viewComplain(JTable ComplainViewTable){//writing to objcet to file
            String filePath = "G:\\complainDetails.txt";
            File file = new File(filePath);
        
        try {//try catch start
                //file function
            BufferedReader br = new BufferedReader(new FileReader(file));
            
            DefaultTableModel model=(DefaultTableModel) ComplainViewTable.getModel();
            
            model.setRowCount(0);
        
            // get lines from txt file
            Object[] tableLines = br.lines().toArray();
            
            // extratct data from lines
            for(int i = 0; i < tableLines.length; i++){
                String line = tableLines[i].toString().trim();
                String[] dataRow = line.split(",");
                model.addRow(dataRow);
            }
                  
        }catch (Exception ex){
                    Logger.getLogger(homeAdminGUI.class.getName()).log(Level.SEVERE, null, ex);
        
        }//end of the function
    
    }
    
}
//end of the class