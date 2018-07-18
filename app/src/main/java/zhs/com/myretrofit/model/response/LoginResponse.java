package zhs.com.myretrofit.model.response;

import java.util.ArrayList;

import zhs.com.myretrofit.model.entity.PermissionEntity;

/**
 *  Created by Zhs on 2018/7/17.
 * 登录返回body
 */
public class LoginResponse {
    public int user_id;
    public String auth;
    public String registerTime;
    public String endTime;
    public String message;
    public String account;
    public int status;
    public ArrayList<PermissionEntity> initPerms;

    public ArrayList<PermissionEntity> getInitPerms() {
        return initPerms;
    }

    public void setInitPerms(ArrayList<PermissionEntity> initPerms) {
        this.initPerms = initPerms;
    }

    //    private String initPerms;
//
//    public String getInitPerms() {
//        return initPerms;
//    }
//
//    public void setInitPerms(String initPerms) {
//        this.initPerms = initPerms;
//    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getAuth() {
        return auth;
    }

    public void setAuth(String auth) {
        this.auth = auth;
    }

    public String getRegisterTime() {
        return registerTime;
    }

    public void setRegisterTime(String registerTime) {
        this.registerTime = registerTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "LoginResponse{" +
                "user_id=" + user_id +
                ", auth='" + auth + '\'' +
                ", registerTime='" + registerTime + '\'' +
                ", endTime='" + endTime + '\'' +
                ", message='" + message + '\'' +
                ", account='" + account + '\'' +
                ", status=" + status +
                ", initPerms='" + initPerms + '\'' +
                '}';
    }
}
