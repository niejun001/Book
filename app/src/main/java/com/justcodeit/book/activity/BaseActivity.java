package com.justcodeit.book.activity;

import android.content.Context;
import android.content.pm.ActivityInfo;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.justcodeit.book.App;

import butterknife.ButterKnife;

/**
 * Created by Administrator on 2018/3/12.
 */

public abstract class BaseActivity extends AppCompatActivity {
    protected Context mContext;
    private ConnectivityManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);// 锁定竖屏
        // setTheme(R.style.AnimationActivity);//设置切换动画
        mContext = getActivityContext();

        initView();
        ButterKnife.bind(this);

        initdata();
        App.getInstance().addActivity(this);
    }
    /**
     * 初始activity方法
     */
    private void initView() {
        loadViewLayout();
    }

    private void initdata(){
        findViewById();
        setListener();
        processLogic();
    }

    /**
     * 加载页面layout
     */
    protected abstract void loadViewLayout();

    /**
     * 加载页面元素
     */
    protected abstract void findViewById();

    /**
     * 设置各种事件的监听器
     */
    protected abstract void setListener();

    /**
     * 业务逻辑处理，主要与后端交互
     */
    protected abstract void processLogic();

    /**
     * Activity.this
     */
    protected abstract Context getActivityContext();

    @Override
    protected void onDestroy() {
        // TODO Auto-generated method stub
        super.onDestroy();
        App.getInstance().finishActivity(this);
    }
}
