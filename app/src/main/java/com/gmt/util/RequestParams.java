package com.gmt.util;

import java.io.File;
import java.util.HashMap;

/**
 * Created by apple on 1/24/15.
 */
public class RequestParams {

    private int state;
    private File file;
    private static final HashMap<String,String> map=new HashMap<>();
    private static RequestParams params;

    private RequestParams(){}

    private RequestParams(String key,String value){
        map.put(key,value);
    }

    public static RequestParams getInstance(){
        map.clear();
        if(params==null)
            params=new RequestParams();
        return params;
    }

    public static RequestParams getInstance(String key,String value){
        map.clear();
        if(params==null)
            params=new RequestParams(key,value);
        return params;
    }

    public void put(String key,String value){
        state=0;
        map.put(key,value);
    }

    public void put(File file){
        state=1;
        this.file=file;
    }

    public com.loopj.android.http.RequestParams done(){
        try{
            if(state==1){
                com.loopj.android.http.RequestParams p=new com.loopj.android.http.RequestParams();
                p.put("name",this.file);
                return p;
            }
            return new com.loopj.android.http.RequestParams(map);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
