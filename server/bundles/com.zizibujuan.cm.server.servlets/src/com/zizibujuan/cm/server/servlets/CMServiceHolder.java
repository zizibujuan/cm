package com.zizibujuan.cm.server.servlets;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.zizibujuan.cm.server.service.ApplicationPropertyService;


public class CMServiceHolder {
	private static final Logger logger = LoggerFactory
			.getLogger(CMServiceHolder.class);

	private static CMServiceHolder singleton;

	public static CMServiceHolder getDefault() {
		return singleton;
	}

	public void activate() {
		singleton = this;
	}

	public void deactivate() {
		singleton = null;
	}
	
	// 经测试，这里注入的applicationPropertyService与Activator中的applicationPropertyService是同一个对象实例
	private ApplicationPropertyService applicationPropertyService;
	public ApplicationPropertyService getApplicationPropertyService() {
		return applicationPropertyService;
	}
	public void setApplicationPropertyService(ApplicationPropertyService applicationPropertyService) {
		logger.info("注入ApplicationPropertyService");
		logger.info("applicationPropertyService In ServiceHolder:"+applicationPropertyService);
		this.applicationPropertyService = applicationPropertyService;
	}

	public void unsetApplicationPropertyService(ApplicationPropertyService applicationPropertyService) {
		logger.info("注销ApplicationPropertyService");
		if (this.applicationPropertyService == applicationPropertyService) {
			this.applicationPropertyService = null;
		}
	}
}
