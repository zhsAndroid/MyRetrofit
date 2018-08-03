package zhs.com.myretrofit.model.entity;

import java.io.Serializable;

/**
 * Created by Zhs on 2018/3/26.
 */

public class SysVerInfoEntity implements Serializable{

    public String productName;
    public String productVersion;
    public String productFtpPath;//数据库路径
    public String productRemark;//更新说明
    public long fileSize;       //文件大小

    public long getFileSize() {
        return fileSize;
    }

    public void setFileSize(long fileSize) {
        this.fileSize = fileSize;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductVersion() {
        return productVersion;
    }

    public void setProductVersion(String productVersion) {
        this.productVersion = productVersion;
    }

    public String getProductFtpPath() {
        return productFtpPath;
    }

    public void setProductFtpPath(String productFtpPath) {
        this.productFtpPath = productFtpPath;
    }

    public String getProductRemark() {
        return productRemark;
    }

    public void setProductRemark(String productRemark) {
        this.productRemark = productRemark;
    }

    @Override
    public String toString() {
        return "SysVerInfoEntity{" +
                "productName='" + productName + '\'' +
                ", productVersion='" + productVersion + '\'' +
                ", productFtpPath='" + productFtpPath + '\'' +
                ", productRemark='" + productRemark + '\'' +
                ", fileSize='" + fileSize + '\'' +
                '}';
    }
}
