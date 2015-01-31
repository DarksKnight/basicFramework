package com.gmt.rule;

import com.gmt.util.DealProxy;

/**
 * Created by apple on 1/25/15.
 */
public abstract class CommonRule<T> {

    DealProxy.DealObserve observe;

    public CommonRule dealEntity(T entity){
        return this;
    }

    public CommonRule setDealObserve(DealProxy.DealObserve observe){
        this.observe=observe;
        return this;
    }
}
