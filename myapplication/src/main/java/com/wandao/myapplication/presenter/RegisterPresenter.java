package com.wandao.myapplication.presenter;

import com.wandao.myapplication.model.Contract;
import com.wandao.myapplication.network.request.EmployeeRegisterInfoRequestBody;
import com.wandao.myapplication.network.request.LogRequestBody;
import com.wandao.myapplication.network.response.LogResponse;
import com.wandao.myapplication.network.schedulers.BaseSchedulerProvider;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class RegisterPresenter {
    private Contract.Model model;

    private Contract.View view;

    private BaseSchedulerProvider schedulerProvider;

    private CompositeDisposable mDisposable;

    public RegisterPresenter(Contract.Model model,
                     Contract.View view,
                     BaseSchedulerProvider schedulerProvider) {
        this.model = model;
        this.view = view;
        this.schedulerProvider = schedulerProvider;
        mDisposable = new CompositeDisposable();
    }
    public void despose() {
        mDisposable.dispose();
    }


    public void postRegisterRequest(EmployeeRegisterInfoRequestBody employeeRegisterInfoRequestBody) {
        Disposable disposable = model.getRegisterResponse(employeeRegisterInfoRequestBody)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(registerBeans -> {
                    // 处理数据 直接获取到List<JavaBean> carBeans
                    view.getDataSuccess(registerBeans);
                }, throwable -> {
                    // 处理异常
                    view.getDataFail(throwable.getMessage());
                });
        mDisposable.add(disposable);
    }
}
