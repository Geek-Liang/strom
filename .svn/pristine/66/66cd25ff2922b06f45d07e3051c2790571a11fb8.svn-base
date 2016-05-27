package com.bcdbook.demos.interceptor;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.bcdbook.user.pojo.User;

@Controller
@RequestMapping("/test")
public class TestController {
	@RequestMapping("/test")
	public String getUser(HttpServletRequest request,Model model){
		
		return "test/test";
	}
	
	@RequestMapping("/testAjax")
	public String testAjaxJsp(HttpServletRequest request,Model model){
		return "test/testAjax";
	}
	
	@RequestMapping("/html")
	public void getHtml(HttpServletRequest request,HttpServletResponse response,Model model){
		try {
//			request.getRequestDispatcher("/WEB-INF/views/test/testhtml.html").forward(request, response);
			
			request.getRequestDispatcher("/static/testhtml.html").forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@RequestMapping("/ajax")
	public void getAjax(HttpServletRequest request,HttpServletResponse response,Model model){
		try {
//			request.getRequestDispatcher("/WEB-INF/views/test/testhtml.html").forward(request, response);
//			System.out.println(response.toString());
			request.getRequestDispatcher("/static/ajax.html").forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value="/ajaxData", method = RequestMethod.POST)
	@ResponseBody
	public String ajaxData(){
		User user = new User();
		user.setUserName("admin");
		user.setAge(2);
		user.setGender(0);
//		JSONObject jo = JSONObject.
		String jsonUser = JSON.toJSONString(user);
		JSONObject jo = JSON.parseObject(jsonUser);
		System.out.println(jo.getString("userName"));
//		System.out.println(jsonUser);
		return jsonUser;
	}
}
