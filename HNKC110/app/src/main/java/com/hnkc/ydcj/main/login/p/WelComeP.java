package com.hnkc.ydcj.main.login.p;

import android.app.Activity;
import android.content.Context;
import android.graphics.Typeface;
import android.view.View;

import androidx.annotation.NonNull;

import com.hg.lib.tool.PermissionsUtils;
import com.hnkc.ydcj.base.BasePresenter;
import com.hnkc.ydcj.base.InitCoFig;
import com.hnkc.ydcj.main.login.ConFig;
import com.hnkc.ydcj.main.login.m.ILoginModel;
import com.hnkc.ydcj.main.login.m.LoginModelP;
import com.hnkc.ydcj.main.login.v.LoginActy;
import com.hnkc.ydcj.main.login.v.WelComeView;
import com.hnkc.ydcj.main.main.v.MainActy;
import com.hnkc.ydcj.utils.ActyUtil;
import com.yanzhenjie.permission.Action;
import com.yanzhenjie.permission.AndPermission;
import com.yanzhenjie.permission.Rationale;
import com.yanzhenjie.permission.RequestExecutor;

import java.util.List;

public class WelComeP extends BasePresenter<WelComeView> implements IwelCome {
    private Activity activity;
    private ILoginModel loginModel;

    public WelComeP(Activity activity) {
        this.activity = activity;
        loginModel = new LoginModelP();
    }

    @Override
    public void Init() {
        getView().setCityName(InitCoFig.CITY_NAME + "市公安局");
        getView().setCityNames(InitCoFig.CITY_NAME);
        getView().setAppName(InitCoFig.WELCOME_APP_NAME);
        setFontType(activity);
        PermissionsUtils.getInstance().chekPermissions(activity, InitCoFig.PERMISSION_ARRAY, new PermissionsUtils.IPermissionsResult() {
            @Override
            public void passPermissons() {
                InitLogin(activity);
            }

            @Override
            public void forbitPermissons() {
                getView().setWelcomeHint("手机权限已被禁止，请从重新进入App!");
            }
        });
    }

    /**
     * 设置字体样式
     */
    private void setFontType(Activity activity) {
        //将字体文件保存在assets/fonts/目录下，创建Typeface对象
        Typeface typeface = Typeface.createFromAsset(activity.getAssets(), "fonnts/FZLTTHJW.TTF");
        getView().setFontType(typeface);
    }

    private void InitLogin(Activity activity) {
        if (loginModel.getLoginState().equals("yes")) {
            ActyUtil.getInstance().startActy(activity, MainActy.class);
            ActyUtil.getInstance().removeActy(activity);
        } else {
            if (loginModel.getLoginWay().equals(ConFig.LOGIN_WAY_WECHAT)) {
                WeChatLogin(activity);
            } else if (loginModel.getLoginWay().equals(ConFig.LOGIN_WAY_ZHMM)) {
                ActyUtil.getInstance().startActy(activity, LoginActy.class);
                ActyUtil.getInstance().removeActy(activity);
            }
        }
    }

    private void WeChatLogin(Activity activity) {
        String WeChataCode = activity.getIntent().getStringExtra("launchParam");
        if (WeChataCode != null) {
            getView().hideWelcomeHint();
            String code = WeChataCode.split("=")[1];
            ActyUtil.getInstance().startActy(activity, MainActy.class);
            ActyUtil.getInstance().removeActy(activity);
        } else {
            getView().setWelcomeHint("请从政务微信登录!");
        }
    }
}