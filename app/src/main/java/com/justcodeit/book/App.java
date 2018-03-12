package com.justcodeit.book;

import android.app.Activity;
import android.app.Application;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/3/12.
 */

public class App extends Application {
    //记录当前栈里所有activity
    private List<Activity> activities = new ArrayList<Activity>();
    /**
     * 应用实例
     **/
    private static App instance;


    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;

    }
    /**
     * 获得实例
     *
     * @return
     */
    public static App getInstance() {
        return instance;
    }

    /**
     * 新建了一个activity
     *
     * @param activity
     */
    public void addActivity(Activity activity) {
        activities.add(activity);
    }

    /**
     * 结束指定的Activity
     *
     * @param activity
     */
    public void finishActivity(Activity activity) {
        if (activity != null) {
            this.activities.remove(activity);
            activity.finish();
            activity = null;
        }
    }

    /**
     * 应用退出，结束所有的activity
     */
    public void exit() {
        for (Activity activity : activities) {
            if (activity != null) {
                activity.finish();
            }
        }
        System.exit(0);
    }
}
