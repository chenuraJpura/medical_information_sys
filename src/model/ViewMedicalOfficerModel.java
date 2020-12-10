/*
NAME-MedlifoSystem
VERSION-2.0
TITE-ViewMedicalOfficer Model
DESCRIPTION-convert the ViewMedicalOfficerModel swing to txt file
*/
package model;//default package

//importing the external plugging
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import view.homeAdminGUI;

public class ViewMedicalOfficerModel {//start the ViewMedicalOfficerModel class
            public static void viewPatientDetails(JTable appointmentViewTable){//writing to objcet to file
            String filePath = "G:\\patientDetails.txt";
            File file = new File(filePath);
        
        try {//try catch start
                //file function
            BufferedReader br = new BufferedReader(new FileReader(file));
            
            DefaultTableModel model=(DefaultTableModel) appointmentViewTable.getModel();
            
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
        
        }
      //end of the function
    }


   
}//end of the class
