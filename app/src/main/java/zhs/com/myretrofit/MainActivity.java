package zhs.com.myretrofit;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import zhs.com.myretrofit.model.response.BookResponse;
import zhs.com.myretrofit.model.response.LoginResponse;
import zhs.com.myretrofit.presenter.BookService;
import zhs.com.myretrofit.presenter.LoginService;
import zhs.com.myretrofit.presenter.RetrofitBookPresenter;
import zhs.com.myretrofit.presenter.RetrofitPresenter;
import zhs.com.myretrofit.utils.LogUtils;

public class MainActivity extends AppCompatActivity {

    private static String TAG = MainActivity.class.getSimpleName();

    @BindView(R.id.tv_show)
    TextView tvShow;

    @BindView(R.id.tv_textView)
    TextView tvBookView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

//        tvShow = (TextView) findViewById(R.id.tv_show);

        goLogin("cdjyj","123456","","","app");

    }

    private void goLogin( String account, String password, String auth, String appKey,String requestSource) {

        RetrofitPresenter.request(RetrofitPresenter.createApi(LoginService.class).getLogin(
                account,password,auth,appKey,requestSource
        ),new RetrofitPresenter.IResponseListener<LoginResponse>() {

            @Override
            public void onSuccess(LoginResponse data) {
                LogUtils.e(TAG,"登录返回值====="+data.toString());
                tvShow.setText(""+data.toString());
                getBookMessage();
            }

            @Override
            public void onFail(String res) {

            }
        });
    }

    private void getBookMessage() {
        RetrofitBookPresenter.request(RetrofitBookPresenter.createApi(BookService.class).getBookInfo(),
                new RetrofitBookPresenter.IResponseListener<BookResponse>() {
                    @Override
                    public void onSuccess(BookResponse data) {
                        LogUtils.e(TAG,"Book返回值====="+data.toString());
                        tvBookView.setText("" + data.toString());
                    }

                    @Override
                    public void onFail(String res) {

                    }
                });
    }
}
