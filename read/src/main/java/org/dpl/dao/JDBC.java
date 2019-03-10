package org.dpl.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBC {
	public void test() throws ClassNotFoundException, SQLException {
		//加载MySql驱动
		Class.forName("com.mysql.cj.jdbc.Driver");
		 Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/read?useUnicode=true&characterEncoding=UTF-8&serverTimezone=UTC", "root", "root");
		//3.操作数据库，实现增删改查
        Statement stmt = conn.createStatement();
        boolean rs = stmt.execute("INSERT INTO `user`(username, mobile) VALUES ('张三', '18868813870');");
        //如果有数据，rs.next()返回true
//        while(rs.next()){
//            System.out.println(rs.getString("user_name")+" 年龄："+rs.getInt("age"));
//        }
	}
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		JDBC jdbc = new JDBC();
		jdbc.test();
	}
}
