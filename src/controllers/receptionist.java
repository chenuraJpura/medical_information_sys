/*
NAME-MedlifoSystem
VERSION-2.0
TITE-receptionist controller
DESCRIPTION-handle the receptionist controller
*/
package controllers;

public class receptionist extends userController{ //start the receptionist class
    private int receptionistStaffID; //declare veriables of staffID
    private String receptionistStaffEmail; //declare veriables of staffEmail

    //create  constructor
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
        this.setReceptionistStaffID(receptionistStaffID);
        this.setReceptionistStaffEmail(receptionistStaffEmail);
    }
    //End of  constructor
    
    @Override
    public String toString() { //return the values by tostring methode
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
    //Setters and getters
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
    
   //END OF Setters and getters
    
}
//start the receptionist class

