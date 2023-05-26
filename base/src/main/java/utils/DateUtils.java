package utils;


import org.apache.commons.lang.StringUtils;
import org.joda.time.DateTime;
import org.joda.time.LocalDate;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 日期处理
 *
 * @author chengsukai
 */
public class DateUtils {
    /**
     * 时间格式(yyyy-MM-dd)
     */
    public final static String DATE_PATTERN = "yyyy-MM-dd";
    /**
     * 时间格式(yyyy-MM-dd HH:mm:ss)
     */
    public final static String DATE_TIME_PATTERN = "yyyy-MM-dd HH:mm:ss";

    public final static String DAY_PATTERN = "MM-dd";

    public final static String DATE_MINUTE = "yyyy-MM-dd HH:mm";

    public final static String TIME = "HH,mm,ss";

    public final static String DETAIL_TIME = "HH:mm:ss";

    public final static String MONTH_DATE = "yyyy-MM";

    /**
     * 日期格式化 日期格式为：yyyy-MM-dd
     *
     * @param date 日期
     * @return 返回yyyy-MM-dd格式日期
     */
    public static String format(Date date) {
        return format(date, DATE_PATTERN);
    }

    public static String getHourTime(Date date) {
        String str = format(date, TIME);

        return str + "*";
    }

    public static String getMonthTime(Date date) {

        return format(date, MONTH_DATE);
    }

    public static String dateTimeFormat(Date date) {
        return format(date, DATE_TIME_PATTERN);
    }

    /**
     * 日期格式化 日期格式为：yyyy-MM-dd
     *
     * @param date    日期
     * @param pattern 格式，如：DateUtils.DATE_TIME_PATTERN
     * @return 返回yyyy-MM-dd格式日期
     */
    public static String format(Date date, String pattern) {
        if (date != null) {
            SimpleDateFormat df = new SimpleDateFormat(pattern);
            return df.format(date);
        }
        return null;
    }

    /**
     * 字符串转换成日期
     *
     * @param strDate 日期字符串
     * @param pattern 日期的格式，如：DateUtils.DATE_TIME_PATTERN
     */
    public static Date stringToDate(String strDate, String pattern) {
        if (StringUtils.isBlank(strDate)) {
            return null;
        }

        DateTimeFormatter fmt = DateTimeFormat.forPattern(pattern);
        return fmt.parseLocalDateTime(strDate).toDate();
    }

    /**
     * 用于计算1900-0-1之后的day天日期是哪天 举例：1900-0-1之后的44326天日期是2021/5/10
     */
    public static String dayToDate(int day) {

        Calendar calendar = new GregorianCalendar(1900, Calendar.JANUARY, -1);
        Date d = calendar.getTime();

        Date date = DateUtils.addDateDays(d, day);

        return format(date, DATE_TIME_PATTERN);
    }

    /**
     * 根据周数，获取开始日期、结束日期
     *
     * @param week 周期 0本周，-1上周，-2上上周，1下周，2下下周
     * @return 返回date[0]开始日期、date[1]结束日期
     */
    public static Date[] getWeekStartAndEnd(int week) {
        DateTime dateTime = new DateTime();
        LocalDate date = new LocalDate(dateTime.plusWeeks(week));

        date = date.dayOfWeek().withMinimumValue();
        Date beginDate = date.toDate();
        Date endDate = date.plusDays(6).toDate();
        return new Date[]{beginDate, endDate};
    }

    /**
     * 对日期的【秒】进行加/减
     *
     * @param date    日期
     * @param seconds 秒数，负数为减
     * @return 加/减几秒后的日期
     */
    public static Date addDateSeconds(Date date, int seconds) {
        DateTime dateTime = new DateTime(date);
        return dateTime.plusSeconds(seconds).toDate();
    }

    /**
     * 对日期的【分钟】进行加/减
     *
     * @param date    日期
     * @param minutes 分钟数，负数为减
     * @return 加/减几分钟后的日期
     */
    public static Date addDateMinutes(Date date, int minutes) {
        DateTime dateTime = new DateTime(date);
        return dateTime.plusMinutes(minutes).toDate();
    }

    /**
     * 对日期的【小时】进行加/减
     *
     * @param date  日期
     * @param hours 小时数，负数为减
     * @return 加/减几小时后的日期
     */
    public static Date addDateHours(Date date, int hours) {
        DateTime dateTime = new DateTime(date);
        return dateTime.plusHours(hours).toDate();
    }

    /**
     * 对日期的【天】进行加/减
     *
     * @param date 日期
     * @param days 天数，负数为减
     * @return 加/减几天后的日期
     */
    public static Date addDateDays(Date date, int days) {
        DateTime dateTime = new DateTime(date);
        return dateTime.plusDays(days).toDate();
    }

    /**
     * 对日期的【周】进行加/减
     *
     * @param date  日期
     * @param weeks 周数，负数为减
     * @return 加/减几周后的日期
     */
    public static Date addDateWeeks(Date date, int weeks) {
        DateTime dateTime = new DateTime(date);
        return dateTime.plusWeeks(weeks).toDate();
    }

    /**
     * 对日期的【月】进行加/减
     *
     * @param date   日期
     * @param months 月数，负数为减
     * @return 加/减几月后的日期
     */
    public static Date addDateMonths(Date date, int months) {
        DateTime dateTime = new DateTime(date);
        return dateTime.plusMonths(months).toDate();
    }

    /**
     * 对日期的【年】进行加/减
     *
     * @param date  日期
     * @param years 年数，负数为减
     * @return 加/减几年后的日期
     */
    public static Date addDateYears(Date date, int years) {
        DateTime dateTime = new DateTime(date);
        return dateTime.plusYears(years).toDate();
    }

    public static String weekName(int week) {

        Map<Integer, String> map = new HashMap<>();

        map.put(1, "周日");
        map.put(2, "周一");
        map.put(3, "周二");
        map.put(4, "周三");
        map.put(5, "周四");
        map.put(6, "周五");
        map.put(7, "周六");

        return map.get(week);
    }

    /**
     * 比较两个日期相差天数，如2018/08/16 23:59:59 和 2018/08/17 0:0:0相差一天
     */
    public static int differentDays(Date date1, Date date2) {
        Calendar cal1 = Calendar.getInstance();
        cal1.setTime(date1);

        Calendar cal2 = Calendar.getInstance();
        cal2.setTime(date2);
        int day1 = cal1.get(Calendar.DAY_OF_YEAR);
        int day2 = cal2.get(Calendar.DAY_OF_YEAR);

        int year1 = cal1.get(Calendar.YEAR);
        int year2 = cal2.get(Calendar.YEAR);
        if (year1 != year2) // 同一年
        {
            int timeDistance = 0;
            for (int i = year1; i < year2; i++) {
                if (i % 4 == 0 && i % 100 != 0 || i % 400 == 0) // 闰年
                {
                    timeDistance += 366;
                } else // 不是闰年
                {
                    timeDistance += 365;
                }
            }

            return timeDistance + (day2 - day1);
        } else // 不同年
        {
            return day2 - day1;
        }
    }

    public static String getWeek(String time) {

        Calendar cal = Calendar.getInstance();
        cal.setTime(stringToDate(time, DATE_PATTERN));
        int weekIndex = cal.get(Calendar.DAY_OF_WEEK);
        return weekName(weekIndex);
    }

    public static int getTwoTimeMinute(Date firstTime) throws ParseException {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        long currentTime = System.currentTimeMillis();
        // 从对象中拿到时间
        long createTime = df.parse(df.format(firstTime)).getTime();
        long diff = (currentTime - createTime) / 1000 / 60;
        return (int) diff;
    }

    /**
     * 遍历所查的日期
     */
    public static List<Map> obtainDateList(String startTime, String endTime) {
        List<Map> list = new ArrayList<>();

        int s = DateUtils.differentDays(DateUtils.stringToDate(startTime, DateUtils.DATE_PATTERN),
                DateUtils.stringToDate(endTime, DateUtils.DATE_PATTERN));

        for (int i = 0; i <= s; i++) {
            Date date = DateUtils.addDateDays(DateUtils.stringToDate(startTime, DateUtils.DATE_PATTERN), i);
            String time = DateUtils.format(date, DateUtils.DATE_PATTERN);
            Map map = new HashMap();
            map.put("time", time);
            map.put("week", getWeek(time));
            map.put("day_time",
                    DateUtils.format(DateUtils.stringToDate(time, DateUtils.DATE_PATTERN), DateUtils.DAY_PATTERN));
            list.add(map);
        }
        return list;
    }

    public static List<String> getAllMonthDays(String date) {
        int year = Integer.parseInt(date.substring(0, 4));
        int month = Integer.parseInt(date.substring(5));
        Calendar a = Calendar.getInstance();
        a.set(Calendar.YEAR, year);
        a.set(Calendar.MONTH, month - 1);
        a.set(Calendar.DATE, 1);
        a.roll(Calendar.DATE, -1);
        int days = a.get(Calendar.DATE);
        List<String> resultList = new ArrayList<>();
        for (int i = 1; i <= days; i++) {
            String day = null;
            if (i < 10) {

                day = date + "-0" + i;
            } else {
                day = date + "-" + i;
            }
            resultList.add(day);
        }
        return resultList;
    }

    public static String longToDate(long currentTime, String formatType) {
        Date dateOld = new Date(currentTime); // 根据long类型的毫秒数生命一个date类型的时间
        String sDateTime = format(dateOld, formatType); // 把date类型的时间转换为string
        return sDateTime;
    }

    /**
     * 获取当前月第一天
     */
    public static String getFirstDayOfMonth(Date date, Integer a) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int month = cal.get(Calendar.MONTH);
        Calendar calendar = Calendar.getInstance();
        // 设置月份
        calendar.set(Calendar.MONTH, month - a);
        // 获取某月最小天数
        int firstDay = calendar.getActualMinimum(Calendar.DAY_OF_MONTH);
        // 设置日历中月份的最小天数
        calendar.set(Calendar.DAY_OF_MONTH, firstDay);
        // 格式化日期
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String firstDayDate = sdf.format(calendar.getTime()) + " 00:00:00";
        return firstDayDate;
    }

    /**
     * 获取当前月最后一天
     */
    public static String getLastDayOfMonth(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int month = cal.get(Calendar.MONTH);
        Calendar calendar = Calendar.getInstance();
        // 设置月份
        calendar.set(Calendar.MONTH, month - 1);
        // 获取某月最小天数
        int lastDay = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
        // 设置日历中月份的最小天数
        calendar.set(Calendar.DAY_OF_MONTH, lastDay);
        // 格式化日期
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String lastDayDate = sdf.format(calendar.getTime()) + " 23:59:00";
        return lastDayDate;
    }
    // 获取当前年分

    public static String selectCurrentYear() {
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        String year = String.valueOf(cal.get(Calendar.YEAR));

        return year;
    }

    public static String selectCurrentMonth() {
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        String month = String.valueOf(cal.get(Calendar.MONTH) + 1);
        return month;
    }

    /**
     * 获取当前Date型日期
     *
     * @return Date() 当前日期
     */
    public static Date getNowDate() {
        return new Date();
    }

    /**
     * 判断时间范围
     *
     * @return String
     */
    public static String getDuringDay(int hour) {
        if (hour >= 5 && hour < 11) {
            return "上午";
        }
        if (hour >= 11 && hour <= 13) {
            return "中午";
        }
        if (hour >= 14 && hour <= 18) {
            return "下午";
        }
        if (hour >= 18 && hour <= 24) {
            return "夜晚";
        }
        if (hour > 0 && hour < 5) {
            return "凌晨";
        }
        return null;
    }


}
