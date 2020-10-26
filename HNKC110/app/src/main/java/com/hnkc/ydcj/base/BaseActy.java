package com.hnkc.ydcj.base;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import butterknife.ButterKnife;

/**
 * Activity基础类
 */
public abstract class BaseActy<V, T extends BasePresenter<V>> extends AppCompatActivity implements BaseView {
    protected T mPresenter;//Presenter对象

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getIntent().getExtras();
        View mView = LayoutInflater.from(this).inflate(bindLayout(), null);
        setContentView(mView);
        ButterKnife.bind(this);
        HideActionBar();
        makeStatusBarTransparent(this); //透明状态栏 沉浸效果
        CreatePresenter();
        AttachView();
        init(bundle);
        doBusiness(this);
    }

    /**
     * 创建Presenter
     * @return
     */
    protected abstract T createPresenter();

    /**
     * [绑定布局]
     */
    public abstract int bindLayout();

    /**
     * 抽象  初始化方法 可以对数据进行初始化
     */

    protected abstract void init(Bundle bundle);

    /**
     * 业务操作
     */
    public abstract void doBusiness(Context mContext);

    /**
     * 从textView获取字符串
     */
    public String getStr(TextView textView) {
        return textView.getText().toString();
    }

    /**
     * 从EditText 获取字符串
     */
    public String getStr(EditText editText) {
        return editText.getText().toString();
    }

    /**
     * 网络状态改变
     *
     * @param netWorkState true 有网络 false无网络
     */
    public void onNetChange(boolean netWorkState) {
    }

    /**
     * 将View与Presenter对象建立起关联
     */
    public void AttachView() {
        if (mPresenter != null) {
            mPresenter.attachView((V) this);
        }
    }

    /**
     * 创建Presenter对象
     */
    public void CreatePresenter() {
        mPresenter = createPresenter();
    }

    /**
     * 隐藏标题栏
     */
    public void HideActionBar() {
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
    }

    /**
     * 透明状态栏
     *
     * @param activity
     */
    public static void makeStatusBarTransparent(Activity activity) {
        Window window = activity.getWindow();
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        int option = window.getDecorView().getSystemUiVisibility() | View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN;
        window.getDecorView().setSystemUiVisibility(option);
        window.setStatusBarColor(Color.TRANSPARENT);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPresenter != null) {
            mPresenter.detachView();
        }
    }
}
