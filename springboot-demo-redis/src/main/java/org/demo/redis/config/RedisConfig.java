package org.demo.redis.config;

import java.lang.reflect.Method;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@EnableCaching
@Configuration
@ConditionalOnClass(RedisOperations.class)
@EnableConfigurationProperties(RedisProperties.class)
public class RedisConfig {

	// 自定义的缓存key的生成策略
	@Bean
	public KeyGenerator keyGenerator() {
		return new KeyGenerator() {
			@Override
			public Object generate(Object target, Method method, Object... params) {
				StringBuffer sb = new StringBuffer();
				sb.append(target.getClass().getName());
				sb.append('.');
				sb.append(method.getName());
				for (Object obj : params) {
					sb.append(obj.toString());
				}
				return sb.toString();
			}
		};
	}

	@Bean(name = "redisTemplate")
	@ConditionalOnMissingBean(name = "redisTemplate")
	public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory redisConnectionFactory) {
		RedisTemplate<String, Object> template = new RedisTemplate<>();

		// 使用fastjson序列化
		FastJsonRedisSerializer<Object> fastJsonRedisSerializer = new FastJsonRedisSerializer<Object>(Object.class);
		// value值的序列化采用fastJsonRedisSerializer
		template.setValueSerializer(fastJsonRedisSerializer);
		template.setHashValueSerializer(fastJsonRedisSerializer);
		// key的序列化采用StringRedisSerializer
		template.setKeySerializer(new StringRedisSerializer());
		template.setHashKeySerializer(new StringRedisSerializer());

		template.setConnectionFactory(redisConnectionFactory);
		return template;
	}

	// @Bean
	// @ConditionalOnMissingBean(StringRedisTemplate.class)
	// public StringRedisTemplate stringRedisTemplate(RedisConnectionFactory
	// redisConnectionFactory) {
	// StringRedisTemplate template = new StringRedisTemplate();
	// template.setConnectionFactory(redisConnectionFactory);
	// return template;
	// }

	// 缓存管理器
	@Bean
	public RedisCacheManager cacheManager(LettuceConnectionFactory lettuceConnectionFactory) {
		// 获取默认配置
		RedisCacheConfiguration cacheConfiguration = getRedisCacheConfiguration(Duration.ZERO);
		// 当redis注解value为“10min”时候，采用下面这个配置
		Map<String, RedisCacheConfiguration> initialCacheConfigurations = new HashMap<>();
		initialCacheConfigurations.put("S20", getRedisCacheConfiguration(Duration.ofSeconds(20L)));
		initialCacheConfigurations.put("M10", getRedisCacheConfiguration(Duration.ofMinutes(10L)));
		initialCacheConfigurations.put("H1", getRedisCacheConfiguration(Duration.ofHours(1L)));
		initialCacheConfigurations.put("H6", getRedisCacheConfiguration(Duration.ofHours(6L)));
		initialCacheConfigurations.put("H12", getRedisCacheConfiguration(Duration.ofHours(12L)));
		RedisCacheManager redisCacheManager = RedisCacheManager.builder(lettuceConnectionFactory).cacheDefaults(cacheConfiguration).withInitialCacheConfigurations(initialCacheConfigurations).transactionAware().build();
		return redisCacheManager;
	}

	// 自定义缓存配置
	private RedisCacheConfiguration getRedisCacheConfiguration(Duration duration) {
		// 获取默认配置
		RedisCacheConfiguration defaultCacheConfiguration = RedisCacheConfiguration.defaultCacheConfig();
		// GenericJackson2JsonRedisSerializer genericJackson2JsonRedisSerializer = new
		// GenericJackson2JsonRedisSerializer();
		FastJsonRedisSerializer<Object> fastJsonRedisSerializer = new FastJsonRedisSerializer<Object>(Object.class);
		return defaultCacheConfiguration.serializeValuesWith(RedisSerializationContext.SerializationPair.fromSerializer(fastJsonRedisSerializer)).entryTtl(duration);
	}
}
