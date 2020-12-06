
package controllers;

public class medicalOfficers extends userController{
    private int medicalStaffID;
    private String medicalStaffEmail;

    public medicalOfficers(int medicalStaffID,
            String medicalStaffEmail,
            String userName,
            String userFirstName,
            String userLastName,
            int userPhoneNo,
            String userNIC,
            date userDOB,
            String userAddress,
            String userGender,
            String mariedState) {
        super(userName, userFirstName,
                userLastName,
                userPhoneNo,
                userNIC,
                userDOB,
                userAddress,
                userGender,
                mariedState);
        this.medicalStaffID = medicalStaffID;
        this.medicalStaffEmail = medicalStaffEmail;
    }
    @Override
    public String toString() {
        return getMedicalStaffID()+","+
               getMedicalStaffEmail()+","+ 
               super.getUserName()+","+
               super.getUserFirstName()+","+
               super.getUserLastName()+","+
               super.getUserPhoneNo()+","+
               super.getUserNIC()+","+
               super.getUserDOB().toString()+","+
               super.getUserAddress()+","+
               super.getUserGen()+","+
               super.getUserMarried();
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
    }
    
    
            
    
}
