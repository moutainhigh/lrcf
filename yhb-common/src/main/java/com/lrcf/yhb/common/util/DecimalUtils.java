package com.lrcf.yhb.common.util;

import java.math.BigDecimal;
import java.text.DecimalFormat;

/**
 * 金额的转换工具类
 * @author 孔荣勋
 *
 */
public class DecimalUtils {

	private static DecimalFormat twoDecimalFormat=new DecimalFormat("0.00");
	private static DecimalFormat fourDecimalFormat=new DecimalFormat("0.0000");
	/**
	 * 保留2位小数
	 * @param money
	 * @return
	 */
	public static String getTwoDecimal(BigDecimal money){
		return twoDecimalFormat.format(money);
	}
	
	/**
	 * 保留四位小数
	 * @param money
	 * @return
	 */
	public static String getFourDecimal(BigDecimal money){
		return fourDecimalFormat.format(money);
	}
	
	/**
	 * 格式化加息劵利率
	 * @param money
	 * @return
	 */
	public static BigDecimal getRaiseDecimal(double raiseSize){
		return new BigDecimal(raiseSize).multiply(new BigDecimal(100)).setScale(2, BigDecimal.ROUND_HALF_UP);
	}

	
	/**
	 * 计算年化收益率
	 * @param dayRates
	 * @return
	 */
	public static BigDecimal getYearRates(BigDecimal dayRates){
		BigDecimal yearRates = dayRates.multiply(new BigDecimal(365)).setScale(4, BigDecimal.ROUND_HALF_UP).multiply(new BigDecimal(100));
		return yearRates;
	}
	
	public static void main(String[] args) {

	}
}
