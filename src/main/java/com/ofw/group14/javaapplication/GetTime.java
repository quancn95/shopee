package com.ofw.group14.javaapplication;

 
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.ofw.group14.entity.Verification;

public class GetTime {

	public static void main(String[] args) { 
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		
		
		String dateStart = "2018-05-26 09:33:58";
        String dateStop = "2018-05-27 09:33:57";
        // Custom date format
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(format.format(timestamp.getTime()));
        System.out.println(timestamp);
        
        Date d1 = null;
        Date d2 = null;
        try {
            d1 = format.parse(dateStart);
            d2 = format.parse(dateStop);
        } catch (ParseException e) {
        }
        // Get msec from each, and subtract.
        long diff = d2.getTime() - d1.getTime();
    	System.out.println(d2.getTime() + " "+  d2.getTime());
        long diffSeconds = diff / 1000;
        long diffMinutes = diff / (60 * 1000);
        long diffHours = diff / (60 * 60 * 1000);
        System.out.println("Số giây : " + diffSeconds + " seconds.");
        System.out.println("Số phút: " + diffMinutes + " minutes.");
        System.out.println("Số giờ: " + diffHours + " hours.");
	}
}
