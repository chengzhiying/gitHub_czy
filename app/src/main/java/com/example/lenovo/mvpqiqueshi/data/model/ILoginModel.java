package com.example.lenovo.mvpqiqueshi.data.model;

/**
 * Created by Lenovo on 2018/5/3.
 */
    //以接口毁掉的形式回显数据
public interface ILoginModel {
    void setOnDataChangeListener(String userName, String pwd, OnDataChangeListener listener);
    interface OnDataChangeListener{
        void onShowData(String responseString);
    }
}
