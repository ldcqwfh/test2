package com.wanda.annoation;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.HeaderParam;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.wanda.entity.User;

@Controller
@SessionAttributes(names="username")
public class annoationTest {
	@ModelAttribute
	public User init(String username) {
		User user = new User();
		user.setUsername(username);
		user.setAge(5555);
		return user;
	}
	@ModelAttribute
	public User init1(String username) {
		User user = new User();
		user.setUsername(username);
		user.setAge(1324);
		return user;
	}
	
  
	@RequestMapping("/annoationTest")
	public void jsonTest(User user,HttpServletRequest request ,HttpServletResponse response) throws Exception {
		System.out.println(user);
		request.getRequestDispatcher("WEB-INF/pages/success.jsp").forward(request, response);
//		response.sendRedirect("WEB-INF/pages/success.jsp");
	}
	
	
	@RequestMapping("/sessionTest")
	public String sessionTest(String username,Model model) {
		model.addAttribute("username", username);
		
		return "session";
	}
	
	@RequestMapping("/sessionTest2")
	public String sessionTest2(ModelMap modelmap) {
		System.out.println((String)modelmap.get("username"));
		return "session";
	}
	
	@RequestMapping("/sessionTest3")
	public String sessionTest3(SessionStatus ss) {
		ss.setComplete();
		return "session";
	}
	
	
	@RequestMapping("/headTest")
	public String headTest(@RequestHeader(required=true, value ="Accept-Language") String head) {
		System.out.println(head);
		return "success";
	}
	
	@RequestMapping("cookieTest")
	public String cookieTest(@CookieValue(value="JSESSIONID") String jessionid) {
		System.out.println(jessionid);
		return "success";
	}
}

