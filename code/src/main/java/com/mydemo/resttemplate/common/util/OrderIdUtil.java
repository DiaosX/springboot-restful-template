package com.mydemo.resttemplate.common.util;

import java.util.Date;

/**
 * @Author yst
 * @Description 订单ID生成帮助类
 * @Date 2022/8/6 21:58
 * @Version 1.0
 */
public class OrderIdUtil {
    private OrderIdUtil() {

    }

    private static Date date = new Date();
    private static StringBuilder buf = new StringBuilder();
    private static int seq = 0;
    private static final int ROTATION = 99999;

    public static synchronized long next() {
        return Long.parseLong(nextStr());
    }

    /**
     * 生成字符串订单ID，一秒内最多生成99999个订单
     */
    public static synchronized String nextStr() {
        if (seq > ROTATION)
            seq = 0;
        buf.delete(0, buf.length());
        date.setTime(System.currentTimeMillis());
        return String.format("%1$tY%1$tm%1$td%1$tk%1$tM%1$tS%2$05d", date, seq++);
    }

}
