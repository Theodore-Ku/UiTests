package com.threadqa.utils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class DateFormatter {

    public String formatDate(String day, String month, String year, String format) {
        LocalDate oldDate = LocalDate.parse(day + " " + month + " " + year,
                DateTimeFormatter.ofPattern("dd MMMM yyyy", Locale.UK));
        return oldDate.format(DateTimeFormatter.ofPattern(format, Locale.UK));
    }

    public String formatDateAndTime(String day, String month,
                                    String year, String time, String format) {
        LocalDateTime oldDate = LocalDateTime.parse(day + " " + month + " " + year + " " + time,
                DateTimeFormatter.ofPattern("dd MMMM yyyy HH:mm", Locale.ENGLISH));
        return oldDate.format(DateTimeFormatter.ofPattern(format, Locale.ENGLISH));
    }

}
