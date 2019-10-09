package com.enlie.blog.tool;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormatUtils {
    public static String format(Date date,String pattern){
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        return sdf.format(date);
    }
}
