package com.gmt.entity.upload;

import com.gmt.entity.BaseEntity;

/**
 * Created by apple on 1/25/15.
 */
public class UploadEntity extends BaseEntity {
    private UploadDetailEntity info;

    public UploadDetailEntity getInfo() {
        return info;
    }

    public void setInfo(UploadDetailEntity info) {
        this.info = info;
    }
}
