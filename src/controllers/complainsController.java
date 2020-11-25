
package controllers;

public class complainsController {
    
    private enum complainType{
    
    }
    private String complainByName;
    private int    complainPhoneNo;
    private date   complainDateObj;
    private String complainDescription;
    private String complainActionTaken;
    private String complainNote;

    public complainsController(String complainByName, int complainPhoneNo, date complainDateObj, String complainDescription, String complainActionTaken, String complainNote) {
        this.complainByName = complainByName;
        this.complainPhoneNo = complainPhoneNo;
        this.complainDateObj = complainDateObj;
        this.complainDescription = complainDescription;
        this.complainActionTaken = complainActionTaken;
        this.complainNote = complainNote;
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
    
    




    
}
