package com.dss.ssm.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.dss.ssm.utils.Logger;

public class BaseController {

protected Logger logger = Logger.getLogger(this.getClass());
	
	/**得到request对象
	 * @return
	 */
	public HttpServletRequest getRequest() {
		HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
		return request;
	}
	
	public static void logBefore(Logger logger, String interfacecName){
		logger.info("");
		logger.info("start");
		logger.info(interfacecName);
	}
	
	public static void logAfter(Logger logger){
		logger.info("end");
		logger.info("");
	}
}
