package com.example.navigationview;

import android.app.Application;

import org.xutils.x;

public class MyApplication extends Application {
/*    public String addinfourl="http://127.0.0.1:8800/addinfo/";*/
    public String login="http://172.16.247.73:8800/login/";
    public String register="http://172.16.247.73:8800/register/";

    public String testdburl="http://172.16.247.73:8800/testdb/?format=json";
    public String getinfourl="http://172.16.247.73:8800/getinfo/";
    public String deleteinfourl="http://172.16.247.73:8800/deleteinfo/";
    public String updateinfourl="http://172.16.247.73:8800/updateinfo/";
    public String addinfourl="http://172.16.247.73:8800/addinfo/";

    public String testdboneurl="http://172.16.247.73:8800/testdbone/?format=json";
    public String testdbtwourl="http://172.16.247.73:8800/testdbtwo/?format=json";
    public String getinfooneurl="http://172.16.247.73:8800/getinfoone/";
    public String getinfotwourl="http://172.16.247.73:8800/getinfotwo/";

    public String URL="http://172.16.247.73:88/";
    public String selectallurl=URL+"json/listjson.php";
    public String inserturl=URL+"json/insert.php";
    public String selectbyidurl=URL+"json/select.php";
    public String selectbyidurl2=URL+"json/select2.php";
    public String selectbyidurl3=URL+"json/select3.php";
    public String deletebyidurl=URL+"json/delete.php";
    public String updatebyidurl=URL+"json/update.php";
    public String imagebaseurl=URL+"json/images/";

    public String selectbypageurl=URL+"json/listjsonpage.php";
    public String selectbypageurl2=URL+"json/listjsonpage2.php";
    public String selectbypageurl3=URL+"json/listjsonpage3.php";//分页效果使用的接口
    @Override
    public void onCreate() {
        super.onCreate();
        x.Ext.init(this);
        //x.Ext.setDebug(BuildConfig.DEBUG); // 是否输出debug日志, 开启debug会影响性能.
    }
}