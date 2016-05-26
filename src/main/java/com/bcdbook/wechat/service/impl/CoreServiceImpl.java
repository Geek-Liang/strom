package com.bcdbook.wechat.service.impl;

import java.io.IOException;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.dom4j.DocumentException;
import org.springframework.stereotype.Service;

import com.bcdbook.enums.WechatEnum.MsgType;
import com.bcdbook.wechat.pojo.resp.TextMessage;
import com.bcdbook.wechat.service.CoreService;
import com.bcdbook.wechat.util.WechatUtil;

/**
 * 
 * @Title: CoreService.java
 * @Description: 处理微信消息的核心业务类
 * @author lason
 * @created 2016年5月24日 下午10:11:28
 */
@Service("coreService")
public class CoreServiceImpl implements CoreService {

	/**
	 * 
	 * @Discription 解析客户发送过来的消息
	 * @author lason
	 * @created 2016年5月24日 下午10:12:24
	 * @param request
	 * @return
	 */
	@Override
	public String processRequest(HttpServletRequest request) {
		String respMsg = null;
		Map<String, String> msg = null;// 定义一个map对象,用来存放解析后的消息
		try {
			// 通过解析的工具类,解析用户发送的消息,得到解析后的map对象
			msg = WechatUtil.parseXml(request);

			String msgType = msg.get("MsgType");// 获取消息的类型
//			System.out.println("数据类型:"+msg.get("MsgType"));
//			System.out.println("数据值:"+msg.get("Content"));

			switch (msgType) {
			case "text":
				respMsg = processTextMsg(msg);
				break;
			case "image":
				respMsg = processImageMsg(msg);
				break;
			case "voice":
				respMsg = processVoiceMsg(msg);
				break;
			case "video":
				respMsg = processVideoMsg(msg);
				break;
			case "shortvideo":
				respMsg = processShortvideoMsg(msg);
				break;
			case "location":
				respMsg = processLocationMsg(msg);
				break;
			case "link":
				respMsg = processLinkMsg(msg);
				break;
			default:
				respMsg = processUnknowMsg(msg);
				break;
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		return respMsg;
	}

	@Override
	public String processTextMsg(Map<String, String> msg) {
		System.out.println("接收到文本消息");
		
		/**
		 * 用来返回的xml格式的字符串
		 */
		String respXML = null;
		// 获取客户发送过来的文本消息
		String content = msg.get("Content");

		
		/*
		 * 以下是用来测试回复消息的方法,真实项目会连接数据库查询对应的返回数据
		 */
		String respContent = null;
		switch (content) {
		case "1":
			respContent = "您输入的是1";
			break;
		case "2":
			respContent = "别开玩笑,我不2";
			break;
		case "你好":
			respContent = "你好,祝你有快乐的一天";
			break;
		case "呵呵":
			respContent = "不要说脏话好不好";
			break;
		case "早":
			respContent = "早上好,祝您一天好心情";
			break;
		case "测试":
			respContent = "不要再试我了,我运行是正常的";
			break;
		case "test":
			respContent = "不要再测试我了,英文我也认识";
			break;

		default:
			respContent = "我不知道您是什么意思";
			break;
		}

		respXML = this.encapsulationTextMsg(msg, respContent);
		System.out.println("回复的文本消息");
		System.out.println(respXML);
		return respXML;
	}

	@Override
	public String processImageMsg(Map<String, String> msg) {
		System.out.println("接收到图片消息");
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String processVoiceMsg(Map<String, String> msg) {
		System.out.println("接收到语音消息");
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String processVideoMsg(Map<String, String> msg) {
		System.out.println("接收到视频消息");
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String processShortvideoMsg(Map<String, String> msg) {
		System.out.println("接收到短视频消息");
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String processLocationMsg(Map<String, String> msg) {
		System.out.println("接收到地址消息");
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String processLinkMsg(Map<String, String> msg) {
		System.out.println("接收到连接消息");
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String processUnknowMsg(Map<String, String> msg) {
		System.out.println("接收到无法识别的消息");
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String encapsulationTextMsg(Map<String, String> reqMsg,
			String respContent) {
		String encapsulationXML = null;
		
		TextMessage textMessage = new TextMessage();
		
		// 发送方帐号（open_id）
		String fromUserName = reqMsg.get("FromUserName");
		// 公众帐号
		String toUserName = reqMsg.get("ToUserName");
		// 消息类型
		String msgType = MsgType.RESP_MESSAGE_TYPE_TEXT.getValue();
		
		textMessage.setToUserName(fromUserName);//设置接收者(客户端用户)
		textMessage.setFromUserName(toUserName);//设置发送者(微信公众平台)
		textMessage.setCreateTime(new Date().getTime());//long类型的时间戳
		textMessage.setMsgType(msgType);//数据类型
		textMessage.setFuncFlag(0);//标记成未读
		textMessage.setContent(respContent);//要回复的消息
		
		encapsulationXML = WechatUtil.textMessageToXml(textMessage);
		return encapsulationXML;
	}
}
