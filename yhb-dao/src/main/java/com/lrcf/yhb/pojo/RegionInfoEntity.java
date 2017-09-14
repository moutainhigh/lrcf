package com.lrcf.yhb.pojo;

/**
 * 
* @ClassName: RegionInfoEntity.java
* @Description: 具体城市信息
*
* @version: v1.0.0
* @author: wangxf
* @date: 2017年5月15日 下午3:12:28 
*
* Modification History:
* Date         Author          Version            Description
*---------------------------------------------------------*
* 2017年5月15日     wangxf           v1.0.0               修改原因
 */
public class RegionInfoEntity {

	/*
	 * 国家
	 */
	private String country;			// 名称
	private double country_id;		// id
	private int country_level;		// 等级
	private int country_state;		// 状态
	/*
	 * 省
	 */
	private String province;		// 名称
	private double province_id;		// id
	private int province_level;		// 等级
	private int province_state;		// 状态
	/*
	 * 市
	 */
	private String city;			// 名称
	private double city_id;			// id
	private int city_level;			// 等级
	private int city_state;			// 状态
	/*
	 * 区县、地级市
	 */
	private String county;			// 名称
	private double county_id;		// id
	private int county_level;		// 等级
	private int county_state;		// 状态
	
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public double getCountry_id() {
		return country_id;
	}
	public void setCountry_id(double country_id) {
		this.country_id = country_id;
	}
	public int getCountry_level() {
		return country_level;
	}
	public void setCountry_level(int country_level) {
		this.country_level = country_level;
	}
	public int getCountry_state() {
		return country_state;
	}
	public void setCountry_state(int country_state) {
		this.country_state = country_state;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public double getProvince_id() {
		return province_id;
	}
	public void setProvince_id(double province_id) {
		this.province_id = province_id;
	}
	public int getProvince_level() {
		return province_level;
	}
	public void setProvince_level(int province_level) {
		this.province_level = province_level;
	}
	public int getProvince_state() {
		return province_state;
	}
	public void setProvince_state(int province_state) {
		this.province_state = province_state;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public double getCity_id() {
		return city_id;
	}
	public void setCity_id(double city_id) {
		this.city_id = city_id;
	}
	public int getCity_level() {
		return city_level;
	}
	public void setCity_level(int city_level) {
		this.city_level = city_level;
	}
	public int getCity_state() {
		return city_state;
	}
	public void setCity_state(int city_state) {
		this.city_state = city_state;
	}
	public String getCounty() {
		return county;
	}
	public void setCounty(String county) {
		this.county = county;
	}
	public double getCounty_id() {
		return county_id;
	}
	public void setCounty_id(double county_id) {
		this.county_id = county_id;
	}
	public int getCounty_level() {
		return county_level;
	}
	public void setCounty_level(int county_level) {
		this.county_level = county_level;
	}
	public int getCounty_state() {
		return county_state;
	}
	public void setCounty_state(int county_state) {
		this.county_state = county_state;
	}
	@Override
	public String toString() {
		return "RegionInfoEntity [country=" + country + ", country_id=" + country_id + ", country_level="
				+ country_level + ", country_state=" + country_state + ", province=" + province + ", province_id="
				+ province_id + ", province_level=" + province_level + ", province_state=" + province_state + ", city="
				+ city + ", city_id=" + city_id + ", city_level=" + city_level + ", city_state=" + city_state
				+ ", county=" + county + ", county_id=" + county_id + ", county_level=" + county_level
				+ ", county_state=" + county_state + "]";
	}
	
}
