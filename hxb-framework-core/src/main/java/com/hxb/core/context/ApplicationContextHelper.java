package com.hxb.core.context;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * Created by yangjiachang on 2017/12/25.
 */
public class ApplicationContextHelper implements ApplicationContextAware {
    private static ApplicationContext context;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext){
        context = applicationContext;
    }

    public static ApplicationContext getContext(){
        return context;
    }

}
