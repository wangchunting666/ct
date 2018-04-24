package com.ct.redis;

import redis.clients.jedis.Jedis;

/**
 * Created by Herdsric-M-003 on 2018/4/24.
 */
public class JedisOct {
    public static void connnectRedis(){
        //连接本地的 Redis 服务
        Jedis jedis = new Jedis("39.106.44.37");
        jedis.auth("123");
        System.out.println("连接成功");
        //查看服务是否运行
        System.out.println("服务正在运行: "+jedis.ping());
    }
}
