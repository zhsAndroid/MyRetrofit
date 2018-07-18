package zhs.com.myretrofit.utils;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.widget.Toast;

/**
 * Created by Zhs on 2017/10/17.
 */
public class ToastUtils {
    private static Handler handler = new Handler(Looper.getMainLooper());

    private static Toast toast = null;

    private static Object synObj = new Object();

    /**
     * @param ctx 使用时的上下文
     * @param msg 提示文字
     */
    public static void showShortMessage(final Context ctx, final String msg) {
        new Thread(new Runnable() {

            @Override
            public void run() {
                handler.post(new Runnable() {

                    @Override
                    public void run() {
                        synchronized (synObj) {
                            if (toast != null) {
                                toast.setText(msg);
                                toast.setDuration(Toast.LENGTH_SHORT);
                            } else {
                                toast = Toast.makeText(ctx.getApplicationContext(), msg,
                                        Toast.LENGTH_SHORT);
                            }
                            toast.show();
                        }
                    }
                });
            }
        }).start();
    }

    /**
     * @param ctx 使用时的上下文
     * @param msg 提示文字
     */
    public static void showLongMessage(final Context ctx, final String msg) {
        new Thread(new Runnable() {

            @Override
            public void run() {
                handler.post(new Runnable() {

                    @Override
                    public void run() {
                        synchronized (synObj) {
                            if (toast != null) {
                                toast.setText(msg);
                                toast.setDuration(Toast.LENGTH_LONG);
                            } else {
                                toast = Toast.makeText(ctx.getApplicationContext(), msg,
                                        Toast.LENGTH_LONG);
                            }
                            toast.show();
                        }
                    }
                });
            }
        }).start();
    }

    //设置Toast对象
    public static void showTextToast(final Context ctx,final String msg) {
        //判断队列中是否包含已经显示的Toast
        if (toast == null) {
            toast = Toast.makeText(ctx.getApplicationContext(), msg, Toast.LENGTH_SHORT);
        }else{
            toast.setText(msg);
        }
        toast.show();
    }

    /**
     * 取消吐司显示
     */
    public static void cancelToast() {
        if (toast != null) {
            toast.cancel();
            toast = null;
        }

    }
}
