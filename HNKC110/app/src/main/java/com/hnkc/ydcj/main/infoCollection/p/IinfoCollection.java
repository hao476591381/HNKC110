package com.hnkc.ydcj.main.infoCollection.p;

import android.widget.TextView;

public interface IinfoCollection {
    void Init();

    void selcetInfoType(int typeCode);

    void showDict(int dictTag,TextView textView);

    void selectAddr(TextView textView,int addrTag);

    void  submitCollectionInfo();
}
