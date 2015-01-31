package com.gmt.entity;

/**
 * Created by apple on 1/25/15.
 */
public class BaseEntity {
    private String errMeg;
    private String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getErrMeg() {
        return errMeg;
    }

    public void setErrMeg(String errMeg) {
        this.errMeg = errMeg;
    }
}
