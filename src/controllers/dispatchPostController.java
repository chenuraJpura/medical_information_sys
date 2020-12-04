package controllers;

public class dispatchPostController extends postalController{
    private String dispatchToName;
    private String dispatchAddress;
    private String dispatchFromName;

    public dispatchPostController(String dispatchToName,
            String dispatchAddress,
            String dispatchFromName,
            int postRefferenceNo, 
            String postNote, 
            date postDateObj) {
        super(postRefferenceNo, postNote, postDateObj);
        this.dispatchToName = dispatchToName;
        this.dispatchAddress = dispatchAddress;
        this.dispatchFromName = dispatchFromName;
    }

    @Override
    public String toString(){
        return  getPostRefferenceNo()+","+
                getDispatchToName()+","+
                getDispatchFromName()+","+
                getDispatchAddress()+","+
                super.getPostNote()+","+
                super.getPostDateObj().toString();
    }


    
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
    
    
    
}
