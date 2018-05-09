package com.example.lenovo.mvpqiqueshi.presenter.contract;

import com.example.lenovo.mvpqiqueshi.presenter.BasePresenter;
import com.example.lenovo.mvpqiqueshi.ui.BaseView;

/**
 * Created by Lenovo on 2018/5/3.
 */

public interface ILoginContract {
    interface ILoginPresenter extends BasePresenter {
        void login(String userName,String userPasw);
    }
    interface ILoginView<ILoginPresenter> extends BaseView<ILoginPresenter>{
        //加载中
        void loading();
        //数据回显
        void showData(String responseString);
        //登录完成
        void completed();
    }
}
