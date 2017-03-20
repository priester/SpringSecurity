package com.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestContrller {

	@RequestMapping("test")
	public String test () {
		return "test";
	}
}
