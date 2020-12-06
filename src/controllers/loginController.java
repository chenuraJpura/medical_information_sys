
package controllers;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import model.AddNewUserModel;
import view.homeAdminGUI;

public class loginController {
    private String userName;
    private String userPass;
    private String userType;
    private String dbUserName;
    private String dbPass;
    private String dbUserType;
    private encryptionController encryptObj;
    
     public loginController(String userName,
            String userType) {
        this.userName = userName;
        this.userType = userType;

    }
    
    public loginController(String userName,
            String userPass,
            String dbUserName, 
            String dbPass) {
        this.userName = userName;
        this.userPass=userPass;
        this.dbUserName = dbUserName;
        this.dbPass = dbPass;

    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPass() {
        return userPass;
    }

    public void setUserPass(String userPass) {
        this.userPass = userPass;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getDbUserName() {
        return dbUserName;
    }

    public void setDbUserName(String dbUserName) {
        this.dbUserName = dbUserName;
    }

    public String getDbPass() {
        return dbPass;
    }

    public void setDbPass(String dbPass) {
        this.dbPass = dbPass;
    }

    public String getDbUserType() {
        return dbUserType;
    }

    public void setDbUserType(String dbUserType) {
        this.dbUserType = dbUserType;
    }

    public encryptionController getEncryptObj() {
        return encryptObj;
    }

    public void setEncryptObj(encryptionController encryptObj) {
        this.encryptObj = encryptObj;
    }
    
    public boolean loginChecker(){//checking the database details and user entered values
        boolean c1=this.userName.equals(this.dbUserName);
        boolean c2=this.userPass.equals(this.dbPass);
        if(c1 && c2){
            return true;
        }
        return false;
    
    }
    
    private int getPreIdNo(){
            int PreIdNo = 1001;
            BufferedReader br=null;
            try{
                    String sCurrentLine;

                    br = new BufferedReader(new FileReader("G:\\loginDetails.txt"));

                    String lastLine = "";

                            while ((sCurrentLine = br.readLine()) != null){
                                lastLine = sCurrentLine;
                            }
                            
                            String[] dataRow = lastLine.split(",");
                            
                            PreIdNo=Integer.parseInt(dataRow[1]);
                            
                }catch(IOException e){
                    
                    e.printStackTrace();
                
                }finally{
                            try{
                                
                                if (br!=null)
                                    br.close();
                                
                            }catch(IOException ex){
                                
                                 ex.printStackTrace();
                            
                            }
                }
            
            return PreIdNo;
        
    
    }
    
    public void storeNewUserData(String IdNo){
           String userData=getUserType()+","+getPreIdNo()+1+","+getUserName()+","+IdNo;
           AddNewUserModel.writingTXT(userData);
    
    }
    
    
    
}
