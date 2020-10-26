package com.hnkc.ydcj.main.wisdomPatrol.list.v;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.flyco.tablayout.SegmentTabLayout;
import com.flyco.tablayout.listener.OnTabSelectListener;
import com.hg.lib.treeview.TreeBean;
import com.hg.lib.treeview.TreeView;
import com.hnkc.ydcj.R;
import com.hnkc.ydcj.base.BaseActy;
import com.hnkc.ydcj.main.wisdomPatrol.list.p.WisdomPatrolListImpl;
import com.hnkc.ydcj.utils.ActyUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 智慧巡防
 */
public class WisdomPatrolListActy extends BaseActy<WisdomPatrolListView, WisdomPatrolListImpl> implements WisdomPatrolListView {
    @BindView(R.id.title_bar_name)
    TextView titleBarName;
    @BindView(R.id.wisdlist_combat_tab)
    SegmentTabLayout wisdlistCombatTab;
    @BindView(R.id.wisdlist_task_type)
    TextView wisdlistTaskType;
    @BindView(R.id.wisdlist_task_type_ll)
    LinearLayout wisdlistTaskTypeLl;
    @BindView(R.id.wisdlist_vp)
    ViewPager wisdlistVp;

    @Override
    protected WisdomPatrolListImpl createPresenter() {
        return new WisdomPatrolListImpl(this);
    }

    @Override
    public int bindLayout() {
        return R.layout.wisdompatrol_list_acty;
    }

    @Override
    protected void init(Bundle bundle) {
        ActyUtil.getInstance().AddActy(this);
        titleBarName.setText("任务列表");
    }

    @Override
    public void doBusiness(Context mContext) {
        mPresenter.Init();
        wisdlistCombatTab.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelect(int position) {
                wisdlistVp.setCurrentItem(position);
            }

            @Override
            public void onTabReselect(int position) {
            }
        });

        wisdlistVp.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                wisdlistCombatTab.setCurrentTab(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    @Override
    public void LoadDismiss() {

    }

    @Override
    public void setWisdlistTaskType(String typeName) {
        wisdlistTaskType.setText(typeName);
    }

    @Override
    public void setTaskTypeBar(List<TreeBean> taskTypeList) {
        TreeView.Show(this, wisdlistTaskTypeLl, wisdlistTaskType, taskTypeList, (id, name) -> mPresenter.selectTaskType(name,id), false, true);
    }

    @Override
    public void setPagerAdapter(ArrayList<Fragment> frgList, String[] titleArry) {
        wisdlistVp.setAdapter(new MyPagerAdapter(frgList, titleArry, getSupportFragmentManager()));
    }

    @Override
    public void setTabData(String[] titleArry) {
        wisdlistCombatTab.setTabData(titleArry);
        wisdlistVp.setCurrentItem(0);
    }

    @OnClick({R.id.title_bar_return, R.id.wisdlist_task_type})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.title_bar_return:
                ActyUtil.getInstance().removeActy(this);
                break;
            case R.id.wisdlist_task_type:
                mPresenter.showTaskTypeBar();
                break;
        }
    }

    private static class MyPagerAdapter extends FragmentPagerAdapter {
        private ArrayList<Fragment> fragList;
        private String[] titleArry;

        MyPagerAdapter(ArrayList<Fragment> fragList, String[] titleArry, FragmentManager fm) {
            super(fm);
            this.fragList = fragList;
            this.titleArry = titleArry;
        }

        @Override
        public int getCount() {
            return fragList.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return titleArry[position];
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            return fragList.get(position);
        }
    }
}