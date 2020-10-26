package com.hnkc.ydcj.http;

import org.xutils.http.RequestParams;

public class HttpParams {

    /**
     * 关键字查询地址
     *
     * @param keywordsStr
     * @return
     */
    public static RequestParams GetKeywords(String location, String keywordsStr) {
        RequestParams params = new RequestParams("https://apis.map.qq.com/ws/place/v1/suggestion");
        params.addQueryStringParameter("region", "长沙");
        params.addQueryStringParameter("get_subpois", "1");
        params.addQueryStringParameter("policy", "1");
        params.addQueryStringParameter("keyword", keywordsStr);
        params.addQueryStringParameter("location", location);
        params.addQueryStringParameter("get_subpois", "1");
        params.addQueryStringParameter("page_size", "20");
        params.addQueryStringParameter("output", "json");
        params.addQueryStringParameter("key", "BCWBZ-336KX-UA34T-ZDIX3-WLNDQ-SNBUO");
        return params;
    }

    /**
     * 获取周边地址
     *
     * @param locations
     * @return
     */
    public static RequestParams getPiosAddr(String locations) {
        RequestParams params = new RequestParams("https://apis.map.qq.com/ws/place/v1/search");
        params.addQueryStringParameter("boundary", "nearby(" + locations + ",500)");
        params.addQueryStringParameter("orderby", "_distance");
        params.addQueryStringParameter("page_size", "10");
        params.addQueryStringParameter("page_index", "1");
        params.addQueryStringParameter("output", "json");
        params.addQueryStringParameter("key", "BCWBZ-336KX-UA34T-ZDIX3-WLNDQ-SNBUO");
        return params;
    }

}
