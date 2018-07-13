package com.wanda.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;
@Controller
public class ExceptionResolver implements HandlerExceptionResolver {

	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception ex) {
		String message = null;
		if(ex instanceof CustomException) {
			message=ex.getMessage();
		}else {
			message="这是其他异常";
			ex.printStackTrace();
		}
		ModelAndView model = new ModelAndView();
		model.setViewName("error");
		model.addObject("message", message);
		return model;
	}

}
