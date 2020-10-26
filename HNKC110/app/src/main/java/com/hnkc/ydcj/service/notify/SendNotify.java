package com.hnkc.ydcj.service.notify;

import android.app.Notification;
import android.content.Context;
import android.os.Build;

import androidx.annotation.RequiresApi;

public  class SendNotify {

    @RequiresApi(api = Build.VERSION_CODES.N)
    public static Notification getPullNotification(Context context){
      return   new NotifyUtil.Builder(context,NotifyCofig.NOTIFY_NETWORK_ID,"通讯状态").IsEnableLights(false).IsEnableVibration(false).setSound("bh").setVibrate(3).getPullNotification();
    }
}
