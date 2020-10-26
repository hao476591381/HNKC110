package com.hnkc.ydcj.utils;

import com.hg.lib.tool.ShowLog;
import com.hnkc.ydcj.main.main.bean.ModuleBean;
import com.hnkc.ydcj.msg.bean.MmsgBean;

import org.xutils.DbManager;
import org.xutils.common.util.KeyValue;
import org.xutils.db.sqlite.WhereBuilder;
import org.xutils.ex.DbException;

import java.util.ArrayList;
import java.util.List;

public class DbUtils {
    private DbManager db;
    private static DbUtils dbUtils;


    public static DbUtils getInstance() {
        if (dbUtils == null) {
            dbUtils = new DbUtils();
        }
        return dbUtils;
    }

    public void init(DbManager db) {
        this.db = db;
    }

    /**
     * 保存模块列表
     * m
     *
     * @throws DbException
     */
    public void SaveModule(List<ModuleBean> moduleList) {
        try {
            db.saveOrUpdate(moduleList);
        } catch (DbException e) {
            e.printStackTrace();
            ShowLog.sys(e.getMessage());
        }
    }


    /**
     * 查询全部功能模块
     *
     * @return
     */
    public List<ModuleBean> FindAllModuleList() {
        List<ModuleBean> p = null;
        try {
            p = db.selector(ModuleBean.class).findAll();
        } catch (DbException e) {
            e.printStackTrace();
        }
        return p;
    }

    /**
     * 查询主要功能模块
     *
     * @return
     */
    public List<ModuleBean> FindMianModuleList() {
        List<ModuleBean> p = null;
        try {
            p = db.selector(ModuleBean.class).where("apptype", "=", "0").and("appsybz", "=", "1").findAll();
        } catch (DbException e) {
            e.printStackTrace();
        }
        return p;
    }

    /**
     * 查询辅助功能模块
     *
     * @return
     */
    public List<ModuleBean> FindAidedModuleList() {
        List<ModuleBean> p = new ArrayList<>();
        try {
            p = db.selector(ModuleBean.class).where("apptype", "=", "1").and("appsybz", "=", "1").findAll();
        } catch (DbException e) {
            e.printStackTrace();
        }
        return p;
    }

    /**
     * 根据appid修改消息状态
     *
     * @param appid
     * @param newMsg 0 代表无新消息 1 代表有新消息
     * @return
     */
    public void UpdateAPP(String appid, String newMsg) {
        WhereBuilder whereBuilder = WhereBuilder.b();
        whereBuilder.and("appid", "=", appid);
        try {
            db.update(ModuleBean.class, whereBuilder, new KeyValue("newMsg", newMsg));
        } catch (DbException e) {
            e.printStackTrace();
        }
    }

    /**
     * 保存反馈信息
     *
     * @throws DbException
     */
    public void SaveMsg(MmsgBean item) {
        try {
            db.saveOrUpdate(item);
        } catch (DbException e) {
            e.printStackTrace();
        }
    }

    /**
     * 根据用户id和消息编号查询消息列表
     *
     * @param userid
     * @param msgnumber
     * @return
     */
    public List<MmsgBean> FindAllMsgList(String userid, String msgnumber) {
        List<MmsgBean> p = new ArrayList<>();
        try {
            p = db.selector(MmsgBean.class).where("userid", "=", userid).and("msgnumber", "=", msgnumber).orderBy("msgtime")
                    .findAll();
        } catch (DbException e) {
            e.printStackTrace();
        }
        return p;
    }

    /**
     * 根据信息id修改消息发送状态
     * @param msgid
     * @param msgState
     * @return
     */
    public void UpMsg(String msgid, String msgState) {
        WhereBuilder whereBuilder = WhereBuilder.b();
        whereBuilder.and("msgid", "=", msgid);
        try {
            db.update(MmsgBean.class, whereBuilder, new KeyValue("msgState", msgState));
        } catch (DbException e) {
            e.printStackTrace();
        }
    }
}
