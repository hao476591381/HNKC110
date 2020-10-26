package com.hnkc.ydcj.main.login.m;

import com.hnkc.ydcj.base.InitCoFig;
import com.hnkc.ydcj.main.login.UserInfoSp;

public class LoginModelP implements ILoginModel {
    @Override
    public String getLoginState() {
        return UserInfoSp.getLoginState();
    }

    @Override
    public String getLoginWay() {
        return InitCoFig.LOGIN_WAY;
    }
}
