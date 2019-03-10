package org.dpl.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.dpl.base.BaseController;
import org.dpl.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserController extends BaseController {
	@Autowired
	User user;

	@RequestMapping("/user2")
	public String user2() {
		// ModelAndView mav = new ModelAndView("path:/jsp/user.jsp");
		// return mav;
		return "user";
	}

	@RequestMapping(value = "/user2/add", method = RequestMethod.POST)
	public String add(HttpServletRequest request) throws IOException {
		// 指定全局配置文件
		String resource = "conf/mybatis-config.xml";
		// 读取配置文件
		InputStream inputStream;
		inputStream = Resources.getResourceAsStream(resource);
		// 构建sqlSessionFactory
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		String username = request.getParameter("username");
		String mobile = request.getParameter("mobile");
		List<Object> list = new ArrayList<>();
		list.add(username);
		list.add(mobile);
		try (SqlSession sqlSession = sqlSessionFactory.openSession();) {
			int i = sqlSession.insert("addUser", list);
			System.out.println(i);
		}
		return "success";
	}

	@RequestMapping("/user2/get")
	public void getUser() throws IOException {
		// 指定全局配置文件
		String resource = "conf/mybatis-config.xml";
		// 读取配置文件
		InputStream inputStream = Resources.getResourceAsStream(resource);
		// 构建sqlSessionFactory
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		try (SqlSession sqlSession = sqlSessionFactory.openSession();) {
			User user = sqlSession.selectOne("selectUser", 1);
			System.out.println(user);
		}
	}

	public void add3() throws IOException {
		// 指定全局配置文件
		String resource = "conf/mybatis-config.xml";
		// 读取配置文件
		InputStream inputStream;
		inputStream = Resources.getResourceAsStream(resource);
		// 构建sqlSessionFactory
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		// User user = new User();
		// user.setUserName("小鹿");
		// user.setMobile("12345678");
		Map<Object, Object> map = new HashMap<>();
		map.put("username", "小狗");
		map.put("mobile", "1246789");
		try (SqlSession sqlSession = sqlSessionFactory.openSession();) {
			// int i = sqlSession.insert("addUser", user);
			int j = sqlSession.insert("addUser2");
			sqlSession.commit();
			System.out.println(j);
			User user = sqlSession.selectOne("selectUser", 1);
			System.out.println(user);
		}
	}

	public static void main(String[] args) throws IOException {
		UserController uc = new UserController();
		uc.add3();
	}
}
