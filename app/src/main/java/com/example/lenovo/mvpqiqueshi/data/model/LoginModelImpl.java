package com.example.lenovo.mvpqiqueshi.data.model;

import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Lenovo on 2018/5/3.
 */
//在m层进行数据的处理
public class LoginModelImpl implements ILoginModel {

    @Override
    public void setOnDataChangeListener(String userName, String userPasw, final OnDataChangeListener listener) {
        String reponseString = "默认数据";
        if (userName.equals("czy")&&userPasw.equals("123")){
            reponseString="登录成功";
        }else{
            reponseString="登录失败";

        }
        Observable
                .just(reponseString)
                .delay(2000, TimeUnit.MILLISECONDS)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<String>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(String s) {
                        //回显数据 接口调用数据
                            listener.onShowData(s);
                    }
                });
    }
}
