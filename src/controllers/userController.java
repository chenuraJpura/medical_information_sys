/*
NAME-MedlifoSystem
VERSION-2.0
TITE-user controller
DESCRIPTION-handle the user controller
*/
package controllers;
//start of the userController class
public class userController {
    
    private String userName;//declare veriables of userName
    private String userFirstName;//declare veriables of userFirstName
    private String userLastName;//declare veriables of userLastName
    private enum userGender{//declare veriables of userGender
        MALE,
        FEMALE,
    }
    private userGender userGen;//declare veriables of userGender
    private int userPhoneNo;//declare veriables of userPhoneNumber
    private String userNIC;//declare veriables of userNIC
    private date userDOB;//declare veriables of userDOB
    private String userAddress;//declare veriables of userAddress
    private enum userMarital{//declare veriables of userMarital
        MARRIED,
        UNMARRIED
    }
    private userMarital userMarried;//declare veriables of userMarried
    
    public void setUserMarital(String marriedState){
        switch (marriedState) {//start the switch case
            case "MARRIED":
            this.userMarried=userMarried.MARRIED;
            break;
            
            case "UNMARRIED":
            this.userMarried=userMarried.UNMARRIED;
            break;
        
        } //End of the switch case
    }
    
    public void setUserGender(String selectedGen){
        switch (selectedGen) { //start the switch case
            case "MALE":
            this.userGen=userGender.MALE;
            break;
            
            case "FEMALE":
            this.userGen=userGender.FEMALE;
            break;
        }//End of the switch case
    }
    //default constructer
    public userController(String userName,
            String userFirstName,
            String userLastName,
            int userPhoneNo,
            String userNIC,
            date userDOB,
            String userAddress,
            String userGender,
            String mariedState
    ) {
        this.setUserName(userName);
        this.setUserFirstName(userFirstName);
        this.setUserLastName(userLastName);
        this.setUserPhoneNo(userPhoneNo);
        setUserGender(userGender);
        setUserMarital(mariedState);
        this.setUserNIC(userNIC);
        this.setUserDOB(userDOB);
        this.setUserAddress(userAddress);
    }//End of the default constructor
    
    // Setters and getters
    public userMarital getUserMarried() {
        return userMarried;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserFirstName() {
        return userFirstName;
    }

    public void setUserFirstName(String userFirstName) {
        this.userFirstName = userFirstName;
    }

    public String getUserLastName() {
        return userLastName;
    }

    public void setUserLastName(String userLastName) {
        this.userLastName = userLastName;
    }

    public int getUserPhoneNo() {
        return userPhoneNo;
    }

    public void setUserPhoneNo(int userPhoneNo) {
        this.userPhoneNo = userPhoneNo;
    }

    public String getUserNIC() {
        return userNIC;
    }

    public void setUserNIC(String userNIC) {
        this.userNIC = userNIC;
    }

    public date getUserDOB() {
        return userDOB;
    }

    public void setUserDOB(date userDOB) {
        this.userDOB = userDOB;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    public userGender getUserGen() {
        return userGen;
    }
    
    // end of Setters and getters
    
     
}//end of the class
