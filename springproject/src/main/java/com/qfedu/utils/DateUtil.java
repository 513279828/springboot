package com.qfedu.utils;

import java.util.Calendar;
import java.util.Date;

// 获取当前日期
public class DateUtil {
    // 获取指定年的今天
    public static Date addYear(int y) {
        // 日历类 完成实例化
        Calendar calendar = Calendar.getInstance();
        // 计算日期
        calendar.add(Calendar.YEAR, y);
        return calendar.getTime();
    }
}
