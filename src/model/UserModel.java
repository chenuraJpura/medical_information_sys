package model;

import controllers.encryptionController;
import controllers.loginController;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import view.homeAdminGUI;

public class UserModel {
private static String filePath = "userData\\loginDetails.txt";

//insert function----------------------------------------------------------
public static void writingTXT(String AddNewUserDetail){//writing to objcet to file 
    BufferedWriter bw = null;
      try {//try catch start
                //file function
                File file = new File(filePath);
                
                if (!file.exists()) {//checking the is given file exists
                    file.createNewFile();//creating new file
                    Exception fileError =new IOException("File is not founded");
                    
                }
                
                FileWriter fw = new FileWriter(file,true);
                
                bw = new BufferedWriter(fw);
                
                bw.write(AddNewUserDetail);
                bw.newLine();
        
                
                
                
                    
      } catch (IOException ioe) {
          System.out.println(ioe);
          ioe.printStackTrace();
      }
	finally
    { 
        try{
                if(bw!=null){
                        bw.close();
                            }
                    }catch(Exception ex)
                    
                    {
                            System.out.println("Error in closing the BufferedWriter"+ex);
           }
	}
    }//end of the function
 
//view function------------------------------------------------------------
public static void viewLoginDetails(JTable loginViewTable){
            File file = new File(filePath);
        
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            
            DefaultTableModel model=(DefaultTableModel) loginViewTable.getModel();
            
            model.setRowCount(0);
        
            // get lines from txt file
            Object[] tableLines = br.lines().toArray();
            
            // extratct data from lines
            for(int i = 0; i < tableLines.length; i++){
                String line = tableLines[i].toString().trim();
                String[] dataRow = line.split(",");
                model.addRow(dataRow);
            }
            br.close();
                  
        }catch (Exception ex){
                    Logger.getLogger(homeAdminGUI.class.getName()).log(Level.SEVERE, null, ex);
        
        }
    
    }

//delete function----------------------------------------------------------
        
 public static void deleteUser(loginController deleteObj){
            File file = new File(filePath);
        
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            //all object are stor in temp in this array 
            ArrayList<loginController> loginObjList = new ArrayList<loginController>();
            //object for match the delete object
            loginController currAppObj;
            // get lines from txt file
            Object[] tableLines = br.lines().toArray();
            
            // extratct data from lines and add to the object array list
            for(int i = 0; i < tableLines.length; i++){
                String line = tableLines[i].toString().trim();
                String[] dataRow = line.split(",");
                currAppObj=new loginController(dataRow);
                loginObjList.add(currAppObj);
            }

            //deleting a all lines in the txt
            PrintWriter writer = new PrintWriter(file);
            writer.print("");
            writer.close();
            
            //removing the deleting object from the object array list
            int deleteIndexNo=0;  
            for(loginController loopObj: loginObjList){
                
                if(deleteObj.objectMathcer(loopObj)){
                   break;
                }
                deleteIndexNo+=1;
                
            }
            
          loginObjList.remove(deleteIndexNo);
          deleteIndexNo=0;
          //writing existing files to txt 
          for(loginController loopObj: loginObjList){
                
              writingTXT(loopObj.toString());
                
          }
          br.close();
                  
        }catch (Exception ex){
                    Logger.getLogger(homeAdminGUI.class.getName()).log(Level.SEVERE, null, ex);
        
        }
    
    }
        
//admin update function----------------------------------------------------------
          
 public static void updateUser(int deleteRowNumber,String updatedString){
              
              File file = new File(filePath);
            
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            //all object are stor in temp in this array 
            ArrayList<loginController> lineObjList = new ArrayList<loginController>();
            //object for match the delete object
            loginController currAppObj;
            loginController updatedObj=new loginController(updatedString);
            // get lines from txt file
            Object[] tableLines = br.lines().toArray();
            
            // extratct data from lines and add to the object array list
            for(int i = 0; i < tableLines.length; i++){
                String line = tableLines[i].toString().trim();
                
                currAppObj=new loginController(line);
                
                lineObjList.add(currAppObj);
                
            }
            
            lineObjList.set(deleteRowNumber,updatedObj);

            //deleting a all lines in the txt
            PrintWriter writer = new PrintWriter(file);
            writer.print("");
            writer.close();
            
            //writing existing files to txt 
            for(loginController loopObj: lineObjList){
                
              writingTXT(loopObj.toString());
                
            }
            br.close();      
        }catch (Exception ex){
                    Logger.getLogger(homeAdminGUI.class.getName()).log(Level.SEVERE, null, ex);
        
        }
    
    }

//update password function-------------------------------------------------------
 public static void updatePasswordByUser(String userName,String newPass){
     
     File file = new File(filePath);
            
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            //all object are stor in temp in this array 
            ArrayList<loginController> lineObjList = new ArrayList<loginController>();
            //object for match the delete object
            loginController currAppObj;
            // get lines from txt file
            Object[] tableLines = br.lines().toArray();
            
            // extratct data from lines and add to the object array list
            for(int i = 0; i < tableLines.length; i++){
                String line = tableLines[i].toString().trim();
                
                currAppObj=new loginController(line);
                if(currAppObj.getUserName().equals(userName)){
                    currAppObj.setUserPass(encryptionController.getEncryptedString(newPass));
                
                }
                lineObjList.add(currAppObj);
                
            }
            
            //deleting a all lines in the txt
            PrintWriter writer = new PrintWriter(file);
            writer.print("");
            writer.close();
            
            //writing existing files to txt 
            for(loginController loopObj: lineObjList){
                
              writingTXT(loopObj.toString());
                
            }
            br.close();      
        }catch (Exception ex){
                    Logger.getLogger(homeAdminGUI.class.getName()).log(Level.SEVERE, null, ex);
        
        }
    

 }

//user logger data enter function------------------------------------------------------------
//insert function----------------------------------------------------------
 public static void writeNewLog(String AddNewUserDetail){//writing to objcet to file 
     String filePath = "userData\\loginLog.txt";

     BufferedWriter bw = null;
      try {//try catch start
                //file function
                File file = new File(filePath);
                
                if (!file.exists()) {//checking the is given file exists
                    file.createNewFile();//creating new file
                    Exception fileError =new IOException("File is not founded");
                    
                }
                
                FileWriter fw = new FileWriter(file,true);
                
                bw = new BufferedWriter(fw);
                
                bw.write(AddNewUserDetail);
                bw.newLine();
        

                    
      } catch (IOException ioe) {
          System.out.println(ioe);
          ioe.printStackTrace();
      }
	finally
    { 
        try{
                if(bw!=null){
                        bw.close();
                            }
                    }catch(Exception ex)
                    
                    {
                            System.out.println("Error in closing the BufferedWriter"+ex);
           }
	}
    }//end of the function

//userName checker-------------------------------------------------------------------------
 public static boolean userNameChecker(String userName){
     boolean mathchState=false;
     File file = new File(filePath);
        
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            
            // get lines from txt file
            Object[] tableLines = br.lines().toArray();
            
            // extratct data from lines
            for(int i = 0; i < tableLines.length; i++){
                String line = tableLines[i].toString().trim();
                String[] dataRow = line.split(",");
                if(userName.equals(dataRow[0])){
                   mathchState=true;
                }
            }
        br.close();          
        }catch (Exception ex){
                    Logger.getLogger(homeAdminGUI.class.getName()).log(Level.SEVERE, null, ex);
        
        }
    return mathchState;
    
    }
//patient viewer for receptionist---------------------------------------------------------- 
 public static void patientView(JTable loginViewTable){
 
         File file = new File(filePath);
        
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            
            DefaultTableModel model=(DefaultTableModel) loginViewTable.getModel();
            
            model.setRowCount(0);
        
            // get lines from txt file
            Object[] tableLines = br.lines().toArray();
            
            // extratct data from lines
            for(int i = 0; i < tableLines.length; i++){
                String line = tableLines[i].toString().trim();
                String[] dataRow = line.split(",");
                if(dataRow[2].equals("PAT")){
                    model.addRow(dataRow);
                }
                
            }
            br.close();
                  
        }catch (Exception ex){
                    Logger.getLogger(homeAdminGUI.class.getName()).log(Level.SEVERE, null, ex);
        
        }
    
 
 }
 
 //patient password reset------------------------------------------------------------------
 public static void patientPassReset(String rowString){
 
                 String[] PatientUserName = rowString.split(",");
           
                 String patientNIC=encryptionController.getEncryptedString(PatientUserName[4]);
                 
                 File file = new File(filePath);
            
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            //all object are stor in temp in this array 
            ArrayList<loginController> lineObjList = new ArrayList<loginController>();
            //object for match the delete object
            loginController currAppObj;
            // get lines from txt file
            Object[] tableLines = br.lines().toArray();
            
            // extratct data from lines and add to the object array list-------------
            for(int i = 0; i < tableLines.length; i++){
                String line = tableLines[i].toString().trim();
                currAppObj=new loginController(line);
                lineObjList.add(currAppObj);
            }
            //resting the new password------------------------------------------------
            for(loginController loopObj:lineObjList){
                
                if(loopObj.getUserName().equals(PatientUserName[0])){
                    loopObj.setUserPass(patientNIC);
                }
            
            }
            
            //deleting a all lines in the txt
            PrintWriter writer = new PrintWriter(file);
            writer.print("");
            writer.close();
            
            //writing existing files to txt 
            for(loginController loopObj: lineObjList){
                
              writingTXT(loopObj.toString());
                
            }
            br.close();      
        }catch (Exception ex){
                    Logger.getLogger(homeAdminGUI.class.getName()).log(Level.SEVERE, null, ex);
        
        }
 
 }
 //medical officer password reset----------------------------------------------------------
 public static void medicalPassReset(String rowString){
 
                 String[] medicalUserDetail = rowString.split(",");
                 
                 updatePasswordByUser(medicalUserDetail[3],medicalUserDetail[7]);
//-----------------------------------------------------------------------------------------    
}
 //receptionist passs reset----------------------------------------------------------------
  public static void receptionistPassReset(String rowString){
 
                 String[] receptionistUserDetail = rowString.split(",");
                 
                updatePasswordByUser(receptionistUserDetail[2],receptionistUserDetail[6]);
//-----------------------------------------------------------------------------------------    
}
}