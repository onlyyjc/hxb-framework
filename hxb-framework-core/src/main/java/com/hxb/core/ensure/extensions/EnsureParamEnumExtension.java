package com.hxb.core.ensure.extensions;


import com.hxb.core.ensure.EnsureParam;
import com.hxb.core.exceptions.HxbExceptionFactory;

/**
 * Created by yangjiachang on 2017/12/25.
 */
public class EnsureParamEnumExtension extends EnsureParam<Enum> {
    private Enum anEnum;

    public EnsureParamEnumExtension(Enum anEnum) {
        super(anEnum);
        this.anEnum = anEnum;
    }

    /**
     * Enum 相等
     * @param comparedEnum
     * @param errorCode
     * @return
     */
    public EnsureParamEnumExtension isEqual(Enum comparedEnum, String errorCode) {
        if (anEnum != comparedEnum) {
            throw HxbExceptionFactory.create(errorCode);
        }
        return this;
    }

    /**
     * Enum 不相等
     * @param comparedEnum
     * @param errorCode
     * @return
     */
    public EnsureParamEnumExtension isNotEqual(Enum comparedEnum, String errorCode){
        if(anEnum == comparedEnum){
            throw HxbExceptionFactory.create(errorCode);
        }
        return this;
    }

    public EnsureParamEnumExtension isNotNull(String errorCode) {
        if (anEnum == null) {
            throw HxbExceptionFactory.create(errorCode);
        }
        return this;
    }
}
