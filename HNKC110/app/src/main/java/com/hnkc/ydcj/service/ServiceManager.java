package com.hnkc.ydcj.service;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;

import com.hg.lib.tool.ShowLog;

import java.util.List;

public class ServiceManager {
    public static void StartMsgPolling(Context context) {
        if (isServiceWork(context, "com.hnkc.ydcj.service.PallingService")) {
            context.startService(new Intent(context, PallingService.class));//开启Socket服务
        } else {
            ShowLog.sys("PallingService正在运行");
        }
    }

    //关闭GPS服务和轮询服务
    public static void StopService(Context context) {
        context.stopService(new Intent(context, PallingService.class));
    }


    //启动轮询服务
  /*  private static void StartMsgPolling(Context context) {
        if (BaseConfig.MY_CITY_NAME.equals(BaseConfig.CITY_HZ)) {
            if (isServiceWork(context, "com.hnkc.ydcj.push.palling.NettyService")) {
                context.startService(new Intent(context, NettyService.class));//开启Socket服务
            } else {
                ShowLog.sys("NettyService正在运行");
            }
        } else {
            if (isServiceWork(context, "com.hnkc.ydcj.push.palling.PallingService")) {
                ShowLog.sys("GpsPullService被拉起");
                context.startService(new Intent(context, PallingService.class));//开启消息轮询服务
            } else {
                ShowLog.sys("GpsPullService正在运行");
            }
        }
    }*/

    //开启GPS服务和轮询服务
 /*   public static void StartService(Context context) {
        MyApplicaton.sputils.putBoolean("MSG_PALLING", true);
        StartMsgPolling(context);
    }
*/
    //保活拉起GPS服务和轮询服务
   /* public static void KeepStartService(Context context) {
        if (MyApplicaton.sputils.getBoolean("MSG_PALLING", false)) {
            StartMsgPolling(context);
        }
    }*/

    //关闭GPS服务和轮询服务
   /* public static void StopService(Context context) {
        MyApplicaton.sputils.putBoolean("MSG_PALLING", false);
        if (BaseConfig.MY_CITY_NAME.equals(BaseConfig.CITY_HZ)) {
            context.stopService(new Intent(context, NettyService.class));
        } else
            context.stopService(new Intent(context, PallingService.class));
    }*/

    /**
     * 判断某个服务是否正在运行的方法
     *
     * @param mContext
     * @param serviceName 是包名+服务的类名（例如：net.loonggg.testbackstage.TestService）
     * @return true代表正在运行，false代表服务没有正在运行
     */
    private static boolean isServiceWork(Context mContext, String serviceName) {
        boolean isWork = false;
        ActivityManager myAM = (ActivityManager) mContext.getSystemService(Context.ACTIVITY_SERVICE);
        List<ActivityManager.RunningServiceInfo> myList = null;
        if (myAM != null) {
            myList = myAM.getRunningServices(100);
        }
        if (myList != null && myList.size() <= 0) {
            return true;
        }
        if (myList != null) {
            for (int i = 0; i < myList.size(); i++) {
                String mName = myList.get(i).service.getClassName();
                if (mName.equals(serviceName)) {
                    isWork = true;
                    break;
                }
            }
        }
        return !isWork;
    }
}
