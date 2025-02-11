package com.demo.test;

import org.demo.jedis.util.JedisConnectionFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import redis.clients.jedis.Jedis;

import java.util.Map;

public class JedisPoolTest {
    private Jedis jedis;

    @BeforeEach
    void setUp() {
        // 1. 建立连接
        jedis = JedisConnectionFactory.getJedis();
        // 2. 设置密码
        jedis.auth("123321");
        // 3. 选择库
        jedis.select(0);
    }

    @Test
    void testString() {
        String result = jedis.set("name", "Ye");
        System.out.println("result = " + result);

        //获取数据
        String name = jedis.get("name");
        System.out.println("name = " + name);
    }

    @Test
    void testHash() {
        //插入数据
        jedis.hset("user:1", "name", "Ye");
        jedis.hset("user:1", "age", "25");

        //获取数据
        Map<String, String> userInfo = jedis.hgetAll("user:1");
        System.out.println(userInfo);
    }

    @AfterEach
    void tearDown() {
        if (jedis != null) {
            jedis.close();
        }
    }
}
