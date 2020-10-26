package com.hnkc.ydcj.main.wisdomPatrol.list.v;

import androidx.fragment.app.Fragment;

import com.hg.lib.treeview.TreeBean;
import com.hnkc.ydcj.base.BaseView;

import java.util.ArrayList;
import java.util.List;

public interface WisdomPatrolListView extends BaseView {

    void setWisdlistTaskType(String typeName);

    void setTaskTypeBar(List<TreeBean> taskTypeList);

    void setPagerAdapter(ArrayList<Fragment> frgList, String[] titleArry);

    void setTabData(String[] titleArry);


}
