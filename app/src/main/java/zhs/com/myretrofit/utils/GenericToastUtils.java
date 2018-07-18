package zhs.com.myretrofit.utils;

import android.content.Context;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Gravity;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Zhs on 2017/11/17.
 * 自定义提示框显示时间
 */

public class GenericToastUtils {

    public static final String TAG = "GenericToastUtils";

    public static final int TOAST_TEXTSIZE = 20;

    /** {@link Toast#LENGTH_SHORT} default time is 3500ms */
    public static final int LENGTH_SHORT_TIME = 2000;

    public static Context mContext = null;

    public static Toast mToast = null;
    public static TextView mTextView = null;
    public static int mDuration = 0;
    public static CharSequence mText = null;

    public Handler mHandler = new Handler();

    public GenericToastUtils(Context context) {
        mContext = context.getApplicationContext();
    }

    public static GenericToastUtils makeText(Context context, CharSequence text, int duration){
        GenericToastUtils instance = new GenericToastUtils(context);
        mContext = context.getApplicationContext();
        mDuration = duration;
        mText = text;
        return instance;
    }

    public static void getToast(Context context, CharSequence text){
        mToast = Toast.makeText(context, null, Toast.LENGTH_LONG);
        mToast.setGravity(Gravity.CENTER, 0, 0);
        LinearLayout toastView = (LinearLayout)mToast.getView();

        // Get the screen size with unit pixels.
        WindowManager wm = (WindowManager)context.getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics outMetrics = new DisplayMetrics();
        wm.getDefaultDisplay().getMetrics(outMetrics);

        mTextView = new TextView(context);
        LayoutParams vlp = new LayoutParams(outMetrics.widthPixels,
                outMetrics.heightPixels);
        vlp.setMargins(0, 0, 0, 0);
        mTextView.setLayoutParams(vlp);
        mTextView.setTextSize(TOAST_TEXTSIZE);
        mTextView.setText(text);
        mTextView.setGravity(Gravity.CENTER);
        toastView.addView(mTextView);
    }

    /**
     * Before call this method, you should call {@link }.
     *
     * @return Toast display duration.
     */
    public int getDuration(){
        return mDuration;
    }

    public void show(){
        Log.d(TAG, "Show custom toast");
        mHandler.post(showRunnable);
    }

    public void hide(){
        Log.d(TAG, "Hide custom toast");
        mDuration = 0;
        if(mToast != null){
            mToast.cancel();
        }
    }

    public Runnable showRunnable = new Runnable(){
        @Override
        public void run() {
            if(mToast != null){
                mTextView.setText(mText);
            }else{
                getToast(mContext, mText);
            }
            if(mDuration != 0){
                mToast.show();
            }else{
                Log.d(TAG, "Hide custom toast in runnable");
                hide();
                return;
            }

            if(mDuration > LENGTH_SHORT_TIME){
                mHandler.postDelayed(showRunnable, LENGTH_SHORT_TIME);
                mDuration -= LENGTH_SHORT_TIME;
            }else{
                mHandler.postDelayed(showRunnable, mDuration);
                mDuration = 0;
            }
        }
    };
}

