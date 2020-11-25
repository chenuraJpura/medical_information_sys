package controllers;


public class receptionist extends userController{
    private int receptionistStaffID;
    private String receptionistStaffEmail;

    public receptionist(int receptionistStaffID, String receptionistStaffEmail, String userName, String userFirstName, String userLastName, int userPhoneNo, String userNIC, date userDOB, String userAddress) {
        super(userName, userFirstName, userLastName, userPhoneNo, userNIC, userDOB, userAddress);
        this.receptionistStaffID = receptionistStaffID;
        this.receptionistStaffEmail = receptionistStaffEmail;
    }

    public int getReceptionistStaffID() {
        return receptionistStaffID;
    }

    public void setReceptionistStaffID(int receptionistStaffID) {
        this.receptionistStaffID = receptionistStaffID;
    }

    public String getReceptionistStaffEmail() {
        return receptionistStaffEmail;
    }

    public void setReceptionistStaffEmail(String receptionistStaffEmail) {
        this.receptionistStaffEmail = receptionistStaffEmail;
    }
    

    
}
