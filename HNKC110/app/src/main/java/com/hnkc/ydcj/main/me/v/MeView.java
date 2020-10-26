package com.hnkc.ydcj.main.me.v;

import android.widget.ImageView;
import android.widget.TextView;

import com.hnkc.ydcj.R;
import com.hnkc.ydcj.base.BaseView;

import butterknife.BindView;

public interface MeView extends BaseView {


    void setTitleBarName(String titleBarName);

    void setMeHead(String imgPath);

    void setMeUsername(String username);

    void setMeUserduty(String userduty);

    void setMePoliceNumber(String policeNumber);

    void setMePoliceUnit(String policeUnit);
}
