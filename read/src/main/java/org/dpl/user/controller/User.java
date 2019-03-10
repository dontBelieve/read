package org.dpl.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//@Controller
//@RequestMapping("/user")
public class User {

	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public String hello(ModelMap model) {
		model.addAttribute("message", "Hello Spring MVC Framework!");
		System.out.println("hihi");
		return "hello";
	}
}
