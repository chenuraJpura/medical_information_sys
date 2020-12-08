/*
Name       : medical information system (Team 09)
version    : 2.0
Title      : complainsController.java
Description: handle the complainsController class
*/
package controllers;

import java.io.BufferedReader;
import java.io.IOException;

public class complainsController {//Start of the complainsController class
    //declare the private variables
    private String complainByName;
    private int    complainPhoneNo;
    private date   complainDateObj;
    private String complainReference;
    private String complainDescription;
    private String complainActionTaken;
    private String complainNote;

    
    
    @Override
    public String toString(){ // returns the value by toString
        return  getComplainByName()+","+
                getComplainPhoneNo()+","+
                getComplainDateObj().toString()+","+
                getComplainDescription()+","+
                getComplainActionTaken()+","+
                getComplainNote()+","+
                getComplainReference();
    }
    //start the default constructor
    public complainsController(String complainByName,
            int complainPhoneNo,
            date complainDateObj,
            String complainDescription,
            String complainActionTaken,
            String complainNote,
            String complainRefference) {
        this.setComplainByName(complainByName);
        this.setComplainPhoneNo (complainPhoneNo);
        this.setComplainDateObj(complainDateObj);
        this.setComplainDescription (complainDescription);
        this.setComplainActionTaken (complainActionTaken);
        this.setComplainNote (complainNote);
        this.setComplainReference(complainRefference);
    }
    // start getters and setters
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
    }// end of the getters and setters
    
    //add an instance methode th read the complain
    public static void readComplain(BufferedReader br)throws IOException{
       
    String complainLine = br.readLine();// reading from an input stream
    
    String[] resultString = complainLine.split("[,]", 0);// create a sting type array
    for(String textField: resultString) {
          System.out.println(textField);// print the textField
       }
          
    }// end of the complainsController class




    
}
