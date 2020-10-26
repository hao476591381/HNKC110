package com.hnkc.ydcj.main.login;

import static com.hnkc.ydcj.base.BaseApp.spUtils;

public class UserInfoSp {

    public static String getLoginState() {
        return spUtils.getStr("loginState", "no");
    }

    public static void setLoginState(String loginState) {
        spUtils.putStr("loginState", loginState);
    }

    public static String getLatitude() {
        return spUtils.getStr("mLatitude");
    }

    public static void setLatitude(String latitude) {
        spUtils.putStr("mLatitude", latitude);
    }

    public static String getLongitude() {
        return spUtils.getStr("mLongitude");
    }

    public static void setLongitude(String longitude) {
        spUtils.putStr("mLongitude", longitude);
    }
}
