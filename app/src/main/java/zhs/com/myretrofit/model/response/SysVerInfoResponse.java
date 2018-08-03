package zhs.com.myretrofit.model.response;

import zhs.com.myretrofit.model.entity.SysVerInfoEntity;

/**
 * Created by Zhs on 2018/3/26.
 * 系统版本更新返回
 */

public class SysVerInfoResponse {
    public int status;
    public String message;
    public SysVerInfoEntity data;

    @Override
    public String toString() {
        return "SysVerInfoResponse{" +
                "status=" + status +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public SysVerInfoEntity getData() {
        return data;
    }

    public void setData(SysVerInfoEntity data) {
        this.data = data;
    }
}
