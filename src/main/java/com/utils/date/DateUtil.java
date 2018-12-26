package com.utils.date;

import com.utils.string.StringUtil;
import lombok.extern.slf4j.Slf4j;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author liuxi
 * @since 2018-12-25
 */
@Slf4j
public final class DateUtil {

    public static final String yyyy_MM_dd = "yyyy-MM-dd";
    public static final String yyyyMMdd = "yyyyMMdd";
    public static final String yyyy_MM_dd_HH_mm_ss = "yyyy-MM-dd HH:mm:ss";
    public static final String yyyy_MM_dd_HH_mm = "yyyy-MM-dd HH:mm";
    public static final String yyyyMMddHHmmss = "yyyyMMddHHmmss";
    public static final String yyyyMMddHHmm = "yyyyMMddHHmm";

    /**
     * 日期转字符串
     * @param date
     * @param pattern
     * @return
     */
    public static String date2str(Date date, String pattern){
        if (null == date) return null;
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        return sdf.format(date);
    }

    /**
     * 字符串转日期
     * @param s
     * @param pattern
     * @return
     */
    public static Date str2date(String s, String pattern){
        if (StringUtil.isEmpty(s)) return null;
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        try {
            return sdf.parse(s);
        } catch (ParseException e) {
            log.error("", e);
        }
        return null;
    }

    /**
     * ${filed} 增加 ${inc}
     * @param date
     * @param inc
     * @param field
     * @return
     */
    public static Date add(Date date, int inc, int field){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);

        calendar.add(field, inc);
        return calendar.getTime();
    }

    /**
     * 日期增加 ${inc}
     * @param date
     * @param inc
     * @return
     */
    public static Date addDay(Date date, int inc) {
        return add(date, inc, Calendar.DAY_OF_MONTH);
    }

    /**
     * 月份增加 ${inc}
     * @param date
     * @param inc
     * @return
     */
    public static Date addMonth(Date date, int inc) {
        return add(date, inc, Calendar.MONTH);
    }
}
