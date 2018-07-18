package zhs.com.myretrofit.utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.util.Log;

/**
 * Created by Zhs on 2018/3/26.
 */
public class AppNameUtil {

    /**
     * 返回当前程序版本名
     */
    public static String getAppVersionName(Context context) {
        String versionName = "";
        double versioncode;
        try {
            // ---get the package info---
            PackageManager pm = context.getApplicationContext().getPackageManager();
            PackageInfo pi = pm.getPackageInfo(context.getApplicationContext().getPackageName(), 0);
            versionName = pi.versionName;
            versioncode = pi.versionCode;
            if (versionName == null || versionName.length() <= 0) {
                return "";
            }
        } catch (Exception e) {
            Log.e("VersionInfo", "Exception", e);
        }
        return versionName;
    }

    //版本名
    public static String getVersionName(Context context) {
        return getPackageInfo(context.getApplicationContext()).versionName;
    }

    //版本号
    public static int getVersionCode(Context context) {
        return getPackageInfo(context.getApplicationContext()).versionCode;
    }

    private static PackageInfo getPackageInfo(Context context) {
        PackageInfo pi = null;

        try {
            PackageManager pm = context.getApplicationContext().getPackageManager();
            pi = pm.getPackageInfo(context.getApplicationContext().getPackageName(),
                    PackageManager.GET_CONFIGURATIONS);

            return pi;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return pi;
    }


    /**
     * 获取本地软件版本号
     */
//    public static int getLocalVersion(Context ctx) {
//        int localVersion = 0;
//        try {
//            PackageInfo packageInfo = ctx.getPackageName()
//                    .getPackageManager()
//                    .getPackageInfo(ctx.getPackageName(), 0);
//            localVersion = packageInfo.versionCode;
//            LogUtil.d("TAG", "本软件的版本号。。" + localVersion);
//        } catch (NameNotFoundException e) {
//            e.printStackTrace();
//        }
//        return localVersion;
//    }
//
//    /**
//     * 获取本地软件版本号名称
//     */
//    public static String getLocalVersionName(Context ctx) {
//        String localVersion = "";
//        try {
//            PackageInfo packageInfo = ctx.getApplicationContext()
//                    .getPackageManager()
//                    .getPackageInfo(ctx.getPackageName(), 0);
//            localVersion = packageInfo.versionName;
//            LogUtil.d("TAG", "本软件的版本号。。" + localVersion);
//        } catch (NameNotFoundException e) {
//            e.printStackTrace();
//        }
//        return localVersion;
//    }

    /*
     * 应用程序最高可用内存是多少
     */
    public static int getmaxMemory() {
        int maxMemory = (int) (Runtime.getRuntime().maxMemory() / 1024);
//        LogUtils.e("TAG", "Max memory is " + maxMemory + "KB");
        return maxMemory;
    }

}
