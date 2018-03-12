package com.justcodeit.book.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;

import com.justcodeit.book.R;

/**
 * Created by Administrator on 2018/3/12.
 */

public class WelcomeActivity extends BaseActivity {
    @Override
    protected void loadViewLayout() {
        setContentView(R.layout.activity_welcome);
    }

    @Override
    protected void findViewById() {

    }

    @Override
    protected void setListener() {

    }

    @Override
    protected void processLogic() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(WelcomeActivity.this,MainActivity.class));
                finish();
            }
        }, 2000);
    }

    @Override
    protected Context getActivityContext() {
        return this;
    }
}
