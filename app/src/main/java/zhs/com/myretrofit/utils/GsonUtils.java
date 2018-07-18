package zhs.com.myretrofit.utils;

import com.google.gson.Gson;

/**
 * Created by Zhs on 2017/10/17.
 */
public class GsonUtils {
    private GsonUtils() {
        throw new AssertionError();
    }

    /**
     * 将对象转换成字符串
     *
     * @param object 待转化的对象
     * @return 转换之后的结果
     */
    public static String toJson(Object object) {
        if (object == null) {
            return "";
        }
        return new Gson().toJson(object);
    }
}
