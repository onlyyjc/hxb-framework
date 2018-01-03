package com.hxb.core.ensure.extensions;

import com.hxb.core.ensure.EnsureParam;
import com.hxb.core.exceptions.HxbExceptionFactory;

/**
 * Created by yangjiachang on 2017/12/25.
 */
public class EnsureParamBooleanExtension extends EnsureParam<Boolean> {
    private Boolean condition;

    public EnsureParamBooleanExtension(Boolean condition) {
        super(condition);
        this.condition = condition;
    }

    public EnsureParamBooleanExtension isFalse(String errorCode){
        if(condition){
            throw HxbExceptionFactory.create(errorCode);
        }
        return this;
    }

    public EnsureParamBooleanExtension isTrue(String errorCode){
        if(!condition){
            throw HxbExceptionFactory.create(errorCode);
        }
        return this;
    }
}
