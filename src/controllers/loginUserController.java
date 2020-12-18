package controllers;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import view.homeAdminGUI;

public class loginUserController {
    private String userName;
    private String userPass;
    private String userType;
    
    private boolean matchFoundState=false;
    
    public loginUserController(String userName, String userPass) {
        this.userName = userName;
        this.userPass = userPass;
    }

    public String getUserType() {
        return userType;
    }

    private void setUserType(String userType) {
        this.userType = userType;
    }

    private String getUserPass() {
        return userPass;
    }

    public String getUserName() {
        return userName;
    }
   
    public boolean loginChecker(){
        String filePath = "userData\\loginDetails.txt";
        File file = new File(filePath);
        
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            // get lines from txt file
            Object[] tableLines = br.lines().toArray();
            
            // extratct data from lines and add to the object array list
            for(int i = 0; i < tableLines.length; i++){
                String line = tableLines[i].toString().trim();
                String[] dataRow = line.split(",");
                
                if(dataRow[0].equals(getUserName())){//checking avlaible userName
                    if(dataRow[3].equals(userPass)){//checking the password
                        
                        setUserType(dataRow[2]);
                        matchFoundState=true;
                        break;
                    }
                }
            
            }
                  
        }catch (Exception ex){
                    Logger.getLogger(homeAdminGUI.class.getName()).log(Level.SEVERE, null, ex);
        
        }
        return matchFoundState;
        
    }
    
    public String loginLogNewRecord(){
        date loggedDate=new date();
        time loggedTime=new time();
        return getUserName()+"|"+
               getUserType()+"|"+
               loggedDate.toString()+"|"+
               loggedTime.toString();
    
    }
    
    }
    








    

