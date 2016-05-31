package com.bcdbook.util.settime;

import javax.annotation.Resource;
import javax.servlet.ServletContext;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.bcdbook.wechat.service.ConnectService;
import com.bcdbook.wechat.service.impl.ConnectServiceImpl;

/**
 * 
 * @Title: WechatSettime.java
 * @Description: 微信相关的定时器的处理
 * @author lason
 * @created 2016年5月30日 下午9:08:01
 */
public class WechatSettime {
//	@Resource
//	private ConnectService connectService;

	/**
	 * 更新accessToken的方法,把最新的accessToken更新到数据库
	 * 
	 * @Discription TODO
	 * @author lason
	 * @created 2016年5月30日 下午9:26:52
	 */
	public void refreshAccessToken() {
		// ConnectService connectService = new ConnectServiceImpl();
		ConnectServiceImpl connectService = (ConnectServiceImpl) getBean("connectService");
		connectService.updateAccessToken(1);
//		System.out.println("执行了updateAccessToken========================================");
	}

	public static ConnectService getBean(String name) {
		WebApplicationContext webApp = ContextLoader.getCurrentWebApplicationContext();
		ServletContext servletContext = webApp.getServletContext();
		ApplicationContext app = WebApplicationContextUtils.getWebApplicationContext(servletContext);
		
		return (ConnectService) app.getBean(name);
	}

}