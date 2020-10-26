package com.hnkc.ydcj.main.wisdomPatrol.list.p;

import androidx.fragment.app.FragmentActivity;

import com.hg.lib.tool.LiveDataBus;
import com.hg.lib.tool.ShowLog;
import com.hg.lib.tool.Toast;
import com.hnkc.ydcj.base.BasePresenter;
import com.hnkc.ydcj.base.CallBack;
import com.hnkc.ydcj.main.wisdomPatrol.bean.WisdTaskBean;
import com.hnkc.ydcj.main.wisdomPatrol.list.m.WisdListModelImpl;
import com.hnkc.ydcj.main.wisdomPatrol.list.v.WisdomPatrolListFrgView;

import java.util.List;

public class WisdomPatrolListFragImpl extends BasePresenter<WisdomPatrolListFrgView> implements IwisdomPatrolListFrg {
    private FragmentActivity activity;
    private WisdListModelImpl wisdListModel;
    private String title;
    private String type = "00";

    public WisdomPatrolListFragImpl(FragmentActivity activity, String title) {
        this.activity = activity;
        this.title = title;
        wisdListModel = new WisdListModelImpl();
    }

    @Override
    public void Init() {
        getView().autoRefresh();
        LiveDataBus.get().with("WisdomPatrolListFragImpl").observe(activity, o -> {
            try {
                type = o.toString();
                getView().autoRefresh();
            } catch (Throwable e) {
                ShowLog.sys(e.getMessage());
            }
        });
    }

    @Override
    public void getWindTaskList() {
        wisdListModel.requestWisdTaskList(title, type, new CallBack<List<WisdTaskBean>>() {
            @Override
            public void onSuccess(List<WisdTaskBean> wisdTaskList) {
                getView().ShowWisdTaskList(wisdTaskList);
                getView().HideWisdlistFrgHint();
                getView().finishRefresh();
            }

            @Override
            public void onError(String error, int requestFlag) {
                getView().ShowWisdlistFrgHint(error);
                getView().finishRefresh();
            }
        });
    }

    @Override
    public void StartActy(WisdTaskBean wisdTaskBean) {
        Toast.Show(activity,wisdTaskBean.getTaskName(),true);
    }
}
