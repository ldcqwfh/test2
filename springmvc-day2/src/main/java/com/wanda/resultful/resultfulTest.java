package com.wanda.resultful;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class resultfulTest {
	@RequestMapping(value="/resultfulTest/{id}",method=RequestMethod.DELETE) 
	public String test1(@PathVariable(value="id") String id) {
		System.out.println("这是删除方法"+id);
		return "redirect:success.jsp";
	}
	
	
	@RequestMapping(value="/resultfulTest/{id}",method=RequestMethod.GET)
	public String test2(@PathVariable String id) {
		System.out.println("这是添加方法"+id);
		return "forward:/WEB-INF/pages/success.jsp";
	}
}
