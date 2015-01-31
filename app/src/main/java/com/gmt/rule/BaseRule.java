package com.gmt.rule;

import com.gmt.entity.BaseEntity;
import com.gmt.util.DealProxy;

/**
 * Created by apple on 1/25/15.
 */
public class BaseRule extends CommonRule<BaseEntity> {

    //单例模式
    private static class SingletonHolder {
        private static final BaseRule INSTANCE = new BaseRule();
    }

    public static final BaseRule getInstance() {
        return SingletonHolder.INSTANCE;
    }

    @Override
    public CommonRule dealEntity(BaseEntity entity) {
        if(!entity.getStatus().equals("0")){
            observe.onFail(entity.getErrMeg());
        }else{
            observe.onSuccess(entity);
        }
        return super.dealEntity(entity);
    }

    @Override
    public CommonRule setDealObserve(DealProxy.DealObserve observe) {
        this.observe=observe;
        return super.setDealObserve(observe);
    }
}
