package controllers;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JLabel;

public class ClockController implements Runnable{
  Thread t=null;  
    int hours=0, minutes=0, seconds=0;  
    String timeString = "";  
    JLabel b;  
      
    ClockController(JLabel clockLabel){  
          
        t = new Thread(this); 
        this.b=clockLabel;
        t.start();  
          
       
    }  
      
     public void run() {  
          try {  
             while (true) {  
      
                Calendar cal = Calendar.getInstance();  
                hours = cal.get( Calendar.HOUR_OF_DAY );  
                if ( hours > 12 ) hours -= 12;  
                minutes = cal.get( Calendar.MINUTE );  
                seconds = cal.get( Calendar.SECOND );  
      
                SimpleDateFormat formatter = new SimpleDateFormat("hh:mm:ss");  
                Date date = cal.getTime();  
                timeString = formatter.format( date );  
      
                printTime();  
      
                t.sleep( 1000 );  // interval given in milliseconds  
             }  
          }  
          catch (Exception e) { }  
     }  
      
    public void printTime(){  
    b.setText(timeString);  
    }  
      
    }  


    

