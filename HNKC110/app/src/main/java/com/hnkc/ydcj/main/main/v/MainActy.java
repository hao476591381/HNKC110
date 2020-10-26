package com.hnkc.ydcj.main.main.v;

import android.content.Context;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.hg.lib.tool.ImgBindTool;
import com.hnkc.ydcj.R;
import com.hnkc.ydcj.base.BaseActy;
import com.hnkc.ydcj.main.main.adapter.MainModuleAdapter;
import com.hnkc.ydcj.main.main.bean.ModuleBean;
import com.hnkc.ydcj.main.main.p.MainImpl;
import com.hnkc.ydcj.main.me.v.MeActy;
import com.hnkc.ydcj.utils.ActyUtil;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 主界面
 */
public class MainActy extends BaseActy<MainView, MainImpl> implements MainView {
    @BindView(R.id.mainview_title_tv)
    TextView mainviewTitleTv;
    @BindView(R.id.mainview_head_iv)
    ImageView mainviewHeadIv;
    @BindView(R.id.mainview_user_name)
    TextView mainviewUserName;
    @BindView(R.id.mainview_user_number)
    TextView mainviewUserNumber;
    @BindView(R.id.mainview_user_unit)
    TextView mainviewUserUnit;
    @BindView(R.id.mainview_pdt_tv)
    TextView mainviewPdtTv;
    @BindView(R.id.mainview_work_status)
    TextView mainviewWorkStatus;
    @BindView(R.id.main_module_rl)
    RecyclerView mainModuleRl;
    @BindView(R.id.main_module1_rl)
    RecyclerView mainModule1Rl;
    private MainModuleAdapter moduleAdapter;

    @Override
    protected MainImpl createPresenter() {
        return new MainImpl(this);
    }

    @Override
    public int bindLayout() {
        return R.layout.main_acty;
    }

    @Override
    protected void init(Bundle bundle) {
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
        mainModuleRl.setLayoutManager(gridLayoutManager);
        GridLayoutManager gridLayoutManager1 = new GridLayoutManager(this, 4);
        mainModule1Rl.setLayoutManager(gridLayoutManager1);
        mPresenter.Init();
    }

    @Override
    public void doBusiness(Context mContext) {

    }

    @Override
    public void LoadDismiss() {

    }

    @OnClick(R.id.mainview_head_iv)
    public void onViewClicked() {
        ActyUtil.getInstance().startActyForResult(this, MeActy.class, 111);
    }

    @Override
    public void setMainViewTitle(String title) {
        mainviewTitleTv.setText(title);
    }

    @Override
    public void setMainViewHead(String imgPath) {
        ImgBindTool.imgBind(mainviewHeadIv, imgPath);
    }

    @Override
    public void setMainViewUserName(String userName) {
        mainviewUserName.setText(userName);
    }

    @Override
    public void setMainViewUserNumber(String userNumber) {
        mainviewUserNumber.setText(userNumber);
    }

    @Override
    public void setMainViewUserUnit(String userUnit) {
        mainviewUserUnit.setText(userUnit);
    }

    @Override
    public void setMainViewPdt(String pdt) {
        mainviewPdtTv.setText(pdt);
    }

    @Override
    public void setMainViewWorkStatus(String workStatus) {
        mainviewWorkStatus.setText(workStatus);
    }

    @Override
    public void setMainAdater(List<ModuleBean> moduleList) {
        moduleAdapter = new MainModuleAdapter(moduleList);
        mainModuleRl.setAdapter(moduleAdapter);
        moduleAdapter.setOnItemClickListener(appId -> mPresenter.StartActy(appId));
    }

    @Override
    public void setAidedAdater(List<ModuleBean> moduleList) {
        moduleAdapter = new MainModuleAdapter(moduleList);
        mainModule1Rl.setAdapter(moduleAdapter);
        moduleAdapter.setOnItemClickListener(appId -> mPresenter.StartActy(appId));
    }
}
