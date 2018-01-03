package com.hxb.core.ensure.extensions;


import com.hxb.core.exceptions.HxbExceptionFactory;

import java.util.Collection;

/**
 * Created by yangjiachang on 2017/12/25.
 */
public class EnsureParamCollectionExtension extends EnsureParamObjectExtension {

    private Collection collection;
    public EnsureParamCollectionExtension(Collection collection) {
        super(collection);
        this.collection =collection;
    }

    public EnsureParamCollectionExtension isNotEmpty(String errorCode){
        if(collection != null && collection.size() > 0){
            return this;
        } else {
            throw HxbExceptionFactory.create(errorCode);
        }
    }

    public EnsureParamCollectionExtension isNotNull(String errorCode) {
        if(collection == null){
            throw HxbExceptionFactory.create(errorCode);
        }
        return this;
    }

    public EnsureParamCollectionExtension isEqualTo(Collection obj, String errorCode) {
        if (!(collection == null ? obj == null : collection.equals(obj))) {
            throw HxbExceptionFactory.create(errorCode);
        }
        return this;
    }

    public EnsureParamCollectionExtension isNotEqualTo(Collection obj, String errorCode) {
        if (collection == null ? obj == null : collection.equals(obj)) {
            throw HxbExceptionFactory.create(errorCode);
        }
        return this;
    }
}
