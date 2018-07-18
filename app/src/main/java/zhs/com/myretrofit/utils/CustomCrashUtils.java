package zhs.com.myretrofit.utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

import zhs.com.myretrofit.base.ZhsApplication;

/**
 * Created by Zhs on 2017/11/2.
 */

public class CustomCrashUtils implements Thread.UncaughtExceptionHandler {

    public static final String TAG = CustomCrashUtils.class.getSimpleName();
    private static CustomCrashUtils mccCrashHandler = new CustomCrashUtils();
    private Context mContext;
    private Thread.UncaughtExceptionHandler mDefaultHandler;
    private Map<String, String> infos = new HashMap<>();

    private static final String VERSION_NAME = "version name";
    private static final String VERSION_CODE = "version code";
    private static final String CURRENT_TIME = "current time";

    private CustomCrashUtils() {

    }

    /**
     * 初始化崩溃捕获函数
     *
     * @param context 上下文
     */
    public void init(Context context) {
        mContext = context.getApplicationContext();
        mDefaultHandler = Thread.getDefaultUncaughtExceptionHandler();
        Thread.setDefaultUncaughtExceptionHandler(this);
    }

//    public void detach() {
//        if(skinObservers == null) return;
//        if(skinObservers.contains(observer)){
//            skinObservers.remove(observer);
//        }
//    }

    public static CustomCrashUtils getInstance() {
        if (mccCrashHandler == null) {
            synchronized (CustomCrashUtils.class) {
                if (mccCrashHandler == null) {
                    mccCrashHandler = new CustomCrashUtils();
                }
            }
        }
        return mccCrashHandler;
    }



    @Override
    public void uncaughtException(final Thread thread, final Throwable ex) {
        final Writer result = new StringWriter();
        final PrintWriter printWriter = new PrintWriter(result);
        ex.printStackTrace(printWriter);
        printWriter.close();
        collectCrashDeviceInfo(mContext);
        saveCrashInfoToFile(ex, mContext);
        new Thread() {
            @Override
            public void run() {
//                Looper.prepare();
//                ToastUtils.showShortMessage(mContext,
//                        mContext.getString(R.string.crash));
                ToastUtils.showShortMessage(mContext,
                        "程序异常中断....");
//                Looper.loop();
            }
        }.start();
        try {
            thread.sleep(2000);
        } catch (InterruptedException e) {
            LogUtils.e(TAG, e.getMessage());
        }
        mDefaultHandler.uncaughtException(thread, ex);

//        LjApplication.getInstance().exitApp();
    }

    /**
     * 收集设备的信息
     *
     * @param ctx 上下文
     */
    public void collectCrashDeviceInfo(Context ctx) {
        try {
            PackageManager pm = ctx.getPackageManager();
            PackageInfo pi = pm.getPackageInfo(ctx.getPackageName(),
                    PackageManager.GET_ACTIVITIES);
            if (pi != null) {
                infos.put(VERSION_NAME, pi.versionName == null ? "not set"
                        : pi.versionName);
                infos.put(VERSION_CODE, pi.versionCode + "");
                infos.put(CURRENT_TIME,
                        TimeUtils.getTime(System.currentTimeMillis(), TimeUtils.DEFAULT_DATE_FORMAT));
            }
        } catch (PackageManager.NameNotFoundException e) {
            LogUtils.e(TAG, "Error while collect package info", e);
        }
        Field[] fields = Build.class.getDeclaredFields();
        for (Field field : fields) {
            try {
                field.setAccessible(true);
                infos.put(field.getName(), field.get(null).toString());
                LogUtils.d(TAG, field.getName() + " : " + field.get(null));

            } catch (Exception e) {
                LogUtils.e(TAG, "Error while collect crash info", e);
            }
        }
    }

    /**
     * 保存崩溃日志到文件里
     *
     * @param ex
     */
    private void saveCrashInfoToFile(Throwable ex, Context ctx) {

        StringBuffer sb = new StringBuffer();
        for (Map.Entry<String, String> entry : infos.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            sb.append(key + ": " + value + "\n");
        }

        Writer writer = new StringWriter();
        PrintWriter printWriter = new PrintWriter(writer);
        ex.printStackTrace(printWriter);
        Throwable cause = ex.getCause();
        while (cause != null) {
            cause.printStackTrace(printWriter);
            cause = cause.getCause();
        }
        printWriter.close();
        String result = writer.toString();
        sb.append(result);
        LogUtils.e(TAG,
                "heapSize: " + android.os.Debug.getNativeHeapAllocatedSize());
        LogUtils.e(TAG, sb.toString());
        if (ZhsApplication.ISDEBUG) {
            FileUtils.saveFileToFile(ctx, sb.toString(), "CrashLog.txt");
        }

    }

}
