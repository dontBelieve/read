package org.dpl.dao.redis;

import redis.clients.jedis.Jedis;

public class TestConnect {
	public static void main(String[] args) {
		TestConnect tc = new TestConnect();
		tc.strTest();
	}

	public void conn() {
		// 连接本地的 Redis 服务
		Jedis jedis = new Jedis("localhost");
		System.out.println("连接成功");
		// 查看服务是否运行
		System.out.println("服务正在运行: " + jedis.ping());
	}

	public void strTest() {
		// 连接本地的 Redis 服务
		Jedis jedis = new Jedis("localhost");
		System.out.println("连接成功");
		// 设置 redis 字符串数据
		jedis.set("runoobkey", "www.runoob.com");
		// 获取存储的数据并输出
		System.out.println("redis 存储的字符串为: " + jedis.get("runoobkey"));
	}
}
