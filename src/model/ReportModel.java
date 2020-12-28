
package model;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import controllers.appointmentController;
import controllers.date;
import controllers.time;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import view.homeAdminGUI;


public class ReportModel {
//converting the CSV to json-------------------------------------------------------------------------------------------------------------------------
    public static void patientToJson(){

        
        try {
            
            File file = new File("userData\\patientDetails.txt");
            BufferedReader br = new BufferedReader(new FileReader(file));
                         
            // get lines from txt file
            Object[] tableLines = br.lines().toArray();
            //Add employees to list
            JSONArray patientList = new JSONArray();
        
        
            // extratct data from lines
            for(int i = 0; i < tableLines.length; i++){
                String line = tableLines[i].toString().trim();
                String[] dataRow = line.split(",");
                JSONObject patientDetails = new JSONObject();
                patientDetails.put("userName",dataRow[0]);
                patientDetails.put("firstName",dataRow[1]);
                patientDetails.put("lastName",dataRow[2]);
                patientDetails.put("phoneNo",Integer.parseInt(dataRow[3]));
                patientDetails.put("NIC",dataRow[4]);
                patientDetails.put("DOB",dataRow[5]);
                patientDetails.put("Address",dataRow[6]);
                patientDetails.put("BloodG",dataRow[7]);
                patientDetails.put("Gen",dataRow[8]);
                patientDetails.put("Marital",dataRow[9]);
                patientDetails.put("Allergies",dataRow[10]);
                
                JSONObject patientObject = new JSONObject(); 
                patientObject.put("patient",patientDetails);
                
                patientList.add(patientObject);
                
            }
            
            //Write JSON file
        try (FileWriter jsonFile = new FileWriter("userData\\patientDetails.json")) {
 
            jsonFile.write(patientList.toJSONString());
            jsonFile.flush();
 
        } catch (IOException e) {
            e.printStackTrace();
        }
                  
        }catch (Exception ex){
                    Logger.getLogger(homeAdminGUI.class.getName()).log(Level.SEVERE, null, ex);
        
        }
        
        
        
        
    
    }
    public static void medicalToJson(){
          try {
            
            File file = new File("userData\\medicalOfficerDetails.txt");
            BufferedReader br = new BufferedReader(new FileReader(file));
                         
            // get lines from txt file
            Object[] tableLines = br.lines().toArray();
            //Add employees to list
            JSONArray mediOffiList = new JSONArray();
        
        
            // extratct data from lines
            for(int i = 0; i < tableLines.length; i++){
                String line = tableLines[i].toString().trim();
                String[] dataRow = line.split(",");
                JSONObject mediOfficerDetails = new JSONObject();
                mediOfficerDetails.put("staffID",Integer.parseInt(dataRow[0]));
                mediOfficerDetails.put("Email",dataRow[1]);
                mediOfficerDetails.put("sp_Area",dataRow[2]);
                mediOfficerDetails.put("UserName",dataRow[3]);
                mediOfficerDetails.put("firstName",dataRow[4]);
                mediOfficerDetails.put("lastName",dataRow[5]);
                mediOfficerDetails.put("phoneNo",Integer.parseInt(dataRow[6]));
                mediOfficerDetails.put("NIC",dataRow[7]);
                mediOfficerDetails.put("DOB",dataRow[8]);
                mediOfficerDetails.put("Address",dataRow[9]);
                mediOfficerDetails.put("Gen",dataRow[10]);
                mediOfficerDetails.put("Marital",dataRow[11]);
                
                JSONObject mediObject = new JSONObject(); 
                mediObject.put("medi_officer",mediOfficerDetails);
                
                mediOffiList.add(mediObject);
                
            }
            
            //Write JSON file
        try (FileWriter jsonFile = new FileWriter("userData\\medicalOfficerDetails.json")) {
 
            jsonFile.write(mediOffiList.toJSONString());
            jsonFile.flush();
 
        } catch (IOException e) {
        }
                  
        }catch (FileNotFoundException | NumberFormatException ex){
                    Logger.getLogger(homeAdminGUI.class.getName()).log(Level.SEVERE, null, ex);
        
        }
        
        
        
        
    
    }
    public static void receptionistToJson(){
          try {
            File file = new File("userData\\receptionistDetails.txt");
            BufferedReader br = new BufferedReader(new FileReader(file));
            // get lines from txt file
            Object[] tableLines = br.lines().toArray();
            //Add employees to list
            JSONArray receptionList = new JSONArray();
         // extratct data from lines
            for(int i = 0; i < tableLines.length; i++){
                String line = tableLines[i].toString().trim();
                String[] dataRow = line.split(",");
                JSONObject receptionistDetails = new JSONObject();
                receptionistDetails.put("staffID",Integer.parseInt(dataRow[0]));
                receptionistDetails.put("Email",dataRow[1]);
                receptionistDetails.put("UserName",dataRow[2]);
                receptionistDetails.put("firstName",dataRow[3]);
                receptionistDetails.put("lastName",dataRow[4]);
                receptionistDetails.put("phoneNo",Integer.parseInt(dataRow[5]));
                receptionistDetails.put("NIC",dataRow[6]);
                receptionistDetails.put("DOB",dataRow[7]);
                receptionistDetails.put("Address",dataRow[8]);
                receptionistDetails.put("Gen",dataRow[9]);
                receptionistDetails.put("Marital",dataRow[10]);
                
                JSONObject mediObject = new JSONObject(); 
                mediObject.put("medi_officer",receptionistDetails);
                
                receptionList.add(mediObject);
                
            }
            
            //Write JSON file
        try (FileWriter jsonFile = new FileWriter("userData\\receptionistDetails.json")) {
 
            jsonFile.write(receptionList.toJSONString());
            jsonFile.flush();
 
        } catch (IOException e) {
        }
                  
        }catch (FileNotFoundException | NumberFormatException ex){
                    Logger.getLogger(homeAdminGUI.class.getName()).log(Level.SEVERE, null, ex);
        
        }
        
        
        
        
    
    }
//pdf genrater    
    public static void appointmentToPDF(ArrayList<appointmentController> mediOffiArry,String medicalOfficerName) throws FileNotFoundException, DocumentException{
        date currDate=new date();
        time printTime=new time();
        // 1. Create document
        Document document = new Document(PageSize.A4, 50, 50, 50, 50);

        // 2. Create PdfWriter              
        PdfWriter.getInstance(document, 
                new FileOutputStream("pdf\\receipt_"+medicalOfficerName+"_"+currDate.RenameReadyToString()+"_.pdf"));
        // 3. Open document
        document.open();

        // 4. Add content
        int count=0;
        for(appointmentController printAppObj:mediOffiArry){
            document.add(new Paragraph("---------------------------------------------------------------------------------------------------------------------------"));
            document.add(new Paragraph("                                                   APPOINTMENT RECEPIT                                                     "));
            document.add(new Paragraph("---------------------------------------------------------------------------------------------------------------------------"));
            document.add(new Paragraph("                                                                                          Appointment No: "+printAppObj.getAppRefNo()));
            document.add(new Paragraph("---------------------------------------------------------------------------------------------------------------------------")); 
            document.add(new Paragraph("            ISSUED Date: "+currDate.toString()));
            document.add(new Paragraph("            ISSUED Time: "+printTime.toString()));
            document.add(new Paragraph("---------------------------------------------------------------------------------------------------------------------------"));
            document.add(new Paragraph("                    Patient Name:  "+printAppObj.getAppPatientName()+"\n\n"));
            document.add(new Paragraph("                    Consultant  :  "+printAppObj.getMedicalOfficersFullName()+"\n\n"));
            document.add(new Paragraph("                    Symptoms    :  "+printAppObj.getAppSymptoms()+"\n\n"));
            document.add(new Paragraph("                    Appointment Date  :  "+printAppObj.getAppDate().toString()+"\n\n"));
            document.add(new Paragraph("                    Appointment Time  :  "+printAppObj.getAppTime().toString()));
            document.add(new Paragraph("---------------------------------------------------------------------------------------------------------------------------"));
            document.add(new Paragraph("            Appointment Status:  "+printAppObj.getAppStatus()+"\n"));
            document.add(new Paragraph("---------------------------------------------------------------------------------------------------------------------------"));  
            count+=1;
            if(count%2==0){
                document.newPage();
            }
        }
        
        
         
        // 5. Close document
        document.close();
    
    }

}
