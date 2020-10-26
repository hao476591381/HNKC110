package com.hnkc.ydcj.main.wisdomPatrol.list.m;

import com.hnkc.ydcj.base.CallBack;

public interface WisdListModel {

    void requestWisdTaskList(String taskState, String tasktype, CallBack callBack);
}
