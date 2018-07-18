package zhs.com.myretrofit.model;

/**
 * Created by Zhs on 2018/7/17.
 * 基本的接收类
 */

public class BaseResponse<T> {
    public String message;
    public int status;
    public T data;

    @Override
    public String toString() {
        return "BaseResponse{" +
                "message='" + message + '\'' +
                ", status=" + status +
                ", data=" + data +
                '}';
    }
}
