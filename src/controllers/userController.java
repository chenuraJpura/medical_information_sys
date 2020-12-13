package controllers;

public class userController {
    
    private String userName;
    private String userFirstName;
    private String userLastName;
    private enum userGender{
        MALE,
        FEMALE,
    }
    private userGender userGen;
    private int userPhoneNo;
    private String userNIC;
    private date userDOB;
    private String userAddress;
    private enum userMarital{
        MARRIED,
        UNMARRIED
    }
    private userMarital userMarried;
    
    public void setUserMarital(String marriedState){
        switch (marriedState) {
            case "MARRIED":
            this.userMarried=userMarried.MARRIED;
            break;
            
            case "UNMARRIED":
            this.userMarried=userMarried.UNMARRIED;
            break;
        
        }
    }
    
    public void setUserGender(String selectedGen){
        switch (selectedGen) {
            case "MALE":
            this.userGen=userGender.MALE;
            break;
            
            case "FEMALE":
            this.userGen=userGender.FEMALE;
            break;
        }
    }
    
    public userController(){}

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
        this.userName = userName;
        this.userFirstName = userFirstName;
        this.userLastName = userLastName;
        this.userPhoneNo = userPhoneNo;
        setUserGender(userGender);
        setUserMarital(mariedState);
        this.userNIC = userNIC;
        this.userDOB = userDOB;
        this.userAddress = userAddress;
    }

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
    
    

    
}
