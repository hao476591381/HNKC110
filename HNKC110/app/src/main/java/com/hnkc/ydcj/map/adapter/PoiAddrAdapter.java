package com.hnkc.ydcj.map.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.hnkc.ydcj.R;
import com.hnkc.ydcj.map.bean.PoiAddrBean;

import java.util.List;

/**
 * 周边位置检索
 */
public class PoiAddrAdapter extends RecyclerView.Adapter<PoiAddrAdapter.PoiAddrHolder> {
    private OnItemClickListener onItemClickListener;
    private List<PoiAddrBean.DataBean> mList;

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public interface OnItemClickListener {
        void onItemClick(PoiAddrBean.DataBean list);
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

    @NonNull
    @Override
    public PoiAddrHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        return new PoiAddrHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.poi_addr_item, viewGroup, false));
    }

    @Override
    public int getItemCount() {
        return mList != null ? mList.size() : 0;
    }

    @Override
    public void onBindViewHolder(@NonNull PoiAddrHolder holder, int position) {
        PoiAddrBean.DataBean mItem = mList.get(position);
        holder.poi_tible_tv.setText(mItem.getTitle());
        holder.poi_addr_tv.setText(mItem.getAddress());
    }

    public class PoiAddrHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView poi_tible_tv;
        TextView poi_addr_tv;
        LinearLayout poi_qr_ll;

        private PoiAddrHolder(@NonNull View v) {
            super(v);
            poi_tible_tv = v.findViewById(R.id.poi_tible_tv);
            poi_addr_tv = v.findViewById(R.id.poi_addr_tv);
            poi_qr_ll = v.findViewById(R.id.poi_qr_ll);
            poi_qr_ll.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if (onItemClickListener != null) {
                onItemClickListener.onItemClick(mList.get(getAdapterPosition()));
            }
        }
    }
}
