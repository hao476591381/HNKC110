package com.hnkc.ydcj.http;

public interface XUtilsCallback {
	/**
	 * 请求成功
	 * @param data 返回信息
	 * @param visitType 访问标识
	 */
	 void getOnSuccess(String data, int visitType);
	/**
	 * 请求失败
	 * @param data 错误信息
	 * @param visitType 访问标识
	 */
	 void getOnFailure(String data, int visitType);
}

 