package com.justcodeit.book.activity;

import android.content.Context;
import android.support.annotation.IdRes;
import android.view.KeyEvent;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.justcodeit.book.R;
import com.justcodeit.book.fragment.FragmentController;
import com.justcodeit.book.view.MyDialogHint;

import butterknife.BindView;

public class MainActivity extends BaseActivity implements RadioGroup.OnCheckedChangeListener {
    @BindView(R.id.hometab_radio)
    RadioGroup hometabRadio;
    @BindView(R.id.home_tv_title)
    TextView home_tv_title;
    private FragmentController controller;

    @Override
    protected void loadViewLayout() {
        setContentView(R.layout.activity_main);
        controller = FragmentController.getInstance(this, R.id.hometab_context);
        controller.showFragment(0);
    }

    @Override
    protected void findViewById() {
        hometabRadio = (RadioGroup) findViewById(R.id.hometab_radio);
    }

    @Override
    protected void setListener() {
        hometabRadio.setOnCheckedChangeListener(this);
    }

    @Override
    protected void processLogic() {

    }

    @Override
    protected Context getActivityContext() {
        return this;
    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, @IdRes int checkedId) {
        switch (checkedId) {
            case R.id.rb_recommend:
                home_tv_title.setText("推荐");
                controller.showFragment(0);
                break;
            case R.id.rb_stack:
                home_tv_title.setText("书库");
                controller.showFragment(1);
                break;
            case R.id.rb_search:
                home_tv_title.setText("搜索");
                controller.showFragment(2);
                break;
            case R.id.rb_mine:
                home_tv_title.setText("我的");
                controller.showFragment(3);
                break;
        }
    }

    public boolean onKeyDown(int keyCode, KeyEvent event) {
        // TODO Auto-generated method stub
        if (((keyCode == KeyEvent.KEYCODE_BACK) ||
                (keyCode == KeyEvent.KEYCODE_HOME))
                && event.getRepeatCount() == 0) {
            new MyDialogHint(MainActivity.this,R.style.MyDialog1).show();
        }
        return false;
    }
}
