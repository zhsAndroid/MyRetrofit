package zhs.com.myretrofit.model.entity;

import android.os.Parcel;
import android.os.Parcelable;

/**
 *  Created by Zhs on 2018/7/17.
 */

public class TagsEntity implements Parcelable {
    private String count;
    private String name;
    private String title;

    @Override
    public String toString() {
        return "TAGSbrea{" +
                "count='" + count + '\'' +
                ", name='" + name + '\'' +
                ", title='" + title + '\'' +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

    }
}
