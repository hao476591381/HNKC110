package com.hnkc.ydcj.main.alert.list.p;

import android.app.Activity;

import com.hnkc.ydcj.base.BasePresenter;
import com.hnkc.ydcj.main.alert.list.v.AlertListView;

/**
 * 警情处理
 */
public class AlertListImpl extends BasePresenter<AlertListView> implements IalertList {
    private Activity activity;
    public AlertListImpl(Activity activity) {
        this.activity=activity;
    }
}
