package com.wandao.myapplication.model;


import com.wandao.myapplication.network.NetWorkManager;
import com.wandao.myapplication.network.request.EmployeeRegisterInfoRequestBody;
import com.wandao.myapplication.network.request.LogRequestBody;
import com.wandao.myapplication.network.response.SimpleResponse;

import io.reactivex.Observable;

/**
 * Created by Zaifeng on 2018/3/1.
 */

public class Model implements Contract.Model {
    @Override
    public Observable<SimpleResponse> getLogResponse(LogRequestBody logRequestBody) {
        return NetWorkManager.getRequest().newLog(logRequestBody);
    }

    @Override
    public Observable<SimpleResponse> getRegisterResponse(EmployeeRegisterInfoRequestBody employeeRegisterInfoRequestBody) {
        return NetWorkManager.getRequest().registerUser(employeeRegisterInfoRequestBody);
    }


}
