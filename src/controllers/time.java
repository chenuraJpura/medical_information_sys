
package controllers;

import com.bulenkov.darcula.ui.DarculaButtonPainter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class time {
    private int minutes;
    private int hours;
    private String AmPmState;

    public time(String timeString){
        String[] resultString=timeString.split(":", 0);
            this.hours=Integer.parseInt(resultString[0]);
            
            resultString=resultString[1].split(" ");
            this.minutes=Integer.parseInt(resultString[0]);
            this.AmPmState=resultString[1];
            
    }
    
    public time(int minutes, int hours, String AmPmState) {
        this.minutes = minutes;
        this.hours = hours;
        this.AmPmState = AmPmState;
    }
    
    public time(){
        DateTimeFormatter hoursFormat = DateTimeFormatter.ofPattern("HH");
        DateTimeFormatter minutesFormat = DateTimeFormatter.ofPattern("mm");
        DateTimeFormatter AmPmFormat = DateTimeFormatter.ofPattern("a");
        
        LocalDateTime now = LocalDateTime.now();  
        this.hours=Integer.parseInt(hoursFormat.format(now));
        this.minutes=Integer.parseInt(minutesFormat.format(now));
        this.AmPmState=AmPmFormat.format(now);
    }

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
    
    @Override
    public String toString(){
        return getHours()+":"+
                getMinutes()+" "+
                getAmPmState();
    }
}
