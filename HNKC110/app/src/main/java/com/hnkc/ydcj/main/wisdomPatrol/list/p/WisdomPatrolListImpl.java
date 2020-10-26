package com.hnkc.ydcj.main.wisdomPatrol.list.p;

import android.app.Activity;

import androidx.fragment.app.Fragment;

import com.hg.lib.tool.LiveDataBus;
import com.hg.lib.treeview.TreeBean;
import com.hnkc.ydcj.base.BasePresenter;
import com.hnkc.ydcj.main.wisdomPatrol.list.v.WisdomPatrolListFrag;
import com.hnkc.ydcj.main.wisdomPatrol.list.v.WisdomPatrolListView;

import java.util.ArrayList;
import java.util.List;

public class WisdomPatrolListImpl extends BasePresenter<WisdomPatrolListView> implements IwisdomPatrolList {
    public WisdomPatrolListImpl(Activity activity) {
    }

    @Override
    public void Init() {
        // getView().setWisdlistTaskType("全部");
        getView().setTabData(getTitleArry());
        getView().setPagerAdapter(getFrgList(), getTitleArry());

    }

    @Override
    public void selectTaskType(String typeName, String typeCode) {
        getView().setWisdlistTaskType(typeName);
        LiveDataBus.get().with("WisdomPatrolListFragImpl").postValue(typeCode);
    }

    @Override
    public void showTaskTypeBar() {
        List<TreeBean> taskTypeList = new ArrayList<>();
        taskTypeList.add(new TreeBean("00", "", "全部"));
        taskTypeList.add(new TreeBean("0", "", "盘查任务"));
        taskTypeList.add(new TreeBean("1", "", "集结任务"));
        taskTypeList.add(new TreeBean("2", "", "重大安保任务"));
        getView().setTaskTypeBar(taskTypeList);
    }

    private ArrayList<Fragment> getFrgList() {
        ArrayList<Fragment> frgList = new ArrayList<>();
        for (String title : getTitleArry()) {
            frgList.add(WisdomPatrolListFrag.getInstance(title));
        }
        return frgList;
    }

    private String[] getTitleArry() {
        return new String[]{"未签收", "正在处理", "处理完毕"};
    }

}
