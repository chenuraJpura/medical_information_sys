
package model;

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

public class ViewComplainModel {
    public static void viewComplain(JTable ComplainViewTable){
            String filePath = "G:\\complainDetails.txt";
            File file = new File(filePath);
        
        try {
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
        
        }
    
    }
    
}