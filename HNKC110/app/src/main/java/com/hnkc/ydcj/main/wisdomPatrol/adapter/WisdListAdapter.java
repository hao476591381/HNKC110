package com.hnkc.ydcj.main.wisdomPatrol.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.hnkc.ydcj.R;
import com.hnkc.ydcj.main.wisdomPatrol.bean.WisdTaskBean;

import java.util.List;

/**
 * 智慧巡防Adapter
 */
public class WisdListAdapter extends RecyclerView.Adapter<WisdListAdapter.WisdListHolder> {
    private List<WisdTaskBean> mList;
    private OnItemClickListener onItemClickListener;

    public WisdListAdapter() {
    }

    /**
     * 添加数据源
     *
     * @param list
     */
    public void addData(List<WisdTaskBean> list) {
        this.mList = list;
        notifyDataSetChanged();
    }

    /**
     * 获取数据
     *
     * @return
     */
    public List<WisdTaskBean> getData() {
        return mList;
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    @NonNull
    @Override
    public WisdListHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int position) {
        return new WisdListHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.wisdompatrol_list_item, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull WisdListHolder holder, int position) {
        // 绑定数据
        WisdTaskBean wisdTaskBean = mList.get(position);
        holder.wisdlist_item_tasknumber.setText(wisdTaskBean.getTaskID());
        holder. wisdlist_item_taskstate.setText(wisdTaskBean.getTaskState());
        holder.wisdlist_item_tasktype.setText(wisdTaskBean.getTaskName());
    }

    @Override
    public int getItemCount() {
        return mList != null ? mList.size() : 0;
    }

    public class WisdListHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        LinearLayout wisdlist_item_click;
        TextView wisdlist_item_tasknumber;
        TextView wisdlist_item_tasktype;
        TextView wisdlist_item_taskstate;

        private WisdListHolder(@NonNull View v) {
            super(v);
            wisdlist_item_click = v.findViewById(R.id.wisdlist_item_click);
            wisdlist_item_tasknumber = v.findViewById(R.id.wisdlist_item_tasknumber);
            wisdlist_item_tasktype = v.findViewById(R.id.wisdlist_item_tasktype);
            wisdlist_item_taskstate= v.findViewById(R.id.wisdlist_item_taskstate);
            wisdlist_item_click.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if (onItemClickListener != null) {
                onItemClickListener.onItemClick(mList.get(getAdapterPosition()));
            }
        }
    }

    public interface OnItemClickListener {
        void onItemClick(WisdTaskBean wisdTaskBean);
    }
}
