package com.hnkc.ydcj.map.p;

import android.app.Activity;

import com.hg.lib.tool.Toast;
import com.hnkc.ydcj.base.BasePresenter;
import com.hnkc.ydcj.base.CallBack;
import com.hnkc.ydcj.map.bean.PoiAddrBean;
import com.hnkc.ydcj.map.m.MapModel;
import com.hnkc.ydcj.map.v.ImapView;
import com.hnkc.ydcj.utils.ActyUtil;
import com.tencent.tencentmap.mapsdk.maps.CameraUpdate;
import com.tencent.tencentmap.mapsdk.maps.model.CameraPosition;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;

import java.util.List;

public class MapImpl extends BasePresenter<ImapView> implements Imap {
    private Activity activity;
    private MapModel mapModel;

    public MapImpl() {
        mapModel = new MapModel();
    }

    @Override
    public void Init(Activity activity) {
        this.activity = activity;
        setCenter();
    }

    @Override
    public void getKeywordsAddr(String keyWords) {
        mapModel.requestKeywordsAddr(keyWords, new CallBack<List<PoiAddrBean.DataBean>>() {
            @Override
            public void onSuccess(List<PoiAddrBean.DataBean> list) {
                getView().setkKeyWordAddrAdapter(list);
            }

            @Override
            public void onError(String error, int requestFlag) {
                Toast.Show(activity, error, false);
            }
        });
    }

    @Override
    public void getPoiAddr(CameraPosition c) {
        LatLng latLng = c.target;
        mapModel.requestPoiAddr(latLng, new CallBack<List<PoiAddrBean.DataBean>>() {
            @Override
            public void onSuccess(List<PoiAddrBean.DataBean> list) {
                getView().setPoiAddrAdapter(list);
            }

            @Override
            public void onError(String error, int requestFlag) {
                Toast.Show(activity, error, false);
            }
        });
    }

    @Override
    public void returnAddr(PoiAddrBean.DataBean dataBean, CallBack callBack) {
        callBack.onSuccess(dataBean);
        ActyUtil.getInstance().removeActy(activity);
    }

    /**
     * 设置地图中心点
     */
    private void setCenter() {
        mapModel.getCameraSigma(new CallBack<CameraUpdate>() {
            @Override
            public void onSuccess(CameraUpdate cameraUpdate) {
                getView().setCenter(cameraUpdate);
            }

            @Override
            public void onError(String error, int requestFlag) {

            }
        });
    }
}
