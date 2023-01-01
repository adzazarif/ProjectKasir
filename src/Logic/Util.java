/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logic;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author WINDOWS 10
 */
public class Util {
        public int rentangWaktu = 30;
      public String date(){
        LocalDateTime myDateObj = LocalDateTime.now();   
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("yyyy-MM-dd");  
        String formattedDate = myDateObj.format(myFormatObj);  
        return formattedDate;
    }
      
        public String dateStart(){
        LocalDateTime myDateObj = LocalDateTime.now();   
            DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("yyyy-MM-dd 00-00-00");  
        String formattedDate = myDateObj.format(myFormatObj);  
        return formattedDate;
    }
    public String dateEnd(){
        LocalDateTime myDateObj = LocalDateTime.now();   
            DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("yyyy-MM-dd 23-59-59");  
        String formattedDate = myDateObj.format(myFormatObj);  
        return formattedDate;
    }
        public String dateMonthAgo(){
        LocalDate thirtyDaysAgo = LocalDate.parse(date()).minusDays(30);
        return String.valueOf(thirtyDaysAgo);
    }
        
        public String dateExp(){
        Date dt = new Date();
        Calendar c = Calendar.getInstance(); 
        c.setTime(dt); 
        c.add(Calendar.DATE, rentangWaktu);
        dt = c.getTime();
        SimpleDateFormat dt1 = new SimpleDateFormat("yyyy-MM-dd");
        String result = dt1.format(dt);
        return result;
    }
    public String dateFull(){
        LocalDateTime myDateObj = LocalDateTime.now();  
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("E, MMM dd yyyy ");  
        String formattedDate = myDateObj.format(myFormatObj);  
        return formattedDate;
    } 
    
}
