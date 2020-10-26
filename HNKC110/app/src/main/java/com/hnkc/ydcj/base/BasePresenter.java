package com.hnkc.ydcj.base;

import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

/**
 * Presenter基类(优化MVP模式, 这里采用弱引用的方式, 防止内存泄露).
 */
public abstract class BasePresenter<T> {

    /**
     * 声明一个View接口类型的弱引用
     */
    private Reference<T> mViewRef;

    /**
     * 与View建立关联
     *
     * @param view
     */
    void attachView(T view) {
        mViewRef = new WeakReference<>(view);
    }

    /**
     * 获取View对象
     *
     * @return
     */
    protected T getView() {
        return mViewRef.get();
    }

    /**
     * 判断是否与View建立起关联
     *
     * @return
     */
    public boolean isViewAttached() {
        return mViewRef != null && mViewRef.get() != null;
    }

    /**
     * 解除与View的关联, 避免内存泄露事件的发生
     */
    void detachView() {
        if (mViewRef != null) {
            mViewRef.clear();
            mViewRef = null;

        }
    }
}
