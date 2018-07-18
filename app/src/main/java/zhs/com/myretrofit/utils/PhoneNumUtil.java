package zhs.com.myretrofit.utils;

import android.text.TextUtils;

/**
 * Created by Zhs on 2017/10/17.
 */
public class PhoneNumUtil {
    /**
     * 验证手机格式
     */
    public static boolean isMobileNumb(String mobiles) {
    /*
    移动：134、135、136、137、138、139、150、151、157(TD)、158、159、187、188
    联通：130、131、132、152、155、156、185、186
    电信：133、153、180、189、（1349卫通）
    总结起来就是第一位必定为1，第二位必定为3或5或8，其他位置的可以为0-9
    */
        String telRegex = "[1]\\d{10}";//"[1]"代表第1位为数字1，"[358]"代表第二位可以为3、5、8中的一个，"\\d{9}"代表后面是可以是0～9的数字，有9位。
//        String telRegex = "[1][358]\\d{9}";//"[1]"代表第1位为数字1，"[358]"代表第二位可以为3、5、8中的一个，"\\d{9}"代表后面是可以是0～9的数字，有9位。
        if (TextUtils.isEmpty(mobiles))
            return false;
        else
            return mobiles.matches(telRegex);
    }

    /**
     * 验证密码
     */
    public static boolean isPassword(String password){
//        (?!^[0-9]+$)      不能全是数字
//        (?!^[a-zA-Z]+$)   不能全是字母
//        (?!^[_#@]+$)      不能全是符号（这里只列出了部分符号，可自己增加，有的符号可能需要转义）
//        .{6,}             长度不能少于6位
//        合起来就是
//        (?!^\\d+$)(?!^[a-zA-Z]+$)(?!^[_#@]+$).{8,}
        String psdMatch = "(?!^[0-9]+$)(?!^[a-z]+$)(?!^[A-Z]+$)(?!^[~!@#$%^&*()_+]+$).{6,20}";
//        String psdMatch = "(?!^\\\\d+$)(?!^[A-Z]+$)(?!^[a-z]+$)(?!^[_#@]+$).{6,20}";
        if(TextUtils.isEmpty(password)) {
            return false;
        } else {
            return password.matches(psdMatch);
        }
    }

    /**
     * 验证密码
     */
    public static boolean isPasswordl(String password){
//        (?!^[0-9]+$)      不能全是数字
//        (?!^[a-zA-Z]+$)   不能全是字母
//        (?!^[_#@]+$)      不能全是符号（这里只列出了部分符号，可自己增加，有的符号可能需要转义）
//        .{6,}             长度不能少于6位
//        合起来就是
//        (?!^\\d+$)(?!^[a-zA-Z]+$)(?!^[_#@]+$).{8,}
//        String psdMatch = "(?!^[0-9]+$)(?!^[a-z]+$)(?!^[A-Z]+$)(?!^[~!@#$%^&*()_+]+$).{6,20}";
        String psdMatch = "(?!^[0-9]+$)(?!^[a-z]+$)(?!^[A-Z]+$)(?!.{6,20})";
//        String psdMatch = ".{6,20}";
//        String psdMatch = "(?!^\\\\d+$)(?!^[A-Z]+$)(?!^[a-z]+$)(?!^[_#@]+$).{6,20}";
        if(TextUtils.isEmpty(password)) {
            return false;
        } else {
            return password.matches(psdMatch);
        }
    }
}

