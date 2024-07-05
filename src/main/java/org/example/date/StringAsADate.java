package org.example.date;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class StringAsADate {
    public static void main(String[] args) throws ParseException {
        String date="31/12/2024";
        Date date1=new SimpleDateFormat("dd/MM/yyyy").parse(date);
        DateTimeFormatter formatter = DateTimeFormat.forPattern("dd/MM/yyyy");

        String dateInString = "07/06/2013";
        DateTime dateTime = DateTime.parse(dateInString, formatter);
        dateTime.toString();
        System.out.println(dateTime.toString());
    }
}
