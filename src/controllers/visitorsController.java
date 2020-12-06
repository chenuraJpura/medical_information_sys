
package controllers;

public class visitorsController {
    
    private String visitID;
    private String visitName;
    private String visitPurpose;
    private int visitPhoneNo;
    private date visitDateObj;
    private time visitInTimeObj;
    private time visitOutTimeObj;
    private String visitNotes;

    @Override
    public String toString(){
        return getVisitID()+","+
               getVisitName()+","+
               getVisitPurpose()+","+
               getVisitDateObj().toString()+","+
               getVisitInTimeObj().toString()+","+
               getVisitOutTimeObj().toString()+","+
               getVisitNotes(); 
    }
    
    public visitorsController(String visitID,
            String visitName,
            String visitPurpose,
            int visitPhoneNo,
            date visitDateObj,
            time visitInTimeObj,
            time visitOutTimeObj,
            String visitNotes) {
        this.visitID = visitID;
        this.visitName = visitName;
        this.visitPurpose = visitPurpose;
        this.visitPhoneNo = visitPhoneNo;
        this.visitDateObj = visitDateObj;
        this.visitInTimeObj = visitInTimeObj;
        this.visitOutTimeObj = visitOutTimeObj;
        this.visitNotes = visitNotes;
    }

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
    
 















    
}
