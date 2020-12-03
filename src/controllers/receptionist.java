package controllers;

public class receptionist extends userController{
    private int receptionistStaffID;
    private String receptionistStaffEmail;

    public receptionist(int receptionistStaffID,
            String receptionistStaffEmail,
            String userName,
            String userFirstName,
            String userLastName,
            int userPhoneNo,
            String userNIC,
            date userDOB,
            String userAddress,
            String userGender,
            String mariedState) {
        super(userName, userFirstName, userLastName,
              userPhoneNo, userNIC, userDOB,
              userAddress,userGender,mariedState);
        this.receptionistStaffID = receptionistStaffID;
        this.receptionistStaffEmail = receptionistStaffEmail;
    }
    
    
    @Override
    public String toString() {
        return super.getUserName()+","+
               super.getUserFirstName()+","+
               super.getUserLastName()+","+
               super.getUserGen()+","+
               super.getUserMarried()+","+
               super.getUserPhoneNo()+","+
               super.getUserNIC()+","+
               super.getUserDOB()+","+
               this.getReceptionistStaffEmail()+","+
               this.getReceptionistStaffID(); //To change body of generated methods, choose Tools | Templates.
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
