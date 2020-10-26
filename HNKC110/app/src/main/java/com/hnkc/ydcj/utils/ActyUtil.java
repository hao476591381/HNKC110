package com.hnkc.ydcj.utils;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;


import com.hnkc.ydcj.R;
import com.hnkc.ydcj.base.BaseApp;

import java.util.LinkedList;
import java.util.List;

/**
 * Activity 管理工具
 */
@SuppressLint("Registered")
public class ActyUtil extends BaseApp {
    private List<Activity> activityList = new LinkedList<>();

    private static ActyUtil instance;

    private ActyUtil() {
    } // 单例模式中获取唯一的ExitApplication实例

    public static ActyUtil getInstance() {
        if (instance == null) {
            instance = new ActyUtil();
        }
        return instance;
    }

    /**
     * 添加Activity到容器中
     *
     * @param activity
     */
    public void AddActy(Activity activity) {
        this.activityList.add(activity);
    }

    /**
     * 移除Activity
     */
    public void removeActy(Activity activity) {
        activity.finish();
        activity. overridePendingTransition(0, R.anim.album_a3);
        if (activityList != null) {
            activityList.remove(activity);
        }
    }

    /**
     * 移除Activity 带返回参数
     *
     * @param activity
     * @param resultCode
     */
    public void removeActy(Activity activity, int resultCode) {
        activity.setResult(resultCode);
        activity.finish();
        activity. overridePendingTransition(0, R.anim.album_a3);
        if (activityList != null) {
            activityList.remove(activity);
        }
    }

    /**
     * 页面跳转
     */
    public void startActy(Activity myActy, Class<?> cls) {
        myActy.startActivity(new Intent(myActy, cls));
        myActy.overridePendingTransition(R.anim.album_a5, 0);
    }

    /**
     * 携带数据的页面跳转
     */
    public void startActy(Activity myActy, Class<?> clz, Bundle bundle) {
        Intent intent = new Intent();
        intent.setClass(myActy, clz);
        intent.putExtras(bundle);
        myActy.startActivity(intent);
        myActy.overridePendingTransition(R.anim.album_a5, 0);
    }

    /**
     * [含有Bundle通过Class打开编辑界面]
     */
    public void startActyForResult(Activity myActy, Class<?> cls, Bundle bundle, int requestCode) {
        Intent intent = new Intent();
        intent.setClass(myActy, cls);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        myActy.startActivityForResult(intent, requestCode);
        myActy.overridePendingTransition(R.anim.album_a5, 0);
    }

    public void startActyForResult(Activity myActy, Class<?> cls, int requestCode) {
        Intent intent = new Intent();
        intent.setClass(myActy, cls);
        myActy.startActivityForResult(intent, requestCode);
        myActy.overridePendingTransition(R.anim.album_a5, 0);
    }

    /**
     * 退出应用
     *
     * @param context
     */
    public void exit(Context context) {
        spUtils.clear();
        for (Activity activity : this.activityList) {
            activity.finish();
        }
        activityList.clear();
        ActivityManager manager = (ActivityManager) context.getSystemService(ACTIVITY_SERVICE); //获取应用程序管理器 
        assert manager != null;
        List<ActivityManager.AppTask> appTaskList = manager.getAppTasks();
        for (ActivityManager.AppTask appTask : appTaskList) {
            appTask.finishAndRemoveTask();
        }
    }
}