package zhs.com.myretrofit.presenter;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;
import zhs.com.myretrofit.model.response.LoginResponse;

/**
 *  Created by Zhs on 2018/7/17.
 */
public interface LoginService {
    @GET("accounts/login")
    Observable<LoginResponse> getLogin(@Query("account") String account,
                                       @Query("password") String password,
                                       @Query("auth") String auth,
                                       @Query("appKey") String appKey,
                                       @Query("requestSource") String requestSource);
}
