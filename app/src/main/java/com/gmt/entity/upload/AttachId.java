package com.gmt.entity.upload;

import com.gmt.entity.BaseEntity;

/**
 * Created by apple on 1/25/15.
 */
public class AttachId extends BaseEntity {
    private AttachIdDetail info;

    public AttachIdDetail getInfo() {
        return info;
    }

    public void setInfo(AttachIdDetail info) {
        this.info = info;
    }
}
