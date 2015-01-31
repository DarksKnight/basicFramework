package com.gmt.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.gmt.R;
import com.gmt.entity.login.LoginEntity;
import com.gmt.model.LoginModel;
import com.gmt.util.DealProxy;
import com.gmt.util.ObjectCallBack;
import com.gmt.util.RequestParams;
import com.gmt.util.StaticField;
import com.gmt.util.StringUtils;


public class LoginActivity extends ActionBarActivity {

    private EditText username;
    private EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username=(EditText)findViewById(R.id.username);
        password=(EditText)findViewById(R.id.password);
        Button btn_Login=(Button)findViewById(R.id.btn_Login);

        btn_Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doLogin();
            }
        });
    }

    private void doLogin(){

        RequestParams requestParams= com.gmt.util.RequestParams.getInstance();
        requestParams.put("loginId", username.getText().toString());

        DealProxy.getInstance().dealView(new ObjectCallBack<LoginEntity>() {
            @Override
            public void getData(LoginEntity obj) {
                StaticField.USER=obj.getInfo();
                Toast.makeText(LoginActivity.this, StaticField.USER.getUserID(), Toast.LENGTH_SHORT).show();
                Intent intent=new Intent();
                intent.setClass(LoginActivity.this,ArrangmentInfoActivity.class);
                startActivity(intent);
            }

            @Override
            public void getError(String error) {
                Toast.makeText(LoginActivity.this, error, Toast.LENGTH_SHORT).show();
            }
        }, new LoginModel(requestParams));
    }
}
