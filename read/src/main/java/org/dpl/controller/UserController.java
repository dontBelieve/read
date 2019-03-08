package org.dpl.controller;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.dpl.pojo.User;

public class UserController {

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

	public static void main(String[] args) throws IOException {
		UserController uc = new UserController();
		uc.getUser();
	}
}
