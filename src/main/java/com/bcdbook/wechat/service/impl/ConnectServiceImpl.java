package com.bcdbook.wechat.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
//import javax.swing.text.StyledEditorKit.BoldAction;



import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.bcdbook.enums.WechatEnum.Wechat;
import com.bcdbook.wechat.service.ConnectService;
import com.bcdbook.wechat.util.WechatRequest;
import com.bcdbook.wechat.util.SHA1;
import com.bcdbook.wechat.util.WechatUtil;

/**
 * 
 * @Title: ConnectService.java
 * @Description: 微信初始验证相关的逻辑处理类
 * @author lason
 * @created 2016年5月24日 上午9:41:51
 */
@Service("connectService")
public class ConnectServiceImpl implements ConnectService {

	private static String Token = Wechat.TOKEN.getValue();// token
	String signature = null;// 微信发送的加密后的签名
	String timestamp = null;// 时间戳
	String nonce = null;// 随机数
	String echostr = null;// 随机字符串

	/**
	 * 
	 * @Discription 验证URL的真实性,真实返回true否则返回false
	 * @author lason
	 * @created 2016年5月24日 上午9:43:49
	 * @param request
	 * @return
	 */
	@Override
	public Boolean safeuuid(HttpServletRequest request) {
		signature = request.getParameter("signature");// 获取加密签名
		timestamp = request.getParameter("timestamp");// 获取时间戳
		nonce = request.getParameter("nonce");// 随机数
		echostr = request.getParameter("echostr");// 随机字符串

		// 以上所有值都不为空,才进入验证,否则没有验证的必要性,直接返回false
		if (signature != null && !signature.equals("") && timestamp != null
				&& !timestamp.equals("") && nonce != null && !nonce.equals("")
				&& echostr != null && !echostr.equals("")) {

			// 创建一个集合,用来存放和排序从端口获取的值
			List<String> params = new ArrayList<String>();
			params.add(Token);
			params.add(timestamp);
			params.add(nonce);

			// 1. 将token、timestamp、nonce三个参数进行字典序排序
			Collections.sort(params, new Comparator<String>() {
				@Override
				public int compare(String o1, String o2) {
					return o1.compareTo(o2);
				}
			});
			// 2. 将三个参数字符串拼接成一个字符串进行sha1加密
			String temp = SHA1.encode(params.get(0) + params.get(1)
					+ params.get(2));

			// 生成的加密值,和传入的加密值相同,返回true,否则返回false
			if (temp.equals(signature)) {
				return true;
			}
			return false;
		} else {
			return false;
		}
	}

	@Override
	public String getAccessToken() {
		//定义请求的url
		String url = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid="
				+ Wechat.APP_ID.getValue() + "&secret=" + Wechat.APP_SECRET.getValue();
		//定义用来返回的accessToken,
		String accessToken = null;
		try {
			String tokenBack = WechatRequest.wechatGet(url);
			if(tokenBack!=null){
				JSONObject tokenJson = JSON.parseObject(tokenBack);
				accessToken = tokenJson.getString("access_token");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return accessToken;
	}
	
	@Override
	public Boolean createMenu(){
		WechatUtil wechatUtil = new WechatUtil();
		
		//定义栏目的样式
		String menu = wechatUtil.getMenu();

        //此处改为自己想要的结构体，替换即可
		//- TODO
        String access_token = Wechat.ACCESS_TOKEN.getValue();
        String url = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token="+access_token;
        
        Boolean createOk = false;
        try {
			String backValue = WechatRequest.wechatPost(url, menu);
			if(backValue!=null){
				JSONObject backJson = JSON.parseObject(backValue);
				System.out.println(JSON.toJSONString(backJson));
				int errcode = backJson.getIntValue("errcode");
				if(errcode==0){
					createOk = true;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
        return createOk;
	}
	
	@Override
	public String getCode() {
		System.out.println("进入获取codeUrl的方法");
		//定义回调的连接地址
		String REDIRECT_URI = "https://strom.bcdbook.com/wechat/login";
		//定义获取code的url地址
		String url = "https://open.weixin.qq.com/connect/oauth2/authorize?appid="+Wechat.APP_ID.getValue()+"&redirect_uri="+REDIRECT_URI+"&response_type=code&scope=snsapi_userinfo&state=shouquan#wechat_redirect";
		return url;
	}
}
