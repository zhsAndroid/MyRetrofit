package zhs.com.myretrofit.presenter;

import android.util.Log;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import zhs.com.myretrofit.base.ZhsApplication;
import zhs.com.myretrofit.constant.HttpConstants;
import zhs.com.myretrofit.utils.NetworkUtils;
import zhs.com.myretrofit.utils.ToastUtils;

/**
 * Created by Zhs on 2018/7/17.
 */

public class RetrofitPresenter {

    public static <T> T createApi(Class<T> service) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(HttpConstants.getDomain())
                .addConverterFactory(GsonConverterFactory.create())
                .client(ZhsApplication.getInstance().genericClient())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        return retrofit.create(service);
    }

    public static <T> void request(Observable<T> observable,
                                   final IResponseListener<T> listener) {

        if (!NetworkUtils.isNetworkAvailable(ZhsApplication.getInstance())) {
            ToastUtils.showShortMessage(ZhsApplication.getInstance(),"网络不可用,请检查网络...");
            if (listener != null) {
                listener.onFail("请求失败");
            }
            return;
        }
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<T>() {

                               @Override
                               public void onError(Throwable e) {
                                   e.printStackTrace();
                                   Log.d("onError", e.getMessage());
                                   if (listener != null) {
                                       listener.onFail("请求失败");
                                   }
                               }

                               @Override
                               public void onComplete() {

                               }

                               @Override
                               public void onSubscribe(Disposable disposable) {

                               }

                               @Override
                               public void onNext(T data) {
                                   if (listener != null) {
                                       listener.onSuccess(data);
                                   }
                               }
                           }
                );
    }

    public interface IResponseListener<T> {

        void onSuccess(T data);

        void onFail(String res);
    }

}
