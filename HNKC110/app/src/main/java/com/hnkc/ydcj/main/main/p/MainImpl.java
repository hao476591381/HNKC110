package com.hnkc.ydcj.main.main.p;

import android.app.Activity;

import com.hg.lib.tool.Toast;
import com.hnkc.ydcj.base.BasePresenter;
import com.hnkc.ydcj.base.CallBack;
import com.hnkc.ydcj.base.InitCoFig;
import com.hnkc.ydcj.main.alert.list.v.AlertListActy;
import com.hnkc.ydcj.main.dutyReport.v.DutyReportActy;
import com.hnkc.ydcj.main.infoCollection.v.InfoCollectionActy;
import com.hnkc.ydcj.main.main.bean.ModuleBean;
import com.hnkc.ydcj.main.main.m.ImainModel;
import com.hnkc.ydcj.main.main.m.MainModelP;
import com.hnkc.ydcj.main.main.v.MainView;
import com.hnkc.ydcj.main.wisdomPatrol.list.v.WisdomPatrolListActy;
import com.hnkc.ydcj.service.ServiceManager;
import com.hnkc.ydcj.utils.ActyUtil;

import java.util.List;

public class MainImpl extends BasePresenter<MainView> implements Imain {
    private Activity mActivity;
    private ImainModel mainModel;

    public MainImpl(Activity activity) {
        this.mActivity = activity;
        mainModel = new MainModelP();
    }

    @Override
    public void Init() {
        ServiceManager.StartMsgPolling(mActivity);//开启消息通讯服务
        getView().setMainViewTitle(InitCoFig.LOGIN_APP_NAME);
        getView().setMainViewUserName("姓名:    张三");
        getView().setMainViewUserNumber("警号:    999999");
        getView().setMainViewUserUnit("单位:    市局指挥中心");
        getView().setMainViewPdt("88888888");
        getView().setMainViewWorkStatus("执勤中");

        mainModel.getMianModuleList(new CallBack<List<ModuleBean>>() {
            @Override
            public void onSuccess(List<ModuleBean> moduleList) {
                getView().setMainAdater(moduleList);
            }

            @Override
            public void onError(String error, int requestFlag) {

            }
        });

        mainModel.getAidedModuleList(new CallBack<List<ModuleBean>>() {
            @Override
            public void onSuccess(List<ModuleBean> moduleList) {
                getView().setAidedAdater(moduleList);
            }

            @Override
            public void onError(String error, int requestFlag) {

            }
        });
    }

    @Override
    public void StartActy(String appId) {
        switch (appId) {
            case "jqcl":
                //警情处理
                ActyUtil.getInstance().startActy(mActivity, AlertListActy.class);
                break;
            case "zhxk":
                //智慧巡控
                ActyUtil.getInstance().startActy(mActivity, WisdomPatrolListActy.class);
                break;
            case "qwbb":
                //勤务报备
                ActyUtil.getInstance().startActy(mActivity, DutyReportActy.class);
                break;
            case "xxcj":
                //信息采集
                ActyUtil.getInstance().startActy(mActivity, InfoCollectionActy.class);
                break;
            case "jrjq":
                //今日警情
                Toast.Show(mActivity, "今日警情", true);
                break;
            case "jqcx":
                //警情查询
                Toast.Show(mActivity, "警情查询", true);
                break;
            case "ydyq":
                //移动要情
                Toast.Show(mActivity, "移动要情", true);
                break;
            case "zjjq":
                //自接警情
                Toast.Show(mActivity, "自接警情", true);
                break;
            case "wjld":
                //五级联动
                Toast.Show(mActivity, "五级联动", true);
                break;
        }
    }
}
