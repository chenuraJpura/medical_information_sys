/*
NAME-MedlifoSystem
VERSION-2.0
TITE-time controller
DESCRIPTION-handle the time controller
*/
package controllers;

import com.bulenkov.darcula.ui.DarculaButtonPainter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
//start of the time class
public class time {
    private int minutes;//declare veriables of minutes
    private int hours;//declare veriables of hours
    private String AmPmState;//declare veriables of AmPmstate

    public time(int minutes, int hours, String AmPmState) {
        this.setMinutes (minutes);
        this.setHours (hours);
        this.setAmPmState(AmPmState);
    }
    
    public time(){//create default constructor
        DateTimeFormatter hoursFormat = DateTimeFormatter.ofPattern("HH");
        DateTimeFormatter minutesFormat = DateTimeFormatter.ofPattern("mm");
        DateTimeFormatter AmPmFormat = DateTimeFormatter.ofPattern("a");
        
        LocalDateTime now = LocalDateTime.now();  
        this.setHours(Integer.parseInt(hoursFormat.format(now)));
        this.setMinutes(Integer.parseInt(minutesFormat.format(now)));
        this.setAmPmState(AmPmFormat.format(now));
    }//End of the default constructor
    
    // Setters and getters
    public int getMinutes() {
        return minutes;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public String getAmPmState() {
        return AmPmState;
    }

    public void setAmPmState(String AmPmState) {
        this.AmPmState = AmPmState;
    }
    //END OF Setters and getters
    
    //return the values by tostring methode
    @Override
    public String toString(){
        return getHours()+":"+
                getMinutes()+getAmPmState();
    }
}// end of the date class
