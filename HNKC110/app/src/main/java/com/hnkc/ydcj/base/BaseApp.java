package com.hnkc.ydcj.base;

import android.app.Application;

import com.hg.lib.tool.SPUtils;
import com.hnkc.ydcj.utils.DbUtils;

import org.xutils.DbManager;
import org.xutils.ex.DbException;
import org.xutils.x;

public class BaseApp extends Application {
    public static SPUtils spUtils;
    private static BaseApp myApplicaton;


    public synchronized static BaseApp getInstance() {
        return myApplicaton;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        myApplicaton = this;
        x.Ext.init(this); // 注册xutils
        spUtils = new SPUtils(this, "hnkc110_sp");
        DbUtils.getInstance().init(getDbManager(1));
    }
    /**
     * 创建数据库
     *
     * @param version 数据库版本
     * @return
     */
    public DbManager getDbManager(int version) {
        DbManager.DaoConfig daoConfig = new DbManager.DaoConfig().setDbName("hnkc110.db").setDbVersion(version);//设置数据库版本,每次启动应用时将会检查该版本号,;
        try {
            return x.getDb(daoConfig);
        } catch (DbException e) {
            e.printStackTrace();
            return null;
        }
    }
}
