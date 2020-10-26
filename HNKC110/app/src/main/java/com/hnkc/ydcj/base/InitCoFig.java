package com.hnkc.ydcj.base;

import android.Manifest;

import com.yanzhenjie.permission.Permission;

public class InitCoFig {
    public static final String LOGIN_WAY = "2";//1政务微信登录 2账号密码登录
    public static final String CITY_NAME = "清远";
    public static final String WELCOME_APP_NAME = "智慧巡防移动终端";
    public static final String LOGIN_APP_NAME = "清远智慧巡防";
    public static final String[] PERMISSION_ARRAY = new String[]{Manifest.permission.RECORD_AUDIO, Manifest.permission.CALL_PHONE, Manifest.permission.READ_PHONE_STATE, Manifest.permission.ACCESS_COARSE_LOCATION, Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.CAMERA};

}
