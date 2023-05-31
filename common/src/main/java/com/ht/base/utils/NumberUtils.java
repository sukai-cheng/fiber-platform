package com.ht.base.utils;

import java.text.DecimalFormat;

/**
 * @author chengsukai
 */
public class NumberUtils {


    /***
     * 保留2位小数
     * @param floatValue
     * @return
     */
    public static float scale(Float floatValue)
    {
        DecimalFormat format = new DecimalFormat("#.00");
        String scaled = format.format(floatValue);
        return Float.parseFloat(scaled);
    }
}
