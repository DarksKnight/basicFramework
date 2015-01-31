package com.gmt.entity.arrangementinfo;

import com.gmt.entity.BaseEntity;

/**
 * Created by apple on 1/25/15.
 */
public class ArrangementInfoEntity extends BaseEntity {
    private ArrangementInfoList info;

    public ArrangementInfoList getInfo() {
        return info;
    }

    public void setInfo(ArrangementInfoList info) {
        this.info = info;
    }
}
