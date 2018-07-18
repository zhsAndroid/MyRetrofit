package zhs.com.myretrofit.utils;

import android.content.Context;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

import zhs.com.myretrofit.R;
import zhs.com.myretrofit.constant.CommonConstants;
import zhs.com.myretrofit.model.entity.WtsEntity;

/**
 * Created by Zhs on 2017/10/17.
 */
public class TimeUtils {
    public static final SimpleDateFormat DEFAULT_DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");

    public static final SimpleDateFormat TEST_DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd  HH:mm:ss");

    private static String[] weekArray = new String[] { "一", "二", "三", "四", "五", "六", "日" };

    private TimeUtils() {

    }

    public static String getTime(long timeInMillis, SimpleDateFormat dateFormat) {
        return dateFormat.format(new Date(timeInMillis));
    }

    /*
    * 获取时间到天
    * */
    public static String getTimeData(long timeInMillis, SimpleDateFormat dateFormat) {

        return dateFormat.format(new Date(timeInMillis));
    }

    public static String getTestTime() {
        Date curDate = new Date(System.currentTimeMillis());// 获取当前时间
        String str = TEST_DATE_FORMAT.format(curDate);
        return str;
    }

    /**
     * 将认证部分选择的时间转换成服务器需要的秒
     *
     * @param hour
     * @param minutes
     * @return
     */
    public static int changeTimeToSeconds(int hour, int minutes) {
        return hour * 60 * 60 + minutes * 60;
    }

    /**
     * 将秒转换成h:m里对应的多少小时
     *
     * @param seconds
     * @return
     */
    public static int changeSecondsToHour(int seconds) {
        return seconds / (60 * 60);
    }

    /**
     * 将秒转换成h:m里对应的多少分
     *
     * @param seconds
     * @return
     */
    public static int changeSecondsToMinutes(int seconds) {
        return (seconds - changeSecondsToHour(seconds) * 60 * 60) / 60;
    }

    /**
     * 根据后台返回的内容显示星期
     *
     * @param wtsEntity
     * @return
     */
    public static String formatChosenDayFromServerData(WtsEntity wtsEntity, Context mContext) {
        String result;
        int totalChosen = wtsEntity.getDays().size();
        if (1 == totalChosen) {
            result = mContext.getString(R.string.chosen_one_day, weekArray[wtsEntity.getDays().get(0) - 1]);
        } else if (7 == totalChosen) {// 选择了7天
            result = "每天";
        } else if (2 == totalChosen && 6 == wtsEntity.getDays().get(0)) {// 选择了两天并且第一天是星期6
            result = "周末";
        } else if (5 == totalChosen && 1 == wtsEntity.getDays().get(0)) {// 选择了五天并且第一天是星期1
            result = "工作日";
        } else if (totalChosen - 1 == wtsEntity.getDays().get(totalChosen - 1) - wtsEntity.getDays().get(0)) {//
            // 头尾两天相差是天数减1，就表示是连续的
            result = mContext.getString(R.string.chosen_time_continuous, weekArray[wtsEntity.getDays().get(0) - 1],
                    weekArray[wtsEntity.getDays().get(totalChosen - 1) - 1]);
        } else {// 不连续的
            result = "星期";
            for (int chosenDay : wtsEntity.getDays()) {
                result = result + weekArray[chosenDay - 1] + "、";
            }
            if (!StringUtils.isEmpty(result)) {
                result = result.substring(0, result.length() - 1);
            }
        }
        return result;
    }

    /**
     * 根据后台返回的内容显示时间
     *
     * @param wtsEntity
     * @return
     */
    public static String formatChosenTimeFromServerData(WtsEntity wtsEntity, Context mContext) {
        String result = mContext.getString(R.string.chosen_time,
                StringUtils.formatTwoLength(TimeUtils.changeSecondsToHour(wtsEntity.getStart_time())),
                StringUtils.formatTwoLength(TimeUtils.changeSecondsToMinutes(wtsEntity.getStart_time())),
                StringUtils.formatTwoLength(TimeUtils.changeSecondsToHour(wtsEntity.getEnd_time())),
                StringUtils.formatTwoLength(TimeUtils.changeSecondsToMinutes(wtsEntity.getEnd_time())));
        if (CommonConstants.ALL_DAY_TIME_ONE.equals(result) || CommonConstants.ALL_DAY_TIME_TWO.equals(result)) {
            result = mContext.getString(R.string.all_day);
        }
        return result;
    }



    /**
     * 获取当前时间
     *
     * @param format "yyyy-MM-dd HH:mm:ss"
     */
    public static String getCurrentTime(String format) {
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format, Locale.getDefault());
        return simpleDateFormat.format(date);
    }

    /**
     * 获取当前时间为本月的第几周
     */
    public static int getWeekOfMonth() {
        Calendar calendar = Calendar.getInstance();
        int week = calendar.get(Calendar.WEEK_OF_MONTH);
        return week - 1;
    }

    /**
     * 获取当前时间为本周的第几天
     */
    public static int getDayOfWeek() {
        Calendar calendar = Calendar.getInstance();
        int day = calendar.get(Calendar.DAY_OF_WEEK);
        if (day == 1) {
            day = 7;
        } else {
            day = day - 1;
        }
        return day;
    }

    /**
     * 获取当前时间的年份
     */
    public static int getYear() {
        Calendar calendar = GregorianCalendar.getInstance();
        return calendar.get(Calendar.YEAR);
    }

    /**
     * 获取当前时间的月份
     */
    public static int getMonth() {
        Calendar calendar = GregorianCalendar.getInstance();
        return calendar.get(Calendar.MONTH)+1;
    }

    /**
     * 获取当前时间是哪天
     */
    public static int getDay() {
        Calendar calendar = GregorianCalendar.getInstance();
        return calendar.get(Calendar.DATE);
    }

    /**
     * @param date1
     * @param date2
     * @return 1:date1大于date2；
     * -1:date1小于date2
     */
    public static int compareDate(String date1, String date2, String format) {
        DateFormat df = new SimpleDateFormat(format, Locale.getDefault());
        try {
            Date dt1 = df.parse(date1);
            Date dt2 = df.parse(date2);
            if (dt1.getTime() > dt2.getTime()) {
                return 1;
            } else if (dt1.getTime() < dt2.getTime()) {
                return -1;
            } else {
                return 0;
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return 0;
    }
}

