package com.hxb.core.exceptions;


import com.hxb.core.context.ApplicationContextHelper;

/**
 * Created by yangjiachang on 2017/12/25.
 */
public class HxbExceptionFactory {

    private static ExceptionDefinitions exceptionDefinitions;

    public static HxbBusinessException create(String errorCode, String...args){
        String exceptionPattern = getExceptionDefinitions().getExceptionMessage(errorCode);

        if(args.length > 0){
            String errorMsg = String.format(exceptionPattern, args);
            return new HxbBusinessException(errorCode,errorMsg);
        }
        return new HxbBusinessException(errorCode,exceptionPattern);
    }

    private static ExceptionDefinitions getExceptionDefinitions(){
        if(exceptionDefinitions == null){
            exceptionDefinitions = ApplicationContextHelper.getContext().getBean(ExceptionDefinitions.class);
        }
        return exceptionDefinitions;
    }

    public static void main(String[] args) {
        test("1","rrs");
    }

    private static void test(Object...args){
        String errorMsg = String.format("%sdf%s", args);
        System.out.println(errorMsg);
    }
}
