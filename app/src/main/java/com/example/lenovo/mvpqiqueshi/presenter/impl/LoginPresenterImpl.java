package com.example.lenovo.mvpqiqueshi.presenter.impl;

import com.example.lenovo.mvpqiqueshi.data.model.ILoginModel;
import com.example.lenovo.mvpqiqueshi.data.model.LoginModelImpl;
import com.example.lenovo.mvpqiqueshi.presenter.contract.ILoginContract;
import com.example.lenovo.mvpqiqueshi.ui.activity.LoginActivity;

/**
 * Created by Lenovo on 2018/5/3.
 */

public class LoginPresenterImpl implements ILoginContract.ILoginPresenter {
    ILoginContract.ILoginView iLoginView;
    private final LoginModelImpl loginModel;

    public LoginPresenterImpl(ILoginContract.ILoginView iLoginView) {
            this.iLoginView=iLoginView;

            //转换器 v层持有p层对象
            iLoginView.setPresenter(this);
        loginModel = new LoginModelImpl();
    }

    //写完m层的数据 过来回显
    @Override
    public void login(String userName, String userPasw) {
        //准备动作
        iLoginView.loading();
        //数据请求
        loginModel.setOnDataChangeListener(userName, userPasw, new ILoginModel.OnDataChangeListener() {
            @Override
            public void onShowData(String responseString) {
                iLoginView.showData(responseString);
                //结束动作
                iLoginView.completed();
            }
        });
    }
}
