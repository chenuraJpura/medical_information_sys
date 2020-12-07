/*
Name       : medical information system (Team 09)
version    : 2.0
Title      : medicalOfficers.java
description: handle the medicalOfficers subclass

*/
package controllers;

public class medicalOfficers extends userController{//start the medical officers subclass inherit from the user controller parentclass
    // declare the private variables
    private int medicalStaffID;
    private String medicalStaffEmail;
    private String medicalSpecializedArea;
    
    //default constructor
    public medicalOfficers(int medicalStaffID,
            String medicalStaffEmail,
            String medicalSpecializedArea,
            String userName,
            String userFirstName,
            String userLastName,
            int userPhoneNo,
            String userNIC,
            date userDOB,
            String userAddress,
            String userGender,
            String mariedState) {
        //here super keyword is used to call methods and access the constructors in the user controller supper class.
        super(userName, userFirstName,
                userLastName,
                userPhoneNo,
                userNIC,
                userDOB,
                userAddress,
                userGender,
                mariedState);
        this.setMedicalStaffID (medicalStaffID);
        this.setMedicalStaffEmail (medicalStaffEmail);
        this.setMedicalSpecializedArea(medicalSpecializedArea);// end of the default constructor
    }
    @Override
    public String toString() { //here return the values by toString method
        return getMedicalStaffID()+","+
               getMedicalStaffEmail()+","+
               getMedicalSpecializedArea()+","+
               super.getUserName()+","+    //call the methods from the user controller supper class
               super.getUserFirstName()+","+
               super.getUserLastName()+","+
               super.getUserPhoneNo()+","+
               super.getUserNIC()+","+
               super.getUserDOB().toString()+","+
               super.getUserAddress()+","+
               super.getUserGen()+","+
               super.getUserMarried();
    }
    //create the getters and setters for variables
    public String getMedicalSpecializedArea() {
        return medicalSpecializedArea;
    }

    public void setMedicalSpecializedArea(String medicalSpecializedArea) {
        this.medicalSpecializedArea = medicalSpecializedArea;
    }

    
    
    public int getMedicalStaffID() {
        return medicalStaffID;
    }

    public void setMedicalStaffID(int medicalStaffID) {
        this.medicalStaffID = medicalStaffID;
    }

    public String getMedicalStaffEmail() {
        return medicalStaffEmail;
    }

    public void setMedicalStaffEmail(String medicalStaffEmail) {
        this.medicalStaffEmail = medicalStaffEmail;
    }// end of the getters and setters
    
    
            
    
}//end of the medical officer subclass
