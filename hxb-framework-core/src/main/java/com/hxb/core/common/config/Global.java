/**
 *Copyright 2014-2017 www.hanxinbank.com  All rights reserved.
 */
package com.hxb.core.common.config;

import com.google.common.collect.Maps;
import com.hxb.core.common.utils.FileUtils;
import com.hxb.core.common.utils.PropertiesLoader;
import com.hxb.core.common.utils.StringUtils;
import com.hxb.core.context.ApplicationContextHelper;
import com.hxb.core.context.HxbPreferencesPlaceholderConfigurer;
import com.hxb.core.context.SpringContextHolder;
import org.springframework.beans.factory.config.PreferencesPlaceholderConfigurer;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PropertiesLoaderUtils;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Properties;

/**
 * 全局配置类
 * @author Mark
 * @version 2014-06-25
 */
public class Global {

	/**
	 * 当前对象实例
	 */
	private static Global global = new Global();

	private static HxbPreferencesPlaceholderConfigurer placeholder =
			SpringContextHolder.getBean(HxbPreferencesPlaceholderConfigurer.class);

	/**
	 * 保存全局属性值
	 */
	private static Map<String, String> map = Maps.newHashMap();

	/**
	 * 属性文件加载对象
	 */
	private static PropertiesLoader loader = new PropertiesLoader("config.properties");

	/**
	 * 获取当前对象实例
	 */
	public static Global getInstance() {
		return global;
	}

	/**
	 * 获取配置
	 */
	public static String getConfig(String key) {
		String value = map.get(key);
		if (value == null){
			Properties properties = new Properties();
			Resource[] Resource = placeholder.getLocations();
			if (Resource != null && Resource.length > 0){
				for (Resource r : Resource){
					try {
						properties.putAll(PropertiesLoaderUtils.loadProperties(r));
					} catch (IOException e) {
						e.printStackTrace();
					}

				}
			}
			value = properties.getProperty(key);
			map.put(key, value != null ? value : StringUtils.EMPTY);
		}
		return value;
	}

	/**
	 * 获取URL后缀
	 */
	public static String getUrlSuffix() {
		return getConfig("urlSuffix");
	}

	/**
	 * 是/否
	 */
	public static final String YES = "1";
	public static final String NO = "0";

	/**
	 * 对/错
	 */
	public static final String TRUE = "true";
	public static final String FALSE = "false";

	
}
