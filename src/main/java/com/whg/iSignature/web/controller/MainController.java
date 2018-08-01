package com.whg.iSignature.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.whg.iSignature.bo.User;

@Controller
@ResponseBody
@RequestMapping("/")
public class MainController {

	@RequestMapping(value="/register")
	public User register(@RequestBody User user){
		return user;
	}
	
	@RequestMapping(value="/uploadSign", method=RequestMethod.POST)
	public String uploadSign(@RequestParam String sign){
		System.out.println(sign.length());
		System.err.println(sign);
		System.out.println(sign.trim().length());
		return sign;
	}
	
}
