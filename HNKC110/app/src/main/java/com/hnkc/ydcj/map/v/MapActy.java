package com.hnkc.ydcj.map.v;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.hnkc.ydcj.R;
import com.hnkc.ydcj.base.BaseActy;
import com.hnkc.ydcj.base.CallBack;
import com.hnkc.ydcj.map.adapter.KeywordAddrAdapter;
import com.hnkc.ydcj.map.adapter.PoiAddrAdapter;
import com.hnkc.ydcj.map.bean.PoiAddrBean;
import com.hnkc.ydcj.map.p.MapImpl;
import com.hnkc.ydcj.utils.ActyUtil;
import com.tencent.tencentmap.mapsdk.maps.CameraUpdate;
import com.tencent.tencentmap.mapsdk.maps.MapView;
import com.tencent.tencentmap.mapsdk.maps.TencentMap;
import com.tencent.tencentmap.mapsdk.maps.model.CameraPosition;

import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

@SuppressLint("ClickableViewAccessibility")
public class MapActy extends BaseActy<ImapView, MapImpl> implements ImapView, TextWatcher, TencentMap.OnCameraChangeListener {
    @BindView(R.id.title_search_et)
    EditText titleSearchEt;
    @BindView(R.id.title_cancel)
    View titleCancel;
    @BindView(R.id.addr_search_map)
    MapView addrSearchMap;
    @BindView(R.id.keyword_addr_search_rv)
    RecyclerView keywordAddrSearchRv;
    @BindView(R.id.addr_marker)
    ImageView addrMarker;
    @BindView(R.id.poi_addr_search_rv)
    RecyclerView poiAddrSearchRv;
    private TencentMap tencentMap;
    private KeywordAddrAdapter keywordAddrAdapter;
    private PoiAddrAdapter poiAddrAdapter;
    private static CallBack mCallBack;

    /**
     * 打开地图
     *
     * @param activity
     */
    public static void startMe(Activity activity, CallBack callBack) {
        mCallBack=callBack;
        ActyUtil.getInstance().startActy(activity, MapActy.class);
    }

    @Override
    protected MapImpl createPresenter() {
        return new MapImpl();
    }

    @Override
    public int bindLayout() {
        return R.layout.map_acty;
    }

    @Override
    protected void init(Bundle bundle) {
        ActyUtil.getInstance().AddActy(this);
        tencentMap = addrSearchMap.getMap();
        tencentMap.setMapType(TencentMap.MAP_TYPE_NAVI);//设置地图类型
        tencentMap.setMapStyle(3);//设置当前地图的样式
        tencentMap.setTrafficEnabled(true); //开启或关闭实时交通路况的功能
        tencentMap.setPoisEnabled(true);//底图 poi 开关

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        keywordAddrSearchRv.setLayoutManager(layoutManager);
        keywordAddrAdapter = new KeywordAddrAdapter();
        keywordAddrSearchRv.setAdapter(keywordAddrAdapter);

        LinearLayoutManager poiLayoutManager = new LinearLayoutManager(this);
        poiAddrSearchRv.setLayoutManager(poiLayoutManager);
        poiAddrAdapter = new PoiAddrAdapter();
        poiAddrSearchRv.setAdapter(poiAddrAdapter);

        mPresenter.Init(this);
    }

    @Override
    public void doBusiness(Context mContext) {
        titleSearchEt.addTextChangedListener(this);
        tencentMap.setOnCameraChangeListener(this);//地图移动监听
        keywordAddrAdapter.setOnItemClickListener(dataBean -> mPresenter.returnAddr(dataBean,mCallBack));
        poiAddrAdapter.setOnItemClickListener(dataBean -> mPresenter.returnAddr(dataBean,mCallBack));
    }

    @Override
    public void LoadDismiss() {
    }

    @Override
    protected void onStart() {
        super.onStart();
        addrSearchMap.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
        addrSearchMap.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        addrSearchMap.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
        addrSearchMap.onStop();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        addrSearchMap.onRestart();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        addrSearchMap.onDestroy();
    }

    @OnClick({R.id.title_bar_return, R.id.title_cancel})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.title_bar_return:
                ActyUtil.getInstance().removeActy(this);
                break;
            case R.id.title_cancel:
                titleSearchEt.setText("");
                break;
        }
    }

    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void afterTextChanged(Editable e) {
        String msgstr = e.toString().trim();
        if (!TextUtils.isEmpty(msgstr)) {
            titleCancel.setVisibility(View.VISIBLE);
            addrMarker.setVisibility(View.GONE);
            mPresenter.getKeywordsAddr(msgstr);
        } else {
            titleCancel.setVisibility(View.GONE);
            keywordAddrSearchRv.setVisibility(View.GONE);
            addrMarker.setVisibility(View.VISIBLE);
            poiAddrSearchRv.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void onCameraChange(CameraPosition cameraPosition) {

    }

    @Override
    public void onCameraChangeFinished(CameraPosition c) {
        mPresenter.getPoiAddr(c);
    }

    @Override
    public void setCenter(CameraUpdate cameraSigma) {
        tencentMap.moveCamera(cameraSigma);// 设置地图中心点以及缩放级别
    }

    @Override
    public void setkKeyWordAddrAdapter(List<PoiAddrBean.DataBean> keyWordList) {
        poiAddrSearchRv.setVisibility(View.GONE);
        keywordAddrSearchRv.setVisibility(View.VISIBLE);
        keywordAddrAdapter.addData(keyWordList);
    }

    @Override
    public void setPoiAddrAdapter(List<PoiAddrBean.DataBean> list) {
        poiAddrSearchRv.setVisibility(View.VISIBLE);
        poiAddrAdapter.addData(list);
    }
}