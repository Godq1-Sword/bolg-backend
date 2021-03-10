package org.gdq.bolg.core.config;

import org.springframework.cache.CacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.cache.RedisCacheWriter;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.time.Duration;

/**
 * @author gdq
 * date 2020/8/24
 * description RedisConfig
 */
@Configuration
public class RedisConfig {

	/**
	 * description 默认SpringCache管理器
	 *
	 * @param redisConnectionFactory redis连接
	 * @return CacheManager
	 * @author gdq date 2020/8/24
	 */
	@Bean
	public CacheManager redisCache(RedisConnectionFactory redisConnectionFactory) {
		System.out.println(redisConnectionFactory);
		RedisCacheConfiguration redisCacheConfiguration = RedisCacheConfiguration.defaultCacheConfig()
				// 过期时间 30分
				.entryTtl(Duration.ofMinutes(30))
				// 前缀
				.prefixCacheNameWith("springcache_")
				// 序列化策略
				.serializeKeysWith(RedisSerializationContext.SerializationPair.fromSerializer(keySerializer()))
				.serializeValuesWith(RedisSerializationContext.SerializationPair.fromSerializer((valueSerializer())));
		// 不阻塞
		return RedisCacheManager.builder(RedisCacheWriter.nonLockingRedisCacheWriter(redisConnectionFactory))
				.cacheDefaults(redisCacheConfiguration).build();
	}

	private RedisSerializer<String> keySerializer() {
		return new StringRedisSerializer();
	}

	private RedisSerializer<String> valueSerializer() {
		return new StringRedisSerializer();
	}
}
