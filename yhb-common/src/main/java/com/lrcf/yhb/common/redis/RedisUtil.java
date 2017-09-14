package com.lrcf.yhb.common.redis;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.util.UUID;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 
 * Copyright: Copyright (c) 2017 LanRu-Caifu
 * 
 * @ClassName: RedisUtil.java
 * @Description: Redis 工具类
 * @author:Krx
 * @date: 2017年5月4日 上午10:57:18
 */
public class RedisUtil {

	protected static ReentrantLock lockPool = new ReentrantLock();
	protected static ReentrantLock lockJedis = new ReentrantLock();

	private static Logger _log = LoggerFactory.getLogger(RedisUtil.class);


	// Redis服务器IP
	private static String IP = "127.0.0.1";

	// Redis的端口号
//	private static int PORT = 6379;
	private static int PORT = 6666;

	// 访问密码
	private static String PASSWORD ="";
	// 可用连接实例的最大数目，默认值为8；
	// 如果赋值为-1，则表示不限制；如果pool已经分配了maxActive个jedis实例，则此时pool的状态为exhausted(耗尽)。
//	@Value("${redis.max_active}")
	private static int MAX_ACTIVE = 500;

	// 控制一个pool最多有多少个状态为idle(空闲的)的jedis实例，默认值也是8。
//	@Value("${redis.max_idle}")
	private static int MAX_IDLE =5;

	// 等待可用连接的最大时间，单位毫秒，默认值为-1，表示永不超时。如果超过等待时间，则直接抛出JedisConnectionException；
//	@Value("${redis.max_wait}")
	private static int MAX_WAIT = 10000;

	// 超时时间
//	@Value("${redis.timeout}")
	private static int TIMEOUT= 10000;

	// 在borrow一个jedis实例时，是否提前进行validate操作；如果为true，则得到的jedis实例均是可用的；
	private static boolean TEST_ON_BORROW = false;

	private static JedisPool jedisPool = null;

	/**
	 * redis过期时间,以秒为单位
	 */
	public final static int EXRP_HOUR = 60 * 60; // 一小时
	public final static int EXRP_DAY = 60 * 60 * 24; // 一天
	public final static int EXRP_MONTH = 60 * 60 * 24 * 30; // 一个月
	public final static int EXRP_SECONDS = 10 * 60; //10分钟


	/**
	 * redis的key名称
	 */
	public final static String statistics = "statistics";  //
	public final static String buyFinanceProducts = "buyFinanceProducts";

	/**
	 * 初始化Redis连接池
	 */
	private static void initialPool() {
		try {
			JedisPoolConfig config = new JedisPoolConfig();
			config.setMaxTotal(MAX_ACTIVE);
			config.setMaxIdle(MAX_IDLE);
			config.setMaxWaitMillis(MAX_WAIT);
			config.setTestOnBorrow(TEST_ON_BORROW);
			jedisPool = new JedisPool(config, IP, PORT, TIMEOUT);
		} catch (Exception e) {
			_log.error("First create JedisPool error : " + e);
		}
	}

	/**
	 * 在多线程环境同步初始化
	 */
	private static synchronized void poolInit() {
		if (null == jedisPool) {
			initialPool();
		}
	}

	/**
	 * 同步获取Jedis实例
	 * 
	 * @return Jedis
	 */
	public synchronized static Jedis getJedis() {
		poolInit();
		Jedis jedis = null;
		try {
			if (null != jedisPool) {
				jedis = jedisPool.getResource();
				try {
					jedis.auth(PASSWORD);
				} catch (Exception e) {

				}
			}
		} catch (Exception e) {
			_log.error("Get jedis error : " + e);
		}
		return jedis;
	}

	/**
	 * 设置 String
	 * 
	 * @param key
	 * @param value
	 */
	public synchronized static void set(String key, String value) {
		try {
			value = StringUtils.isBlank(value) ? "" : value;
			Jedis jedis = getJedis();
			jedis.set(key, value);
			jedis.close();
		} catch (Exception e) {
			_log.error("Set key error : " + e);
		}
	}

	/**
	 * 设置 byte[]
	 * 
	 * @param key
	 * @param value
	 */
	public synchronized static void set(byte[] key, byte[] value) {
		try {
			Jedis jedis = getJedis();
			jedis.set(key, value);
			jedis.close();
		} catch (Exception e) {
			_log.error("Set key error : " + e);
		}
	}

	/**
	 * 设置 String 过期时间
	 * 
	 * @param key
	 * @param value
	 * @param seconds
	 *            以秒为单位
	 */
	public synchronized static void set(String key, String value, int seconds) {
		try {
			value = StringUtils.isBlank(value) ? "" : value;
			Jedis jedis = getJedis();
			jedis.setex(key, seconds, value);
			jedis.close();
		} catch (Exception e) {
			_log.error("Set keyex error : " + e);
		}
	}

	/**
	 * 设置 byte[] 过期时间
	 * 
	 * @param key
	 * @param value
	 * @param seconds
	 *            以秒为单位
	 */
	public synchronized static void set(byte[] key, byte[] value, int seconds) {
		try {
			Jedis jedis = getJedis();
			jedis.set(key, value);
			jedis.expire(key, seconds);
			jedis.close();
		} catch (Exception e) {
			_log.error("Set key error : " + e);
		}
	}

	/**
	 * 获取String值
	 * 
	 * @param key
	 * @return value
	 */
	public synchronized static String get(String key) {
		Jedis jedis = getJedis();
		if (null == jedis) {
			return null;
		}
		String value = jedis.get(key);
		jedis.close();
		return value;
	}

	/**
	 * 获取byte[]值
	 * 
	 * @param key
	 * @return value
	 */
	public synchronized static byte[] get(byte[] key) {
		Jedis jedis = getJedis();
		if (null == jedis) {
			return null;
		}
		byte[] value = jedis.get(key);
		jedis.close();
		return value;
	}

	/**
	 * 删除值
	 * 
	 * @param key
	 */
	public synchronized static void remove(String key) {
		try {
			Jedis jedis = getJedis();
			jedis.del(key);
			jedis.close();
		} catch (Exception e) {
			_log.error("Remove keyex error : " + e);
		}
	}

	/**
	 * 删除值
	 * 
	 * @param key
	 */
	public synchronized static void remove(byte[] key) {
		try {
			Jedis jedis = getJedis();
			jedis.del(key);
			jedis.close();
		} catch (Exception e) {
			_log.error("Remove keyex error : " + e);
		}
	}

	/**
	 * 获取redis key 的过期时间
	 * 
	 * @param key
	 */
	public synchronized static Long getttlTime(String key) {
		Jedis jedis = getJedis();
		if (jedis == null) {
			return null;
		}
		long time = jedis.ttl(key);
		jedis.close();
		return time;
	}

	/**
	 * 删除当前选择数据库中的所有key
	 * 
	 * @param_key
	 */
	public synchronized static void flushdb() {
		try {
			Jedis jedis = getJedis();
			jedis.flushDB();
			jedis.close();
		} catch (Exception e) {
			_log.error("Remove keyex error : " + e);
		}
	}

	/**
	 * lpush
	 * 
	 * @param key
	 * @param key
	 */
	public synchronized static void lpush(String key, String... strings) {
		try {
			Jedis jedis = RedisUtil.getJedis();
			jedis.lpush(key, strings);
			jedis.close();
		} catch (Exception e) {
			_log.error("lpush error : " + e);
		}
	}

	/**
	 * expire
	 * @param key
	 * @param second
	 */
	public synchronized static void expire(String key, Integer second) {
		try {
			Jedis jedis = RedisUtil.getJedis();
			jedis.expire(key, second);
			jedis.close();
		} catch (Exception e) {
			_log.error("lpush error : " + e);
		}
	}


	/**
	 * lrem
	 * 
	 * @param key
	 * @param count
	 * @param value
	 */
	public synchronized static void lrem(String key, long count, String value) {
		try {
			Jedis jedis = RedisUtil.getJedis();
			jedis.lrem(key, count, value);
			jedis.close();
		} catch (Exception e) {
			_log.error("lpush error : " + e);
		}
	}

	/**
	 * sadd
	 * 
	 * @param key
	 * @param value
	 * @param seconds
	 */
	public synchronized static void sadd(String key, String value, int seconds) {
		try {
			Jedis jedis = RedisUtil.getJedis();
			jedis.sadd(key, value);
			jedis.expire(key, seconds);
			jedis.close();
		} catch (Exception e) {
			_log.error("sadd error : " + e);
		}
	}


	public static void main(String[] args) {
		String token = UUID.randomUUID().toString().replaceAll("-","");
		String key = "USER_SESSION" + token;
		RedisUtil.set(key,"bbbb");
		RedisUtil.expire(key, 100000);
	}

}
