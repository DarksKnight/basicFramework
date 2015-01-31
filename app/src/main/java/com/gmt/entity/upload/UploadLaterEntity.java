package com.gmt.entity.upload;

import com.gmt.entity.BaseEntity;

/**
 * Created by apple on 1/25/15.
 */
public class UploadLaterEntity extends BaseEntity {
    private UploadLaterDetailEntity info;

    public UploadLaterDetailEntity getInfo() {
        return info;
    }

    public void setInfo(UploadLaterDetailEntity info) {
        this.info = info;
    }
}
