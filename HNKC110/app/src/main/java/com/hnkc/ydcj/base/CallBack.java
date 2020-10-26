package com.hnkc.ydcj.base;

/**
 * 泛型类的回调接口
 *
 * @param <T>
 */
public interface CallBack<T> {

    void onSuccess(T response);

    void onError(String error, int requestFlag);
}
