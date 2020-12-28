package model;

import controllers.appointmentController;
import controllers.date;
import controllers.time;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
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

public class AppointmentModel {

    private static String filePath = "userData\\appointmentDetails.txt";

//writing area-------------------------------------------------------------------------    

    public static void writingTXT(String appointmentString){//writing to objcet to file 
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
                
                bw.write(appointmentString);
                bw.newLine();
        
                } catch (IOException ioe) {
                        System.out.println(ioe);
                }
	finally
    { 
        try{
                if(bw!=null){
                        bw.close();
                            }
                    }catch(IOException ex)
                    
                    {
                            System.out.println("Error in closing the BufferedWriter"+ex);
           }
	}
    }//end of the function

//delete area----------------------------------------------------------------------------------------

    public static void deleteAppointment(appointmentController deleteObj){
            
            File file = new File(filePath);
        
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            //all object are stor in temp in this array 
            ArrayList<appointmentController> appObjList = new ArrayList<appointmentController>();
            //object for match the delete object
            appointmentController currAppObj;
            // get lines from txt file
            Object[] tableLines = br.lines().toArray();
            
            // extratct data from lines and add to the object array list
            for(int i = 0; i < tableLines.length; i++){
                String line = tableLines[i].toString().trim();
                String[] dataRow = line.split(",");
                currAppObj=new appointmentController(
                dataRow[0],
                dataRow[1],
                new date(dataRow[2]),
                new time(dataRow[3]),
                dataRow[4],
                dataRow[5],
                Integer.parseInt(dataRow[6]));
                appObjList.add(currAppObj);
            }

            //deleting a all lines in the txt
            PrintWriter writer = new PrintWriter(file);
            writer.print("");
            writer.close();
            
            //removing the deleting object from the object array list
            int deleteIndexNo=0;  
            for(appointmentController loopObj: appObjList){
                
                if(deleteObj.objectMathcer(loopObj)){
                   break;
                }
                deleteIndexNo+=1;
                
            }
          appObjList.remove(deleteIndexNo);
          deleteIndexNo=0;
          //writing existing files to txt 
          for(appointmentController loopObj: appObjList){
                
              writingTXT(loopObj.toString());
                
          }
            br.close();
         
        }catch (IOException | NumberFormatException ex){
                    Logger.getLogger(homeAdminGUI.class.getName()).log(Level.SEVERE, null, ex);
        
        }
    
    }

//view area-------------------------------------------------------------------------------------    
    
    public static void viewAppointment(JTable appointmentViewTable){
            
            File file = new File(filePath);
        
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            
            DefaultTableModel model=(DefaultTableModel) appointmentViewTable.getModel();
            
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
                  
        }catch (IOException ex){
                    Logger.getLogger(homeAdminGUI.class.getName()).log(Level.SEVERE, null, ex);
        
        }
    
    }

//update area-------------------------------------------------------------------------------------

    public static void updateAppointment(int deleteRowNumber,String updatedString){
            
            File file = new File(filePath);
                  try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            //all object are stor in temp in this array 
            ArrayList<appointmentController> appObjList = new ArrayList<appointmentController>();
            //object for match the delete object
            appointmentController currAppObj;
            appointmentController updatedObj=new appointmentController(updatedString);
            // get lines from txt file
            Object[] tableLines = br.lines().toArray();
            
            // extratct data from lines and add to the object array list
            for(int i = 0; i < tableLines.length; i++){
                String line = tableLines[i].toString().trim();
                
                currAppObj=new appointmentController(line);
                
                appObjList.add(currAppObj);
                
            }
            
            appObjList.set(deleteRowNumber,updatedObj);

            //deleting a all lines in the txt
            PrintWriter writer = new PrintWriter(file);
            writer.print("");
            writer.close();
            
            //writing existing files to txt 
            for(appointmentController loopObj: appObjList){
                
              writingTXT(loopObj.toString());
                
            }
            
            br.close();
                  
        }catch (IOException ex){
                    Logger.getLogger(homeAdminGUI.class.getName()).log(Level.SEVERE, null, ex);
        
        }
    
    }
    
//view by userName--------------------------------------------------------------------------

    public static void viewAppointmentByUser(JTable appointmentViewTable,String userName,int userType){
            
            File file = new File(filePath);
        
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            
            DefaultTableModel model=(DefaultTableModel) appointmentViewTable.getModel();
            
            model.setRowCount(0);
        
            // get lines from txt file
            Object[] tableLines = br.lines().toArray();
            
            // extratct data from lines
            for(int i = 0; i < tableLines.length; i++){
                String line = tableLines[i].toString().trim();
                String[] dataRow = line.split(",");
                
                if(userType==1){//patient user type
                
                    if(dataRow[0].equals(userName)){
                    model.addRow(dataRow);
                }
                
                }
                
                if(userType==2){//medical officer
                
                    if(dataRow[1].equals(userName)){
                    model.addRow(dataRow);
                }
                    
                }
                
            }
            br.close();
                  
        }catch (IOException ex){
                    Logger.getLogger(homeAdminGUI.class.getName()).log(Level.SEVERE, null, ex);
        
        }
    
    }

//get next appoinment reference ID----------------------------------------------------------------------

    public static int getNextAppRefNo(){
    int nextID=1001;
            BufferedReader br=null;
            try{
                            String sCurrentLine;
                            String lastLine="";
                            File file=new File(filePath);
                            if(file.length()!=0){//checking the 
                                br = new BufferedReader(new FileReader(filePath));
                                while ((sCurrentLine = br.readLine())!=null){
                                    lastLine = sCurrentLine;
                                }
                            }
                            String[] dataRow = lastLine.split(",");
                            nextID=Integer.parseInt(dataRow[6])+1;
                            
                }catch(IOException e){
                    System.out.println(e);
                
                }finally{
                            try{
                                
                                if (br!=null)
                                    br.close();
                                
                            }catch(IOException ex){
                            }
                }
        
        return nextID;
    
    } 

//update by appointment by ref ID-------------------------------------------------------------------------    
    
    public static void updateAppointmentByRefID(int referID,String updatedString){
         File file = new File(filePath);
            
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            //all object are stor in temp in this array 
            ArrayList<appointmentController> lineObjList = new ArrayList<appointmentController>();
            //object for match the delete object
            appointmentController currAppObj;
            appointmentController updatedObj=new appointmentController(updatedString);
            // get lines from txt file
            Object[] tableLines = br.lines().toArray();
            int matchedObjNo=0;
            // extratct data from lines and add to the object array list
            for(int i = 0; i < tableLines.length; i++){
                String line = tableLines[i].toString().trim();
                
                currAppObj=new appointmentController(line);
                if(currAppObj.getAppRefNo()==referID){
                    matchedObjNo=i;
                }
                lineObjList.add(currAppObj);
                
            }
            
            lineObjList.set(matchedObjNo,updatedObj);

            //deleting a all lines in the txt
            PrintWriter writer = new PrintWriter(file);
            writer.print("");
            writer.close();
            
            //writing existing files to txt 
            for(appointmentController loopObj: lineObjList){
                
              writingTXT(loopObj.toString());
                
            }
            
            br.close();
                  
        }catch (IOException ex){
                    Logger.getLogger(homeAdminGUI.class.getName()).log(Level.SEVERE, null, ex);
        
        }
    
    }

//-----------------------------------------------------------------------------------------------  
    public static void updateAppointmentState(String relaventString,String newState) throws FileNotFoundException{
        File file = new File(filePath);
                  try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            //all object are stor in temp in this array 
            ArrayList<appointmentController> appObjList = new ArrayList<appointmentController>();
            //object for match the delete object
            appointmentController currAppObj;
            // get lines from txt file
            Object[] tableLines = br.lines().toArray();
            
            // extratct data from lines and add to the object array list
            for(int i = 0; i < tableLines.length; i++){
                String line = tableLines[i].toString().trim();
                currAppObj=new appointmentController(line);
                if(currAppObj.objectMathcer(new appointmentController(relaventString))){
                    currAppObj.setAppStatus(newState);
                }
                appObjList.add(currAppObj);
                
            }
            
            //deleting a all lines in the txt
            PrintWriter writer = new PrintWriter(file);
            writer.print("");
            writer.close();
            
            //writing existing files to txt 
            for(appointmentController loopObj: appObjList){
                
              writingTXT(loopObj.toString());
                
            }
            
            br.close();
        }catch (IOException ex){
                    Logger.getLogger(homeAdminGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    
}
//view appointment count-------------------------------------------------------------------------
    public static int [] appointmentCounter(String mediCalOffiFullName) throws FileNotFoundException{
        int[] finalCount={0,0,0};
        File file = new File(filePath);
        
        try {
            
            BufferedReader br = new BufferedReader(new FileReader(file));
            //all object are stor in temp in this array 
            ArrayList<appointmentController> appObjList = new ArrayList<appointmentController>();
            //object for match the delete object
            appointmentController currAppObj;
            // get lines from txt file
            Object[] tableLines = br.lines().toArray();
            
            // extratct data from lines
            for(int i = 0; i < tableLines.length; i++){
                String line = tableLines[i].toString().trim();
                    currAppObj=new appointmentController(line);
                    if(currAppObj.getMedicalOfficersFullName().equals(mediCalOffiFullName)){
                          appObjList.add(currAppObj);
                    }
                }
            br.close();
            //counting part-----------------------------------------------------------------
            int finished=0,incoming = 0,approved=0;
            for(appointmentController loopObj:appObjList){
                if(loopObj.getAppStatus().equals("Pending")){
                    incoming+=1;
                }
                if(loopObj.getAppStatus().equals("Approved")){
                    approved+=1;
                }
                if(loopObj.getAppStatus().equals("finished")){
                    finished+=1;
                }
            }
            finalCount[0]=approved;
            finalCount[1]=finished;
            finalCount[2]=incoming;
                  
        }catch (IOException ex){
                    Logger.getLogger(homeAdminGUI.class.getName()).log(Level.SEVERE, null, ex);
        
        }
        
        return finalCount; 
     
     
    }
//
    //view appointment count-------------------------------------------------------------------------
    public static ArrayList<appointmentController> medicalOffierAppoinmentSelecter(String mediCalOffiFullName) throws FileNotFoundException{
        ArrayList<appointmentController> appObjList = new ArrayList<appointmentController>();
        File file = new File(filePath);
        
        try {
            
            BufferedReader br = new BufferedReader(new FileReader(file));
            //all object are stor in temp in this array 
            
            //object for match the delete object
            appointmentController currAppObj;
            // get lines from txt file
            Object[] tableLines = br.lines().toArray();
            
            // extratct data from lines
            for(int i = 0; i < tableLines.length; i++){
                String line = tableLines[i].toString().trim();
                    currAppObj=new appointmentController(line);
                    if(currAppObj.getMedicalOfficersFullName().equals(mediCalOffiFullName)){
                          appObjList.add(currAppObj);
                    }
                }
            br.close();
            
                  
        }catch (IOException ex){
                    Logger.getLogger(homeAdminGUI.class.getName()).log(Level.SEVERE, null, ex);
        
        }
        
        return appObjList; 
     
     
    }

}