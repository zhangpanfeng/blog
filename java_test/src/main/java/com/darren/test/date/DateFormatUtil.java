package com.darren.test.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

/**
 * 日期格式化工具
 * 
 * @author zhangpanfeng
 * 
 */
public class DateFormatUtil {
    /**
     * 字符串转日期
     * 
     * @param source
     *            源数据
     * @param format
     *            格式
     * @return 日期
     */
    public static Date stringToDate(String source, String format) {
        // SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        // yyyy年MM月dd日 HH时mm分ss秒
        // 字符串转换为日期
        SimpleDateFormat dateFormat = new SimpleDateFormat(format);
        Date date = null;
        try {
            date = dateFormat.parse(source);
        } catch (ParseException e) {
            String message = "字符串转换日期格式失败！";
            System.out.println(message);
        }

        return date;
    }

    /**
     * 日期转字符串
     * 
     * @param date
     *            源数据
     * @param format
     *            格式
     * @return 字符串
     */
    public static String dateToString(Date date, String format) {

        SimpleDateFormat dateFormat = new SimpleDateFormat(format);
        String stringResult = dateFormat.format(date);

        return stringResult;
    }

    /**
     * 获取年份
     * 
     * @return 年
     */
    public static int getYear() {
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH) + 1;
        System.out.println(month);
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(day);
        int hour = calendar.get(Calendar.HOUR);
        int hours = calendar.get(Calendar.HOUR_OF_DAY);
        System.err.println(hour + "-" + hours);
        return year;
    }

    /**
     * 获取随机数
     * 
     * @param i
     *            参数
     * @return
     */
    public static int getRandom(int i) {
        Random random = new Random();
        int number = random.nextInt(i);

        return number;
    }
}
