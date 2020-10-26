package com.hnkc.ydcj.main.login.v;

import android.graphics.Typeface;

import com.hnkc.ydcj.base.BaseView;

public interface WelComeView extends BaseView {
    void setFontType(Typeface typeface);

    void setAppName(String appName);

    void setCityName(String cityName);

    void setCityNames(String cityName);

    void setWelcomeHint(String hintStr);

    void hideWelcomeHint();
}
