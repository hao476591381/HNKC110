package com.hnkc.ydcj.map.m;

import com.hnkc.ydcj.base.CallBack;
import com.tencent.tencentmap.mapsdk.maps.CameraUpdate;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;

public  interface ImapModel {

    void getCameraSigma(CallBack callBack);

    void requestKeywordsAddr(String keywords, CallBack callBack);

    void requestPoiAddr(LatLng latLng, CallBack callBack);
}
