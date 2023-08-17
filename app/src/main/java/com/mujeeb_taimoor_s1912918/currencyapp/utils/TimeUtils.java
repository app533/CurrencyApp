// Timoor Mujeeb - s1912918
package com.mujeeb_taimoor_s1912918.currencyapp.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class TimeUtils {

    public static String getUTCstring() {
        SimpleDateFormat sdf = new SimpleDateFormat("EEE MMM dd yyyy HH:mm:ss");
        sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
        String date = sdf.format(new Date().getTime());
        if (!date.contains("UTC")) {
            date += " UTC";
        }
        return date;
    }
}
