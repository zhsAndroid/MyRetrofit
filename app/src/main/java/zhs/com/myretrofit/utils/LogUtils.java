package zhs.com.myretrofit.utils;

import android.util.Log;

import zhs.com.myretrofit.base.ZhsApplication;


/**
 * Created by Zhs on 2017/10/17.
 * 对打印的 日志 加了长度
 */
public class LogUtils {
    private LogUtils() {
    }

    public static void d(String tag, String message) {
        if (StringUtils.isEmpty(message)) {
            return;
        }
//        if (BuildConfig.DOCTOR_DEBUG) {
//            Log.d(tag, message);
//        }
        if (ZhsApplication.ISDEBUG) {
            Log.d(tag, message);
        }
    }

    public static void d(String tag, String messageTitle, Object object) {
//        if (BuildConfig.DOCTOR_DEBUG) {
//            Log.d(tag, messageTitle + " " + GsonUtils.toJson(object));
//        }
        if (ZhsApplication.ISDEBUG) {
            Log.d(tag, messageTitle + " " + GsonUtils.toJson(object));
        }
    }

    public static void e(String tag, String message) {

        if (tag == null || tag.length() == 0
                || message == null || message.length() == 0)
            return;

        int segmentSize = 3 * 1024;
        long length = message.length();
        if (length <= segmentSize ) {// 长度小于等于限制直接打印
            if (ZhsApplication.ISDEBUG) {
                Log.e(tag, message);
            }
//            Log.e(tag, message);
        }else {
            while (message.length() > segmentSize ) {// 循环分段打印日志
                String logContent = message.substring(0, segmentSize );
                message = message.replace(logContent, "");
                if (ZhsApplication.ISDEBUG) {
                    Log.e(tag, logContent);
                }
//                Log.e(tag, logContent);
            }
            if (ZhsApplication.ISDEBUG) {
                Log.e(tag, message);
            }
//            Log.e(tag, message);// 打印剩余日志
        }

        if (StringUtils.isEmpty(message)) {
            return;
        }
//        if (BuildConfig.DOCTOR_DEBUG) {
//            Log.d(tag, message);
//        }

    }

    public static void e(String tag, String messageTitle, Object object) {
        if (ZhsApplication.ISDEBUG) {
            Log.e(tag, messageTitle + " " + GsonUtils.toJson(object));
        }
    }

    public static void i(String tag, String message) {
        if (StringUtils.isEmpty(message)) {
            return;
        }
        if (ZhsApplication.ISDEBUG) {
            Log.i(tag, message);
        }
//        if (BuildConfig.DOCTOR_DEBUG) {
//            Log.d(tag, message);
//        }
    }

    public static void i(String tag, String messageTitle, Object object) {
        if (ZhsApplication.ISDEBUG) {
            Log.i(tag, messageTitle + " " + GsonUtils.toJson(object));
        }
    }

    public static void v(String tag, String message) {
        if (StringUtils.isEmpty(message)) {
            return;
        }
        if (ZhsApplication.ISDEBUG) {
            Log.v(tag, message);
        }
//        if (BuildConfig.DOCTOR_DEBUG) {
//            Log.d(tag, message);
//        }
    }

    public static void v(String tag, String messageTitle, Object object) {
        if (ZhsApplication.ISDEBUG) {
            Log.v(tag, messageTitle + " " + GsonUtils.toJson(object));
        }
    }

    public static void w(String tag, String message) {
        if (StringUtils.isEmpty(message)) {
            return;
        }
        if (ZhsApplication.ISDEBUG) {
            Log.w(tag, message);
        }
//        if (BuildConfig.DOCTOR_DEBUG) {
//            Log.d(tag, message);
//        }
    }

    public static void w(String tag, String messageTitle, Object object) {
        if (ZhsApplication.ISDEBUG) {
            Log.w(tag, messageTitle + " " + GsonUtils.toJson(object));
        }
    }

}
