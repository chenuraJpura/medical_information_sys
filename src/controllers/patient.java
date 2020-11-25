package controllers;

public class patient extends userController{
    private enum patientBloodGroup{
        A,
        B,
        AB,
        O,
        A_Negative,
        B_Negative,
        AB_Negative,
        O_Negative
    };
   private String patientAllergies;

    public patient(String patientAllergies, String userName, String userFirstName, String userLastName, int userPhoneNo, String userNIC, date userDOB, String userAddress) {
        super(userName, userFirstName, userLastName, userPhoneNo, userNIC, userDOB, userAddress);
        this.patientAllergies = patientAllergies;
    }

    public String getPatientAllergies() {
        return patientAllergies;
    }

    public void setPatientAllergies(String patientAllergies) {
        this.patientAllergies = patientAllergies;
    }
   
}
