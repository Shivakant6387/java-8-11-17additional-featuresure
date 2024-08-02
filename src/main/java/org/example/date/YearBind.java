package org.example.date;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

public class YearBind {
    public static void main(String[] args) {
        Date date =Calendar.getInstance().getTime();
        SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
        String dates=dateFormat.format(date);
        System.out.println(dates);
        LocalDate currentDate = LocalDate.now();
        int currentYear = currentDate.getYear();
        System.out.println("Current Year: " + currentYear);
        int oldYear=2024;
        int total=0;
        total=currentYear-oldYear;
        System.out.println(total);
    }
}
