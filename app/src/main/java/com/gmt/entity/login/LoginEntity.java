package com.gmt.entity.login;

import com.gmt.entity.BaseEntity;

/**
 * Created by apple on 1/25/15.
 */
public class LoginEntity extends BaseEntity {

    private UserEntity info;

    public UserEntity getInfo() {
        return info;
    }

    public void setInfo(UserEntity info) {
        this.info = info;
    }
}
