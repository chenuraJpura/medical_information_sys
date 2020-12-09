/*
Name       : medical information system (Team 09)
version    : 2.0
Title      : AddNewRecievedPostModel.java
Description: Writting AddNewRecievedPostModel exeption writing appointments record string to txt

*/
package model;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class AddNewRecievedPostModel {// start of the AddNewRecievedPostModel class
public static void writingTXT(String recievedPostString){//writing to objcet to file 
    BufferedWriter bw = null;
      try {//try catch start
                //file function
                File file = new File("G:\\addNewRecievedPostDetails.txt");
                
                if (!file.exists()) {//checking the is given file exists
                    file.createNewFile();//creating new file
                    Exception fileError =new IOException("File is not founded");
                    
                }
                
                FileWriter fw = new FileWriter(file,true);//open the file for writing
                
                bw = new BufferedWriter(fw);
                
                bw.write(recievedPostString);// new recived postal details wtiting to the line
                bw.newLine();//creat a new line
        

        // catch error of writting or closing the file                  
      } catch (IOException ioe) {
          System.out.println(ioe);
          ioe.printStackTrace();
      }
	finally
    { 
        try{//start try catch
                if(bw!=null){
                        bw.close();//closing the buffer writer
                            }
                    }catch(Exception ex)// catch
                    
                    {
                            System.out.println("Error in closing the BufferedWriter"+ex);// disply the error
           }
	}
    }//end of the function
}// end of the AddNewRecievedPostModel class
