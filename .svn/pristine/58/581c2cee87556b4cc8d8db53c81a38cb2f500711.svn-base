package com.bcdbook.util.settime;

import javax.annotation.Resource;

import com.bcdbook.wechat.service.ConnectService;

/**
 * 
 * @Title: WechatSettime.java
 * @Description: 微信相关的定时器的处理
 * @author lason
 * @created 2016年5月30日 下午9:08:01
 */
public class WechatSettime {
	@Resource
	private ConnectService connectService;
	/**
	 * 更新accessToken的方法,把最新的accessToken更新到数据库
	 * 
	 * @Discription TODO
	 * @author lason
	 * @created 2016年5月30日 下午9:26:52
	 */
	public void updateAccessToken() {
		connectService.updateAccessToken(1);
		
//		System.out.println("执行了updateAccessToken");
	}

}
