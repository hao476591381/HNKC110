package com.hg.lib.view;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.hg.lib.R;

public class LicensePlateView extends RelativeLayout implements View.OnClickListener {

    private TextView[] TextViews;
    private Activity mActivity;
    private View mNumView;
    private View mProvinceView;
    private int updateViewPosition;
    private static int ITEM_VIEW_COUNT = 7; //输入框个数

    private static final int[] VIEW_IDS = new int[]{
            R.id.item_code_iv1, R.id.item_code_iv2, R.id.item_code_iv3,
            R.id.item_code_iv4, R.id.item_code_iv5, R.id.item_code_iv6,
            R.id.item_code_iv7, R.id.item_code_iv8
    };

    private static final int[] VIEW_PROVINCE_IDS = new int[]{
            R.id.select_province_11_tv, R.id.select_province_12_tv, R.id.select_province_13_tv,
            R.id.select_province_14_tv, R.id.select_province_15_tv, R.id.select_province_16_tv,
            R.id.select_province_17_tv, R.id.select_province_18_tv, R.id.select_province_19_tv,
            R.id.select_province_110_tv,
            R.id.select_province_21_tv, R.id.select_province_22_tv, R.id.select_province_23_tv,
            R.id.select_province_24_tv, R.id.select_province_25_tv, R.id.select_province_26_tv,
            R.id.select_province_27_tv, R.id.select_province_28_tv, R.id.select_province_29_tv,
            R.id.select_province_210_tv,
            R.id.select_province_31_tv, R.id.select_province_32_tv, R.id.select_province_33_tv,
            R.id.select_province_34_tv, R.id.select_province_35_tv, R.id.select_province_35_tv,
            R.id.select_province_36_tv, R.id.select_province_37_tv, R.id.select_province_38_tv,
            R.id.select_province_41_tv, R.id.select_province_42_tv, R.id.select_province_43_tv,
            R.id.select_hide_tv, R.id.select_xny_cb
    };

    private static final int[] VIEW_NUM_IDS = new int[]{
            R.id.select_num_100_tv, R.id.select_num_101_tv, R.id.select_num_102_tv,
            R.id.select_num_103_tv, R.id.select_num_104_tv, R.id.select_num_105_tv,
            R.id.select_num_106_tv, R.id.select_num_107_tv, R.id.select_num_108_tv,
            R.id.select_num_109_tv,
            R.id.select_num_200_tv, R.id.select_num_201_tv, R.id.select_num_202_tv,
            R.id.select_num_203_tv, R.id.select_num_204_tv, R.id.select_num_205_tv,
            R.id.select_num_206_tv, R.id.select_num_207_tv, R.id.select_num_208_tv,
            R.id.select_num_209_tv,
            R.id.select_num_300_tv, R.id.select_num_301_tv, R.id.select_num_302_tv,
            R.id.select_num_303_tv, R.id.select_num_304_tv, R.id.select_num_305_tv,
            R.id.select_num_306_tv, R.id.select_num_307_tv, R.id.select_num_308_tv,
            R.id.select_num_309_tv,
            R.id.select_num_400_tv, R.id.select_num_401_tv, R.id.select_num_402_tv,
            R.id.select_num_403_tv, R.id.select_num_404_tv, R.id.select_num_405_tv,
            R.id.select_num_406_tv, R.id.select_hide_tv, R.id.select_xny_cb
    };

    public LicensePlateView(Context context) {
        this(context, null);
    }

    public LicensePlateView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    @SuppressLint("ClickableViewAccessibility")
    public LicensePlateView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mActivity = (Activity) context;
        TextViews = new TextView[8];
        View.inflate(context, R.layout.layout_license_plate_frame, this);
        int textsLength = VIEW_IDS.length;
        for (int i = 0; i < textsLength; i++) {
            //textview放进数组中，方便修改操作
            TextViews[i] = findViewById(VIEW_IDS[i]);
            OnFrameTouchListener mTouchListener = new OnFrameTouchListener();
            TextViews[i].setOnTouchListener(mTouchListener);
        }
        TextViews[0].setBackgroundResource(R.drawable.license_plate_first_view_blue);//第一个输入框默认设置点中效果
    }


    @SuppressLint("InflateParams")
    public void setKeyboardContainerLayout(RelativeLayout layout) {
        LayoutInflater mInflater = LayoutInflater.from(mActivity);
        mProvinceView = mInflater.inflate(R.layout.layout_keyboard_province, null);
        RelativeLayout.LayoutParams rlParams = new RelativeLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        rlParams.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
        mProvinceView.setLayoutParams(rlParams);
        mNumView = mInflater.inflate(R.layout.layout_keyboard_num, null);
        mNumView.setLayoutParams(rlParams);
        View view;
        CheckBox select_xny_cb;
        for (int viewProvinceId : VIEW_PROVINCE_IDS) {
            if (viewProvinceId == R.id.select_xny_cb) {
                select_xny_cb = mProvinceView.findViewById(R.id.select_xny_cb);
                select_xny_cb.setOnCheckedChangeListener(onCheckedChangeListener);
            } else {
                view = mProvinceView.findViewById(viewProvinceId);
                view.setOnClickListener(this);
            }
        }
        for (int viewNumId : VIEW_NUM_IDS) {
            if (viewNumId == R.id.select_xny_cb) {
                select_xny_cb = mNumView.findViewById(R.id.select_xny_cb);
                select_xny_cb.setOnCheckedChangeListener(onCheckedChangeListener);
            } else {
                view = mNumView.findViewById(viewNumId);
                view.setOnClickListener(this);
            }
        }

        layout.addView(mProvinceView);
        layout.addView(mNumView);
        mNumView.setVisibility(GONE);
        mProvinceView.setVisibility(GONE);

    }

    CompoundButton.OnCheckedChangeListener onCheckedChangeListener = new CompoundButton.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
            TextViews[7].setText("");
            if (b) {
                ITEM_VIEW_COUNT = 8;
                TextViews[7].setVisibility(VISIBLE);
            } else {
                ITEM_VIEW_COUNT = 7;
                TextViews[7].setVisibility(GONE);
            }
        }
    };

    /**
     * 键盘的点击事件 todo
     */
    @Override
    public void onClick(View view) {
        if (view instanceof TextView) {
            if (view.getId() == R.id.select_hide_tv) {
                mProvinceView.setVisibility(GONE);
                mNumView.setVisibility(GONE);
            } else {
                TextView tv = (TextView) view;
                tv.setSelected(true);
                String text = tv.getText().toString();
                setTextViewContent(text);
            }
        }
    }

    /**
     * 设置 TextView 的输入内容
     * 根据isUpdateView 判断修改/删除操作
     */
    private void setTextViewContent(String content) {
        if (updateViewPosition <= ITEM_VIEW_COUNT) {
            TextViews[updateViewPosition].setText(content);
            updateViewPosition++;
            setTextViewsBackground(updateViewPosition);
        }
        if (updateViewPosition == 0) {
            mProvinceView.setVisibility(VISIBLE);
            mNumView.setVisibility(GONE);
        } else {
            mProvinceView.setVisibility(GONE);
            mNumView.setVisibility(VISIBLE);
        }
        if (updateViewPosition == ITEM_VIEW_COUNT) {
            mProvinceView.setVisibility(GONE);
            mNumView.setVisibility(GONE);
        }
    }

    /**
     * 获取车牌号
     *
     * @return
     */
    public String getLPContent() {
        StringBuilder sb = new StringBuilder(ITEM_VIEW_COUNT);
        for (int i = 0; i < ITEM_VIEW_COUNT; i++) {
            sb.append(TextViews[i].getText().toString());
        }
        if (isCarnumberNO(sb.toString())) {
            return sb.toString();
        } else {
            return "no";
        }
    }

    /**
     * 显示输入框的TouchListener TODO
     */
    @SuppressLint("ClickableViewAccessibility")
    private class OnFrameTouchListener implements OnTouchListener {
        @Override
        public boolean onTouch(View view, MotionEvent event) {
            if (view instanceof TextView) {
                TextView tv = (TextView) view;
                for (int i = 0; i < ITEM_VIEW_COUNT; i++) {
                    if (tv.getId() == VIEW_IDS[i]) {
                        updateViewPosition = i;
                        if (i == 0) {
                            mProvinceView.setVisibility(VISIBLE);
                            mNumView.setVisibility(GONE);
                        } else {
                            mProvinceView.setVisibility(GONE);
                            mNumView.setVisibility(VISIBLE);
                        }
                        setTextViewsBackground(i);
                    }
                }
            }
            return true;
        }
    }

    private void setTextViewsBackground(int position) {
        //第一个框的样式
        if (position == 0) {
            TextViews[0].setBackgroundResource(R.drawable.license_plate_first_view_blue);
        } else {
            TextViews[0].setBackgroundResource(R.drawable.license_plate_first_view_all_gray);
        }
        //从第二个开始，到倒数第二个
        //根据点击选中效果，设置两边的样式
        if (position < 7 - 2 && position >= 1) {
            for (int i = 1; i < 7 - 2; i++) {
                TextViews[i].setBackgroundResource(R.drawable.license_plate_view_right_gray);
            }
            if (position == 1) {
                TextViews[position - 1].setBackgroundResource(R.drawable.license_plate_first_view_gray);
            } else {
                TextViews[position - 1].setBackgroundResource(R.drawable.license_plate_view_half_gray);
            }
            TextViews[position].setBackgroundResource(R.drawable.license_plate_mid_view_blue);
        } else {
            for (int i = 1; i < 7 - 2; i++) {
                TextViews[i].setBackgroundResource(R.drawable.license_plate_view_right_gray);
            }
        }

        //倒数第二个框的样式，根据选中的效果，设置前后两个框的样式
        if (position == 7 - 2) {
            TextViews[position].setBackgroundResource(R.drawable.license_plate_mid_view_blue);
            TextViews[position + 1].setBackgroundResource(R.drawable.license_plate_last_view_bg);
            TextViews[position - 1].setBackgroundResource(R.drawable.license_plate_view_half_gray);
        } else {
            TextViews[7 - 2].setBackgroundResource(R.drawable.license_plate_mid_view_bg);
        }
        //最后一个框的样式，根据选中的样式，前面一个样式需要改变
        if (position == 7 - 1) {
            TextViews[position].setBackgroundResource(R.drawable.license_plate_last_view_blue);
            TextViews[position - 1].setBackgroundResource(R.drawable.license_plate_view_half_gray);
        } else {
            TextViews[7 - 1].setBackgroundResource(R.drawable.license_plate_last_view_bg);
        }
    }

    public static boolean isCarnumberNO(String carnumber) {
        String carnumRegex = "([京津沪渝冀豫云辽黑湘皖鲁新苏浙赣鄂桂甘晋蒙陕吉闽贵粤青藏川宁琼使领 A-Z]{1}[A-Z]{1}(([0-9]{5}[DF])|([DF]([A-HJ-NP-Z0-9])[0-9]{4})))|([京津沪渝冀豫云辽黑湘皖鲁新苏浙赣鄂桂甘晋蒙陕吉闽贵粤青藏川宁琼使领 A-Z]{1}[A-Z]{1}[A-HJ-NP-Z0-9]{4}[A-HJ-NP-Z0-9 挂学警港澳]{1})";
        if (TextUtils.isEmpty(carnumber)) return false;
        else return carnumber.matches(carnumRegex);
    }
}
