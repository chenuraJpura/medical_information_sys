/*
Name       : medical information system (Team 09)
version    : 2.0
Title      : recievedPostalController.java
Description: handle the appointmentController class
*/
package controllers;

public class recievedPostController extends postalController{//start the recievedPost Controller subclass inherit from the postal Controller parentclass
    //declare private variables
    private String recievedFrom;
    private String recievedFromAddress;
    private String recievedToName;
 
    //default constructor
    public recievedPostController(
            int postRefferenceNo,
            String recievedToName,
            String recievedFrom,
            String recievedFromAddress,
            String postNote,
            date postDateObj) {
        super(postRefferenceNo, postNote, postDateObj);
        this.setRecievedFrom (recievedFrom);
        this.setRecievedFromAddress (recievedFromAddress);
        this.setRecievedToName (recievedToName);
    }

    public recievedPostController(String commaSeperatedString){//parameter constructor
                String[] dataRow = commaSeperatedString.split(",");
                super.setPostRefferenceNo(Integer.parseInt(dataRow[0]));
                setRecievedToName(dataRow[1]);
                setRecievedFrom(dataRow[2]);
                setRecievedFromAddress(dataRow[3]);
                super.setPostNote(dataRow[4]);
                super.setPostDateObj(new date(dataRow[5]));
                
     }
    
@Override
public String toString(){
        return  getPostRefferenceNo()+","+//0
                getRecievedToName()+","+//1
                getRecievedFrom()+","+//2
                getRecievedFromAddress()+","+//3
                super.getPostNote()+","+//4
                super.getPostDateObj().toString();//5
}

    public recievedPostController(String[] dataRow){
        super(Integer.parseInt(dataRow[0]),
                dataRow[4],
                new date(dataRow[5]));
        setRecievedToName(dataRow[1]);
        setRecievedFrom(dataRow[2]);
        setRecievedFromAddress(dataRow[3]);
        
    }

public boolean objectMathcer(recievedPostController matchObj){
        
        return matchObj.toString().equals(this.toString());
         
}
    

    //getters and setters

    public String getRecievedFrom() {
        return recievedFrom;
    }

    public void setRecievedFrom(String recievedFrom) {
        this.recievedFrom = recievedFrom;
    }

    public String getRecievedFromAddress() {
        return recievedFromAddress;
    }

    public void setRecievedFromAddress(String recievedFromAddress) {
        this.recievedFromAddress = recievedFromAddress;
    }

    public String getRecievedToName() {
        return recievedToName;
    }

    public void setRecievedToName(String recievedToName) {
        this.recievedToName = recievedToName;
    }// end of the getters and setters
    

    




}// end of the recieved post controller class

