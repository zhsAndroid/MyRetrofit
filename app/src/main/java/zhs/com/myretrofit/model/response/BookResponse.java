package zhs.com.myretrofit.model.response;

import java.util.ArrayList;

import zhs.com.myretrofit.model.entity.TagsEntity;

/**
 *  Created by Zhs on 2018/7/17.
 */

public class BookResponse {
    public String summary;
    public String price;

    public ArrayList<TagsEntity> tags;

    @Override
    public String toString() {
        return "BookResponse{" +
                "summary='" + summary + '\'' +
                ", price='" + price + '\'' +
                ", tags=" + tags +
                '}';
    }
}
