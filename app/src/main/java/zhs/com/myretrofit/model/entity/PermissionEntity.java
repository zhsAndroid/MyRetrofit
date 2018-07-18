package zhs.com.myretrofit.model.entity;

import java.io.Serializable;

/**
 *  Created by Zhs on 2018/7/17.
 * 权限问题
 */

public class PermissionEntity implements Serializable{
    private String value;
    private String url;
    private String type;
    private String id;

    @Override
    public String toString() {
        return "PermissionEntity{" +
                "value='" + value + '\'' +
                ", url='" + url + '\'' +
                ", type='" + type + '\'' +
                ", id='" + id + '\'' +
                '}';
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
