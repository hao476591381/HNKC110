package com.hnkc.ydcj.map.p;

import android.app.Activity;

import com.hnkc.ydcj.base.CallBack;
import com.hnkc.ydcj.map.bean.PoiAddrBean;
import com.tencent.tencentmap.mapsdk.maps.model.CameraPosition;

interface Imap {
    void Init(Activity activity);

    void getKeywordsAddr(String keyWords);

    void getPoiAddr(CameraPosition c);

    void  returnAddr(PoiAddrBean.DataBean dataBean, CallBack callBack);
}
