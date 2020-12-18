
package controllers;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import model.UserModel;

public class loginController {
    //new user var
    private String userName;
    private int userID;
    private String userType;
    private String userPass;
    
    public loginController(String[] dataRow){//special constructor
    this(dataRow[0],Integer.parseInt(dataRow[1]),//userID
         dataRow[2],//type
         dataRow[3]);//pass   
    }
    public loginController(//default constructor for create a new record
            String userName,
            String userType,
            String userPass) {
            setUserName(userName);
            setUserType(userType);
            setUserPass(encryptionController.getEncryptedString(userPass));

            
            
    }
    
    public loginController(String commaSeperatedString){
        String[] dataRow = commaSeperatedString.split(",");
                setUserName(dataRow[0]);
                setUserID(Integer.parseInt(dataRow[1]));
                setUserType(dataRow[2]);
                setUserPass(dataRow[3]);
                
    }
    
    public loginController(//for login checker
            String userName,
            int userID,
            String userType,
            String userPass){
            setUserName(userName);
            setUserID(userID);
            setUserType(userType);
            setUserPass(userPass);
    }
    
    public int getNextIdNo(){//getting next avialble iD
                       int nextID=1001;
            BufferedReader br=null;
            try{
                            String sCurrentLine;
                            String lastLine="";

                            File file=new File("userData\\loginDetails.txt");
                            if(file.length()!=0){//checking the 
                                br = new BufferedReader(new FileReader("userData\\loginDetails.txt"));
                                while ((sCurrentLine = br.readLine())!=null){
                                    lastLine = sCurrentLine;
                                }
                            }
                            String[] dataRow = lastLine.split(",");
                            nextID=Integer.parseInt(dataRow[1]);
                }catch(IOException e){
                    System.out.println(e);
                    e.printStackTrace();
                
                }finally{
                            try{
                                
                                if (br!=null)
                                    br.close();
                                
                            }catch(IOException ex){
                                
                                 ex.printStackTrace();
                            
                            }
                }

        return nextID;
    
    }
    
    public void storeNewUserData(){//storing new user
           String userData=getUserName()+","+(getNextIdNo()+1)+","+getUserType()+","+getUserPass();
           UserModel.writingTXT(userData);
   
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    
    private void setUserName(String userName) {
        this.userName = userName;
    }

    private void setUserType(String userType) {
        this.userType = userType;
    }

    public void setUserPass(String userPass) {
        this.userPass = userPass;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserType() {
        return userType;
    }

    public String getUserPass() {
        return userPass;
    }
    @Override
    public String toString(){
        return getUserName()+","+getUserID()+","+getUserType()+","+getUserPass();
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }
    
    public boolean objectMathcer(loginController matchObj){
        
        return matchObj.toString().equals(this.toString());
         
    }
    
    
}
