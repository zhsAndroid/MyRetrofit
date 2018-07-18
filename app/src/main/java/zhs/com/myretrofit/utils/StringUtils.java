package zhs.com.myretrofit.utils;

/**
 * Created by Zhs on 2017/10/17.
 */
public class StringUtils {

    private StringUtils() {
    }

    public static boolean isEmpty(String str) {
        return (null == str || str.trim().length() == 0);
    }

    public static boolean isEmptyAndNull(String content){
        if(content == null || content.trim().equals("") || content.trim().length() == 0)
            return true;
        else
            return false;
    }

    /**
     * 将一位的时间转换成两位的
     *
     * @param value
     * @return
     */
    public static String formatTwoLength(int value) {
        String result;
        if (value < 10) {
            result = "0" + value;
        } else {
            result = value + "";
        }
        return result;
    }
}
