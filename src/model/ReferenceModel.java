package model;

import controllers.loginController;
import java.awt.List;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import static model.UserModel.writingTXT;
import view.homeAdminGUI;

public class ReferenceModel {
//add new department----------------------------------------------------------------------------------- 
     public static void writingDepartment(String newDepartment){//writing to objcet to file 
         String filePath = "userData\\departments.txt";
         BufferedWriter bw = null;
      try {//try catch start
                //file function
                File file = new File(filePath);
                
                if (!file.exists()) {//checking the is given file exists
                    file.createNewFile();//creating new file
                    Exception fileError=new IOException("File is not founded");
                }
                
                FileWriter fw = new FileWriter(file,true);
                
                bw = new BufferedWriter(fw);
                
                bw.write(newDepartment);
                bw.newLine();
        
                } catch (IOException ioe) {
                        System.out.println(ioe);
                        ioe.printStackTrace();
                }
                finally{ 
                            try{
                                    if(bw!=null){
                                    bw.close();
                            }
                        }catch(Exception ex){
                            System.out.println("Error in closing the BufferedWriter"+ex);
                        }
                }
    }//end of the function
//add new specialized area----------------------------------------------------------------------------
     public static void writingSpecializedArea(String newArea){//writing to objcet to file 
         String filePath = "userData\\specializedArea.txt";
         BufferedWriter bw = null;
      try {//try catch start
                //file function
                File file = new File(filePath);
                
                if (!file.exists()) {//checking the is given file exists
                    file.createNewFile();//creating new file
                    Exception fileError=new IOException("File is not founded");
                }
                
                FileWriter fw = new FileWriter(file,true);
                
                bw = new BufferedWriter(fw);
                
                bw.write(newArea);
                bw.newLine();
        
                } catch (IOException ioe) {
                        System.out.println(ioe);
                        ioe.printStackTrace();
                }
                finally{ 
                            try{
                                    if(bw!=null){
                                    bw.close();
                            }
                        }catch(Exception ex){
                            System.out.println("Error in closing the BufferedWriter"+ex);
                        }
                }
    }//end of the function
//delete new reference record-------------------------------------------------------------------------     
    public static void deleteRefRecord(int referenceeState,String selectedItem) throws FileNotFoundException{
        String filePath="userData\\";
        if(referenceeState==1){
            filePath = "userData\\departments.txt";
        }else if(referenceeState==2){
            filePath = "userData\\specializedArea.txt";
        
        }
       File file = new File(filePath);
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            // get lines from txt file
            Object[] tableLines = br.lines().toArray();
            String[] stringArray = Arrays.copyOf(tableLines,tableLines.length, String[].class);
            ArrayList<String> list = new ArrayList<String>(Arrays.asList(stringArray));
            // extratct data from lines and add to the object array list
            for(int i = 0; i < stringArray.length; i++){
                String line = stringArray[i].toString().trim();
                if(line.equals(selectedItem)){
                    list.remove(selectedItem);
                }
            }
             //deleting a all lines in the txt
            PrintWriter writer = new PrintWriter(file);
            writer.print("");
            writer.close();
          //writing existing files to txt 
          for(String loopObj: list){
              if(referenceeState==1){
                  writingDepartment(loopObj);
              }else if(referenceeState==2){
                  writingSpecializedArea(loopObj);
              }  
              br.close();
                
          }
            
            }catch (Exception ex){
                    Logger.getLogger(homeAdminGUI.class.getName()).log(Level.SEVERE, null, ex);
        
            }
}//end of the 
    
        
        
        
        
        
}//end of the class
     
    

