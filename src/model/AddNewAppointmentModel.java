/*
NAME-MedlifoSystem
VERSION-2.0
TITE-addNewAppointment Model
DESCRIPTION-convert the appoinment swing to txt file
*/
package model;//default package

//importing the external pluggings
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

//start the appoinment model class
public class AddNewAppointmentModel {
            public static void writingTXT(String appointmentString){//writing to objcet to file 
    BufferedWriter bw = null;
      try {//try catch start
                //file function
                File file = new File("G:\\appointmentDetails.txt");
                
                if (!file.exists()) {//checking the is given file exists
                    file.createNewFile();//creating new file
                    Exception fileError =new IOException("File is not founded");
                    
                }
                
                FileWriter fw = new FileWriter(file,true);
                
                bw = new BufferedWriter(fw);
                
                bw.write(appointmentString);//write the appoinment swing
                bw.newLine();
        

                    
      } catch (IOException ioe) {
          System.out.println(ioe);
          ioe.printStackTrace();
      }
	finally
    { 
        try{
                if(bw!=null){
                        bw.close(); //close the file
                            }
                    }catch(Exception ex)
                    
                    {
                            System.out.println("Error in closing the BufferedWriter"+ex);
           }
	}
    }//end of the function

}
//end of the class