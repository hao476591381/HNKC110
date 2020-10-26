package com.hnkc.ydcj.bin;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.hg.lib.tool.PermissionsUtils;
import com.hnkc.ydcj.R;
import com.hnkc.ydcj.base.BaseActy;
import com.hnkc.ydcj.main.login.p.WelComeP;
import com.hnkc.ydcj.main.login.v.WelComeView;
import com.hnkc.ydcj.utils.ActyUtil;
import com.yanzhenjie.permission.Action;
import com.yanzhenjie.permission.AndPermission;
import com.yanzhenjie.permission.Permission;
import com.yanzhenjie.permission.Rationale;
import com.yanzhenjie.permission.RequestExecutor;

import java.util.List;

import butterknife.BindView;

public class WelcomeActy extends BaseActy<WelComeView, WelComeP> implements WelComeView {


    @BindView(R.id.welcome_hint_tv)
    TextView welcomeHintTv;
    @BindView(R.id.welcome_cityname_tv)
    TextView welcomeCitynameTv;
    @BindView(R.id.welcome_appname_tv)
    TextView welcomeAppnameTv;
    @BindView(R.id.welcome_cityname)
    TextView welcomeCityname;

    @Override
    protected WelComeP createPresenter() {
        return new WelComeP(this);
    }

    @Override
    public int bindLayout() {
        return R.layout.welcome_acty;
    }

    @Override
    protected void init(Bundle bundle) {
        ActyUtil.getInstance().AddActy(this);
    }

    @Override
    public void doBusiness(Context mContext) {
        mPresenter.Init();
    }

    @Override
    public void LoadDismiss() {

    }

    @Override
    public void setFontType(Typeface typeface) {
        welcomeAppnameTv.setTypeface(typeface);
        welcomeCitynameTv.setTypeface(typeface);
    }

    @Override
    public void setAppName(String appName) {
        welcomeAppnameTv.setText(appName);
    }

    @Override
    public void setCityName(String cityName) {
        welcomeCitynameTv.setText(cityName);

    }

    @Override
    public void setCityNames(String cityName) {
        welcomeCityname.setText(cityName);
    }

    @Override
    public void setWelcomeHint(String hintStr) {
        welcomeHintTv.setVisibility(View.VISIBLE);
        welcomeHintTv.setText(hintStr);
    }

    @Override
    public void hideWelcomeHint() {
        welcomeHintTv.setVisibility(View.GONE);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        //就多一个参数this
        PermissionsUtils.getInstance().onRequestPermissionsResult(this, requestCode, grantResults);
    }
}
