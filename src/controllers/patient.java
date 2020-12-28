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
    
    public patient(String[] dataRow){
            this(    dataRow[0],
                     dataRow[1],
                     dataRow[2],
                     Integer.parseInt(dataRow[3]),//Phone No
                     dataRow[4],//NIC
                     new date(dataRow[5]),//DOB
                     dataRow[6],//Address
                     dataRow[7],//B Group
                     dataRow[8],//Gen
                     dataRow[9],//Married
                     dataRow[10]);   
           
    }
    
    public patient(String commaSeperatedString){
        String[] dataRow = commaSeperatedString.split(",");
        
                super.setUserName(dataRow[0]);
                super.setUserFirstName(dataRow[1]);
                super.setUserLastName(dataRow[2]);
                super.setUserPhoneNo(Integer.parseInt(dataRow[3]));
                super.setUserNIC(dataRow[4]);
                super.setUserDOB(new date(dataRow[5]));
                super.setUserAddress(dataRow[6]);
                setBloodGroup(dataRow[7]);
                super.setUserGender(dataRow[8]);
                super.setUserMarital(dataRow[9]);
                setPatientAllergies(dataRow[10]);
    }
   
    @Override
    public String toString() {
        return super.getUserName()+","+
               super.getUserFirstName()+","+
               super.getUserLastName()+","+
               super.getUserPhoneNo()+","+
               super.getUserNIC()+","+
               super.getUserDOB().toString()+","+
               super.getUserAddress()+","+
               this.getBloodGroup()+","+
               super.getUserGen()+","+
               super.getUserMarried()+","+
               this.getPatientAllergies();
    }
    
    public patient(
            String userName,
            String userFirstName,
            String userLastName,
            int userPhoneNo,
            String userNIC,
            date userDOB,
            String userAddress,
            String patientBloodGroup,
            String userGender,
            String userMarriedState,
            String patientAllergies) {
        super(userName, userFirstName, userLastName, 
                userPhoneNo, userNIC, userDOB,
                userAddress,userGender,userMarriedState);
        this.patientAllergies = patientAllergies;
        setBloodGroup(patientBloodGroup);
        
    
    }
    
    public void newLoginPatient(){
        loginController newPatientLoginObj=new loginController(getUserName(),"PAT",getUserNIC());
        newPatientLoginObj.storeNewUserData();
    }
        
    public String getPatientAllergies() {
        return patientAllergies;
    }

    public void setPatientAllergies(String patientAllergies) {
        this.patientAllergies = patientAllergies;
    }

    public patientBloodGroup getBloodGroup() {
        return bloodGroup;
    }
    
     public boolean objectMathcer(patient matchObj){
        
        return matchObj.toString().equals(this.toString());
         
    }
    
}
