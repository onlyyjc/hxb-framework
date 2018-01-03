/**
 *Copyright 2014-2017 蜂鸟钱包 All rights reserved.
 */
package com.hxb.core.common.supcan.annotation.common.properties;

import java.lang.annotation.*;

/**
 * 硕正Background注解
 * @author WangZhen
 * @version 2013-11-12
 */
@Target({ ElementType.ANNOTATION_TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface SupBackground {
	
	/**
	 * 背景颜色
	 * @return
	 */
	String bgColor() default "";

}
