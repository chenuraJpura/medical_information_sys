package model;

import controllers.medicalOfficers;
import controllers.patient;
import controllers.receptionist;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import view.homeAdminGUI;

public class loginFeederModel {
    private String userName;
    private String userType;
    private patient matchedPatientObj;
    private medicalOfficers matchedMedicalOfficerObj;
    private receptionist matchedReceptionist;

    public loginFeederModel(String userName,String userType) {
        setUserName(userName);
        setUserType(userType);
        switch(getUserType()){
            case "ADMIN":break;
            case "PAT":matchedPatient(); break;
            case "MED":matchedMedicalOfficer();break;
            case "REC":matchedReceptionist();break;
        }
    }

    public medicalOfficers getMatchedMedicalOfficerObj() {
        return matchedMedicalOfficerObj;
    }

    private void setMatchedMedicalOfficerObj(medicalOfficers matchedMedicalOfficerObj) {
        this.matchedMedicalOfficerObj = matchedMedicalOfficerObj;
    }

    public receptionist getMatchedReceptionist() {
        return matchedReceptionist;
    }

    private void setMatchedReceptionist(receptionist matchedReceptionist) {
        this.matchedReceptionist = matchedReceptionist;
    }
   
    public patient getMatchedPatientObj() {
        return matchedPatientObj;
    }

    private void setMatchedPatientObj(patient matchedPatientObj) {
        this.matchedPatientObj = matchedPatientObj;
    }
     
    private void setUserName(String userName) {
        this.userName = userName;
    }

    private void setUserType(String userType) {
        this.userType = userType;
    }

    private String getUserName() {
        return userName;
    }

    private String getUserType() {
        return userType;
    }
    
    private void matchedPatient(){
         String filePath = "userData\\patientDetails.txt";
         File file = new File(filePath);
        
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            //object for match the delete object
            patient currAppObj;
            // get lines from txt file
            Object[] tableLines = br.lines().toArray();
            
            // extratct data from lines and add to the object array list
            for(int i = 0; i < tableLines.length; i++){
                String line = tableLines[i].toString().trim();
                String[] dataRow = line.split(",");
                currAppObj=new patient(dataRow);
                if(currAppObj.getUserName().equals(getUserName())){
                    setMatchedPatientObj(currAppObj);
                    break;
                }
               
            }
            br.close();
         
                  
        }catch (Exception ex){
                    Logger.getLogger(homeAdminGUI.class.getName()).log(Level.SEVERE, null, ex);
        
        }
        
        
    }
    
    private void matchedMedicalOfficer(){
         String filePath = "userData\\medicalOfficerDetails.txt";
         File file = new File(filePath);
        
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            //object for match the delete object
            medicalOfficers currAppObj;
            // get lines from txt file
            Object[] tableLines = br.lines().toArray();
            
            // extratct data from lines and add to the object array list
            for(int i = 0; i < tableLines.length; i++){
                String line = tableLines[i].toString().trim();
                String[] dataRow = line.split(",");
                currAppObj=new medicalOfficers(dataRow);

                if(currAppObj.getUserName().equals(getUserName())){
                    setMatchedMedicalOfficerObj(currAppObj);
                    break;
                }
               
            }
            br.close();
            
                  
        }catch (Exception ex){
                    Logger.getLogger(homeAdminGUI.class.getName()).log(Level.SEVERE, null, ex);
        
        }
        
        
    }
    
    private void matchedReceptionist(){
        String filePath = "userData\\receptionistDetails.txt";
         File file = new File(filePath);
        
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            //object for match the delete object
            receptionist currAppObj;
            // get lines from txt file
            Object[] tableLines = br.lines().toArray();
            
            // extratct data from lines and add to the object array list
            for(int i = 0; i < tableLines.length; i++){
                String line = tableLines[i].toString().trim();
                String[] dataRow = line.split(",");
                currAppObj=new receptionist(dataRow);
                if(currAppObj.getUserName().equals(getUserName())){
                    setMatchedReceptionist(currAppObj);
                    break;
                }
               
            }

         br.close();
                  
        }catch (Exception ex){
                    Logger.getLogger(homeAdminGUI.class.getName()).log(Level.SEVERE, null, ex);
        
        }
        
        
    }


    
}
