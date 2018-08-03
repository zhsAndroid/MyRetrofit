package zhs.com.myretrofit.presenter;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;
import zhs.com.myretrofit.model.response.SysVerInfoResponse;

/**
 * Created by Zhs on 2018/3/26.
 */

public interface SysVerInfoService {
    @GET("dayReport/down/check/version")
    Observable<SysVerInfoResponse> getSysVerInfo(@Query("version") String version,
//                                                              @Query("auth") String auth,
                                                 @Query("requestSource") String requestSource);
}
