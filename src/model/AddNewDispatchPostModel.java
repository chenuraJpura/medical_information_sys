package model;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class AddNewDispatchPostModel {
    public static void writingTXT(String dispatchPostString){//writing to objcet to file 
    BufferedWriter bw = null;
      try {//try catch start
                //file function
                File file = new File("G:\\addNewDispatchPostDetails.txt");
                
                if (!file.exists()) {//checking the is given file exists
                    file.createNewFile();//creating new file
                    Exception fileError =new IOException("File is not founded");
                    
                }
                
                FileWriter fw = new FileWriter(file,true);
                
                bw = new BufferedWriter(fw);
                
                bw.write(dispatchPostString);
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
}
