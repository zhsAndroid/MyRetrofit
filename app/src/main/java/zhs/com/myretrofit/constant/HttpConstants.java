
package zhs.com.myretrofit.constant;

import zhs.com.myretrofit.base.ZhsApplication;

/**
 * Created by zhs on 2018/7/17.
 */
public class HttpConstants {
    public static final String APP_API_DOMAIN = "http://www.lanjicloud.com:88/api/";    //正试环境

    public static final String APP_API_T = "https://api.douban.com/";    //临时测试
//    public static final String APP_API_DOMAIN = "http://www.lanjicloud.com:99/api/";// 临时测试

//    public static final String APP_API_DOMAIN = "http://192.168.10.105:1210/api/";

    public enum HttpStatus {
        ServerFail, LogicFail, LogicSuccess, TimeOut
    }

    //正式地址和非正式地址之分   测试的Debug环境
    public static String getDomain() {
        if (ZhsApplication.ISDEBUG) {
            return HttpConstants.APP_API_DOMAIN;
        } else {
            return HttpConstants.APP_API_DOMAIN;
        }
    }

}
