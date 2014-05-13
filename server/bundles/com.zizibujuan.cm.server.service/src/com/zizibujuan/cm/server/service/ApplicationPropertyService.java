package com.zizibujuan.cm.server.service;

import java.util.Map;
import java.util.Properties;

/**
 * 系统属性 服务接口
 * 
 * @author jinzw
 * @since 0.0.1
 */
public interface ApplicationPropertyService {
	
	/**
	 * 将对应的值加1，保存起来，并返回
	 * 
	 * @param propertyName 属性名
	 * @return 新的属性值
	 */
	Long getNextLong(String propertyName);
	
	/**
	 * 获取指定key对应的字符串值
	 * 
	 * @param propertyName 键
	 * @return 字符串类型的值
	 */
	String getForString(String propertyName);
	
	/**
	 * 获取指定key对应的int类型的值
	 * 
	 * @param propertyName 键
	 * @return int类型的值
	 */
	int getForInt(String propertyName);
	
	// TODO：增加一个分组参数

	/**
	 * 根据城市名称获取城市编码
	 * 
	 * @param cityName 城市名称
	 * @return 城市编码，如果找不到则返回null
	 */
	String getCityCodeByValue(String cityName);

	/**
	 * 获取城市名称
	 * @param cityCode 城市代码
	 * @return 城市名称，如果没有找到，则返回空的map对象
	 * <pre>
	 * map结构:
	 * 		country: 国家名称
	 * 		province：省份名称
	 * 		city：城市名称
	 * </pre>
	 */
	Map<String,Object> getCity(String cityCode);

	/**
	 * 获取一组属性
	 * @param groupKey
	 * @return 属性
	 */
	Properties getProperties(String groupKey);

}
