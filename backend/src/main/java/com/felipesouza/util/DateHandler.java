package com.felipesouza.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateHandler {

    public static Date fromString(String date) {
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
        Date converted;
        try {
            converted = dateFormatter.parse(date);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        return converted;
    }
}
