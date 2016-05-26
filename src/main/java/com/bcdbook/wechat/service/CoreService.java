package com.bcdbook.wechat.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

/**
 * 
 * @Title: CoreService.java
 * @Description: 处理用户消息的核心方法类
 * @author lason
 * @created 2016年5月25日 下午1:21:37
 */
public interface CoreService {
	/**
	 * 
	 * @Discription 解析用户发来的所有请求
	 * @author lason
	 * @created 2016年5月25日 下午1:22:13
	 * @param request
	 * @return
	 */
	public String processRequest(HttpServletRequest request);

	/**
	 * 
	 * @Discription 处理文本消息的方法
	 * @author lason
	 * @created 2016年5月25日 下午1:23:25
	 * @param msg
	 * @return
	 */
	public String processTextMsg(Map<String, String> msg);

	/**
	 * 
	 * @Discription 处理图片消息
	 * @author lason
	 * @created 2016年5月25日 下午1:27:04
	 * @param msg
	 * @return
	 */
	public String processImageMsg(Map<String, String> msg);

	/**
	 * 
	 * @Discription 处理语音消息
	 * @author lason
	 * @created 2016年5月25日 下午1:27:16
	 * @param msg
	 * @return
	 */
	public String processVoiceMsg(Map<String, String> msg);

	/**
	 * 
	 * @Discription 处理视频消息
	 * @author lason
	 * @created 2016年5月25日 下午1:27:38
	 * @param msg
	 * @return
	 */
	public String processVideoMsg(Map<String, String> msg);

	/**
	 * 
	 * @Discription 处理短视频消息
	 * @author lason
	 * @created 2016年5月25日 下午1:27:47
	 * @param msg
	 * @return
	 */
	public String processShortvideoMsg(Map<String, String> msg);

	/**
	 * 
	 * @Discription 处理地里位置消息
	 * @author lason
	 * @created 2016年5月25日 下午1:29:16
	 * @param msg
	 * @return
	 */
	public String processLocationMsg(Map<String, String> msg);

	/**
	 * 
	 * @Discription 处理连接消息
	 * @author lason
	 * @created 2016年5月25日 下午1:28:01
	 * @param msg
	 * @return
	 */
	public String processLinkMsg(Map<String, String> msg);

	/**
	 * 
	 * @Discription 处理不能识别类型的消息
	 * @author lason
	 * @created 2016年5月25日 下午1:30:26
	 * @param msg
	 * @return
	 */
	public String processUnknowMsg(Map<String, String> msg);

	/**
	 * 
	 * @Discription 封装文本类型的返回值
	 * @author lason
	 * @created 2016年5月25日 下午2:16:56
	 * @param reqMsg
	 * @param respContent
	 * @return
	 */
	public String encapsulationTextMsg(Map<String, String> reqMsg,
			String respContent);
}
