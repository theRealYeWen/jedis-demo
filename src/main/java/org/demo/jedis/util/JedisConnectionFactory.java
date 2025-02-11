package org.demo.jedis.util;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.time.Duration;

public class JedisConnectionFactory {
    private static final JedisPool jedisPool;

    static {
        // 配置连接池
        JedisPoolConfig poolConfig = new JedisPoolConfig();
        // 最大连接数
        poolConfig.setMaxTotal(8);
        // 最大空闲连接
        poolConfig.setMaxIdle(8);
        //最小空闲连接
        poolConfig.setMinIdle(1);
        //等待时长
        poolConfig.setMaxWait(Duration.ofMillis(1000L));

        // 创建连接池对象
        jedisPool = new JedisPool(poolConfig, "127.0.0.1", 6379,
                1000, String.valueOf(123321));
    }

    public static Jedis getJedis() {
        return jedisPool.getResource();
    }
}
