package com.bcdbook.wechat.service.impl;

import java.io.IOException;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bcdbook.wechat.service.ConnectService;
import com.bcdbook.wechat.service.MaterialService;
import com.bcdbook.wechat.util.WechatRequest;

/**
 * 
     * @Title: MaterialServiceImpl.java    
     * @Description: 素材管理的实现类
     * @author lason       
     * @created 2016年5月30日 上午10:21:45
 */
@Service("materialService")
public class MaterialServiceImpl implements MaterialService {
	@Resource
	private ConnectService connectService;
	
	@Override
	public String countMaterials() {
		//获取ACCESS_TOKEN
		String ACCESS_TOKEN = connectService.getAccessToken();
		//定义请求的url
		String url = "https://api.weixin.qq.com/cgi-bin/material/get_materialcount?access_token="+ACCESS_TOKEN;
		//定义返回的数据字符串
		String countMsg = null;
		try {
			//调用wechatGet,执行微信端的调用
			countMsg = WechatRequest.wechatGet(url);
		} catch (IOException e) {
			e.printStackTrace();
		}
		//返回获取到的数据
		return countMsg;
	}
	
	/**
	 * 
	    * @Discription 获取素材列表
	    * @author lason       
	    * @created 2016年5月30日 上午10:22:25      
	    * @return     
	    * @see com.bcdbook.wechat.service.MaterialService#listMaterial()
	 */
	@Override
	public String listMaterial(String materialType,int offset,int count) {
		String ACCESS_TOKEN = connectService.getAccessToken();
		//定义请求的url
		String url = "https://api.weixin.qq.com/cgi-bin/material/batchget_material?access_token="+ACCESS_TOKEN;
		String postValue = "{\"type\":\""+materialType+"\",\"offset\":"+offset+",\"count\":"+count+"}";
		
//		JSONObject tokenJson = null;
		//定义获取返回值的字符串
		String tokenBack = null;
		try {
			//调用微信接口,获取数据列表(json格式的素材数据)
			tokenBack = WechatRequest.wechatPost(url, postValue);
			return tokenBack;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return tokenBack;
	}
	
	/**
	 * 
	    * @Discription 根据传入的素材id获取对应的素材
	    * @author lason       
	    * @created 2016年5月31日 下午1:44:54      
	    * @param mediaId
	    * @return     
	    * @see com.bcdbook.wechat.service.MaterialService#getMaterial(java.lang.String)
	 */
	@Override
	public String getMaterial(String mediaId) {
		//获取accessToken
		String ACCESS_TOKEN = connectService.getAccessToken();
		//定义请求的url
		String url = "https://api.weixin.qq.com/cgi-bin/material/get_material?access_token="+ACCESS_TOKEN;
//		定义要传到后台的微信需要的的数据(素材的id)
		String postValue = "{\"media_id\":\""+mediaId+"\"}";
		
		//定义用来解析返回的json格式的数据
		String tokenBack = null;
		try {
			//根据url和postValue从微信获取素材对象
			tokenBack = WechatRequest.wechatPost(url, postValue);
//			return tokenBack;
//			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		//返回获取到的json格式的素材字符串
		return tokenBack;
	}

}
