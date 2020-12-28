package controllers;

public class medicalOfficers extends userController{
    private int medicalStaffID;
    private String medicalStaffEmail;
    private String medicalSpecializedArea;

    public boolean objectMathcer(medicalOfficers matchObj){
        
        return matchObj.toString().equals(this.toString());
         
    }
    
    public medicalOfficers(String commaSeperatedString){
        String[] dataRow = commaSeperatedString.split(",");
        
                setMedicalStaffID(Integer.parseInt(dataRow[0]));
                setMedicalStaffEmail(dataRow[1]);
                setMedicalSpecializedArea(dataRow[2]);
                
                super.setUserName(dataRow[3]);
                super.setUserFirstName(dataRow[4]);
                super.setUserLastName(dataRow[5]);
                super.setUserPhoneNo(Integer.parseInt(dataRow[6]));
                super.setUserNIC(dataRow[7]);
                super.setUserDOB(new date(dataRow[8]));
                super.setUserAddress(dataRow[9]);
                super.setUserGender(dataRow[10]);
                super.setUserMarital(dataRow[11]);
                
    }
    
    public medicalOfficers(String[] dataRow){
        this(        Integer.parseInt(dataRow[0]),//staf  ID
                     dataRow[1],
                     dataRow[2],//specialized area
                     dataRow[3],//User name
                     dataRow[4],//fn
                     dataRow[5],//ln
                     Integer.parseInt(dataRow[6]),//4n
                     dataRow[7],//nic
                     new date(dataRow[8]),//dob
                     dataRow[9],//address
                     dataRow[10],//gen   
                     dataRow[11]);
                     }
    
    
    
    @Override
    public String toString() {
        return getMedicalStaffID()+","+
               getMedicalStaffEmail()+","+
               getMedicalSpecializedArea()+","+
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
        this.medicalSpecializedArea=medicalSpecializedArea;
        
    }

    public void newLoginMedicalOfficer(){
        loginController newMedicalLoginObj=new loginController(getUserName(),"MED",getUserNIC());
        newMedicalLoginObj.storeNewUserData();
    }

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
    }
    
    
            
    
}
