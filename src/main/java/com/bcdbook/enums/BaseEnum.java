package com.bcdbook.enums;

public class BaseEnum {
	public enum BackMsg {
		// text,image,voice,video,shortvideo,location,link,news;
		SUCCESS("{\"coder\":0,\"msg\":\"success\"}", "Service层处理成功"), 
		ERROR("{\"coder\":1,\"msg\":\"error\"}", "Service层处理出错");

		private final String value;
		private final String name;

		// 构造器默认也只能是private, 从而保证构造函数只能在内部使用
		private BackMsg(String value, String name) {
			this.value = value;
			this.name = name;
		}

		public String getValue() {
			return value;
		}

		public String getName() {
			return name;
		}
	}
//
//	public enum ControllerMsg {
//		// text,image,voice,video,shortvideo,location,link,news;
//		SUCCESS("{\"coder\":0,\"msg\":\"success\"}", "Controller层处理成功"), 
//		ERROR("{\"coder\":1,\"msg\":\"error\"}", "Controller层处理出错");
//
//		private final String value;
//		private final String name;
//
//		// 构造器默认也只能是private, 从而保证构造函数只能在内部使用
//		private ControllerMsg(String value, String name) {
//			this.value = value;
//			this.name = name;
//		}
//
//		public String getValue() {
//			return value;
//		}
//
//		public String getName() {
//			return name;
//		}
//	}
}
