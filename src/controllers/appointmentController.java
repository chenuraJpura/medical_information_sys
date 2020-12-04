
package controllers;

public class appointmentController {
    //appointment var defined
    private String appPatientName;
    private date appDate;
    private time appTime;
    private String appSymptoms;
    private String appConclution;
    private String appStatus;
    //default constructor
    public appointmentController(String appPatientName, date appDate, time appTime, String appSymptoms, String appConclution, String appStatus) {
        this.appPatientName = appPatientName;
        this.appDate = appDate;
        this.appTime = appTime;
        this.appSymptoms = appSymptoms;
        this.appConclution = appConclution;
        this.appStatus = appStatus;
    }

    @Override
    public String toString(){
        return getAppPatientName()+","+
               appDate.toString()+","+
               appTime.toString()+","+
               getAppSymptoms()+","+
               getAppConclution()+","+
               getAppStatus() ;
    }
    
    public String getAppPatientName() {
        return appPatientName;
    }

    public void setAppPatientName(String appPatientName) {
        this.appPatientName = appPatientName;
    }
//getter and setter
    public date getAppDate() {
        return appDate;
    }

    public void setAppDate(date appDate) {
        this.appDate = appDate;
    }

    public time getAppTime() {
        return appTime;
    }

    public void setAppTime(time appTime) {
        this.appTime = appTime;
    }

    public String getAppSymptoms() {
        return this.appSymptoms;
    }

    public void setAppSymptoms(String appSymptoms) {
        this.appSymptoms = appSymptoms;
    }

    public String getAppConclution() {
        return appConclution;
    }

    public void setAppConclution(String appConclution) {
        this.appConclution = appConclution;
    }

    public String getAppStatus() {
        return appStatus;
    }

    public void setAppStatus(String appStatus) {
        this.appStatus = appStatus;
    }
    
    
    



    
}
