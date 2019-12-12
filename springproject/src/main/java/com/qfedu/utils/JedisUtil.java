package com.qfedu.utils;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.util.List;
import java.util.Map;
import java.util.Set;

// Jedis工具类

/*
Jedis的作用：
    解决应用服务器的cpu和内存压力

    减少io的读操作，减轻io的压力

    关系型数据库的扩展性不强，难以改变表结构
 */

/*
    nosql数据库没有关联关系，数据结构简单，拓展表比较容易

    nosql读取速度快，对较大数据处理快
 */

/*
    Redis是一个开源的key—value型数据库，支持string、list、set、zset和hash类型数据。
    对这些数据的操作都是原子性的，redus为了保证效率会定期持久化数据。
 */
public class JedisUtil {
    private static JedisPool jedisPool;

    private Jedis jedis;

    // 配置连接池
    static {
        JedisPoolConfig poolConfig = new JedisPoolConfig();
        poolConfig.setMaxIdle(20); // 最大空闲客户端连接对象
        poolConfig.setMaxTotal(1000); // 最大的客户端连接对象
        poolConfig.setMaxWaitMillis(2000); //最多等待时间 毫秒
        jedisPool = new JedisPool(poolConfig, "39.105.189.141", 6380);
    }


    public JedisUtil() {
        jedis = jedisPool.getResource();
        jedis.auth("qfjava");
    }

    // 新增 字符串 Key不存在新增 存在修改
    public void addStr(String key, String val) {
        jedis.set(key, val);
    }

    public void addStr(String key, String val, int seconds) {
        jedis.psetex(key, seconds * 1000, val);
    }

    // 新增 list集合
    public void addList(String key, String... arr) {
        jedis.lpush(key, arr); // 添加到头部

        //从尾部添加
        // jedis.rpush(key, arr);
    }

    // 新增 Set集合
    public void addSet(String key, String... arr) {
        jedis.sadd(key, arr);
    }

    // 新增 有序Set Zset SortSet
    public void addZSet(String key, double score, String val) {
        jedis.zadd(key, score, val);
    }

    // 新增 hash
    public void addHash(String key, String field, String val) {
        jedis.hset(key, field, val);
    }

    // 删除
    public void del(String key) {
        jedis.del(key);
    }

    // 删除集合数据
    public void delList(String key, String v) {
        jedis.lrem(key, 1, v);
    }

    // 查询
    public String getStr(String key) {
        return jedis.get(key);
    }

    public List<String> getList(String key) {
        return jedis.lrange(key, 0, -1);
    }

    public Set<String> getSet(String key) {
        return jedis.smembers(key);
    }

    public Map<String, String> getHash(String key) {
        return jedis.hgetAll(key);
    }

    // 检查
    public boolean checkHash(String key, String f) {
        return jedis.hexists(key, f);
    }

    public boolean checkKey(String key) {
        return jedis.exists(key);
    }

    // 设置有效期
    public void setExpire(String key, int seconds) {
        jedis.expire(key, seconds);
    }

    // 查询剩余有效期 毫秒
    public long ttl(String key) {
        return jedis.ttl(key);
    }

}
