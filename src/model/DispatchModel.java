package model;

import controllers.dispatchPostController;
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

public class DispatchModel {
    private static String filePath = "userData\\DispatchPostDetails.txt";
    //insert Dispatch-------------------------------------------------------------------
     public static void writingTXT(String dispatchPostString){//writing to objcet to file 
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
     
    //view dispatch------------------------------------------------------------------
     public static void viewDispatchPost(JTable DispatchPostViewTable){
            
            File file = new File(filePath);
        
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            // get the first line
            // get the columns name from the first line
            // set columns name to the jtable model
            //String firstLine = br.readLine().trim();
            //String[] columnsName = firstLine.split(",");
            DefaultTableModel model=(DefaultTableModel) DispatchPostViewTable.getModel();
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
            
            br.close();
        } catch (Exception ex) {
            Logger.getLogger(homeAdminGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
//delete function------------------------------------------------------------------------
     public static void deleteDispatch(dispatchPostController deleteObj){
            
            File file = new File(filePath);
        
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            //all object are stor in temp in this array 
            ArrayList<dispatchPostController> dispPostObjList = new ArrayList<dispatchPostController>();
            //object for match the delete object
            dispatchPostController currAppObj;
            // get lines from txt file
            Object[] tableLines = br.lines().toArray();
            
            // extratct data from lines and add to the object array list
            for(int i = 0; i < tableLines.length; i++){
                String line = tableLines[i].toString().trim();
                String[] dataRow = line.split(",");
                currAppObj=new dispatchPostController(dataRow);
                dispPostObjList.add(currAppObj);
            }

            //deleting a all lines in the txt
            PrintWriter writer = new PrintWriter(file);
            writer.print("");
            writer.close();
            
            //removing the deleting object from the object array list
            int deleteIndexNo=0;  
            for(dispatchPostController loopObj: dispPostObjList){
                
                if(deleteObj.objectMathcer(loopObj)){
                   break;
                }
                deleteIndexNo+=1;
                
            }
          dispPostObjList.remove(deleteIndexNo);
          deleteIndexNo=0;
          //writing existing files to txt 
          for(dispatchPostController loopObj: dispPostObjList){
                
              writingTXT(loopObj.toString());
                
          }
          
          br.close();
                  
        }catch (Exception ex){
                    Logger.getLogger(homeAdminGUI.class.getName()).log(Level.SEVERE, null, ex);
        
        }
    
    } 
 //update function---------------------------------------
     public static void updateDispatch(
              int deleteRowNumber,
              String updatedString){
              
              File file = new File(filePath);
            
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            //all object are stor in temp in this array 
            ArrayList<dispatchPostController> lineObjList = new ArrayList<dispatchPostController>();
            //object for match the delete object
            dispatchPostController currAppObj;
            dispatchPostController updatedObj=new dispatchPostController(updatedString);
            // get lines from txt file
            Object[] tableLines = br.lines().toArray();
            
            // extratct data from lines and add to the object array list
            for(int i = 0; i < tableLines.length; i++){
                String line = tableLines[i].toString().trim();
                
                currAppObj=new dispatchPostController(line);
                
                lineObjList.add(currAppObj);
                
            }
            
            lineObjList.set(deleteRowNumber,updatedObj);

            //deleting a all lines in the txt
            PrintWriter writer = new PrintWriter(file);
            writer.print("");
            writer.close();
            
            //writing existing files to txt 
            for(dispatchPostController loopObj: lineObjList){
                
             writingTXT(loopObj.toString());
                
            }
            
            br.close();
                  
        }catch (Exception ex){
                    Logger.getLogger(homeAdminGUI.class.getName()).log(Level.SEVERE, null, ex);
        
        }
    
    }
}


    
