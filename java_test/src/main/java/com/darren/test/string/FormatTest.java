package com.darren.test.string;

import java.util.Date;

import com.darren.test.date.DateFormatUtil;

public class FormatTest {

    public static void main(String[] args) {
        System.out.println(DateFormatUtil.dateToString(new Date(), "yyyy-MM-dd HH:mm:ss"));
        System.out.println(DateFormatUtil.stringToDate("2015-04-29 11:21:30", "yyyy-MM-dd HH:mm:ss"));
        System.out.println(DateFormatUtil.getYear());

        StringFormatUtil.stringFormat(11);
        StringFormatUtil.stringFormat(11111);

        StringFormatUtil.numberFormat(11);
        StringFormatUtil.numberFormat(11111);

    }

}
