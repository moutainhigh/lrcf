package com.lrcf.yhb.common.config;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;

/**
 * entity 父类
 * @author liutq
 *
 */
@SuppressWarnings("serial")
public class BaseEntity implements Serializable{

	public String toString(){	
		return ToStringBuilder.reflectionToString(this,
						ToStringStyle.SHORT_PREFIX_STYLE);
	}
}
