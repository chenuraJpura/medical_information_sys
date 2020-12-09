/*
NAME-MedlifoSystem
VERSION-2.0
TITE-AddNewVisitorsModel Model
DESCRIPTION-convert the AddNewVisitorsModel swing to txt file
*/
package model;//default package

//importing the external plugging
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class AddNewVisitorsModel {//start the AddNewVisitorsModel class
    public static void writingTXT(String AddNewVisitorString){//writing to objcet to file 
    BufferedWriter bw = null;
      try {//try catch start
                //file function
                File file = new File("G:\\visitorsDetails.txt");
                
                if (!file.exists()) {//checking the is given file exists
                    file.createNewFile();//creating new file
                    Exception fileError =new IOException("File is not founded");
                    
                }
                
                FileWriter fw = new FileWriter(file,true);
                
                bw = new BufferedWriter(fw);
                
                bw.write(AddNewVisitorString);//write the VisitorsModel swing
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
//end of the class