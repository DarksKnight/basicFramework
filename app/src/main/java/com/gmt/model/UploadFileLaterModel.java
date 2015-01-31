package com.gmt.model;

import android.util.Log;

import com.gmt.entity.BaseEntity;
import com.gmt.entity.upload.UploadLaterEntity;
import com.gmt.util.DealProxy;
import com.gmt.util.Request;
import com.gmt.util.RequestCallBack;
import com.gmt.util.RequestParams;
import com.google.gson.Gson;

import org.json.JSONObject;

/**
 * Created by apple on 1/25/15.
 */
public class UploadFileLaterModel extends CommonModel {

    private RequestParams requestParams=null;

    public UploadFileLaterModel(RequestParams requestParams){
        this.requestParams=requestParams;
    }

    @Override
    public void getData() {
        Request.post("", requestParams, new RequestCallBack() {
            @Override
            public void onSuccess(JSONObject response) {
                Log.i("ffff", response.toString());
                BaseEntity entity;
                Gson g = new Gson();
                try {
                    entity = g.fromJson(response.toString(), UploadLaterEntity.class);
                } catch (Exception e) {
                    e.printStackTrace();
                    entity = g.fromJson(response.toString(), BaseEntity.class);
                }
                DealProxy.getInstance().dealModel(entity);
            }
        });
    }
}
