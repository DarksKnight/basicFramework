package com.gmt.model;

import com.gmt.entity.BaseEntity;
import com.gmt.entity.login.LoginEntity;
import com.gmt.util.DealProxy;
import com.gmt.util.Request;
import com.gmt.util.RequestCallBack;
import com.gmt.util.RequestParams;
import com.google.gson.Gson;

import org.json.JSONObject;

/**
 * Created by apple on 1/24/15.
 */
public class LoginModel extends CommonModel {

    private RequestParams requestParams=null;

    public LoginModel(){}

    public LoginModel(RequestParams requestParams){
        this.requestParams=requestParams;
    }

    @Override
    public void getData() {
        Request.post("",requestParams,new RequestCallBack() {
            @Override
            public void onSuccess(JSONObject response) {
                BaseEntity entity;
                Gson g=new Gson();
                try{
                    entity=g.fromJson(response.toString(),LoginEntity.class);
                }catch (Exception e){
                    e.printStackTrace();
                    entity=g.fromJson(response.toString(),BaseEntity.class);
                }
                DealProxy.getInstance().dealModel(entity);
            }
        });
    }

}
