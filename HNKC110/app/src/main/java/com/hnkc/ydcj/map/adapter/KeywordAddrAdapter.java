package com.hnkc.ydcj.map.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.hg.lib.tool.CharShift;
import com.hnkc.ydcj.R;
import com.hnkc.ydcj.map.bean.PoiAddrBean;

import java.util.List;

/**
 * 地图关键字地点搜索
 */
public class KeywordAddrAdapter extends RecyclerView.Adapter<KeywordAddrAdapter.KeywordAddrHolder> {
    private List<PoiAddrBean.DataBean> mList;
    private OnItemClickListener onItemClickListener;

    public KeywordAddrAdapter() {
    }

    /**
     * 添加数据源
     *
     * @param list
     */
    public void addData(List<PoiAddrBean.DataBean> list) {
        this.mList = list;
        notifyDataSetChanged();
    }

    /**
     * 获取数据
     *
     * @return
     */
    public List<PoiAddrBean.DataBean> getData() {
        return mList;
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    @NonNull
    @Override
    public KeywordAddrHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int position) {
        return new KeywordAddrHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.keyword_addr_item, viewGroup, false));
    }

    @Override
    public int getItemCount() {
        return mList != null ? mList.size() : 0;
    }

    @Override
    public void onBindViewHolder(@NonNull KeywordAddrHolder holder, int position) {
        // 绑定数据
        PoiAddrBean.DataBean keyWord = mList.get(position);
        holder.keyword_addrname_item_tv.setText(keyWord.getTitle());
        holder.keyword_addr_item_tv.setText(keyWord.getAddress());
        holder.keyword__distance_item_tv.setText(getDistance(keyWord.get_distance()));
    }

    public class KeywordAddrHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView keyword_addrname_item_tv;
        TextView keyword_addr_item_tv;
        TextView keyword__distance_item_tv;
        RelativeLayout keyword_addr_item_rl;

        private KeywordAddrHolder(@NonNull View v) {
            super(v);
            keyword_addrname_item_tv = v.findViewById(R.id.keyword_addrname_item_tv);
            keyword_addr_item_tv = v.findViewById(R.id.keyword_addr_item_tv);
            keyword__distance_item_tv = v.findViewById(R.id.keyword__distance_item_tv);
            keyword_addr_item_rl = v.findViewById(R.id.keyword_addr_item_rl);
            keyword_addr_item_rl.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if (onItemClickListener != null) {
                onItemClickListener.onItemClick(mList.get(getAdapterPosition()));
            }
        }
    }


    public interface OnItemClickListener {
        void onItemClick(PoiAddrBean.DataBean keyWordList);
    }

    private String getDistance(double distanceStr) {
        if (distanceStr < 1000) {
            String xx = CharShift.douToStr(distanceStr);
            if (xx.substring(xx.indexOf(".") + 1).equals("0")) {
                return xx.substring(0, xx.indexOf(".")) + "m";
            } else {
                return xx + "m";
            }
        } else {
            String ss = CharShift.douToStr(Math.rint(distanceStr / 100) / 10);
            if (ss.substring(ss.indexOf(".") + 1).equals("0")) {
                return ss.substring(0, ss.indexOf(".")) + "km";
            } else {
                return ss + "km";
            }
        }
    }
}
