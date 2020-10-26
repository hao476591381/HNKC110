package com.hnkc.ydcj.main.alert.list.v;

import android.content.Context;
import android.os.Bundle;
import android.widget.TextView;

import com.hnkc.ydcj.R;
import com.hnkc.ydcj.base.BaseActy;
import com.hnkc.ydcj.main.alert.list.p.AlertListImpl;
import com.hnkc.ydcj.utils.ActyUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 警情处理
 */
public class AlertListActy extends BaseActy<AlertListView, AlertListImpl> implements AlertListView {
    @BindView(R.id.title_bar_name)
    TextView titleBarName;

    @Override
    protected AlertListImpl createPresenter() {
        return new AlertListImpl(this);
    }

    @Override
    public int bindLayout() {
        return R.layout.alertlist_acty;
    }

    @Override
    protected void init(Bundle bundle) {
        ActyUtil.getInstance().AddActy(this);
        titleBarName.setText("警情列表");
    }

    @Override
    public void doBusiness(Context mContext) {

    }

    @Override
    public void LoadDismiss() {

    }


    @OnClick(R.id.title_bar_return)
    public void onViewClicked() {
        ActyUtil.getInstance().removeActy(this);
    }
}
