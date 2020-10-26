package com.hnkc.ydcj.main.wisdomPatrol.list.m;

import com.hnkc.ydcj.base.CallBack;
import com.hnkc.ydcj.main.wisdomPatrol.bean.WisdTaskBean;

import java.util.ArrayList;
import java.util.List;

public class WisdListModelImpl implements WisdListModel {

    @Override
    public void requestWisdTaskList(String taskState, String tasktype, CallBack callBack) {
        try {
            List<WisdTaskBean> wisdTaskList = new ArrayList<>();
            List<WisdTaskBean> mList = getWisdTaskDate();
            if (tasktype.equals("00")) {
                for (int i = 0; i < mList.size(); i++) {
                    if (taskState.equals(mList.get(i).getTaskState())) {
                        wisdTaskList.add(mList.get(i));
                    }
                }
                callBack.onSuccess(wisdTaskList);
            } else {
                for (int i = 0; i < mList.size(); i++) {
                    if (taskState.equals(mList.get(i).getTaskState()) && tasktype.equals(mList.get(i).getTaskType())) {
                        wisdTaskList.add(mList.get(i));
                    }
                }
                callBack.onSuccess(wisdTaskList);
            }
        } catch (Throwable e) {
            callBack.onError("任务查询失败", 0);
        }
    }

    private List<WisdTaskBean> getWisdTaskDate() {
        List<WisdTaskBean> list = new ArrayList<>();
        list.add(new WisdTaskBean("0000", "未签收", "0", "盘查任务"));
        list.add(new WisdTaskBean("0001", "未签收", "1", "集结任务"));
        list.add(new WisdTaskBean("0002", "未签收", "2", "重大安保任务"));
        list.add(new WisdTaskBean("0003", "正在处理", "0", "盘查任务"));
        list.add(new WisdTaskBean("0004", "正在处理", "1", "集结任务"));
        list.add(new WisdTaskBean("0005", "正在处理", "2", "重大安保任务"));
        list.add(new WisdTaskBean("0006", "处理完毕", "0", "盘查任务"));
        list.add(new WisdTaskBean("0007", "处理完毕", "1", "集结任务"));
        list.add(new WisdTaskBean("0008", "处理完毕", "2", "重大安保任务"));

        list.add(new WisdTaskBean("0009", "未签收", "0", "盘查任务"));
        list.add(new WisdTaskBean("0010", "未签收", "1", "集结任务"));
        list.add(new WisdTaskBean("0011", "未签收", "2", "重大安保任务"));
        return list;

    }
}
