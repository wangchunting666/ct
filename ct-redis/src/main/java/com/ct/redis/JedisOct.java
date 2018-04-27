package com.ct.redis;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisCluster;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Herdsric-M-003 on 2018/4/24.
 */
public class JedisOct {
    public static void connnectRedisSet(){
        //连接本地的 Redis 服务
        //Jedis jedis = new Jedis("localhost");
        //Jedis jedis = new Jedis("39.106.44.37",7000);
        //jedis.set("hello","hello");
        //jedis.auth("123");
        //System.out.println("连接成功");
        //查看服务是否运行
        HashSet<HostAndPort> hashSet=new HashSet<>();
        hashSet.add(new HostAndPort("39.106.44.37", 7000));
        hashSet.add(new HostAndPort("39.106.44.37", 7001));
        hashSet.add(new HostAndPort("39.106.44.37", 7002));
        hashSet.add(new HostAndPort("39.106.44.37", 7003));
        hashSet.add(new HostAndPort("39.106.44.37", 7004));
        hashSet.add(new HostAndPort("39.106.44.37", 7005));
        JedisCluster jedisCluster=new JedisCluster(hashSet);
        jedisCluster.set("duan", "100");
        System.out.println("服务正在运行: "+jedisCluster.get("duan"));
    }

    public static void connnectRedisGet(){
        //连接本地的 Redis 服务
        //Jedis jedis = new Jedis("localhost");
        //Jedis jedis = new Jedis("39.106.44.37",7001);
        //JedisCluster cluster = new JedisCluster("39.106.44.37",7001);
        //jedis.auth("123");
        //System.out.println("连接成功");
        //查看服务是否运行
        //System.out.println("服务正在运行: "+jedis.get("hello"));
    }
}
