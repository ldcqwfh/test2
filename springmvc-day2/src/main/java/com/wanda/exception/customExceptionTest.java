package com.wanda.exception;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class customExceptionTest {
	@RequestMapping("/exception")
	public  String test() throws CustomException {
		try {
			int i = 1/0; 
		} catch (Exception e) {
			throw new CustomException("这是我往自定义异常处理器中想传的参数");
		}
		return "error";
	}
}
