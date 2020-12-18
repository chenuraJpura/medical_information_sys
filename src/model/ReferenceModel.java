package model;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ReferenceModel {
//add new department 
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
    
//add new specialized area
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
    
}
