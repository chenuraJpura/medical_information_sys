/*
Name       : medical information system (Team 09)
version    : 2.0
Title      : postalController.java
Description: handle the postalController class
*/
package controllers;

public class postalController {// start of the postalController class
    // declare the private variables
    private int postRefferenceNo;
    private String postNote;
    private date postDateObj;
            
    //create default constructors
    public postalController(int postRefferenceNo, String postNote, date postDateObj) {
        this.setPostRefferenceNo (postRefferenceNo);
        this.setPostNote (postNote);
        this.setPostDateObj (postDateObj);
    }

    
    // start getters and setters for variables
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
    }// end of the getters and setters
    
    
}// end of the postalController class
