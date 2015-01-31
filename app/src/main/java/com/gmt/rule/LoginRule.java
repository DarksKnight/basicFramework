package com.gmt.rule;

import com.gmt.entity.login.LoginEntity;
import com.gmt.util.DealProxy;

/**
 * Created by apple on 1/25/15.
 */
public class LoginRule extends CommonRule<LoginEntity>{

    @Override
    public CommonRule dealEntity(LoginEntity entity) {
        if(entity.getStatus().equals("0")){
            entity.getInfo().setUserID("100");
        }
        observe.onSuccess(entity);
        return super.dealEntity(entity);
    }

    @Override
    public CommonRule setDealObserve(DealProxy.DealObserve observe) {
        return super.setDealObserve(observe);
    }
}
