package com.hnkc.ydcj.main.main.v;

import com.hnkc.ydcj.base.BaseView;
import com.hnkc.ydcj.main.main.bean.ModuleBean;

import java.util.List;

public interface MainView extends BaseView {
    void setMainViewTitle(String title);

    void setMainViewHead(String imgPath);

    void setMainViewUserName(String userName);

    void setMainViewUserNumber(String userNumber);

    void setMainViewUserUnit(String userUnit);

    void setMainViewPdt(String pdt);

    void setMainViewWorkStatus(String workStatus);

    void setMainAdater(List<ModuleBean> moduleList);

    void setAidedAdater(List<ModuleBean> moduleList);

}
