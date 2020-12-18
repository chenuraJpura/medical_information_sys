package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import view.homeAdminGUI;

public class dropDownFeederModel {
    private String fileName;
    private int columnsNo;
    private JComboBox comboBoxForFeed;
    private String doctorType;

    public dropDownFeederModel(String fileName,
            JComboBox comboBoxForFeed,
            String doctorType) {
        this.fileName = fileName;
        this.comboBoxForFeed=comboBoxForFeed;
        this.doctorType=doctorType;
    }
    
    public dropDownFeederModel(
            String fileName,
            JComboBox comboBoxForFeed
            ){
        this.fileName=fileName;
        this.comboBoxForFeed=comboBoxForFeed;
    
    }
    
    public void dropFeeder(){
        String filePath = "userData\\"+this.fileName;
            File file = new File(filePath);
        
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            
            // get lines from txt file
            Object[] tableLines = br.lines().toArray();
            
            // extratct data from lines
            // set data to jtable model
            for(int i = 0; i < tableLines.length; i++)
            {
                String line = tableLines[i].toString().trim();
                String[] dataRow = line.split(",");
                if(dataRow[2].equals(doctorType)){
                    String fullName=dataRow[4]+" "+dataRow[5];
                    
                    this.comboBoxForFeed.addItem(fullName);
                    
                }
            }
            
            
        } catch (Exception ex) {
            Logger.getLogger(homeAdminGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    
    }
    
    public void dropFeeder(boolean Department){
        String filePath = "userData\\"+this.fileName;
            File file = new File(filePath);
        
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            
            // get lines from txt file
            Object[] tableLines = br.lines().toArray();
            
            // extratct data from lines
            // set data to jtable model
            this.comboBoxForFeed.removeAllItems();
            for(int i = 0; i < tableLines.length; i++)
            {
                String line = tableLines[i].toString().trim();

                this.comboBoxForFeed.addItem(line);
                
                 
            }
            
            
        } catch (Exception ex) {
            Logger.getLogger(homeAdminGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    
    }

    public void setComboBoxForFeed(JComboBox comboBoxForFeed) {
        this.comboBoxForFeed = comboBoxForFeed;
    }

    

    
}
