package com.lrcf.yhb.common.util;

import java.util.Locale;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * Copyright: Copyright (c) 2017 LanRu-Caifu
 * 
 * @ClassName: SpringContextUtil.java
 * @Description: Spring 获取 bean工具类
 * @author:Krx
 * @date: 2017年4月8日 下午6:43:21
 */
@Component
public class SpringContextUtil implements ApplicationContextAware {
	private static ApplicationContext context = null;

	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.context = applicationContext;
	}

	public static <T> T getBean(String beanName) {
		return (T) context.getBean(beanName);
	}

	public static String getMessage(String key) {
		return context.getMessage(key, null, Locale.getDefault());
	}
}
