package zhs.com.myretrofit.base;

import android.app.Activity;
import android.app.Application;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;

import static zhs.com.myretrofit.BuildConfig.IS_DEBUG;

/**
 * Created by Zhs on 2018/7/17.
 */

public class ZhsApplication extends Application {
    public static final boolean ISDEBUG = true; //true   false

    private static ZhsApplication eContext = null;
    public ArrayList<Activity> runActivity = new ArrayList<>();

    private static final int TIMEOUT_READ = 15;
    private static final int TIMEOUT_CONNECTION = 15;
    private static OkHttpClient mOkHttpClient;

    public ZhsApplication() {
        eContext = this;
    }

    //懒汉式 单例模式
    public static ZhsApplication getInstance() {
        if (eContext == null) {
            synchronized (ZhsApplication.class) {
                if (eContext == null) {
                    eContext = new ZhsApplication();
                }
            }
        }
//        if (null == eContext) {
//            eContext = new LjApplication();
//        }
        return eContext;
    }

    public void addRunActivity(Activity value) {
        if (null == this.runActivity) {
            this.runActivity = new ArrayList<>();
        }
        if (!this.runActivity.contains(value)) {
            this.runActivity.add(value);
        }
    }

    public void removeRunActivity(Activity value) {
//        SkinManager.getInstance().killData();
        if (null != this.runActivity) {
            this.runActivity.remove(value);
        }
    }

    public void exitApp() {
        if (null != this.runActivity) {
            for (Activity act : this.runActivity) {
                act.finish();
            }
        }
        // 杀死该应用进程
        android.os.Process.killProcess(android.os.Process.myPid());
    }

    public OkHttpClient genericClient() {

        if (mOkHttpClient != null)
            return mOkHttpClient;

        HttpLoggingInterceptor logInterceptor = new HttpLoggingInterceptor();
//        HttpLoggingInterceptor.Level level = BuildConfig.IS_DEBUG ?
//                HttpLoggingInterceptor.Level.HEADERS :
//                HttpLoggingInterceptor.Level.NONE;

        HttpLoggingInterceptor.Level level = IS_DEBUG ?
                HttpLoggingInterceptor.Level.HEADERS :
                HttpLoggingInterceptor.Level.NONE;
        logInterceptor.setLevel(level);


        return mOkHttpClient = new OkHttpClient.Builder()
                .retryOnConnectionFailure(true)
                .addInterceptor(logInterceptor)
                .readTimeout(TIMEOUT_READ, TimeUnit.SECONDS)
                .connectTimeout(TIMEOUT_CONNECTION, TimeUnit.SECONDS)
                .build();
    }

}
