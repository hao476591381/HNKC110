package com.hnkc.ydcj.main.main.bean;

import org.xutils.db.annotation.Column;
import org.xutils.db.annotation.Table;

@Table(name = "Module", onCreated = "")
public class ModuleBean {

    /**
     * appid : appID jqcl、abrw、zxhs、jrjq等
     * appname : app名称 警情处理、安保任务、在线会商、今日警情等
     * apptype : 模块类型 0主要模块、1辅助模块 三个界面以上以及有实时消息交互为主要模块其次为辅助模块。
     * appsybz : 使用标志 0 禁用 1 使用
     * apptb : app图标
     * appfwdz : web访问地址
     * newMsg: 是否有新消息 0无消息 1有消息
     */
    @Column(name = "appid", isId = true, autoGen = true, property = "NOT NULL")
    private String appid;
    @Column(name = "appname")
    private String appname;
    @Column(name = "apptype")
    private String apptype;
    @Column(name = "appsybz")
    private String appsybz;
    @Column(name = "apptb")
    private String apptb;
    @Column(name = "appfwdz")
    private String appfwdz;
    @Column(name = "newMsg")
    private String newMsg="0";

    public ModuleBean() {
    }

    public ModuleBean(String appid, String appname, String apptype, String appsybz, String apptb, String appfwdz, String newMsg) {
        this.appid = appid;
        this.appname = appname;
        this.apptype = apptype;
        this.appsybz = appsybz;
        this.apptb = apptb;
        this.appfwdz = appfwdz;
        this.newMsg = newMsg;

    }

    public String getNewMsg() {
        return newMsg;
    }

    public void setNewMsg(String newMsg) {
        this.newMsg = newMsg;
    }

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    public String getAppname() {
        return appname;
    }

    public void setAppname(String appname) {
        this.appname = appname;
    }

    public String getApptype() {
        return apptype;
    }

    public void setApptype(String apptype) {
        this.apptype = apptype;
    }

    public String getAppsybz() {
        return appsybz;
    }

    public void setAppsybz(String appsybz) {
        this.appsybz = appsybz;
    }

    public String getApptb() {
        return apptb;
    }

    public void setApptb(String apptb) {
        this.apptb = apptb;
    }

    public String getAppfwdz() {
        return appfwdz;
    }

    public void setAppfwdz(String appfwdz) {
        this.appfwdz = appfwdz;
    }
}
