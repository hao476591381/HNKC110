package com.hnkc.ydcj.http;

import android.content.Context;

import com.hg.lib.tool.ShowLog;
import com.hg.lib.view.HgDiaLog;

import org.xutils.common.Callback;
import org.xutils.ex.HttpException;
import org.xutils.http.RequestParams;
import org.xutils.x;

/**
 * http请求类
 */
public class HttpXutils {
    private static HgDiaLog hgDiaLog;

    /**
     * 显示dialog的post请求
     *
     * @param requestParams   访问地址
     * @param visitType       请求类型
     * @param dialogStr       dialog提示
     * @param isdialogdismiss 是否手动取消dialog
     * @param xUtilsCallback  结果返回接口
     */
    public static Callback.Cancelable Post(RequestParams requestParams, int visitType, String dialogStr, boolean isdialogdismiss, Context Context, XUtilsCallback xUtilsCallback) {
        dialogShow(dialogStr, isdialogdismiss, Context);
        return Post(requestParams, visitType, xUtilsCallback);
    }

    /**
     * 显示dialog 的get请求
     *
     * @param requestParams   访问地址
     * @param visitType       请求类型
     * @param dialogStr       dialog提示
     * @param isdialogdismiss 是否手动取消dialog
     * @param xUtilsCallback  结果返回接口
     */
    public static Callback.Cancelable getHttp(RequestParams requestParams, int visitType, String dialogStr, boolean isdialogdismiss, Context Context, XUtilsCallback xUtilsCallback) {
        dialogShow(dialogStr, isdialogdismiss, Context);
        return getHttp(requestParams, visitType, xUtilsCallback);
    }

    /**
     * post请求
     *
     * @param RequestParams 请求参数
     */
    public static Callback.Cancelable Post(RequestParams RequestParams, final int visitType, final XUtilsCallback xUtilsCallback) {
        return x.http().post(RequestParams, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String s) {
                xUtilsCallback.getOnSuccess(s, visitType);


            }

            @Override
            public void onError(Throwable arg0, boolean b) {
                if (arg0 instanceof HttpException) { // 网络错误
                    HttpException httpEx = (HttpException) arg0;
                    int responseCode = httpEx.getCode();
                    switch (responseCode) {
                        case 404:
                            xUtilsCallback.getOnFailure("404，接口地址不存在！", visitType);
                            break;
                        case 500:
                            xUtilsCallback.getOnFailure("500，服务器程序错误！", visitType);
                            break;
                        case 400:
                            xUtilsCallback.getOnFailure("400，接口访问异常！", visitType);
                            break;
                    }
                } else { // 其他错误
                    xUtilsCallback.getOnFailure("安全网络访问失败，错误信息=" + arg0.getMessage(), visitType);
                }
            }

            @Override
            public void onCancelled(CancelledException e) {

            }

            @Override
            public void onFinished() {
                DialogDismiss();
            }
        });
    }

    /**
     * 聊天post请求
     *
     * @param RequestParams 请求参数
     */
   /* public static Callback.Cancelable Post(RequestParams RequestParams, final int visitType, final MyMsgBean myMsgBean, final XUtilsCallbacks xUtilsCallback) {
        return x.http().post(RequestParams, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String s) {
                xUtilsCallback.getOnSuccess(s, visitType,myMsgBean);
            }

            @Override
            public void onError(Throwable arg0, boolean b) {
                if (arg0 instanceof HttpException) { // 网络错误
                    HttpException httpEx = (HttpException) arg0;
                    int responseCode = httpEx.getCode();
                    switch (responseCode) {
                        case 404:
                            xUtilsCallback.getOnFailure("404，接口地址不存在！", visitType,myMsgBean);
                            break;
                        case 500:
                            xUtilsCallback.getOnFailure("500，服务器程序错误！", visitType,myMsgBean);
                            break;
                        case 400:
                            xUtilsCallback.getOnFailure("400，接口访问异常！", visitType,myMsgBean);
                            break;
                    }
                } else { // 其他错误
                    xUtilsCallback.getOnFailure("安全网络访问失败，错误信息=" + arg0.getMessage(), visitType,myMsgBean);
                }
            }

            @Override
            public void onCancelled(CancelledException e) {

            }

            @Override
            public void onFinished() {
                DialogDismiss();
            }
        });
    }
*/
    /**
     * get 请求
     *
     * @param params
     * @param visitType
     * @param xUtilsCallback
     * @return
     */
    public static Callback.Cancelable getHttp(RequestParams params, final int visitType, final XUtilsCallback xUtilsCallback) {
        return x.http().get(params, new Callback.CommonCallback<String>() {
            @Override
            public void onCancelled(CancelledException arg0) {
            }

            @Override
            public void onError(Throwable arg0, boolean arg1) {
                if (arg0 instanceof HttpException) { // 网络错误
                    HttpException httpEx = (HttpException) arg0;
                    int responseCode = httpEx.getCode();
                    switch (responseCode) {
                        case 404:
                            xUtilsCallback.getOnFailure("404，接口地址不存在！", visitType);
                            break;
                        case 500:
                            xUtilsCallback.getOnFailure("500，服务器程序错误！", visitType);
                            break;
                        case 400:
                            xUtilsCallback.getOnFailure("400，接口访问异常！", visitType);
                            break;
                    }
                } else { // 其他错误
                    xUtilsCallback.getOnFailure("网络访问失败，错误信息=" + arg0.getMessage(), visitType);
                }
            }

            @Override
            public void onFinished() {
                DialogDismiss();
            }

            @Override
            public void onSuccess(String arg0) {
                xUtilsCallback.getOnSuccess(arg0, visitType);
            }
        });
    }

    /**
     * dialog 显示
     *
     * @param str          加载提示
     * @param isCancelable 是否可以手动取消
     */
    private static void dialogShow(String str, boolean isCancelable, Context context) {
        hgDiaLog=HgDiaLog.LoadDl(context, str, () -> ShowLog.sys("点击屏幕取消！"),isCancelable);
        hgDiaLog.show();
    }

    /**
     * 取消网络访问
     *
     * @param http
     */
    public static void HttpCancel(Callback.Cancelable http) {
        if (http != null) {
            http.cancel();
        }
    }

    /**
     * 关闭dialog显示
     */
    private static void DialogDismiss() {
        if (hgDiaLog != null)
            hgDiaLog.dismiss();
    }
}
