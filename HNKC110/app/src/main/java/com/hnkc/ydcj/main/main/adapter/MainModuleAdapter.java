package com.hnkc.ydcj.main.main.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.myview.imgview.NumImageView;
import com.hg.lib.tool.ImgBindTool;
import com.hnkc.ydcj.R;
import com.hnkc.ydcj.main.main.bean.ModuleBean;
import com.hnkc.ydcj.utils.DbUtils;

import java.util.List;

/**
 * 显示模块的适配器.
 */
public class MainModuleAdapter extends RecyclerView.Adapter<MainModuleAdapter.ModuleHolder> {
    private List<ModuleBean> moduleList;
    private OnItemClickListener onItemClickListener;

    public MainModuleAdapter(List<ModuleBean> moduleList) {
        this.moduleList = moduleList;

    }

    /**
     * 添加数据源
     *
     * @param moduleList
     */
    public void addData(List<ModuleBean> moduleList) {
        this.moduleList = moduleList;
        notifyDataSetChanged();
    }

    /**
     * 获取数据
     *
     * @return
     */
    public List<ModuleBean> getData() {
        return moduleList;
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    @NonNull
    @Override
    public ModuleHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int position) {
        View convertView = null;
        ModuleBean moduleBean = moduleList.get(position);
        switch (moduleBean.getApptype()) {
            case "0":
                convertView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.main_module_item, viewGroup, false);
                break;
            case "1":
                convertView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.main_module1_item, viewGroup, false);
                break;
        }

        return new ModuleHolder(convertView);
    }

    @Override
    public void onBindViewHolder(@NonNull ModuleHolder holder, int position) {
        // 绑定数据
        ModuleBean moduleBean = moduleList.get(position);
        holder.module_item_tv.setText(moduleBean.getAppname());
        ImgBindTool.ModuleImgBind(holder.module_item_iv,"assets://img/"+moduleBean.getApptb());
        Point(holder,moduleBean.getNewMsg());
    }

    @Override
    public int getItemCount() {
        return moduleList != null ? moduleList.size() : 0;
    }

    public class ModuleHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private NumImageView module_item_iv;
        private TextView module_item_tv;

        private ModuleHolder(@NonNull View itemView) {
            super(itemView);
            module_item_iv = itemView.findViewById(R.id.module_item_iv);
            module_item_tv = itemView.findViewById(R.id.module_item_tv);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            ModuleBean moduleBean = moduleList.get(getAdapterPosition());
            DbUtils.getInstance().UpdateAPP(moduleBean.getAppid(),"0");
            module_item_iv.hidePoint();
            if (onItemClickListener != null) {
                onItemClickListener.onItemClick(moduleBean.getAppid());
            }
        }
    }

    public interface OnItemClickListener {
        void onItemClick(String appId);
    }

    /**
     * 红点隐藏和显示
     * @param holder
     * @param newMsg
     */
    private void Point(ModuleHolder holder, String newMsg) {
        if (newMsg.equals("0")) {
            holder.module_item_iv.hidePoint();
        } else if (newMsg.equals("1")) {
            holder.module_item_iv.showPoint("");
        }
    }
}
