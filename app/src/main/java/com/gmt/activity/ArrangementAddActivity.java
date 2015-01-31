package com.gmt.activity;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.ActionBarActivity;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.gmt.R;
import com.gmt.entity.upload.AttachId;
import com.gmt.entity.upload.UploadEntity;
import com.gmt.entity.upload.UploadLaterEntity;
import com.gmt.model.GetAttachIdModel;
import com.gmt.model.UploadFileLaterModel;
import com.gmt.model.UploadFileModel;
import com.gmt.util.CommonUtil;
import com.gmt.util.DealProxy;
import com.gmt.util.ObjectCallBack;
import com.gmt.util.RequestParams;
import com.gmt.util.StaticField;
import com.gmt.util.StringUtils;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

import java.io.File;
import java.util.Calendar;
import java.util.Locale;

/**
 * Created by apple on 1/25/15.
 */
public class ArrangementAddActivity extends ActionBarActivity {

    private TextView tv_detail;
    private ImageView iv;

    private String attachId="";
    private String fileattachsysname;
    private String path;
    private String fileName;

    //loading框
    private ProgressDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arrangmentinfoadd);

        Button take=(Button)findViewById(R.id.take);
        tv_detail=(TextView)findViewById(R.id.tv_detail);
        iv=(ImageView)findViewById(R.id.iv);

        initData();

        take.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //上传图片
                dialog= CommonUtil.showDialog(ArrangementAddActivity.this, "上传中");
                fileName=DateFormat.format("yyyyMMdd_hhmmss",Calendar.getInstance(Locale.CHINA)) + ".jpg";
                Intent it = new Intent("android.media.action.IMAGE_CAPTURE");
                it.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(new File(Environment.getExternalStorageDirectory().getPath()+"Image/"+fileName)));
                startActivityForResult(it, 1);
            }
        });
    }

    /**
     * 初始化，获得attachId
     */
    private void initData(){
        RequestParams requestParams= com.gmt.util.RequestParams.getInstance();
        requestParams.put("userId", StaticField.USER.getUserID());
        requestParams.put("encryptStr", StringUtils.MD5Encoder(StaticField.USER.getUserID() + "GTL20150109", "UTF-8"));

        DealProxy.getInstance().dealView(new ObjectCallBack<AttachId>() {
            @Override
            public void getData(AttachId obj) {
                attachId=obj.getInfo().getBisAttachId();
                Toast.makeText(ArrangementAddActivity.this, obj.getInfo().getBisAttachId(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void getError(String error) {
                Toast.makeText(ArrangementAddActivity.this, error, Toast.LENGTH_SHORT).show();
            }
        }, new GetAttachIdModel(requestParams));
    }

    /**
     * 上传图片，第一次调用接口
     */
    private void firstUpload(){
        File file=new File(Environment.getExternalStorageDirectory().getPath()+"Image/"+fileName);
        RequestParams requestParams= com.gmt.util.RequestParams.getInstance();
        requestParams.put(file);

        DealProxy.getInstance().dealView(new ObjectCallBack<UploadEntity>() {
            @Override
            public void getData(UploadEntity obj) {
                fileattachsysname=obj.getInfo().getFileattachsysname();
                path=obj.getInfo().getPath();
                lastUpload();
            }

            @Override
            public void getError(String error) {
                Toast.makeText(ArrangementAddActivity.this, error, Toast.LENGTH_SHORT).show();
            }
        }, new UploadFileModel(requestParams));
    }

    /**
     * 上传图片，第二次调用接口
     */
    private void lastUpload(){
        RequestParams requestParams= com.gmt.util.RequestParams.getInstance();
        requestParams.put("userId",StaticField.USER.getUserID());

        DealProxy.getInstance().dealView(new ObjectCallBack<UploadLaterEntity>() {
            @Override
            public void getData(UploadLaterEntity obj) {
                tv_detail.setText(StaticField.HOST+obj.getInfo().getImgBigSize());
                CommonUtil.dismissDialog(dialog);
                Toast.makeText(ArrangementAddActivity.this, obj.getInfo().getResult(), Toast.LENGTH_SHORT).show();
                ImageLoader.getInstance().init(new ImageLoaderConfiguration.Builder(ArrangementAddActivity.this).build());
                ImageLoader.getInstance().displayImage(StaticField.HOST + obj.getInfo().getImgBigSize(), iv);
            }

            @Override
            public void getError(String error) {
                Toast.makeText(ArrangementAddActivity.this, error, Toast.LENGTH_SHORT).show();
            }
        }, new UploadFileLaterModel(requestParams));
    }

    /**
     * 调用相机拍完照返回上传图片
     * @param requestCode
     * @param resultCode
     * @param data
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == Activity.RESULT_OK) {
            firstUpload();
        }
    }
}
