
package controllers;

public class loginController {
    private String userName;
    private String userPass;
    private String dbUserName;
    private String dbPass;
    private encryptionController encryptObj;
    
    public loginController(String userName, String userPass,String dbUserName, String dbPass) {
        this.userName = userName;
        this.userPass=userPass;
        this.dbUserName = dbUserName;
        this.dbPass = dbPass;

    }
    
    public boolean loginChecker(){//checking the database details and user entered values
        boolean c1=this.userName.equals(this.dbUserName);
        boolean c2=this.userPass.equals(this.dbPass);
        if(c1 && c2){
            return true;
        }
        return false;
    
    }
    
    
    
}
