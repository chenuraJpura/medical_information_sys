/*
NAME-MedlifoSystem
VERSION-2.0
TITE-visitors controller
DESCRIPTION-handle the visitors controller
*/
package controllers;
//start of the visitorsController class
public class visitorsController {
    
    private String visitID;//declare veriables of visitID
    private String visitName;//declare veriables of visitName
    private String visitPurpose;//declare veriables of visitPurpose
    private int visitPhoneNo;//declare veriables of visitPhoneNo
    private date visitDateObj;//declare veriables of visitDateObj
    private time visitInTimeObj;//declare veriables of visitInTimeObj
    private time visitOutTimeObj;//declare veriables of visitOutTimeObj
    private String visitNotes;//declare veriables of visitNotes

    @Override//return the values by tostring methode
    public String toString(){
        return getVisitID()+","+
               getVisitName()+","+
               getVisitPurpose()+","+
               getVisitDateObj().toString()+","+
               getVisitInTimeObj().toString()+","+
               getVisitOutTimeObj().toString()+","+
               getVisitNotes(); 
    }
     //default constructer
    public visitorsController(String visitID,
            String visitName,
            String visitPurpose,
            int visitPhoneNo,
            date visitDateObj,
            time visitInTimeObj,
            time visitOutTimeObj,
            String visitNotes) {
        this.setVisitID(visitID);
        this.setVisitName(visitName);
        this.setVisitPurpose(visitPurpose);
        this.setVisitPhoneNo(visitPhoneNo);
        this.setVisitDateObj(visitDateObj);
        this.setVisitInTimeObj(visitInTimeObj);
        this.setVisitOutTimeObj(visitOutTimeObj);
        this.setVisitNotes(visitNotes);
    }
   //Setters and getters
    public String getVisitID() {
        return visitID;
    }

    public void setVisitID(String visitID) {
        this.visitID = visitID;
    }

    public String getVisitName() {
        return visitName;
    }

    public void setVisitName(String visitName) {
        this.visitName = visitName;
    }

    public String getVisitPurpose() {
        return visitPurpose;
    }

    public void setVisitPurpose(String visitPurpose) {
        this.visitPurpose = visitPurpose;
    }

    public int getVisitPhoneNo() {
        return visitPhoneNo;
    }

    public void setVisitPhoneNo(int visitPhoneNo) {
        this.visitPhoneNo = visitPhoneNo;
    }

    public date getVisitDateObj() {
        return visitDateObj;
    }

    public void setVisitDateObj(date visitDateObj) {
        this.visitDateObj = visitDateObj;
    }

    public time getVisitInTimeObj() {
        return visitInTimeObj;
    }

    public void setVisitInTimeObj(time visitInTimeObj) {
        this.visitInTimeObj = visitInTimeObj;
    }

    public time getVisitOutTimeObj() {
        return visitOutTimeObj;
    }

    public void setVisitOutTimeObj(time visitOutTimeObj) {
        this.visitOutTimeObj = visitOutTimeObj;
    }

    public String getVisitNotes() {
        return visitNotes;
    }

    public void setVisitNotes(String visitNotes) {
        this.visitNotes = visitNotes;
    }
    // end of Setters and getters
 
   
}// end of the class
