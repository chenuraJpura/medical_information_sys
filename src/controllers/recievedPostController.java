package controllers;

public class recievedPostController extends postalController{
    private String recievedFrom;
    private String recievedFromAddress;
    private String recievedToName;

    public recievedPostController(String recievedFrom,
            String recievedFromAddress,
            String recievedToName,
            int postRefferenceNo,
            String postNote,
            date postDateObj) {
        super(postRefferenceNo, postNote, postDateObj);
        this.recievedFrom = recievedFrom;
        this.recievedFromAddress = recievedFromAddress;
        this.recievedToName = recievedToName;
    }

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
    }
    
    @Override
    public String toString(){
        return  getPostRefferenceNo()+","+
                getRecievedToName()+","+
                getRecievedFrom()+","+
                getRecievedFromAddress()+","+
                super.getPostNote()+","+
                super.getPostDateObj().toString();}
}
