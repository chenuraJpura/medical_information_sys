
package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import view.homeAdminGUI;


public class ReportModel {

    public void patientToJson(){

        
        try {
            
            File file = new File("userData\\patientDetails.txt");
            BufferedReader br = new BufferedReader(new FileReader(file));
                         
            // get lines from txt file
            Object[] tableLines = br.lines().toArray();
            //Add employees to list
            JSONArray patientList = new JSONArray();
        
        
            // extratct data from lines
            for(int i = 0; i < tableLines.length; i++){
                String line = tableLines[i].toString().trim();
                String[] dataRow = line.split(",");
                JSONObject patientDetails = new JSONObject();
                patientDetails.put("userName",dataRow[0]);
                patientDetails.put("firstName",dataRow[1]);
                patientDetails.put("lastName",dataRow[2]);
                patientDetails.put("phoneNo",Integer.parseInt(dataRow[3]));
                patientDetails.put("NIC",dataRow[4]);
                patientDetails.put("DOB",dataRow[5]);
                patientDetails.put("Address",dataRow[6]);
                patientDetails.put("BloodG",dataRow[7]);
                patientDetails.put("Gen",dataRow[8]);
                patientDetails.put("Marital",dataRow[9]);
                patientDetails.put("Allergies",dataRow[10]);
                
                JSONObject patientObject = new JSONObject(); 
                patientObject.put("patient",patientDetails);
                
                patientList.add(patientObject);
                
            }
            
            //Write JSON file
        try (FileWriter jsonFile = new FileWriter("userData\\patientDetails.json")) {
 
            jsonFile.write(patientList.toJSONString());
            jsonFile.flush();
 
        } catch (IOException e) {
            e.printStackTrace();
        }
                  
        }catch (Exception ex){
                    Logger.getLogger(homeAdminGUI.class.getName()).log(Level.SEVERE, null, ex);
        
        }
        
        
        
        
    
    }
}
