package zhs.com.myretrofit.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import zhs.com.myretrofit.MainActivity;
import zhs.com.myretrofit.R;
import zhs.com.myretrofit.utils.LogUtils;

/**
 * Created by Zhs on 2017/10/29.
 * 账号消息
 */
public class AccountInfoActivity extends AppCompatActivity {

    private static String TAG = AccountInfoActivity.class.getSimpleName();

    @BindView(R.id.tv_show)
    TextView tvShow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acc);
        ButterKnife.bind(this);

        LogUtils.e(TAG,"onCreate===2==");
        tvShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AccountInfoActivity.this, MainActivity.class));
                finish();
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        LogUtils.e(TAG,"onStart===2==");
    }

    @Override
    protected void onResume() {
        super.onResume();
        LogUtils.e(TAG,"onResume===2==");
    }

    @Override
    protected void onPause() {
        super.onPause();
        LogUtils.e(TAG,"onPause===2==");
    }

    @Override
    protected void onStop() {
        super.onStop();
        LogUtils.e(TAG,"onStop===2==");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        LogUtils.e(TAG,"onDestroy==2===");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        LogUtils.e(TAG,"onRestart==2===");
    }

}
