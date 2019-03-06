package org.dpl.user.controller;

import javax.servlet.jsp.tagext.PageData;

import org.apache.log4j.Logger;
import org.dpl.base.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/userc")
public class UserController extends BaseController {
	static Logger log = Logger.getLogger(UserController.class.getName());
	
	@RequestMapping("/test")
	public void test() {
		log.info("Going to test");
		PageData pd = getPageData();
		baseservice.hello();
		System.out.println("userc.test");
		log.info("Exiting the test");
	}
}
