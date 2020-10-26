package com.hnkc.ydcj.main.wisdomPatrol.list.p;

import android.app.Activity;

import com.hnkc.ydcj.main.wisdomPatrol.bean.WisdTaskBean;

public interface IwisdomPatrolListFrg {

    void Init();

    void getWindTaskList();

    void StartActy(WisdTaskBean wisdTaskBean);
}
