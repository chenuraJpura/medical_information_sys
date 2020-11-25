package controllers;

public class recievedPostController extends postalController{
    private String recievedFrom;
    private String recievedFromAddress;
    private String recievedToName;

    public recievedPostController(String recievedFrom, String recievedFromAddress, String recievedToName, int postRefferenceNo, String postNote, date postDateObj) {
        super(postRefferenceNo, postNote, postDateObj);
        this.recievedFrom = recievedFrom;
        this.recievedFromAddress = recievedFromAddress;
        this.recievedToName = recievedToName;
    }

    
    
    
    
    
}
