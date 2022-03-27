package com.dahua.employee.util;

import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

public class RedisUtil {

    // 服务器IP地址
    private final static String IPADDR = "localhost";

    // 端口
    private final static Integer PORT = 6379;

    // 密码
    private final static String AUTH = null;

    // 连接超时的时间
    private final static Integer TIMEOUT = 10000;

    private static JedisPool jedisPool = null;

    /**
     * 获取Jedis实例
     */

    public static Jedis getJedis() {

        jedisPool = new JedisPool(new GenericObjectPoolConfig<Jedis>(), IPADDR, PORT, TIMEOUT, AUTH);
        return jedisPool.getResource();
    }

    /***
     *
     * 释放资源
     */
    public static void returnResource(final Jedis jedis) {
        if (jedis != null) {
            jedisPool.returnResource(jedis);
        }

    }
}
