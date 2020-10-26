package com.hnkc.ydcj.msg.bean;

import org.xutils.db.annotation.Column;
import org.xutils.db.annotation.Table;

@Table(name = "MSG110")
public class MmsgBean {

    /**
     * msgid : 消息id
     * msgtype : 消息类型
     * msgtime : 发送时间
     * userid : 用户id
     * username : 用户姓名
     * userheadimg : 用户头像
     * userunit : 用户单位
     * msgstr : 消息内容
     * filename : 文件名称
     * thumpath : 缩略图地址
     * filesize : 文件大小
     * voidtime : 录音时长
     * devicetype : 终端类型
     * msgnumber : 消息编号(警情id、任务id、会话id等)
     */
    @Column(name = "msgid", isId = true, property = "NOT NULL")
    private String msgid;//消息id
    @Column(name = "msgtype")
    private String msgtype;//消息类型
    @Column(name = "msgtime")
    private long msgtime;//发送时间
    @Column(name = "userid")
    private String userid;//用户id
    @Column(name = "username")
    private String username;//用户姓名
    @Column(name = "userheadimg")
    private String userheadimg;//用户头像
    @Column(name = "userunit")
    private String userunit;//用户单位
    @Column(name = "msgstr")
    private String msgstr;//消息内容
    @Column(name = "filename")
    private String filename;//文件名称
    @Column(name = "thumpath")
    private String thumpath;//缩略图地址
    @Column(name = "imgdescribe")
    private String imgdescribe;//图片描述
    @Column(name = "filesize")
    private String filesize;//文件大小
    @Column(name = "voidtime")
    private int voidtime;//录音时长
    @Column(name = "devicetype")
    private String devicetype;//终端类型
    @Column(name = "msgnumber")
    private String msgnumber;//消息编号(警情id、任务id、会话id等)
    @Column(name = "msgState")
    private String msgState;//0 发送中 1 发送成功   2发送失败
    @Column(name = "isComMsg")
    private String isComMsg;//是否为收到的消息 0收到的消息 1发送的消息

    public MmsgBean() {
    }

    public MmsgBean(String msgid, String msgtype, long msgtime, String userid, String username, String userheadimg, String userunit, String msgstr, String  imgdescribe, String filename, String thumpath, String filesize, int voidtime, String devicetype, String msgnumber, String msgState, String isComMsg) {
        this.msgid = msgid;
        this.msgtype = msgtype;
        this.msgtime = msgtime;
        this.userid = userid;
        this.username = username;
        this.userheadimg = userheadimg;
        this.userunit = userunit;
        this.msgstr = msgstr;
        this.imgdescribe=imgdescribe;
        this.filename = filename;
        this.thumpath = thumpath;
        this.filesize = filesize;
        this.voidtime = voidtime;
        this.devicetype = devicetype;
        this.msgnumber = msgnumber;
        this.msgState = msgState;
        this.isComMsg = isComMsg;
    }

    public MmsgBean(String msgid, String msgtype, long msgtime, String userid, String username,
                    String userheadimg, String userunit, String msgstr, String msgnumber, String msgState, String isComMsg) {
        this.msgid = msgid;
        this.msgtype = msgtype;
        this.msgtime = msgtime;
        this.userid = userid;
        this.username = username;
        this.userheadimg = userheadimg;
        this.userunit = userunit;
        this.msgstr = msgstr;
        this.msgnumber = msgnumber;
        this.msgState = msgState;
        this.isComMsg = isComMsg;
    }

    public String getImgdescribe() {
        return imgdescribe;
    }

    public void setImgdescribe(String imgdescribe) {
        this.imgdescribe = imgdescribe;
    }

    public String getMsgState() {
        return msgState;
    }

    public void setMsgState(String msgState) {
        this.msgState = msgState;
    }

    public String getIsComMsg() {
        return isComMsg;
    }

    public void setIsComMsg(String isComMsg) {
        this.isComMsg = isComMsg;
    }

    public String getMsgid() {
        return msgid;
    }

    public void setMsgid(String msgid) {
        this.msgid = msgid;
    }

    public String getMsgtype() {
        return msgtype;
    }

    public void setMsgtype(String msgtype) {
        this.msgtype = msgtype;
    }

    public long getMsgtime() {
        return msgtime;
    }

    public void setMsgtime(long msgtime) {
        this.msgtime = msgtime;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserheadimg() {
        return userheadimg;
    }

    public void setUserheadimg(String userheadimg) {
        this.userheadimg = userheadimg;
    }

    public String getUserunit() {
        return userunit;
    }

    public void setUserunit(String userunit) {
        this.userunit = userunit;
    }

    public String getMsgstr() {
        return msgstr;
    }

    public void setMsgstr(String msgstr) {
        this.msgstr = msgstr;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getThumpath() {
        return thumpath;
    }

    public void setThumpath(String thumpath) {
        this.thumpath = thumpath;
    }

    public String getFilesize() {
        return filesize;
    }

    public void setFilesize(String filesize) {
        this.filesize = filesize;
    }

    public int getVoidtime() {
        return voidtime;
    }

    public void setVoidtime(int voidtime) {
        this.voidtime = voidtime;
    }

    public String getDevicetype() {
        return devicetype;
    }

    public void setDevicetype(String devicetype) {
        this.devicetype = devicetype;
    }

    public String getMsgnumber() {
        return msgnumber;
    }

    public void setMsgnumber(String msgnumber) {
        this.msgnumber = msgnumber;
    }
}
