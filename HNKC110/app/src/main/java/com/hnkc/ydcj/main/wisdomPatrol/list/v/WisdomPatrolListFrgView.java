package com.hnkc.ydcj.main.wisdomPatrol.list.v;

import com.hnkc.ydcj.base.BaseView;
import com.hnkc.ydcj.main.wisdomPatrol.bean.WisdTaskBean;

import java.util.List;

public interface WisdomPatrolListFrgView extends BaseView {

    void autoRefresh();

    void finishRefresh();

    void ShowWisdlistFrgHint(String hintStr);

    void HideWisdlistFrgHint();

    void ShowWisdTaskList(List<WisdTaskBean> wisdTaskList);
}
