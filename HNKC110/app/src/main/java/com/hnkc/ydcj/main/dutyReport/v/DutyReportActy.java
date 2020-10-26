package com.hnkc.ydcj.main.dutyReport.v;

import android.content.Context;
import android.os.Bundle;
import android.widget.TextView;

import com.hnkc.ydcj.R;
import com.hnkc.ydcj.base.BaseActy;
import com.hnkc.ydcj.main.dutyReport.p.DutyReportImpl;
import com.hnkc.ydcj.utils.ActyUtil;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 勤务报备
 */
public class DutyReportActy extends BaseActy<DutyReportView, DutyReportImpl> implements DutyReportView {
    @BindView(R.id.title_bar_name)
    TextView titleBarName;

    @Override
    protected DutyReportImpl createPresenter() {
        return new DutyReportImpl(this);
    }

    @Override
    public int bindLayout() {
        return R.layout.dutyreport_acty;
    }

    @Override
    protected void init(Bundle bundle) {
        ActyUtil.getInstance().AddActy(this);
        titleBarName.setText("勤务报备");
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
