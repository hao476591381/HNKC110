package com.hnkc.ydcj.main.login.v;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import com.hnkc.ydcj.R;
import com.hnkc.ydcj.base.BaseActy;
import com.hnkc.ydcj.main.login.p.LoginImpl;
import com.hnkc.ydcj.utils.ActyUtil;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 登录界面
 */
public class LoginActy extends BaseActy<LoginView, LoginImpl> implements LoginView {
    @BindView(R.id.login_appname_tv)
    TextView loginAppnameTv;
    @BindView(R.id.login_username_et)
    EditText loginUsernameEt;
    @BindView(R.id.login_password_et)
    EditText loginPasswordEt;
    @BindView(R.id.login_cityname)
    TextView loginCityname;

    @Override
    protected LoginImpl createPresenter() {
        return new LoginImpl(this);
    }

    @Override
    public int bindLayout() {
        return R.layout.login_acty;
    }

    @Override
    protected void init(Bundle bundle) {
        ActyUtil.getInstance().AddActy(this);
        mPresenter.Init();
    }

    @Override
    public void doBusiness(Context mContext) {

    }

    @Override
    public void LoadDismiss() {

    }

    @Override
    public void setFontType(Typeface typeface) {
        loginAppnameTv.setTypeface(typeface);
    }

    @Override
    public void setAppName(String appName) {
        loginAppnameTv.setText(appName);
    }

    @Override
    public void setCityName(String cityName) {
        loginCityname.setText(cityName);
    }

    @Override
    public String getPassWord() {
        return getStr(loginPasswordEt);
    }

    @Override
    public String getUserName() {
        return getStr(loginUsernameEt);
    }

    @OnClick(R.id.login_but)
    public void onViewClicked() {
        mPresenter.submitLogin();
    }
}
