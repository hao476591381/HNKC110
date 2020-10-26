package com.hnkc.ydcj.main.infoCollection.p;

import android.app.Activity;
import android.widget.TextView;

import com.flyco.tablayout.listener.CustomTabEntity;
import com.hg.lib.tool.CharShift;
import com.hg.lib.tool.DateTool;
import com.hg.lib.tool.GsonUtil;
import com.hg.lib.tool.Toast;
import com.hg.lib.treeview.TreeBean;
import com.hg.lib.treeview.TreeView;
import com.hnkc.ydcj.base.BasePresenter;
import com.hnkc.ydcj.base.CallBack;
import com.hnkc.ydcj.main.infoCollection.bean.TabEntity;
import com.hnkc.ydcj.main.infoCollection.v.InfoCollectionView;
import com.hnkc.ydcj.map.bean.PoiAddrBean;
import com.hnkc.ydcj.map.v.MapActy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class InfoCollectionImpl extends BasePresenter<InfoCollectionView> implements IinfoCollection {
    private Activity activity;
    private Map<String, String> peopleInfoMap;
    private int collectionTypeCode = 0;

    public InfoCollectionImpl(Activity activity) {
        this.activity = activity;
    }

    @Override
    public void Init() {
        setTabData();
        peopleInfoMap = new HashMap<>();
        getView().showTitleBarBut("提交");
        getView().setCollectionTime(DateTool.getSysData("2"));
    }

    @Override
    public void selcetInfoType(int typeCode) {
        this.collectionTypeCode = typeCode;
        switch (typeCode) {
            case 0:
                //人员采集
                getView().ShowCollectonPeopleInclude();
                break;
            case 1:
                //车辆采集
                getView().ShowCollectonVehicleInclude();
                break;
        }
    }

    @Override
    public void showDict(int dictTag, TextView textView) {
        List<TreeBean> dictList = new ArrayList<>();
        switch (dictTag) {
            case 1:
                //人员类型
                dictList.add(new TreeBean("0", "", "正常"));
                dictList.add(new TreeBean("1", "", "涉毒"));
                dictList.add(new TreeBean("2", "", "涉赌"));
                dictList.add(new TreeBean("3", "", "其他"));
                TreeView.Show(activity, textView, dictList, (id, name) -> {
                    textView.setText(name);
                    peopleInfoMap.put("peopleType", name);
                }, false, true);
                break;
            case 2:
                //人员性别
                dictList.add(new TreeBean("0", "", "男"));
                dictList.add(new TreeBean("1", "", "女"));
                TreeView.Show(activity, textView, dictList, (id, name) -> {
                    textView.setText(name);
                    peopleInfoMap.put("peopleSex", name);
                }, false, true);
                break;
            case 3:
                //人员国籍
                dictList.add(new TreeBean("0", "", "中国"));
                dictList.add(new TreeBean("1", "", "美国"));
                dictList.add(new TreeBean("2", "", "英国"));
                dictList.add(new TreeBean("3", "", "韩国"));
                dictList.add(new TreeBean("4", "", "朝鲜"));
                TreeView.Show(activity, textView, dictList, (id, name) -> {
                    textView.setText(name);
                    peopleInfoMap.put("nationality", name);
                }, false, true);
                break;
            case 4:
                //人员民族
                dictList.add(new TreeBean("0", "", "汉族"));
                dictList.add(new TreeBean("1", "", "满族"));
                dictList.add(new TreeBean("2", "", "土家族"));
                dictList.add(new TreeBean("3", "", "朝鲜族"));
                dictList.add(new TreeBean("4", "", "维吾尔族"));
                TreeView.Show(activity, textView, dictList, (id, name) -> {
                    textView.setText(name);
                    peopleInfoMap.put("peopleNation", name);
                }, false, true);
                break;
            case 5:
                //证件类型
                dictList.add(new TreeBean("0", "", "身份证"));
                dictList.add(new TreeBean("1", "", "驾驶证"));
                dictList.add(new TreeBean("2", "", "护照"));
                TreeView.Show(activity, textView, dictList, (id, name) -> {
                    textView.setText(name);
                    peopleInfoMap.put("peopleIdType", name);
                }, false, true);
                break;

            case 6:
                //人员种族  东亚人种（黄种人）、高加索人种（白种人）、尼格罗人种（黑种人）、澳洲人种（棕种人）。
                dictList.add(new TreeBean("0", "", "东亚人种"));
                dictList.add(new TreeBean("1", "", "高加索人种"));
                dictList.add(new TreeBean("2", "", "尼格罗人种"));
                dictList.add(new TreeBean("3", "", "澳洲人种"));
                TreeView.Show(activity, textView, dictList, (id, name) -> {
                    textView.setText(name);
                    peopleInfoMap.put("peopleRace", name);
                }, false, true);
                break;
            case 7:
                //车辆类型
                dictList.add(new TreeBean("0", "", "大型车乘用车"));
                dictList.add(new TreeBean("1", "", "中型乘用车"));
                dictList.add(new TreeBean("2", "", "小型乘用车"));
                dictList.add(new TreeBean("3", "", "微型乘用车"));
                dictList.add(new TreeBean("4", "", "重型车载货车"));
                dictList.add(new TreeBean("5", "", "中型载货车"));
                dictList.add(new TreeBean("6", "", "小型载货车"));
                dictList.add(new TreeBean("7", "", "微型载货车"));
                dictList.add(new TreeBean("8", "", "三轮汽车"));
                dictList.add(new TreeBean("9", "", "低速货车"));
                dictList.add(new TreeBean("10", "", "摩托车"));
                dictList.add(new TreeBean("11", "", "重型挂车"));
                dictList.add(new TreeBean("12", "", "中型挂车"));
                dictList.add(new TreeBean("13", "", "轻型挂车"));
                TreeView.Show(activity, textView, dictList, (id, name) -> textView.setText(name), false, true);
                break;
            case 8:
                //车身颜色
                dictList.add(new TreeBean("0", "", "白色"));
                dictList.add(new TreeBean("1", "", "黑色"));
                dictList.add(new TreeBean("2", "", "红色"));
                dictList.add(new TreeBean("3", "", "银白色"));
                dictList.add(new TreeBean("4", "", "银色"));
                dictList.add(new TreeBean("5", "", "银灰色"));
                dictList.add(new TreeBean("6", "", "黄色"));
                TreeView.Show(activity, textView, dictList, (id, name) -> textView.setText(name), false, true);
                break;
            case 9:
                //车牌种类
                dictList.add(new TreeBean("0", "", "小型汽车号牌"));
                dictList.add(new TreeBean("1", "", "大型汽车号牌"));
                dictList.add(new TreeBean("2", "", "挂车号牌"));
                dictList.add(new TreeBean("3", "", "使、领馆汽车号牌"));
                dictList.add(new TreeBean("4", "", "港澳入出境车号牌"));
                dictList.add(new TreeBean("5", "", "教练汽车号牌"));
                dictList.add(new TreeBean("6", "", "警用汽车号牌"));
                dictList.add(new TreeBean("7", "", "新式军牌"));
                TreeView.Show(activity, textView, dictList, (id, name) -> textView.setText(name), false, true);
                break;
        }
    }

    @Override
    public void selectAddr(TextView textView, int addrTag) {
        MapActy.startMe(activity, new CallBack<PoiAddrBean.DataBean>() {
            @Override
            public void onSuccess(PoiAddrBean.DataBean dataBean) {
                textView.setText(dataBean.getAddress());
                PoiAddrBean.DataBean.LocationBean locationBean = dataBean.getLocation();
                switch (addrTag) {
                    case 1:
                        //采集地址
                        peopleInfoMap.put("collectionAddr", dataBean.getAddress());
                        peopleInfoMap.put("collectionAddrLat", CharShift.douToStr(locationBean.getLat()));
                        peopleInfoMap.put("collectionAddrLng", CharShift.douToStr(locationBean.getLng()));
                        break;
                    case 2:
                        //联系地址
                        peopleInfoMap.put("contactAddr", dataBean.getAddress());
                        peopleInfoMap.put("contactAddrLat", CharShift.douToStr(locationBean.getLat()));
                        peopleInfoMap.put("contactAddrLng", CharShift.douToStr(locationBean.getLng()));
                        break;
                    case 3:
                        //居住地址
                        peopleInfoMap.put("residentialAddr", dataBean.getAddress());
                        peopleInfoMap.put("residentialAddrLat", CharShift.douToStr(locationBean.getLat()));
                        peopleInfoMap.put("residentialAddrLng", CharShift.douToStr(locationBean.getLng()));
                        break;
                }
            }

            @Override
            public void onError(String error, int requestFlag) {

            }
        });
    }

    @Override
    public void submitCollectionInfo() {
        peopleInfoMap.put("infoId", UUID.randomUUID().toString().replaceAll("-", "")); //采集编号生成
        peopleInfoMap.put("collectionTime", getView().getCollectionTime());
        peopleInfoMap.put("ssdwmc", "市局指挥中心");
        peopleInfoMap.put("ssdwdm", "110110110");

        switch (collectionTypeCode) {
            case 0:
                //人员信息
                peopleInfoMap.put("peopleName", getView().getPeopleName());
                peopleInfoMap.put("peopleNativePlace", getView().getPeopleNativePlace());
                peopleInfoMap.put("peopleIdNumber", getView().getPeopleIdNumber());
                peopleInfoMap.put("peopleKoseki", getView().getPeopleKoseki());
                peopleInfoMap.put("peopleContactInformation", getView().getPeopleContactInformation());
                String infoJson = GsonUtil.getInstance().mapToJson(peopleInfoMap);
                Toast.Show(activity, infoJson, true);
                break;
            case 1:
                //车辆信息
                break;
        }
    }

    private void setTabData() {
        ArrayList<CustomTabEntity> mTabEntities = new ArrayList<>();
        mTabEntities.add(new TabEntity("人员", 0, 0));
        mTabEntities.add(new TabEntity("车辆", 0, 0));
        getView().setTabData(mTabEntities);
    }
}
