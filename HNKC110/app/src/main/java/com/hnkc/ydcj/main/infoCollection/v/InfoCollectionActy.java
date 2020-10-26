package com.hnkc.ydcj.main.infoCollection.v;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.flyco.tablayout.CommonTabLayout;
import com.flyco.tablayout.listener.CustomTabEntity;
import com.flyco.tablayout.listener.OnTabSelectListener;
import com.hg.lib.TimerPicker.TimePicker;
import com.hg.lib.tool.DateTool;
import com.hg.lib.view.LicensePlateView;
import com.hnkc.ydcj.R;
import com.hnkc.ydcj.base.BaseActy;
import com.hnkc.ydcj.main.infoCollection.p.InfoCollectionImpl;
import com.hnkc.ydcj.utils.ActyUtil;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 信息采集
 */
public class InfoCollectionActy extends BaseActy<InfoCollectionView, InfoCollectionImpl> implements InfoCollectionView, OnTabSelectListener {
    @BindView(R.id.title_bar_name)
    TextView titleBarName;
    @BindView(R.id.infocollection_tab)
    CommonTabLayout infocollectionTab;
    @BindView(R.id.collecton_people_include)
    LinearLayout collectonPeopleInclude;
    @BindView(R.id.collecton_vehicle_include)
    RelativeLayout collectonVehicleInclude;
    @BindView(R.id.title_bar_but)
    TextView titleBarBut;
    @BindView(R.id.people_name)
    EditText peopleName;
    @BindView(R.id.people_type)
    TextView peopleType;
    @BindView(R.id.people_sex)
    TextView peopleSex;
    @BindView(R.id.people_nationality)
    TextView peopleNationality;
    @BindView(R.id.people_native_place)
    TextView peopleNativePlace;
    @BindView(R.id.people_nation)
    TextView peopleNation;
    @BindView(R.id.people_race)
    TextView peopleRace;
    @BindView(R.id.people_id_type)
    TextView peopleIdType;
    @BindView(R.id.people_id_number)
    TextView peopleIdNumber;
    @BindView(R.id.people_date_of_birth)
    TextView peopleDateOfBirth;
    @BindView(R.id.people_koseki)
    EditText peopleKoseki;
    @BindView(R.id.people_contact_information)
    EditText peopleContactInformation;
    @BindView(R.id.people_contact_address)
    TextView peopleContactAddress;
    @BindView(R.id.people_residential_address)
    TextView peopleResidentialAddress;
    @BindView(R.id.collection_person)
    EditText collectionPerson;
    @BindView(R.id.collection_time)
    TextView collectionTime;
    @BindView(R.id.collection_addr)
    TextView collectionAddr;
    @BindView(R.id.vehicle_type)
    TextView vehicleType;
    @BindView(R.id.vehicle_color)
    TextView vehicleColor;
    @BindView(R.id.license_plate_type)
    TextView licensePlateType;
    @BindView(R.id.vehicle_owner_name)
    EditText vehicleOwnerName;
    @BindView(R.id.infocollection_ll)
    RelativeLayout infocollectionLl;
    @BindView(R.id.license_plate_number)
    LicensePlateView licensePlateNumber;

    @Override
    protected InfoCollectionImpl createPresenter() {
        return new InfoCollectionImpl(this);
    }

    @Override
    public int bindLayout() {
        return R.layout.infocollection_acty;
    }

    @Override
    protected void init(Bundle bundle) {
        ActyUtil.getInstance().AddActy(this);
        titleBarName.setText("信息采集");
        mPresenter.Init();
    }

    @Override
    public void doBusiness(Context mContext) {
        infocollectionTab.setOnTabSelectListener(this);
        licensePlateNumber.setKeyboardContainerLayout(infocollectionLl);
    }

    @Override
    public void LoadDismiss() {

    }

    @Override
    public void showTitleBarBut(String barName) {
        titleBarBut.setVisibility(View.VISIBLE);
        titleBarBut.setText(barName);
    }

    @Override
    public void setTabData(ArrayList<CustomTabEntity> mTabEntities) {
        infocollectionTab.setTabData(mTabEntities);
    }

    @Override
    public void ShowCollectonPeopleInclude() {
        //人员采集视图
        collectonPeopleInclude.setVisibility(View.VISIBLE);
        collectonVehicleInclude.setVisibility(View.GONE);
    }

    @Override
    public void ShowCollectonVehicleInclude() {
        //车辆采集视图
        collectonPeopleInclude.setVisibility(View.GONE);
        collectonVehicleInclude.setVisibility(View.VISIBLE);
    }

    @Override
    public void setCollectionTime(String time) {
        collectionTime.setText(time);
    }

    @Override
    public String getCollectionPersonName() {
        return getStr(collectionPerson);
    }

    @Override
    public String getCollectionTime() {
        return getStr(collectionTime);
    }

    @Override
    public String getPeopleName() {
        return getStr(peopleName);
    }

    @Override
    public String getPeopleNativePlace() {
        return getStr(peopleNativePlace);
    }

    @Override
    public String getPeopleIdNumber() {
        return getStr(peopleIdNumber);
    }

    @Override
    public String getPeopleKoseki() {
        return getStr(peopleKoseki);
    }

    @Override
    public String getPeopleContactInformation() {
        return getStr(peopleContactInformation);
    }

    @Override
    public String getVehicleOwnerName() {
        return getStr(vehicleOwnerName);
    }

    @Override
    public String getLicensePlateNumber() {
        return licensePlateNumber.getLPContent();
    }

    @Override
    public void onTabSelect(int position) {
        mPresenter.selcetInfoType(position);
    }

    @Override
    public void onTabReselect(int position) {

    }

    @OnClick({R.id.title_bar_return, R.id.title_bar_but, R.id.collection_time, R.id.people_date_of_birth
            , R.id.people_type, R.id.people_sex, R.id.people_nationality, R.id.people_nation, R.id.people_id_type
            , R.id.collection_addr, R.id.people_contact_address, R.id.people_residential_address, R.id.people_race
            , R.id.vehicle_type, R.id.vehicle_color, R.id.license_plate_type, R.id.license_plate_number})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.title_bar_return:
                ActyUtil.getInstance().removeActy(this);
                break;
            case R.id.collection_time:
                //采集时间
                TimePicker.Time(this, collectionTime, getStr(collectionTime));
                break;
            case R.id.people_date_of_birth:
                //出生日期
                TimePicker.Date(this, peopleDateOfBirth, DateTool.getTodayShort());
                break;
            case R.id.people_type:
                //人员类型
                mPresenter.showDict(1, peopleType);
                break;
            case R.id.people_sex:
                //人员性别
                mPresenter.showDict(2, peopleSex);
                break;
            case R.id.people_nationality:
                //人员国籍
                mPresenter.showDict(3, peopleNationality);
                break;
            case R.id.people_nation:
                //人员民族
                mPresenter.showDict(4, peopleNation);
                break;
            case R.id.people_id_type:
                //证件类型
                mPresenter.showDict(5, peopleIdType);
                break;
            case R.id.people_race:
                //人员种族
                mPresenter.showDict(6, peopleRace);
                break;
            case R.id.vehicle_type:
                //车辆类型
                mPresenter.showDict(7, vehicleType);
                break;
            case R.id.vehicle_color:
                //车身颜色
                mPresenter.showDict(8, vehicleColor);
                break;
            case R.id.license_plate_type:
                //号码种类
                mPresenter.showDict(9, licensePlateType);
                break;
            case R.id.license_plate_number:
                //输入车牌号 todo
                break;
            case R.id.collection_addr:
                //采集地址
                mPresenter.selectAddr(collectionAddr, 1);
                break;
            case R.id.people_contact_address:
                //联系地址
                mPresenter.selectAddr(peopleContactAddress, 2);
                break;
            case R.id.people_residential_address:
                //居住地址
                mPresenter.selectAddr(peopleResidentialAddress, 3);
                break;
            case R.id.title_bar_but:
                //提交
                mPresenter.submitCollectionInfo();
                break;
        }
    }

}
