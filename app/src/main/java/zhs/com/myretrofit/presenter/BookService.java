package zhs.com.myretrofit.presenter;


import io.reactivex.Observable;
import retrofit2.http.GET;
import zhs.com.myretrofit.model.response.BookResponse;

/**
 * 接口
 *  Created by Zhs on 2018/7/17.
 */
public interface BookService {
    /**
     * 获取图书信息
     */
    @GET("v2/book/1220562")
    Observable<BookResponse> getBookInfo();

}
