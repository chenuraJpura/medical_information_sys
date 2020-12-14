package controllers;

public class dispatchPostController extends postalController{
    private String dispatchToName;
    private String dispatchAddress;
    private String dispatchFromName;
   
    public dispatchPostController(String[] dataRow){
        super(Integer.parseInt(dataRow[0]),dataRow[4],new date(dataRow[5]));
        setDispatchToName(dataRow[1]);
        setDispatchAddress(dataRow[2]);
        setDispatchFromName(dataRow[3]);
        this.dispatchFromName = dispatchFromName;
    }
    
    public dispatchPostController(String commaSeperatedString){
     String[] dataRow = commaSeperatedString.split(",");
                super.setPostRefferenceNo(Integer.parseInt(dataRow[0]));
                setDispatchToName(dataRow[1]);
                setDispatchFromName(dataRow[2]);
                setDispatchAddress(dataRow[3]);
                super.setPostNote(dataRow[4]);
                super.setPostDateObj(new date(dataRow[5]));
    
    }
    
    public dispatchPostController(
            int postRefferenceNo,
            String dispatchToName,
            String dispatchFromName,
            String dispatchAddress,
            String postNote, 
            date postDateObj) {
        super(postRefferenceNo, postNote, postDateObj);
        this.dispatchToName = dispatchToName;
        this.dispatchAddress = dispatchAddress;
        this.dispatchFromName = dispatchFromName;
    }
 public boolean objectMathcer(dispatchPostController matchObj){
        
        return matchObj.toString().equals(this.toString());
         
    }

    // create a parameter constructor
    public dispatchPostController(String[] dataRow){
        super(Integer.parseInt(dataRow[0]),dataRow[4],new date(dataRow[5]));
        setDispatchToName(dataRow[1]);
        setDispatchAddress(dataRow[2]);
        setDispatchFromName(dataRow[3]);
        this.dispatchFromName = dispatchFromName;
    }
    
    @Override
    public String toString(){//return the values by tostring methode
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
    }//END OF Setters and getters
    

    
    
}
