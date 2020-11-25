package controllers;

public class postalController {
    private int postRefferenceNo;
    private String postNote;
    private date postDateObj;

    public postalController(int postRefferenceNo, String postNote, date postDateObj) {
        this.postRefferenceNo = postRefferenceNo;
        this.postNote = postNote;
        this.postDateObj = postDateObj;
    }

    
    
    public int getPostRefferenceNo() {
        return postRefferenceNo;
    }

    public void setPostRefferenceNo(int postRefferenceNo) {
        this.postRefferenceNo = postRefferenceNo;
    }

    public String getPostNote() {
        return postNote;
    }

    public void setPostNote(String postNote) {
        this.postNote = postNote;
    }

    public date getPostDateObj() {
        return postDateObj;
    }

    public void setPostDateObj(date postDateObj) {
        this.postDateObj = postDateObj;
    }
    
    
}
