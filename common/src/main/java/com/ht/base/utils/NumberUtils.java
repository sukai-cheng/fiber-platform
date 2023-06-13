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

    public static String addNum(String str) {
        String numStr = str.substring(str.length() - 4); //取出最后四位数字
        if (!StringUtils.isEmpty(numStr)) { //如果最后四位不是数字，抛NumberFormatException异常
            int n = numStr.length(); //取出字符串的长度
            int num = Integer.parseInt(numStr) + 1; //将该数字加一
            String added = String.valueOf(num);
            n = Math.min(n, added.length());
            //拼接字符串
            return str.subSequence(0, str.length() - n) + added;
        } else {
            throw new NumberFormatException();
        }
    }

    public static String addNum2(String str) {
        String numStr = str.substring(str.length() - 2); //取出最后两位数字
        if (!StringUtils.isEmpty(numStr)) { //如果最后四位不是数字，抛NumberFormatException异常
            int n = numStr.length(); //取出字符串的长度
            int num = Integer.parseInt(numStr) + 1; //将该数字加一
            String added = String.valueOf(num);
            n = Math.min(n, added.length());
            //拼接字符串
            return str.subSequence(0, str.length() - n) + added;
        } else {
            throw new NumberFormatException();
        }
    }

    public static void main(String[] args) {
        System.out.println(addNum2("00"));
    }

}
