package com.bcdbook.test.user;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.bcdbook.wechat.service.ConnectService;
import com.bcdbook.wechat.service.CoreService;
import com.bcdbook.wechat.service.EncapsulationService;
import com.bcdbook.wechat.service.EventService;
import com.bcdbook.wechat.service.MaterialService;
import com.bcdbook.wechat.service.MessageService;

//import com.bcdbook.wechat.service.impl.ConnectService;

@RunWith(SpringJUnit4ClassRunner.class)		//表示继承了SpringJUnit4ClassRunner类
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"})
public class TestWechat {
	
	private static Logger logger = Logger.getLogger(TestWechat.class);
	
	@Resource
	private ConnectService connectService = null;
	@Resource
	private CoreService coreService = null;
	@Resource
	private MessageService messageService = null;
	@Resource
	private EventService eventService = null;
	@Resource
	private EncapsulationService encapsulationService = null;
	@Resource
	private MaterialService materialService = null;
	
	@Test
	public void testGetAccessToken(){
		System.out.println(connectService.makeAccessToken());
	}
	
	@Test
	public void testCreateMenu(){
		System.out.println(connectService.createMenu());
	}
	
	@Test
	public void testEncapsulationTextMsg(){
//		
//		<ToUserName>gh_0e183f03e273<ToUserName/>
//		<FromUserName>o8yDuvoYJ-39Z1o9YRRjREfIfFL4<FromUserName/>
//		<CreateTime>1464159131<CreateTime/>
//		<MsgType>text<MsgType/>
//		<Content>1<Content/>
//		<MsgId>6288515584202222661<MsgId/>
//		
		Map<String, String> reqMsg = new HashMap<String, String>();
		reqMsg.put("ToUserName", "gh_0e183f03e273");
		reqMsg.put("FromUserName", "o8yDuvoYJ-39Z1o9YRRjREfIfFL4");
		reqMsg.put("CreateTime", "1464159131");
		reqMsg.put("MsgType", "text");
		reqMsg.put("Content", "1");
		reqMsg.put("MsgId", "6288515584202222661");
		String respContent = "测试";
		
		String respXML = encapsulationService.encapsulationTextMsg(reqMsg, respContent);
		System.out.println(respXML);
	}
	
	@Test
	public void testMaterialService(){
		materialService.listMaterial("voice");
//		materialService.getMaterial("mErowUdivp53pbwYC5N7cXSMwyjbxQlCSalIexy9-5E");
	}
	
	@Test
	public void testAddAccessToken(){
		connectService.addAccessToken();
	}
	
}
