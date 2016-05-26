package com.bcdbook.wechat.service;

import javax.servlet.http.HttpServletRequest;

/**
 * 
 * @Title: ConnectService.java
 * @Description: 用于微信连接和一些基础操作的接口
 * @author lason
 * @created 2016年5月25日 下午12:38:50
 */
public interface ConnectService {
	/**
	 * 
	 * @Discription 微信连接时用于验证
	 * @author lason
	 * @created 2016年5月25日 下午12:39:29
	 * @param request
	 * @return
	 */
	public Boolean safeuuid(HttpServletRequest request);

	/**
	 * 
	 * @Discription 获取AccessToken
	 * @author lason
	 * @created 2016年5月25日 下午12:40:00
	 * @return
	 */
	public String getAccessToken();

	/**
	 * 
	 * @Discription 创建微信下方的菜单
	 * @author lason
	 * @created 2016年5月25日 下午12:40:17
	 * @return
	 */
	public Boolean createMenu();
	
	public String getCode();
}
