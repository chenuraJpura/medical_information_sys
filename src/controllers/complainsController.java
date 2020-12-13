
package controllers;

import java.io.BufferedReader;
import java.io.IOException;

public class complainsController {
    
    private String complainByName;
    private int    complainPhoneNo;
    private date   complainDateObj;
    private String complainReference;
    private String complainDescription;
    private String complainActionTaken;
    private String complainNote;

    public complainsController(String commaSeperatedString){
        String[] dataRow = commaSeperatedString.split(",");
        
                setComplainByName(dataRow[0]);
                setComplainPhoneNo(Integer.parseInt(dataRow[1]));
                setComplainDateObj(new date(dataRow[2]));
                setComplainDescription(dataRow[3]);
                setComplainActionTaken(dataRow[4]);
                setComplainNote(dataRow[5]);
                setComplainReference(dataRow[6]);
                
    }
    
    @Override
    public String toString(){
        return  getComplainByName()+","+
                getComplainPhoneNo()+","+
                getComplainDateObj().toString()+","+
                getComplainDescription()+","+
                getComplainActionTaken()+","+
                getComplainNote()+","+
                getComplainReference();
    }
    
    public complainsController(
            String complainByName,
            int complainPhoneNo,
            date complainDateObj,
            String complainDescription,
            String complainActionTaken,
            String complainNote,
            String complainRefference) {
        this.complainByName = complainByName;
        this.complainPhoneNo = complainPhoneNo;
        this.complainDateObj = complainDateObj;
        this.complainDescription = complainDescription;
        this.complainActionTaken = complainActionTaken;
        this.complainNote = complainNote;
        this.complainReference=complainRefference;
    }

    public boolean objectMathcer(complainsController matchObj){
        
        return matchObj.toString().equals(this.toString());
         
    }
    
    public String getComplainByName() {
        return complainByName;
    }

    public void setComplainByName(String complainByName) {
        this.complainByName = complainByName;
    }

    public int getComplainPhoneNo() {
        return complainPhoneNo;
    }

    public void setComplainPhoneNo(int complainPhoneNo) {
        this.complainPhoneNo = complainPhoneNo;
    }

    public date getComplainDateObj() {
        return complainDateObj;
    }

    public void setComplainDateObj(date complainDateObj) {
        this.complainDateObj = complainDateObj;
    }

    public String getComplainDescription() {
        return complainDescription;
    }

    public void setComplainDescription(String complainDescription) {
        this.complainDescription = complainDescription;
    }

    public String getComplainActionTaken() {
        return complainActionTaken;
    }

    public void setComplainActionTaken(String complainActionTaken) {
        this.complainActionTaken = complainActionTaken;
    }

    public String getComplainNote() {
        return complainNote;
    }

    public void setComplainNote(String complainNote) {
        this.complainNote = complainNote;
    }

    public String getComplainReference() {
        return complainReference;
    }

    public void setComplainReference(String complainReference) {
        this.complainReference = complainReference;
    }
    
    public static void readComplain(BufferedReader br)throws IOException{
       
    String complainLine = br.readLine();
    
    String[] resultString = complainLine.split("[,]", 0);
    for(String textField: resultString) {
          System.out.println(textField);
       }
          
    }




    
}
