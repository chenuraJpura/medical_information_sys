package controllers;

import model.ReferenceModel;

public class referenceController {
    private String complainDepartment;
    private String specializedArea;
    private boolean state;
    public referenceController(
            String newItem,boolean state
    ) {
        this.state=state;
        if(state==true){
        
            setComplainDepartment(newItem);
        
        }else if(state==false){
            
            setSpecializedArea(newItem);
            
        }
        
    }

    public void newRecord(){
        if(isState()==true){
            ReferenceModel.writingDepartment(getComplainDepartment());
        }else if(isState()==false){
           ReferenceModel.writingSpecializedArea(getSpecializedArea());
        }
    }

    public boolean isState() {
        return state;
    }
    public String getComplainDepartment() {
        return complainDepartment;
    }

    public void setComplainDepartment(String complainDepartment) {
        this.complainDepartment = complainDepartment;
    }

    public String getSpecializedArea() {
        return specializedArea;
    }

    public void setSpecializedArea(String specializedArea) {
        this.specializedArea = specializedArea;
    }
    
    
    
    
}
