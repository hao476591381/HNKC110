package com.hnkc.ydcj.base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.hnkc.ydcj.R;

import java.util.Objects;

import butterknife.ButterKnife;

/**
 * fragment基础类
 */
public abstract class BaseFrag<V, T extends BasePresenter<V>> extends Fragment implements BaseView {
    private View view;
    protected T mPresenter;//Presenter对象
    private boolean isViewInitiated;//是否初始化过布局
    private boolean isVisibleToUser;//当前界面是否可见
    private boolean isDataInitiated;//是否加载过数据

    // Fragment被创建
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    /**
     * 创建Presenter
     *
     * @return
     */
    protected abstract T createPresenter();

    // 初始化Fragment布局
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (view == null) {
            view = inflater.inflate(SetView(), container, false);
            ButterKnife.bind(this, view);
            this.CreatePresenter();
            this.init();
        } else {
            ViewGroup p = (ViewGroup) view.getParent();
            if (p != null) {
                p.removeView(view);
            }
        }
        return view;
    }

    /**
     * 初始化布局, 子类必须实现
     */
    public abstract int SetView();


    /**
     * 初始化数据, 子类可以不实现
     */
    public abstract void init();

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        this.isVisibleToUser = isVisibleToUser;
        if (isVisibleToUser) {
            prepareFetchData();
        }
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        isViewInitiated = true;
    }

    private void prepareFetchData() {
        prepareFetchData(true);
    }

    /**
     * 判断懒加载条件
     *
     * @param forceUpdate 强制更新，好像没什么用？
     */
    private void prepareFetchData(boolean forceUpdate) {
        if (isVisibleToUser && isViewInitiated && (!isDataInitiated || forceUpdate)) {
            LoadData();
            isDataInitiated = true;
        }
    }

    protected abstract void LoadData();

    /**
     * 创建Presenter对象
     */
    private void CreatePresenter() {
        mPresenter = createPresenter();
        if (mPresenter != null) {
            //将View与Presenter对象建立起关联
            mPresenter.attachView((V) this);
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        this.view = null;
        ButterKnife.bind(getActivity()).unbind();
    }
}
