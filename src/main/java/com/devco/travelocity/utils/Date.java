package com.devco.travelocity.utils;

import com.devco.travelocity.exceptions.DateException;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;

public class Date {

    private static Calendar day;
    private static Calendar calendar;
    private static LocalDate localDate;
    private static final String FORMAT = "yyyy-MM-dd";

    public static Calendar dateSys() {

        try{
            DateFormat df = new SimpleDateFormat(FORMAT);
            Calendar newCalendar = Calendar.getInstance();
            df.setLenient(false);
            localDate = LocalDate.now();
            newCalendar.setTime(df.parse(localDate.toString()));
            return newCalendar;
        }catch (ParseException e){
            throw new DateException(DateException.MESSAGE_FAILED_GET_DATE, e);
        }

    }

    public static int start(int startDay){
        day = dateSys();
        return day.get(Calendar.DAY_OF_MONTH)+startDay;
    }

    public static int end(int endDay){
        day = dateSys();
        return day.get(Calendar.DAY_OF_MONTH)+endDay;
    }
}
