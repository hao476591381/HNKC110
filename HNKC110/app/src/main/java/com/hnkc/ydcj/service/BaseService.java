package com.hnkc.ydcj.service;

import android.app.Service;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;

import androidx.annotation.Nullable;

import com.hg.lib.tool.ShowLog;
import com.hnkc.ydcj.main.login.UserInfoSp;
import com.hnkc.ydcj.service.notify.NotifyCofig;
import com.hnkc.ydcj.service.notify.SendNotify;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.map.geolocation.TencentLocationListener;
import com.tencent.map.geolocation.TencentLocationManager;
import com.tencent.map.geolocation.TencentLocationRequest;

import static com.hnkc.ydcj.base.BaseApp.spUtils;

public abstract class BaseService extends Service implements TencentLocationListener {
    public TencentLocationManager locationManager;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    public abstract void Init();//初始化

    public abstract void HttpRequest();//http请求

    public abstract void onDestroys();

    @Override
    public void onCreate() {
        super.onCreate();
        InitTencentLocation();
        Init();
    }

    @Override
    public void onStatusUpdate(String s, int i, String s1) {

    }

    @Override
    public void onLocationChanged(TencentLocation l, int error, String s) {
        if (TencentLocation.ERROR_OK == error) {
            // 定位成功
            String mLongitude = String.valueOf(l.getLongitude());   //经度
            String mLatitude = String.valueOf(l.getLatitude());//纬度
            ShowLog.sys("mLongitude==" + mLongitude + "---mLatitude==" + mLatitude);
            UserInfoSp.setLatitude(mLatitude);
            UserInfoSp.setLongitude(mLongitude);
            EnableForegroundLocation();
        } else {
            // 定位失败
            ShowLog.sys("定位失败------" + s);
        }
        HttpRequest();
    }

    private void InitTencentLocation() {
        TencentLocationRequest request = TencentLocationRequest
                .create()
                .setRequestLevel(TencentLocationRequest.REQUEST_LEVEL_ADMIN_AREA)
                .setInterval(10000) // 设置定位周期, 建议值为 1s-20s
                .setAllowGPS(true);
        locationManager = TencentLocationManager.getInstance(this);
        int e = locationManager.requestLocationUpdates(request, this, getMainLooper());
        switch (e) {
            case 0:
                ShowLog.sys("定位成功");
                break;
            case 1:
                ShowLog.sys("设备缺少使用腾讯定位SDK需要的基本条件");
                break;
            case 2:
                ShowLog.sys(" 配置的 key 不正确");
                break;
            case 3:
                ShowLog.sys(" 自动加载libtencentloc.so失败");
                break;
        }
    }

    /**
     * 开启前台定位服务
     */
    public void EnableForegroundLocation() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            if (locationManager != null) {
                locationManager.enableForegroundLocation(NotifyCofig.NOTIFY_NETWORK_TYPE, SendNotify.getPullNotification(this));
            }
        }
    }

    /**
     * 关闭前台定位
     */
    public void DisableForegroundLocation() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            if (locationManager != null) {
                locationManager.disableForegroundLocation(true);
            }
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        DisableForegroundLocation();
        locationManager.removeUpdates(this);
        onDestroys();
    }
}
