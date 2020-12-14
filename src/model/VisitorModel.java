package model;

import controllers.date;
import controllers.time;
import controllers.visitorsController;
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

public class VisitorModel {
 
    private static String filePath = "userData\\visitorsDetails.txt";
//insert function--------------------------------------------------------------------------    
    public static void writingTXT(String AddNewVisitorString){//writing to objcet to file 
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
                
                bw.write(AddNewVisitorString);
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
    

//view visitor function-------------------------------------------------------------------------
    
public static void viewVisitor(JTable visitorViewTable){
           
            File file = new File(filePath);
        
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            // get the first line
            // get the columns name from the first line
            // set columns name to the jtable model
            //String firstLine = br.readLine().trim();
            //String[] columnsName = firstLine.split(",");
            DefaultTableModel model=(DefaultTableModel) visitorViewTable.getModel();
            model.setRowCount(0);
        
        //model.setColumnIdentifiers(columnsName);
            
            // get lines from txt file
            Object[] tableLines = br.lines().toArray();
            
            // extratct data from lines
            // set data to jtable model
            for(int i = 0; i < tableLines.length; i++)
            {
                String line = tableLines[i].toString().trim();
                String[] dataRow = line.split(",");
                model.addRow(dataRow);
            }
            
            
        } catch (Exception ex) {
            Logger.getLogger(homeAdminGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
//delete visitor------------------------------------------------------------------------------------
    public static void deleteVisitors(visitorsController deleteObj){
          
            File file = new File(filePath);
        
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            //all object are stor in temp in this array 
            ArrayList<visitorsController> visitObjList = new ArrayList<visitorsController>();
            //object for match the delete object
            visitorsController currAppObj;
            // get lines from txt file
            Object[] tableLines = br.lines().toArray();
            
            // extratct data from lines and add to the object array list
            for(int i = 0; i < tableLines.length; i++){
                String line = tableLines[i].toString().trim();
                String[] dataRow = line.split(",");
                currAppObj=new visitorsController(
                dataRow[0],//ID
                dataRow[1],//Name
                dataRow[2],//Purpose
                Integer.parseInt(dataRow[3]),//4n no        
                new date(dataRow[4]),//date
                new time(dataRow[5]),//in time
                new time(dataRow[6]),//out time
                dataRow[7]);//note
                visitObjList.add(currAppObj);
                
            }

            //deleting a all lines in the txt
            PrintWriter writer = new PrintWriter(file);
            writer.print("");
            writer.close();
            
            //removing the deleting object from the object array list
            int deleteIndexNo=0;  
            for(visitorsController loopObj: visitObjList){
                
                if(deleteObj.objectMathcer(loopObj)){
                   break;
                }
                deleteIndexNo=+1;
                
            }
          visitObjList.remove(deleteIndexNo);
          deleteIndexNo=0;
          //writing existing files to txt 
          for(visitorsController loopObj: visitObjList){
                
             writingTXT(loopObj.toString());
                
          }
                  
        }catch (Exception ex){
                    Logger.getLogger(homeAdminGUI.class.getName()).log(Level.SEVERE, null, ex);
        
        }
    
    }

//Update Visitors-------------------------------------------------------------------------
 public static void updateVisitors(
              int deleteRowNumber,
              String updatedString){
            
            File file = new File(filePath);
        
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            //all object are stor in temp in this array 
            ArrayList<visitorsController> visitObjList = new ArrayList<visitorsController>();
            //object for match the delete object
            visitorsController currAppObj;
            visitorsController updatedObj=new visitorsController(updatedString);
            // get lines from txt file
            Object[] tableLines = br.lines().toArray();
            
            // extratct data from lines and add to the object array list
            for(int i = 0; i < tableLines.length; i++){
                String line = tableLines[i].toString().trim();
                
                currAppObj=new visitorsController(line);
                
                visitObjList.add(currAppObj);
                
            }
            
            visitObjList.set(deleteRowNumber,updatedObj);

            //deleting a all lines in the txt
            PrintWriter writer = new PrintWriter(file);
            writer.print("");
            writer.close();
            
            //writing existing files to txt 
            for(visitorsController loopObj: visitObjList){
                
              writingTXT(loopObj.toString());
                
            }
                  
        }catch (Exception ex){
                    Logger.getLogger(homeAdminGUI.class.getName()).log(Level.SEVERE, null, ex);
        
        }
    
    }
    


    
}
