package com.hnkc.ydcj.main.me.v;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.hg.lib.tool.ImgBindTool;
import com.hnkc.ydcj.R;
import com.hnkc.ydcj.base.BaseActy;
import com.hnkc.ydcj.main.me.p.MeImpl;
import com.hnkc.ydcj.service.ServiceManager;
import com.hnkc.ydcj.utils.ActyUtil;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 个人中心
 */
public class MeActy extends BaseActy<MeView, MeImpl> implements MeView {
    @BindView(R.id.title_bar_name)
    TextView titleBarName;
    @BindView(R.id.me_head_iv)
    ImageView meHeadIv;
    @BindView(R.id.me_username_tv)
    TextView meUsernameTv;
    @BindView(R.id.me_userduty_tv)
    TextView meUserdutyTv;
    @BindView(R.id.me_police_number)
    TextView mePoliceNumber;
    @BindView(R.id.me_police_unit)
    TextView mePoliceUnit;

    @Override
    protected MeImpl createPresenter() {
        return new MeImpl(this);
    }

    @Override
    public int bindLayout() {
        return R.layout.me_acty;
    }

    @Override
    protected void init(Bundle bundle) {
        ActyUtil.getInstance().AddActy(this);
        mPresenter.Init();
    }

    @Override
    public void doBusiness(Context mContext) {

    }

    @Override
    public void LoadDismiss() {

    }

    @OnClick({R.id.title_bar_return, R.id.me_head_iv, R.id.me_quit_bt})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.title_bar_return:
                ActyUtil.getInstance().removeActy(this);
                break;
            case R.id.me_head_iv:
                break;
            case R.id.me_quit_bt:
                ActyUtil.getInstance().exit(this);
                ServiceManager.StopService(this);
                break;
        }
    }

    @Override
    public void setTitleBarName(String barName) {
        titleBarName.setText(barName);
    }

    @Override
    public void setMeHead(String imgPath) {
        ImgBindTool.imgBind(meHeadIv, imgPath);
    }

    @Override
    public void setMeUsername(String username) {
        meUsernameTv.setText(username);
    }

    @Override
    public void setMeUserduty(String userduty) {
        meUserdutyTv.setText(userduty);
    }

    @Override
    public void setMePoliceNumber(String policeNumber) {
        mePoliceNumber.setText(policeNumber);
    }

    @Override
    public void setMePoliceUnit(String policeUnit) {
        mePoliceUnit.setText(policeUnit);
    }
}
