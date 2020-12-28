package model;

import controllers.complainsController;
import controllers.date;
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

public class ComplainModel {
    private static String filePath = "userData\\complainDetails.txt";
//insert function-----------------------------------------------------------------------------------
    public static void writingTXT(String complainString){//writing to objcet to file 
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
                
                bw.write(complainString);
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
//View function-------------------------------------------------------------------------------------
    public static void viewComplain(JTable ComplainViewTable){
            
            File file = new File(filePath);
        
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            
            DefaultTableModel model=(DefaultTableModel) ComplainViewTable.getModel();
            
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
                  
        }catch (Exception ex){
                    Logger.getLogger(homeAdminGUI.class.getName()).log(Level.SEVERE, null, ex);
        
        }
    
    }
//delete function-----------------------------------------------------------------------------
    public static void deleteComplain(complainsController deleteObj){
            
            File file = new File(filePath);
        
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            //all object are stor in temp in this array 
            ArrayList<complainsController> complObjList = new ArrayList<complainsController>();
            //object for match the delete object
            complainsController currAppObj;
            // get lines from txt file
            Object[] tableLines = br.lines().toArray();
            
            // extratct data from lines and add to the object array list
            for(int i = 0; i < tableLines.length; i++){
                String line = tableLines[i].toString().trim();
                currAppObj=new complainsController(line);
                complObjList.add(currAppObj);//adding the objcet to list
            }

            //deleting a all lines in the txt
            PrintWriter writer = new PrintWriter(file);
            writer.print("");
            writer.close();
            
            //removing the deleting object from the object array list
            int deleteIndexNo=0;  
            for(complainsController loopObj: complObjList){
                
                if(deleteObj.objectMathcer(loopObj)){
                   break;
                }
                deleteIndexNo+=1;
                
            }
          complObjList.remove(deleteIndexNo);
          deleteIndexNo=0;
          //writing existing files to txt 
          for(complainsController loopObj: complObjList){
                
              writingTXT(loopObj.toString());
                
          }
          br.close();
                  
        }catch (Exception ex){
                    Logger.getLogger(homeAdminGUI.class.getName()).log(Level.SEVERE, null, ex);
        
        }
    
    }
//Update Complain-------------------------------------------------------------------------------
    public static void updateComplain(int deleteRowNumber,String updatedString){
            
            File file = new File(filePath);
            
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            //all object are stor in temp in this array 
            ArrayList<complainsController> lineObjList = new ArrayList<complainsController>();
            //object for match the delete object
            complainsController currAppObj;
            complainsController updatedObj=new complainsController(updatedString);
            // get lines from txt file
            Object[] tableLines = br.lines().toArray();
            
            // extratct data from lines and add to the object array list
            for(int i = 0; i < tableLines.length; i++){
                String line = tableLines[i].toString().trim();
                currAppObj=new complainsController(line);
                lineObjList.add(currAppObj);
                
            }
            
            lineObjList.set(deleteRowNumber,updatedObj);

            //deleting a all lines in the txt
            PrintWriter writer = new PrintWriter(file);
            writer.print("");
            writer.close();
            
            //writing existing files to txt 
            for(complainsController loopObj: lineObjList){
                
              writingTXT(loopObj.toString());
                
            }
            
            br.close();
                  
        }catch (Exception ex){
                    Logger.getLogger(homeAdminGUI.class.getName()).log(Level.SEVERE, null, ex);
        
        }
    
    }
//Update Complain by reference ID-------------------------------------------------------------------------------
    public static void updateComplainByRefID(int referID,String updatedString){
            
            File file = new File(filePath);
            
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            //all object are stor in temp in this array 
            ArrayList<complainsController> lineObjList = new ArrayList<complainsController>();
            //object for match the delete object
            complainsController currAppObj;
            complainsController updatedObj=new complainsController(updatedString);
            // get lines from txt file
            Object[] tableLines = br.lines().toArray();
            int matchedObjNo=0;
            // extratct data from lines and add to the object array list
            for(int i = 0; i < tableLines.length; i++){
                String line = tableLines[i].toString().trim();
                
                currAppObj=new complainsController(line);
                if(currAppObj.getComplainRefNo()==referID){
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
            for(complainsController loopObj: lineObjList){
                
              writingTXT(loopObj.toString());
                
            }
            
            br.close();
                  
        }catch (Exception ex){
                    Logger.getLogger(homeAdminGUI.class.getName()).log(Level.SEVERE, null, ex);
        
        }
    
    }    
//view complain by userName---------------------------------------------------------------------
    public static void viewComplainByUser(JTable complainViewTable,String userName){
            
            File file = new File(filePath);
        
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            
            DefaultTableModel model=(DefaultTableModel) complainViewTable.getModel();
            
            model.setRowCount(0);
        
            // get lines from txt file
            Object[] tableLines = br.lines().toArray();
            
            // extratct data from lines
            for(int i = 0; i < tableLines.length; i++){
                String line = tableLines[i].toString().trim();
                String[] dataRow = line.split(",");
                if(dataRow[0].equals(userName)){
                    model.addRow(dataRow);
                    
                }
                
            }
            

            br.close();
        }catch (Exception ex){
                    Logger.getLogger(homeAdminGUI.class.getName()).log(Level.SEVERE, null, ex);
        
        }
    
    }
//get next reference ID----------------------------------------------------------------------------
    public static int getNextReferenceNo(){//getting next avialble complain refference id
                       int nextID=1001;
            BufferedReader br=null;
            try{
                            String sCurrentLine;
                            String lastLine="";

                            File file=new File("userData\\complainDetails.txt");
                            if(file.length()!=0){//checking the 
                                br = new BufferedReader(new FileReader("userData\\complainDetails.txt"));
                                while ((sCurrentLine = br.readLine())!=null){
                                    lastLine = sCurrentLine;
                                }
                            }
                            String[] dataRow = lastLine.split(",");
                            nextID=Integer.parseInt(dataRow[7]);
                            
                }catch(IOException e){
                    System.out.println(e);
                    e.printStackTrace();
                
                }finally{
                            try{
                                
                                if (br!=null)
                                    br.close();
                                
                            }catch(IOException ex){
                                
                                 ex.printStackTrace();
                            
                            }
                }
        
        return nextID+1;
    
    }
}
