package com.gmt.util;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.apache.http.Header;
import org.json.JSONObject;

/**
 * Created by apple on 1/24/15.
 */
public class Request {

    private final static AsyncHttpClient client = new AsyncHttpClient();

    public static void post(String url,RequestParams params,final RequestCallBack requestCallBack){

        client.post(StaticField.HOST+url,params.done(),new JsonHttpResponseHandler() {

            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                try{
                    requestCallBack.onSuccess(response);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });
    }

    public static void post(String url,final RequestCallBack requestCallBack){

        client.post(StaticField.HOST+url,new JsonHttpResponseHandler() {

            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                try{
                    requestCallBack.onSuccess(response);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }

        });
    }
}
