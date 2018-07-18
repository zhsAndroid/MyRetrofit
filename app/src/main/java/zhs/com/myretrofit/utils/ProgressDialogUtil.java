//package com.example.jlzg.utils;
//
//import android.app.AlertDialog;
//import android.app.ProgressDialog;
//import android.content.Context;
//import android.content.DialogInterface;
//
///**
// * Created by Zhs on 2017/10/17.
// * 网络加载进度条
// */
//public class ProgressDialogUtil {
//
//    public static ProgressDialog mProgressDialog;
//
//    private static int progressTheme = AlertDialog.THEME_HOLO_LIGHT;
//
//    public static void showProgressDialog(Context context, CharSequence title,
//                                          CharSequence message, boolean indeterminate,
//                                          boolean cancelable, DialogInterface.OnCancelListener cancelListener) {
//
//        try {
//            if(null != mProgressDialog && mProgressDialog.isShowing()){
//                mProgressDialog.dismiss();
//            }
//
//            mProgressDialog = new ProgressDialog(context.getApplicationContext(), progressTheme);
//            mProgressDialog.setIndeterminate(indeterminate);
//            mProgressDialog.setCancelable(cancelable);
//            mProgressDialog.setTitle(title);
//            mProgressDialog.setMessage(message);
//            mProgressDialog.setOnCancelListener(cancelListener);
//
//            mProgressDialog.show();
//        } catch (Exception e) {
//            LogUtils.e("对话框异常","-====" + e.getMessage());
//        }
//    }
//
//    public static void showProgressDialog(Context context, CharSequence message) {
//        try {
//            if(null != mProgressDialog && mProgressDialog.isShowing()){
//                mProgressDialog.dismiss();
//            }
//
//            mProgressDialog = new ProgressDialog(context.getApplicationContext(), progressTheme);
//            mProgressDialog.setIndeterminate(false);
//            mProgressDialog.setCancelable(true);
//            mProgressDialog.setTitle(null);
//            mProgressDialog.setMessage(message);
//            mProgressDialog.show();
//        } catch (Exception e) {
//            LogUtils.e("对话框异常","-====" + e.getMessage());
//        }
//    }
//
//    /**
//     * 取消ProgressDialog
//     */
//    public static void dismissProgressDialog() {
//        if (null != mProgressDialog) {
//            if (mProgressDialog.isShowing()) {
//                mProgressDialog.dismiss();
//            }
//        }
//    }
//
//    /**
//     * 设置加载框的内容
//     * @param strMessage 加载框的内容
//     */
//    public static void setMessage(String strMessage){
//        mProgressDialog.setMessage(strMessage);
//    }
//}
//
package zhs.com.myretrofit.utils;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;

/**
 * Created by Zhs on 2017/10/17.
 * 网络加载进度条
 */
public class ProgressDialogUtil {

    public static ProgressDialog mProgressDialog;

    private static int progressTheme = AlertDialog.THEME_HOLO_LIGHT;

    public static void showProgressDialog(Context context, CharSequence title,
                                          CharSequence message, boolean indeterminate,
                                          boolean cancelable, DialogInterface.OnCancelListener cancelListener) {

        try {
            if(null != mProgressDialog && mProgressDialog.isShowing()){
                mProgressDialog.dismiss();
            }

            mProgressDialog = new ProgressDialog(context, progressTheme);
            mProgressDialog.setIndeterminate(indeterminate);
            mProgressDialog.setCancelable(cancelable);
            mProgressDialog.setTitle(title);
            mProgressDialog.setMessage(message);
            mProgressDialog.setOnCancelListener(cancelListener);

            mProgressDialog.show();
        } catch (Exception e) {
            LogUtils.e("对话框异常","-====" + e.getMessage());
        }
    }

    public static void showProgressDialog(Context context, CharSequence message) {
        try {
            if(null != mProgressDialog && mProgressDialog.isShowing()){
                mProgressDialog.dismiss();
            }

            mProgressDialog = new ProgressDialog(context, progressTheme);
            mProgressDialog.setIndeterminate(false);
            mProgressDialog.setCancelable(true);
            mProgressDialog.setTitle(null);
            mProgressDialog.setMessage(message);
            mProgressDialog.show();
        } catch (Exception e) {
            LogUtils.e("对话框异常","-====" + e.getMessage());
        }
    }

    /**
     * 取消ProgressDialog
     */
    public static void dismissProgressDialog() {
        if (null != mProgressDialog) {
            if (mProgressDialog.isShowing()) {
                mProgressDialog.dismiss();
            }
        }
    }

    /**
     * 设置加载框的内容
     * @param strMessage 加载框的内容
     */
    public static void setMessage(String strMessage){
        mProgressDialog.setMessage(strMessage);
    }
}


