package com.wandao.myapplication.model;
import com.wandao.myapplication.network.request.EmployeeRegisterInfoRequestBody;
import com.wandao.myapplication.network.request.LogRequestBody;
import com.wandao.myapplication.network.response.Response;
import com.wandao.myapplication.network.response.SimpleResponse;

import io.reactivex.Observable;


/**
 * Created by Zaifeng on 2018/3/1.
 */

public class Contract {

    public interface Persenter {
        public void getCarList(String userId);
    }

    public interface View {
        void getDataFail(String s);


        void getDataSuccess(SimpleResponse msg);

    }

    public interface Model {
        public Observable<SimpleResponse> getLogResponse(LogRequestBody logRequestBody);
        public Observable<SimpleResponse> getRegisterResponse(EmployeeRegisterInfoRequestBody employeeRegisterInfoRequestBody);
    }

}
