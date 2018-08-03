package zhs.com.myretrofit;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import zhs.com.myretrofit.model.response.BookResponse;
import zhs.com.myretrofit.model.response.LoginResponse;
import zhs.com.myretrofit.model.response.SysVerInfoResponse;
import zhs.com.myretrofit.presenter.BookService;
import zhs.com.myretrofit.presenter.LoginService;
import zhs.com.myretrofit.presenter.RetrofitBookPresenter;
import zhs.com.myretrofit.presenter.RetrofitPresenter;
import zhs.com.myretrofit.presenter.SysVerInfoService;
import zhs.com.myretrofit.utils.AppNameUtil;
import zhs.com.myretrofit.utils.LogUtils;
import zhs.com.myretrofit.view.AccountInfoActivity;

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

        LogUtils.e(TAG,"onCreate===1==");
//        tvShow = (TextView) findViewById(R.id.tv_show);

        goLogin("cdjyj","123456","","","app");
//        LogUtils.e(TAG, "----getVersionCode--------" + AppNameUtil.getVersionCode(this));
//        LogUtils.e(TAG, "----getVersionName--------" + AppNameUtil.getVersionName(this));

        getSysVerInfo(AppNameUtil.getVersionName(this), "app");

        tvShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, AccountInfoActivity.class));
            }
        });

    }

    private void goLogin( String account, String password, String auth, String appKey,String requestSource) {

        RetrofitPresenter.request(RetrofitPresenter.createApi(LoginService.class).getLogin(
                account,password,auth,appKey,requestSource
        ),new RetrofitPresenter.IResponseListener<LoginResponse>() {

            @Override
            public void onSuccess(LoginResponse data) {
//                LogUtils.e(TAG,"登录返回值====="+data.toString());
//                tvShow.setText(""+data.toString());
//                getBookMessage();
            }

            @Override
            public void onFail(String res) {

            }
        });
    }

    private void getSysVerInfo(String version, String requestSource) {
        RetrofitPresenter.request(RetrofitPresenter.createApi(SysVerInfoService.class).getSysVerInfo(version, requestSource),
                new RetrofitPresenter.IResponseListener<SysVerInfoResponse>() {
                    @Override
                    public void onSuccess(SysVerInfoResponse mSysVerInfoResponse) {
//                        LogUtils.e(TAG, "系统版本===" + mSysVerInfoResponse.toString());
//                        if (mSysVerInfoResponse.getData() != null) {
//                            LjApplication.getInstance().mSysVerInfoResponse = mSysVerInfoResponse.getData();
//
//                        }
                    }

                    @Override
                    public void onFail(String res) {
                        LogUtils.e(TAG, "系统版本===" + res.toString());
                    }
                });
    }

    private void getBookMessage() {
        RetrofitBookPresenter.request(RetrofitBookPresenter.createApi(BookService.class).getBookInfo(),
                new RetrofitBookPresenter.IResponseListener<BookResponse>() {
                    @Override
                    public void onSuccess(BookResponse data) {
//                        LogUtils.e(TAG,"Book返回值====="+data.toString());
                        tvBookView.setText("" + data.toString());
                    }

                    @Override
                    public void onFail(String res) {

                    }
                });
    }

    @Override
    protected void onStart() {
        super.onStart();
        LogUtils.e(TAG,"onStart==1===");
    }

    @Override
    protected void onResume() {
        super.onResume();
        LogUtils.e(TAG,"onResume==1===");
    }

    @Override
    protected void onPause() {
        super.onPause();
        LogUtils.e(TAG,"onPause===1==");
    }

    @Override
    protected void onStop() {
        super.onStop();
        LogUtils.e(TAG,"onStop===1==");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        LogUtils.e(TAG,"onDestroy===1==");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        LogUtils.e(TAG,"onRestart===1==");
    }
}
