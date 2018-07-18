//package zhs.com.myretrofit.utils;
//
//import android.app.Notification;
//import android.app.NotificationManager;
//import android.app.PendingIntent;
//import android.content.Context;
//import android.content.Intent;
//import android.net.Uri;
//import android.support.v4.content.FileProvider;
//import android.widget.RemoteViews;
//
//import com.example.jlzg.R;
//import com.example.jlzg.constant.CommonConstants;
//import com.example.jlzg.ui.activity.MainActivity;
//
//import java.io.File;
//import java.util.HashMap;
//import java.util.Map;
//
///**
// * Created by Zhs on 2017/11/9.
// * 通知管理工具类
// */
//
//public class NotificationUtil {
//    private Context mContext;
//    // NotificationManager ： 是状态栏通知的管理类，负责发通知、清楚通知等。
//    private NotificationManager manager;
//    // 定义Map来保存Notification对象
//    private Map<Integer, Notification> map = null;
//    RemoteViews remoteViews;
//    Notification notification;
//
//    File pathRead;//= new File(getExternalFilesDir(null) + File.separator);//app正式路径   相对路径
//    File file;//= new File(pathRead+"");
//    File[] fs;// = file.listFiles();
//
//    String LookStr = null;
//
//    String LookLoad = null;
//
//    public NotificationUtil(Context context) {
//        this.mContext = context.getApplicationContext();
//        // NotificationManager 是一个系统Service，必须通过 getSystemService()方法来获取。
//        manager = (NotificationManager) mContext
//                .getSystemService(Context.NOTIFICATION_SERVICE);
//        map = new HashMap<Integer, Notification>();
//    }
//
//    public void showNotification(int notificationId,String mmm) {
//        // 判断对应id的Notification是否已经显示， 以免同一个Notification出现多次
//        if (!map.containsKey(notificationId)) {
//            // 创建通知对象
//            notification = new Notification();
//
//            // 设置通知栏滚动显示文字
//            LogUtils.e("下载文件","=====mmm======"+mmm);
//            LookLoad = mmm;
//            notification.tickerText = "开始下载"+mmm+"文件";
////            LogUtils.e("下载文件","==========="+notification.tickerText);
//
//            // 设置显示时间
//            notification.when = System.currentTimeMillis();
//            // 设置通知显示的图标
//            notification.icon = R.drawable.icon_update;
//            // 设置通知的特性: 通知被点击后，自动消失
//            notification.flags = Notification.FLAG_NO_CLEAR;
//
////            关于Notification的Flags
////            notification.flags = Notification.FLAG_NO_CLEAR; // 点击清除按钮时就会清除消息通知,但是点击通知栏的通知时不会消失
////            notification.flags = Notification.FLAG_ONGOING_EVENT; // 点击清除按钮不会清除消息通知,可以用来表示在正在运行
////            notification.flags = Notification.FLAG_AUTO_CANCEL; // 点击清除按钮或点击通知后会自动消失
////            notification.flags = Notification.FLAG_INSISTENT; // 一直进行，比如音乐一直播放，知道用户响应
//
//            // 设置点击通知栏操作
//            Intent in = new Intent(mContext, MainActivity.class);// 点击跳转到指定页面
//            PendingIntent pIntent = PendingIntent.getActivity(mContext, 0, in, 0);
//
//            notification.contentIntent = pIntent;
//            // 设置通知的显示视图
//            remoteViews = new RemoteViews(
//                    mContext.getPackageName(),
//                    R.layout.notification_contentview);
//            // 设置暂停按钮的点击事件
//            Intent pause = new Intent(mContext, MainActivity.class);// 设置跳转到对应界面
//
//
////            PendingIntent pauseIn = PendingIntent.getActivity(mContext, 0, in, 0);
////            PendingIntent pauseIn = PendingIntent.getActivity(mContext, 0, getWordFileIntent(LookStr), 0);
//
////            remoteViews.setOnClickPendingIntent(R.id.pause, (PendingIntent)mContext.startActivity(getPdfFileIntent(LookStr)));
//            //********** 简单分隔 **************************
//            // 设置取消按钮的点击事件
//
//            Intent stop = new Intent(mContext, MainActivity.class);// 设置跳转到对应界面
//            PendingIntent stopIn = PendingIntent
//                    .getActivity(mContext, 0, in, 0);
//            // 这里可以通过Bundle等传递参数
//            remoteViews.setOnClickPendingIntent(R.id.cancel, stopIn);
//            // 设置通知的显示视图
//            notification.contentView = remoteViews;
//            // 发出通知
//            manager.notify(notificationId, notification);
//            map.put(notificationId, notification);// 存入Map中
//        }
//    }
//
//
//    private void getReportDatas() {
//        pathRead = new File(CommonConstants.REPORT_FILE_PATH + CommonConstants.mLoginAccount + File.separator);//app正式路径   相对路径
//
//        orderByDate(pathRead + "");
//        LogUtils.e("通知栏查看下载报告", "我到过===" + pathRead);
//    }
//
//    public void orderByDate(String fliePath) {
//        file = new File(fliePath);
//        fs = file.listFiles();
//
//    }
//
//    /**
//     * 取消通知操作
//     *
//     * @description：
//     * @author ldm
//     * @date 2016-5-3 上午9:32:47
//     */
//    public void cancel(int notificationId) {
//        manager.cancel(notificationId);
//        map.remove(notificationId);
//    }
//
//    public void updateProgress(int notificationId, int progress) {
//        Notification notify = map.get(notificationId);
//        if (null != notify) {
//            // 修改进度条
//            getReportDatas();
//            if (fs.length == 0) {
//                return;
//            } else {
//                for (int i = 0;i < fs.length; i++) {
//                    if (fs[i].toString().endsWith(LookLoad)) {
//                        LookStr = fs[i].toString();
//                        LogUtils.e("查看报告的名字","LookStr========"+LookStr);
//                    }
//                }
//            }
//            PendingIntent pauseIn = null;
//            if (LookStr != null ) {
//                if (LookStr.endsWith(".pdf")) {
//                    pauseIn = PendingIntent.getActivity(mContext, 0, getPdfFileIntent(LookStr), 0);
//                    LogUtils.e("","空空空空空空空空空空空空空空空空空空空空空空空空=pdf===" + LookStr);
//                } else {
//                    pauseIn = PendingIntent.getActivity(mContext, 0, getWordFileIntent(LookStr), 0);
//                    LogUtils.e("","空空空空空空空空空空空空空空空空空空空空空空空空=doc===" + LookStr);
//                }
//            } else {
//                LogUtils.e("","空空空空空空空空空空空空空空空空空空空空空空空空空空空空空空空空空空空空空");
//            }
//
//            // 这里可以通过Bundle等传递参数
//            remoteViews.setOnClickPendingIntent(R.id.pause, pauseIn);
//            notification.flags = Notification.FLAG_AUTO_CANCEL;
//            // 设置点击通知栏操作
//            notify.contentView.setProgressBar(R.id.pBar, 100, progress, false);
//            manager.notify(notificationId, notify);
//        }
//    }
//    //android获取一个用于打开Word文件的intent
//    public Intent getWordFileIntent(String param) {
//
//        Intent intent = null;
//        try {
//            intent = new Intent("android.intent.action.VIEW");
//            intent.addCategory("android.intent.category.DEFAULT");
//// 授予目录临时共享权限
//            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_GRANT_READ_URI_PERMISSION
//                    | Intent.FLAG_GRANT_WRITE_URI_PERMISSION);
//            Uri uri = FileProvider.getUriForFile(mContext, "com.example.jlzg.fileprovider", new File(param));
////                    Uri uri = Uri.fromFile(new File(param));
//            intent.setDataAndType(uri, "application/msword");
//        } catch (Exception e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
//        return intent;
//    }
//
//    //android获取一个用于打开PDF文件的intent
//    public Intent getPdfFileIntent(String param) {
//
//        Intent intent = null;
//        try {
//            intent = new Intent("android.intent.action.VIEW");
//            intent.addCategory("android.intent.category.DEFAULT");
//            // 授予目录临时共享权限
//            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_GRANT_READ_URI_PERMISSION
//                    | Intent.FLAG_GRANT_WRITE_URI_PERMISSION);
//            Uri uri = FileProvider.getUriForFile(mContext, "com.example.jlzg.fileprovider", new File(param));
//            intent.setDataAndType(uri, "application/pdf");
//        } catch (Exception e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
//        return intent;
//    }
//}
