package com.hnkc.ydcj.map.m;

import com.hg.lib.tool.CharShift;
import com.hg.lib.tool.GsonUtil;
import com.hnkc.ydcj.base.CallBack;
import com.hnkc.ydcj.http.HttpParams;
import com.hnkc.ydcj.http.HttpXutils;
import com.hnkc.ydcj.http.XUtilsCallback;
import com.hnkc.ydcj.main.login.UserInfoSp;
import com.hnkc.ydcj.map.bean.PoiAddrBean;
import com.tencent.tencentmap.mapsdk.maps.CameraUpdate;
import com.tencent.tencentmap.mapsdk.maps.CameraUpdateFactory;
import com.tencent.tencentmap.mapsdk.maps.model.CameraPosition;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;

import org.xutils.http.RequestParams;

public class MapModel implements ImapModel {


    @Override
    public void getCameraSigma(CallBack callBack) {
        double mLatitude = CharShift.strToDouble(UserInfoSp.getLatitude());
        double mLongitude = CharShift.strToDouble(UserInfoSp.getLongitude());
        CameraUpdate cameraUpdate = CameraUpdateFactory.newCameraPosition(new CameraPosition(
                new LatLng(mLatitude, mLongitude), //新的中心点坐标
                16,  //新的缩放级别
                0, //俯仰角 0~45° (垂直地图时为0)
                0)); //偏航角 0~360° (正北方为0)
        callBack.onSuccess(cameraUpdate);
    }

    @Override
    public void requestKeywordsAddr(String keywords, CallBack callBack) {
        String location = UserInfoSp.getLatitude() + "," + UserInfoSp.getLongitude();
        RequestParams params = HttpParams.GetKeywords(location, keywords);
        HttpXutils.getHttp(params, 0, new XUtilsCallback() {
            @Override
            public void getOnSuccess(String data, int visitType) {
                PoiAddrBean keywordsBean = GsonUtil.getInstance().fromJson(data ,PoiAddrBean.class);
                if (keywordsBean.getStatus() == 0) {
                    callBack.onSuccess(keywordsBean.getData());
                } else {
                    callBack.onError(keywordsBean.getMessage(),visitType);
                }
            }

            @Override
            public void getOnFailure(String data, int visitType) {
                callBack.onError(data,visitType);
            }
        });
    }

    @Override
    public void requestPoiAddr(LatLng latLng, CallBack callBack) {
        RequestParams params = HttpParams.getPiosAddr(latLng.getLatitude() + "," + latLng.getLongitude());
        HttpXutils.getHttp(params, 0, new XUtilsCallback() {
            @Override
            public void getOnSuccess(String data, int visitType) {
                PoiAddrBean poiAddrBean = GsonUtil.getInstance().fromJson(data ,PoiAddrBean.class);
                if (poiAddrBean.getStatus() == 0) {
                    callBack.onSuccess(poiAddrBean.getData());
                } else {
                    callBack.onError(poiAddrBean.getMessage(),visitType);
                }
            }

            @Override
            public void getOnFailure(String data, int visitType) {
                callBack.onError(data,visitType);
            }
        });

    }
}