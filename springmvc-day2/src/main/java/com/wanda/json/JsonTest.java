package com.wanda.json;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wanda.entity.User;

@Controller
public class JsonTest {
	@RequestMapping("/jsonTest")
	public @ResponseBody User jsonTest(@RequestBody User user) {
		System.out.println(user);
		return user;
	}
}
