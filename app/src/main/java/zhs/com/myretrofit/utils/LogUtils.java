package zhs.com.myretrofit.utils;

import android.util.Log;

import zhs.com.myretrofit.base.ZhsApplication;


/**
 * Created by Zhs on 2017/10/17.
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
        if (StringUtils.isEmpty(message)) {
            return;
        }
//        if (BuildConfig.DOCTOR_DEBUG) {
//            Log.d(tag, message);
//        }
        if (ZhsApplication.ISDEBUG) {
            Log.e(tag, message);
        }
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
