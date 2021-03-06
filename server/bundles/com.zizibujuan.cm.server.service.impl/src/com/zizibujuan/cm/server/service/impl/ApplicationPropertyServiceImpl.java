package com.zizibujuan.cm.server.service.impl;

import java.util.Map;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.zizibujuan.cm.server.dao.ApplicationPropertyDao;
import com.zizibujuan.cm.server.service.ApplicationPropertyService;

/**
 * 系统属性服务实现类
 * 
 * @author jinzw
 * @since 0.0.1
 */
public class ApplicationPropertyServiceImpl implements
		ApplicationPropertyService {
	private static final Logger logger = LoggerFactory.getLogger(ApplicationPropertyServiceImpl.class);
	private ApplicationPropertyDao applicationPropertyDao;
	
	@Override
	public Long getNextLong(String propertyName){
		Long id = applicationPropertyDao.getLong(propertyName);
		id++;
		applicationPropertyDao.putLong(propertyName, id);
		return id;
	}
	
	@Override
	public String getForString(String propertyName) {
		return applicationPropertyDao.getForString(propertyName);
	}
	
	@Override
	public int getForInt(String propertyName) {
		return applicationPropertyDao.getInt(propertyName);
	}
	
	@Override
	public String getCityCodeByValue(String cityName) {
		return applicationPropertyDao.getCityCodeByValue(cityName);
	}
	
	@Override
	public Map<String, Object> getCity(String cityCode) {
		return applicationPropertyDao.getCity(cityCode);
	}
	
	@Override
	public Properties getProperties(String groupKey) {
		return applicationPropertyDao.getProperties(groupKey);
	}
	
	public void setApplicationPropertyDao(ApplicationPropertyDao applicationPropertyDao) {
		logger.info("注入ApplicationPropertyDao");
		this.applicationPropertyDao = applicationPropertyDao;
	}

	public void unsetApplicationPropertyDao(ApplicationPropertyDao applicationPropertyDao) {
		if (this.applicationPropertyDao == applicationPropertyDao) {
			logger.info("注销ApplicationPropertyDao");
			this.applicationPropertyDao = null;
		}
	}

}
