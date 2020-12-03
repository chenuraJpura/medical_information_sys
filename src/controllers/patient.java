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
    private patientBloodGroup bloodGroup;
   private String patientAllergies;

   public void setBloodGroup(String bloodG){
       switch (bloodG) {
            case "A":
            this.bloodGroup=patientBloodGroup.A;
            break;
            
            case "B":
            this.bloodGroup=patientBloodGroup.B;
            break;
            
            case "AB":
            this.bloodGroup=patientBloodGroup.AB;
            break;
            
            case "O":
            this.bloodGroup=patientBloodGroup.O;
            break;
            
            case "A-":
            this.bloodGroup=patientBloodGroup.A_Negative;
            break;
            
            case "B-":
            this.bloodGroup=patientBloodGroup.B_Negative;
            break;
            
            case "AB-":
            this.bloodGroup=patientBloodGroup.AB_Negative;
            break;
            
            case "O-":
            this.bloodGroup=patientBloodGroup.O_Negative;
            break;
       
       
       }

}
   
    public patient(String patientAllergies,
            String userName,
            String userFirstName,
            String userLastName,
            int userPhoneNo,
            String userNIC,
            date userDOB,
            String userAddress,
            String patientBloodGroup,
            String userGender,
            String userMarriedState) {
        super(userName, userFirstName, userLastName, 
                userPhoneNo, userNIC, userDOB,
                userAddress,userGender,userMarriedState);
        this.patientAllergies = patientAllergies;
        setBloodGroup(patientBloodGroup);
  }

    public String getPatientAllergies() {
        return patientAllergies;
    }

    public void setPatientAllergies(String patientAllergies) {
        this.patientAllergies = patientAllergies;
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
               this.getPatientAllergies()+","+
               this.bloodGroup; //To change body of generated methods, choose Tools | Templates.
    }
   
    
}
