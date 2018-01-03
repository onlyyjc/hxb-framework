package com.hxb.core.exceptions;

import com.alibaba.dubbo.rpc.RpcException;

/**
 * Created by yangjiachang on 2017/12/25.
 */
public class HxbRuntimeException extends RpcException {

    public HxbRuntimeException() {
    }

    public HxbRuntimeException(String message, Throwable cause) {

        super(message, cause);
    }
}
