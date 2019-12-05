package com.wandao.myapplication.network.request;

import com.wandao.myapplication.network.response.LogResponse;
import com.wandao.myapplication.network.response.Response;
import com.wandao.myapplication.network.response.SimpleResponse;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Query;

/**
 * Created by Zaifeng on 2018/2/28.
 * 封装请求的接口
 */

public interface Request {



    //开关柜门事件
    String HOST = "http://192.168.1.218:80/";
    @Headers({"Content-Type: application/json","Accept: application/json"})
    @POST("zk-web/sendDoorEvent")
    Observable<SimpleResponse> newLog(@Body LogRequestBody logRequestBody);


    //注册用户
    @Headers({"Content-Type: application/json","Accept: application/json"})
    @POST("zk-web/sendEmployeeRegisterInfo")
    Observable<SimpleResponse> registerUser(@Body EmployeeRegisterInfoRequestBody logRequestBody);


//获取部门列表
    @Headers({"Content-Type: application/json","Accept: application/json"})
    @POST("zk-web/getDepartmentList")
    Observable<SimpleResponse > getDepartmentList(@Body EmployeeRegisterInfoRequestBody logRequestBody);
}
