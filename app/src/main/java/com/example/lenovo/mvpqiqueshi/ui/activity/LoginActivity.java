package com.example.lenovo.mvpqiqueshi.ui.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.lenovo.mvpqiqueshi.R;
import com.example.lenovo.mvpqiqueshi.presenter.contract.ILoginContract;
import com.example.lenovo.mvpqiqueshi.presenter.impl.LoginPresenterImpl;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends AppCompatActivity implements ILoginContract.ILoginView<ILoginContract.ILoginPresenter> {

    @BindView(R.id.etUserName)
    EditText etUserName;
    @BindView(R.id.etUserPasw)
    EditText etUserPasw;
    @BindView(R.id.login)
    Button login;
    @BindView(R.id.pb_waiting)
    ProgressBar pbWaiting;
    private LoginPresenterImpl loginPresenter;
    ILoginContract.ILoginPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        new LoginPresenterImpl(this);
    }

    @OnClick(R.id.login)
    public void onViewClicked() {
        String userName = etUserName.getText().toString();
        String userPasw = etUserPasw.getText().toString();
        //启动activity所
        presenter.login(userName, userPasw);
    }

    @Override
    public void setPresenter(ILoginContract.ILoginPresenter iLoginPresenter) {

        presenter = iLoginPresenter;
    }

    public void loading() {
        pbWaiting.setVisibility(View.VISIBLE);
    }

    @Override
    public void showData(String responseString) {
        Toast.makeText(this, responseString, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void completed() {
        pbWaiting.setVisibility(View.GONE);
    }
}
