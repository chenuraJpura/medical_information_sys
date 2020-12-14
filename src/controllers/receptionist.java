package controllers;

public class receptionist extends userController{
    private int receptionistStaffID;
    private String receptionistStaffEmail;

    public boolean objectMathcer(receptionist matchObj){
        
        return matchObj.toString().equals(this.toString());
         
    }
    
    public receptionist(String commaSeperatedString){
        String[] dataRow = commaSeperatedString.split(",");
        
                setReceptionistStaffID(Integer.parseInt(dataRow[0]));
                setReceptionistStaffEmail(dataRow[1]);
                super.setUserName(dataRow[2]);
                super.setUserFirstName(dataRow[3]);
                super.setUserLastName(dataRow[4]);
                super.setUserPhoneNo(Integer.parseInt(dataRow[5]));
                super.setUserNIC(dataRow[6]);
                super.setUserDOB(new date(dataRow[7]));
                super.setUserAddress(dataRow[8]);
                super.setUserGender(dataRow[9]);
                super.setUserMarital(dataRow[10]);
                
    }
  
    
    public receptionist(String[] dataRow){
            this(    Integer.parseInt(dataRow[0]),//id
                     dataRow[1],//mail
                     dataRow[2],//userName
                     dataRow[3],//fn
                     dataRow[4],//ln
                     Integer.parseInt(dataRow[5]),//4n
                     dataRow[6],//nic
                     new date(dataRow[7]),//dob
                     dataRow[8],//address
                     dataRow[9],//gen
                     dataRow[10]);//married
                        
           
    }
    
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
        //loginController newReceptionistLoginObj=new loginController(getUserName(),"REC",getUserNIC());
        //newReceptionistLoginObj.storeNewUserData();
    }
    
    
    @Override
    public String toString() {
        return this.getReceptionistStaffID()+","+
               this.getReceptionistStaffEmail()+","+
               super.getUserName()+","+
               super.getUserFirstName()+","+
               super.getUserLastName()+","+
               super.getUserPhoneNo()+","+
               super.getUserNIC()+","+ 
               super.getUserDOB()+","+
               super.getUserAddress()+","+
               super.getUserGen()+","+
               super.getUserMarried();
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
