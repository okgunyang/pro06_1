package com.shop2.myapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/mobile/")
public class MobileController {

	@GetMapping("test1.do")
	public String test1() {
		return "mobile/test1";
	}
	
}
