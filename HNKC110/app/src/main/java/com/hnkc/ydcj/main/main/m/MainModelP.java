package com.hnkc.ydcj.main.main.m;

import com.hnkc.ydcj.base.CallBack;
import com.hnkc.ydcj.main.main.bean.ModuleBean;
import com.hnkc.ydcj.utils.DbUtils;

import java.util.ArrayList;
import java.util.List;

public class MainModelP implements ImainModel {
    public MainModelP() {
        saveModuleList();
    }

    @Override
    public void getMianModuleList(CallBack callBack) {
        List<ModuleBean> moduleList=DbUtils.getInstance().FindMianModuleList();
        callBack.onSuccess(moduleList);
    }

    @Override
    public void getAidedModuleList(CallBack callBack) {
        List<ModuleBean> moduleList=DbUtils.getInstance().FindAidedModuleList();
        callBack.onSuccess(moduleList);
    }


    private void saveModuleList(){
        List<ModuleBean> moduleList = new ArrayList<>();
        moduleList.add(new ModuleBean("jqcl", "警情处理", "0", "1", "alert_dispose_icon.png", null, "0"));
        moduleList.add(new ModuleBean("zhxk", "智慧巡控", "0", "1", "zhxk_icon.png", null, "0"));
        moduleList.add(new ModuleBean("qwbb", "勤务报备", "0", "1", "qwbb_icon.png", null, "0"));
        moduleList.add(new ModuleBean("xxcj", "信息采集", "0", "1", "qwbb_icon.png", null, "0"));

        moduleList.add(new ModuleBean("jrjq", "今日警情", "1", "1", "oneday_alert_icon.png", null, "0"));
        moduleList.add(new ModuleBean("jqcx", "警情查询", "1", "1", "query_icon.png", null, "0"));
        moduleList.add(new ModuleBean("ydyq", "移动要情", "1", "1", "ydyq_icon.png", null, "0"));
        moduleList.add(new ModuleBean("zjjq", "自接警情", "1", "1", "zjjq_icon.png", null, "0"));
        moduleList.add(new ModuleBean("wjld", "五级联动", "1", "1", "linkage_alert_icon.png", null, "0"));
        DbUtils.getInstance().SaveModule(moduleList);
    }
}
