package com.hnkc.ydcj.main.wisdomPatrol.list.v;

import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.hnkc.ydcj.R;
import com.hnkc.ydcj.base.BaseFrag;
import com.hnkc.ydcj.main.wisdomPatrol.adapter.WisdListAdapter;
import com.hnkc.ydcj.main.wisdomPatrol.bean.WisdTaskBean;
import com.hnkc.ydcj.main.wisdomPatrol.list.p.WisdomPatrolListFragImpl;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

import java.util.List;

import butterknife.BindView;

public class WisdomPatrolListFrag extends BaseFrag<WisdomPatrolListFrgView, WisdomPatrolListFragImpl> implements WisdomPatrolListFrgView {
    @BindView(R.id.wisdlist_frg_hint)
    TextView wisdlistFrgHint;
    @BindView(R.id.wisdlist_frg_rv)
    RecyclerView wisdlistFrgRv;
    @BindView(R.id.wisdlist_frg_refresh)
    SmartRefreshLayout wisdlistFrgRefresh;
    private String title;
    private WisdListAdapter wisdListAdapter;

    public static WisdomPatrolListFrag getInstance(String title) {
        WisdomPatrolListFrag wisdomPatrolListFrag = new WisdomPatrolListFrag();
        wisdomPatrolListFrag.title = title;
        return wisdomPatrolListFrag;
    }

    @Override
    protected WisdomPatrolListFragImpl createPresenter() {
        return new WisdomPatrolListFragImpl(getActivity(), title);
    }

    @Override
    public int SetView() {
        return R.layout.wisdompatrol_list_frag;
    }

    @Override
    public void init() {
        mPresenter.Init();
        wisdlistFrgRefresh.setEnableLoadMore(false);
        wisdlistFrgRefresh.setDisableContentWhenRefresh(true);
        wisdlistFrgRefresh.setOnRefreshListener(refreshLayout -> mPresenter.getWindTaskList());

        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        wisdlistFrgRv.setLayoutManager(layoutManager);
        wisdListAdapter = new WisdListAdapter();
        wisdListAdapter.setOnItemClickListener(wisdTaskBean -> mPresenter.StartActy(wisdTaskBean));
        wisdlistFrgRv.setAdapter(wisdListAdapter);

    }

    @Override
    protected void LoadData() {

    }

    @Override
    public void LoadDismiss() {

    }

    @Override
    public void autoRefresh() {
        wisdlistFrgRefresh.autoRefresh();
    }

    @Override
    public void finishRefresh() {
        wisdlistFrgRefresh.finishRefresh();
    }

    @Override
    public void ShowWisdlistFrgHint(String hintStr) {
        wisdlistFrgHint.setVisibility(View.VISIBLE);
        wisdlistFrgHint.setText(hintStr);
    }

    @Override
    public void HideWisdlistFrgHint() {
        wisdlistFrgHint.setVisibility(View.GONE);
    }

    @Override
    public void ShowWisdTaskList(List<WisdTaskBean> wisdTaskList) {
        wisdListAdapter.addData(wisdTaskList);
    }
}
