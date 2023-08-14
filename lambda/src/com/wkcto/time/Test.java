package com.wkcto.time;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.ChronoUnit;

/**
 * java.time包中线程安全的日期类
 * Author : 动力节点老崔
 */
public class Test {
    public static void main(String[] args) {
        //1)LocalDate日期类
        LocalDate date = LocalDate.now();   //当前日期
        System.out.println( date );     //2019-04-24

        //2)当前时间
        LocalTime time = LocalTime.now();
        System.out.println( time );     //19:50:35.344

        //3)日期与时间
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now);        //2019-04-24T19:51:03.726

        //4)返回当前日期的各个属性值
        System.out.println( now.getYear());
        System.out.println( now.getMonthValue());
        System.out.println( now.getDayOfMonth());
        System.out.println( now.getHour());
        System.out.println( now.getMinute());
        System.out.println( now.getSecond());
        System.out.println( now.getNano());     //在毫秒数后面添加6个0

        //5)自定义时间
        LocalDateTime another = LocalDateTime.of(2100, 10, 12, 8, 58, 28);
        System.out.println( another );

        //6)使用plus增加时间, minus可以减少时间
        another = another.plusYears(1);
        System.out.println(another);

        another = another.plusMonths(1);
        System.out.println(another);

        another = another.plusDays(1);
        System.out.println(another);

        another = another.plusHours(1);
        System.out.println(another);

        another = another.plusMinutes(1);
        System.out.println(another);

        another = another.plusSeconds(1);
        System.out.println(another);

        another = another.plus(10, ChronoUnit.YEARS);
        System.out.println(another);

        //7)设置时间
        another = another.withYear(2088);
        another = another.withMonth(7);
        System.out.println( another);

        //8)判断星期几
        System.out.println( another.getDayOfWeek());

        //9)把日期转换为指定格式的字符串
        DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.LONG);
        //LocalDateTime类中有一个format( DateTimeFormatter) 实例方法可以把日期转换为指定格式字符串
        System.out.println( now.format(formatter) );        //2019年4月24日 下午08时03分28秒

        formatter = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT);
        System.out.println( now.format(formatter));     //19-4-24 下午8:03

        //自定义日期格式: y年, M月 d日 H小时 m分钟 s秒 S毫秒
        formatter = DateTimeFormatter.ofPattern("yyyy年MM月dd日 HH:mm:ss SSS");
        System.out.println( now.format(formatter));  //2019年04月24日 20:05:16 338

        //10)把字符串转换为日期
        String text = "2089年8月12日 8:28:58";
        formatter = DateTimeFormatter.ofPattern("yyyy年M月dd日 H:mm:ss");
        // LocalDateTime.parse(text, formatter)静态方法,可以把text文件以formatter格式转换为日期对象
        another = LocalDateTime.parse(text, formatter);
        System.out.println(another);

    }
}
