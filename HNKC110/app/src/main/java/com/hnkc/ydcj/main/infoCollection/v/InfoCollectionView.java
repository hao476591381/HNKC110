package com.hnkc.ydcj.main.infoCollection.v;

import com.flyco.tablayout.listener.CustomTabEntity;
import com.hnkc.ydcj.base.BaseView;

import java.util.ArrayList;

public interface InfoCollectionView extends BaseView {

    void showTitleBarBut(String barName);

    void setTabData(ArrayList<CustomTabEntity> mTabEntities);

    void ShowCollectonPeopleInclude(); //人员采集视图

    void ShowCollectonVehicleInclude(); //车辆采集视图

    void setCollectionTime(String time);//设置采集时间

    /*获取基本信息*/
    String getCollectionPersonName();//采集人员姓名

    String getCollectionTime();//采集时间

    /*获取人员基本信息*/
    String getPeopleName();//人员姓名

    String getPeopleNativePlace();//人员籍贯

    String getPeopleIdNumber();//人员证件号码

    String getPeopleKoseki();//人员户籍

    String getPeopleContactInformation();//人员联系方式

    /*获取车辆基本信息*/
    String getVehicleOwnerName();//车主姓名

    String getLicensePlateNumber();//车牌号码
}
