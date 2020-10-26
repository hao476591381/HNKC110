package com.hnkc.ydcj.main.login.p;

import android.app.Activity;
import android.graphics.Typeface;

import com.hg.lib.tool.Toast;
import com.hnkc.ydcj.base.BasePresenter;
import com.hnkc.ydcj.base.InitCoFig;
import com.hnkc.ydcj.main.login.UserInfoSp;
import com.hnkc.ydcj.main.login.m.ILoginModel;
import com.hnkc.ydcj.main.login.m.LoginModelP;
import com.hnkc.ydcj.main.login.v.LoginView;
import com.hnkc.ydcj.main.main.v.MainActy;
import com.hnkc.ydcj.utils.ActyUtil;

public class LoginImpl extends BasePresenter<LoginView> implements Ilogin {
    private ILoginModel loginModel;
    private Activity activity;

    public LoginImpl(Activity activity) {
        this.activity=activity;
        loginModel = new LoginModelP();
    }

    @Override
    public void Init() {
        getView().setAppName(InitCoFig.LOGIN_APP_NAME);
        getView().setCityName(InitCoFig.CITY_NAME);
        setFontType(activity);
    }

    @Override
    public void submitLogin() {
        if (!getView().getUserName().isEmpty()) {
            if (!getView().getPassWord().isEmpty()) {
                UserInfoSp.setLoginState("yes");
                ActyUtil.getInstance().startActy(activity, MainActy.class);
                ActyUtil.getInstance().removeActy(activity);
            } else {
                Toast.Show(activity, "密码不能为空!", false);
            }
        } else {
            Toast.Show(activity, "账号不能为空!", false);
        }
    }

    /**
     * 设置字体样式
     */
    private void setFontType(Activity activity) {
        //将字体文件保存在assets/fonts/目录下，创建Typeface对象
        Typeface typeface = Typeface.createFromAsset(activity.getAssets(), "fonnts/FZLTTHJW.TTF");
        getView().setFontType(typeface);
    }
}
