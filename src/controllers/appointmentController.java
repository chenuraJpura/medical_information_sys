package controllers;

public class appointmentController {
    //appointment var defined
    private String appPatientName;
    private date appDate;
    private time appTime;
    private String appSymptoms;
    private String appStatus;
    private String medicalOfficersFullName;
    private int appRefNo;
    //default constructor
    
    public appointmentController(
            String appPatientName,
            String medicalOfficersFullName,
            date appDate,
            time appTime, 
            String appSymptoms, 
            String appStatus,
            int appRefNo) {
        this.appPatientName = appPatientName;
        this.medicalOfficersFullName=medicalOfficersFullName;
        this.appDate = appDate;
        this.appTime = appTime;
        this.appSymptoms = appSymptoms;
        this.appStatus = appStatus;
        setAppRefNo(appRefNo);
    }
    public appointmentController(String commaSeperatedString){
    String[] dataRow = commaSeperatedString.split(",");
                setAppPatientName(dataRow[0]);
                setMedicalOfficersFullName(dataRow[1]);
                setAppDate(new date(dataRow[2]));
                setAppTime(new time(dataRow[3]));
                setAppSymptoms(dataRow[4]);
                setAppStatus(dataRow[5]);
                setAppRefNo(Integer.parseInt(dataRow[6]));
    }
            
    public boolean objectMathcer(appointmentController matchObj){
        return matchObj.toString().equals(this.toString());
    }

    public String getMedicalOfficersFullName() {
        return medicalOfficersFullName;
    }

    public void setMedicalOfficersFullName(String medicalOfficersFullName) {
        this.medicalOfficersFullName = medicalOfficersFullName;
    }
    
    @Override
    public String toString(){
        return getAppPatientName()+","+
               getMedicalOfficersFullName()+","+
               appDate.toString()+","+
               appTime.toString()+","+
               getAppSymptoms()+","+
               getAppStatus()+","+
               getAppRefNo();
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

    public String getAppStatus() {
        return appStatus;
    }

    public void setAppStatus(String appStatus) {
        this.appStatus = appStatus;
    }

    public int getAppRefNo() {
        return appRefNo;
    }

    public void setAppRefNo(int appRefNo) {
        this.appRefNo = appRefNo;
    }
  
}
