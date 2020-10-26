package com.hnkc.ydcj.map.v;

import com.hnkc.ydcj.base.BaseView;
import com.hnkc.ydcj.map.bean.PoiAddrBean;
import com.tencent.tencentmap.mapsdk.maps.CameraUpdate;

import java.util.List;

public interface ImapView extends BaseView {

    void setCenter(CameraUpdate cameraSigma);

    void setkKeyWordAddrAdapter(List<PoiAddrBean.DataBean> list);

    void setPoiAddrAdapter(List<PoiAddrBean.DataBean> list);
}
