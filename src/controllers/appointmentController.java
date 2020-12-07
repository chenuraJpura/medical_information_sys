/*
Name       : medical information system (Team 09)
version    : 2.0
Title      : appointmentController.java
Description: handle the appointmentController class
*/
package controllers;

public class appointmentController {//start of the appointment controller
    //Declare the variables of appointment controller

    private String appPatientName;
    private date appDate;
    private time appTime;
    private String appSymptoms;
    private String appConclution;
    private String appStatus;
    //Create the default constructor
    public appointmentController(String appPatientName, date appDate, time appTime, String appSymptoms, String appConclution, String appStatus) {
        this.setAppPatientName(appPatientName);
        this.setAppDate (appDate);
        this.setAppTime (appTime);
        this.setAppSymptoms (appSymptoms);
        this.setAppConclution (appConclution);
        this.setAppStatus (appStatus);
    }

    @Override
    public String toString(){//here return the values by toString methode
        return getAppPatientName()+","+
               appDate.toString()+","+
               appTime.toString()+","+
               getAppSymptoms()+","+
               getAppConclution()+","+
               getAppStatus() ;
    }
    // getters and setters
    public String getAppPatientName() {
        return this.appPatientName;
    }

    public void setAppPatientName(String appPatientName) {
        this.appPatientName = appPatientName;
    }

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
    
    //end of the getters and setters
    

}// end of the appointment controller
