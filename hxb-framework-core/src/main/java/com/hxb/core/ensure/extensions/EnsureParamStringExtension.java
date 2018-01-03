package com.hxb.core.ensure.extensions;


import com.hxb.core.common.utils.StringUtils;
import com.hxb.core.ensure.EnsureParam;
import com.hxb.core.exceptions.HxbExceptionFactory;

/**
 * Created by yangjiachang on 2017/12/25.
 */
public class EnsureParamStringExtension extends EnsureParam<Object> {
    private String string;

    public EnsureParamStringExtension(String string) {
        super(string);
        this.string = string;
    }

    public EnsureParamStringExtension isNotNull(String errorCode) {
        if (string == null) {
            throw HxbExceptionFactory.create(errorCode);
        }
        return this;
    }

    public EnsureParamStringExtension isNotEmpty(String errorCode) {
        if (StringUtils.isEmpty(string)) {
            throw HxbExceptionFactory.create(errorCode);
        }
        return this;
    }

    public EnsureParamStringExtension isNotBlank(String errorCode){
        if(StringUtils.isBlank(string)){
            throw HxbExceptionFactory.create(errorCode);
        }
        return this;
    }

    public EnsureParamStringExtension isEqualTo(String comparedString, String errorCode) {
        if (!StringUtils.equals(string, comparedString)) {
            throw HxbExceptionFactory.create(errorCode);
        }
        return this;
    }

    public EnsureParamStringExtension isNotEqualTo(String comparedString, String errorCode) {
        if (StringUtils.equals(string, comparedString)) {
            throw HxbExceptionFactory.create(errorCode);
        }
        return this;
    }

}
