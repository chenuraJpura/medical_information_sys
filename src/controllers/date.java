
package controllers;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class date {
    private int day;
    private int month;
    private int year;

    public date(String dateString){
        String[] resultString=dateString.split("[/]", 0);
            this.day=Integer.parseInt(resultString[0]);
            this.month=Integer.parseInt(resultString[1]);
            this.year=Integer.parseInt(resultString[2]);
            
    }

    public date(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public void setYear(int year) {
        this.year = year;
    }
    
    public date(){//default constructor set the current date for object
         DateTimeFormatter yearFormat = DateTimeFormatter.ofPattern("yyyy");
         DateTimeFormatter monthFormat = DateTimeFormatter.ofPattern("MM");
         DateTimeFormatter dayFormat = DateTimeFormatter.ofPattern("dd");
         
         LocalDateTime now = LocalDateTime.now();  
         this.year=Integer.parseInt(yearFormat.format(now));
         this.month=Integer.parseInt(monthFormat.format(now));
         this.day=Integer.parseInt(dayFormat.format(now));
    }
    
    public String toString(){
        return this.day+"/"+this.month+"/"+this.year;
    }
    
    //rename ready to string
    public String RenameReadyToString(){
        return this.day+"_"+this.month+"_"+this.year;
    }
    

    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }
    
    
    
    
    
}
