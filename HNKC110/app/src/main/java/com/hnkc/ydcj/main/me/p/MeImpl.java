package com.hnkc.ydcj.main.me.p;

import android.app.Activity;

import com.hnkc.ydcj.base.BasePresenter;
import com.hnkc.ydcj.main.me.v.MeView;

public class MeImpl extends BasePresenter<MeView> implements Ime {
    public MeImpl(Activity activity) {
    }

    @Override
    public void Init() {
        getView().setTitleBarName("个人中心");
        getView().setMeUsername("张三");
        getView().setMeUserduty("巡警");
        getView().setMePoliceNumber("888888");
        getView().setMePoliceUnit("市局指挥中心");
    }
}
