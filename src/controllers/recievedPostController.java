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
    public recievedPostController(String recievedFrom,
            String recievedFromAddress,
            String recievedToName,
            int postRefferenceNo,
            String postNote,
            date postDateObj) {
        super(postRefferenceNo, postNote, postDateObj);
        this.setRecievedFrom (recievedFrom);
        this.setRecievedFromAddress (recievedFromAddress);
        this.setRecievedToName (recievedToName);
    }
    //parameter constructor
    public recievedPostController(String[] dataRow){
        super(Integer.parseInt(dataRow[0]),
                dataRow[4],
                new date(dataRow[5]));
        setRecievedToName(dataRow[1]);
        setRecievedFrom(dataRow[2]);
        setRecievedFromAddress(dataRow[3]);
        
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
    
    //create an instance methode
    public boolean objectMathcer(recievedPostController matchObj){
        
        return matchObj.toString().equals(this.toString());
         
    }
    
    @Override
    public String toString(){//here return the values by toString methode
        return  getPostRefferenceNo()+","+
                getRecievedToName()+","+
                getRecievedFrom()+","+
                getRecievedFromAddress()+","+
                super.getPostNote()+","+
                super.getPostDateObj().toString();
    }
}// end of the recieved post controller class
