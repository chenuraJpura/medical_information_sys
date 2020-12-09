/*
Name       : medical information system (Team 09)
version    : 2.0
Title      : AddNewPatientModel.java
Description: Writting text files and streams for a new patient
*/
package model;//default package

//import the external pluggings
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class AddNewPatientModel {// start of the AddNewPatientModel
    public static void writingTXT(String patientString){//writing to objcet to file 
    BufferedWriter bw = null;
      try {//try catch start
                
                File file = new File("G:\\patientDetails.txt");//initialization file constructor
                
                if (!file.exists()) {//checking the is given file exists
                    file.createNewFile();//creating new file
                    Exception fileError =new IOException("File is not founded");
                    
                }
                
                FileWriter fw = new FileWriter(file,true);//open the file for writing
                
                bw = new BufferedWriter(fw);
                
                bw.write(patientString);//patientString writing to the line
                bw.newLine();//create new line
        

        // catch error of writting or closing the file            
      } catch (IOException ioe) {
          System.out.println(ioe);
          ioe.printStackTrace();
      }
	finally
    { 
        try{// start try catch
                if(bw!=null){
                        bw.close();// closing the buffer reader
                            }
                    }catch(Exception ex)//catch
                    
                    {
                            System.out.println("Error in closing the BufferedWriter"+ex);//display the error
           }
	}
    }//end of the function
    
}//end of the AddNewPatientModel
