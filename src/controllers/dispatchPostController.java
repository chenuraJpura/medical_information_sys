/*
NAME-MedlifoSystem
VERSION-2.0
TITE-dispatchpostPost controller
DESCRIPTION-handle the dispatchpostPost  controller
*/
package controllers;

//start the dispatchpostPost class
public class dispatchPostController extends postalController{
    private String dispatchToName;//declare veriables of name
    private String dispatchAddress;//declare veriables of address
    private String dispatchFromName;//declare veriables of fromName

    public dispatchPostController(String dispatchToName, //create default constructor
            String dispatchAddress,
            String dispatchFromName,
            int postRefferenceNo, 
            String postNote, 
            date postDateObj) {
        super(postRefferenceNo, postNote, postDateObj);
        this.setDispatchToName ( dispatchToName);
        this.setDispatchAddress( dispatchAddress);
        this.setDispatchFromName( dispatchFromName);
    }
    //end of the constructor
    
    @Override
    public String toString(){//return the values by tostring methode
        return  getPostRefferenceNo()+","+
                getDispatchToName()+","+
                getDispatchFromName()+","+
                getDispatchAddress()+","+
                super.getPostNote()+","+
                super.getPostDateObj().toString();
    }
    
    //Setters and getters
    public String getDispatchToName() {
        return dispatchToName;
    }

    public void setDispatchToName(String dispatchToName) {
        this.dispatchToName = dispatchToName;
    }

    public String getDispatchAddress() {
        return dispatchAddress;
    }

    public void setDispatchAddress(String dispatchAddress) {
        this.dispatchAddress = dispatchAddress;
    }

    public String getDispatchFromName() {
        return dispatchFromName;
    }

    public void setDispatchFromName(String dispatchFromName) {
        this.dispatchFromName = dispatchFromName;
    }
    
    //END OF Setters and getters
    
}//end of the dispatchpostPost class
