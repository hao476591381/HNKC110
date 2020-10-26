package com.hnkc.ydcj.main.dutyReport.p;

import android.app.Activity;

import com.hnkc.ydcj.base.BasePresenter;
import com.hnkc.ydcj.main.dutyReport.v.DutyReportView;

/**
 * 勤务报备
 */
public class DutyReportImpl extends BasePresenter<DutyReportView> implements IdutyReport {
    private Activity activity;

    public DutyReportImpl(Activity activity) {
        this.activity = activity;
    }
}
