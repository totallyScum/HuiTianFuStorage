package com.wandao.myapplication.constant;

import android.content.Context;
import android.content.SharedPreferences;

public class UrlConstant {
    /**
     * 域名:
     */

 //   http://192.168.1.218:80/zk-web/getSoftwarePackageInfo
    public static String BASE_URL="http://192.168.1.218:80/";

    public static String getBaseUrl(Context context) {

        SharedPreferences sharedPreferences= context.getSharedPreferences("data", Context.MODE_PRIVATE);
        String ip=sharedPreferences.getString("IP",BASE_URL);
        BASE_URL = ip;
        return ip;
    }

    public static void setBaseUrl(String baseUrl, Context context) {
        if (baseUrl!="") {
            SharedPreferences sharedPreferences = context.getSharedPreferences("data", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            //步骤3：将获取过来的值放入文件
            editor.putString("IP", baseUrl);
            editor.commit();
            BASE_URL = baseUrl;
        }
    }

    public void initBaseUrl(Context context){
        SharedPreferences sharedPreferences= context.getSharedPreferences("data", Context.MODE_PRIVATE);
        String ip=sharedPreferences.getString("IP",BASE_URL);
        BASE_URL=ip;
    }
}
