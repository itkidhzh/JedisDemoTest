package com.kidhh;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.util.ResourceBundle;

/**
 * @ClassName
 * @Description: TODO
 * @Author: kidhzh@outlook.com
 */
public class JedisUtils {
    private static String host = null;
    private static String port = null;
    private static String maxTotal = null;
    private static String maxIdle = null;

    private static JedisPool jedisPool = null;

    static {
        // 获取配置文件对象
        ResourceBundle resourceBundle = ResourceBundle.getBundle("redis");

        host = resourceBundle.getString("redis.host");
        port = resourceBundle.getString("redis.port");
        maxTotal = resourceBundle.getString("redis.maxTotal");
        maxIdle = resourceBundle.getString("redis.maxIdle");

        // 创建 Redis 配置对象
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();

        // 详细配置参数
        jedisPoolConfig.setMaxTotal(Integer.parseInt(maxTotal));
        jedisPoolConfig.setMaxIdle(Integer.parseInt(maxIdle));

        // 创建连接
        jedisPool = new JedisPool(jedisPoolConfig,host,Integer.parseInt(port));
    }

    /**
     * 创建 Redis 链接
     * @return 获取到的链接
     */
    // 获取 Redis 链接
    public static Jedis getJedis(){
        return jedisPool.getResource();
    }

}
