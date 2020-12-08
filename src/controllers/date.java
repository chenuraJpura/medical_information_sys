/*
NAME-MedlifoSystem
VERSION-2.0
TITE-date controller
DESCRIPTION-handle the date controller
*/
package controllers;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class date {//start of the date class

    private int day; //declare veriables of day
    private int month;//declare veriables of month
    private int year;//declare veriables of year


    public date(String dateString){ //create constructor
        String[] resultString=dateString.split("[/]", 0);
            this.setDay(Integer.parseInt(resultString[0]));
            this.setMonth(Integer.parseInt(resultString[1]));
            this.setYear(Integer.parseInt(resultString[2]));
            
    }//End of the constructor

    public date(int day, int month, int year) {
        this.setDay (day);
        this.setMonth( month);
        this.setYear ( year);
    }
    // getters and setters
    public void setDay(int day) {
        this.day = day;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public void setYear(int year) {
        this.year = year;
    }//END OF Setters and getters
    
    public date(){//default constructor set the current date for object
         DateTimeFormatter yearFormat = DateTimeFormatter.ofPattern("yyyy");
         DateTimeFormatter monthFormat = DateTimeFormatter.ofPattern("MM");
         DateTimeFormatter dayFormat = DateTimeFormatter.ofPattern("dd");
         
         LocalDateTime now = LocalDateTime.now();  
         this.year=Integer.parseInt(yearFormat.format(now));
         this.month=Integer.parseInt(monthFormat.format(now));
         this.day=Integer.parseInt(dayFormat.format(now));
    }
    
    @Override
    public String toString(){  //return the values by tostring methode
        return this.day+"//"+this.month+"//"+this.year;
    }
    
    
    
    
}// end of the date controller
