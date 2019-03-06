package org.dpl.user.controller;

import javax.servlet.jsp.tagext.PageData;

import org.dpl.base.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/userc")
public class UserController extends BaseController {

	@RequestMapping("/test")
	public void test() {
		logger.info("Going to test");
		PageData pd = getPageData();
		baseservice.hello();
		System.out.println("aaa");
		logger.info("Exiting the test");
	}
}
