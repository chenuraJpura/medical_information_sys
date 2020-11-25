package controllers;

public class dispatchPostController extends postalController{
    private String dispatchToName;
    private String dispatchAddress;
    private String dispatchFromName;

    public dispatchPostController(String dispatchToName, String dispatchAddress, String dispatchFromName, int postRefferenceNo, String postNote, date postDateObj) {
        super(postRefferenceNo, postNote, postDateObj);
        this.dispatchToName = dispatchToName;
        this.dispatchAddress = dispatchAddress;
        this.dispatchFromName = dispatchFromName;
    }
    
    
    
}
