package com.div.redis.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.GenericToStringSerializer;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import com.div.subscriber.Receiver;

@Configuration
@EnableRedisRepositories
public class RedisConfiguration {

	@Bean
	public JedisConnectionFactory connectionFactory() {
		RedisStandaloneConfiguration standaloneConfiguration = new RedisStandaloneConfiguration();
		standaloneConfiguration.setHostName("localhost");
		standaloneConfiguration.setPort(6379);
		return new JedisConnectionFactory(standaloneConfiguration);
	}

	@Bean
	public RedisTemplate<String, Object> redisTemplate() {
	    RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
	    redisTemplate.setConnectionFactory(connectionFactory());
	    
//	    redisTemplate.setHashKeySerializer(new JdkSerializationRedisSerializer()); // Removed


	    // Use StringRedisSerializer for keys and hash keys
	    redisTemplate.setKeySerializer(new StringRedisSerializer());
	    redisTemplate.setHashKeySerializer(new StringRedisSerializer());

	    // Use GenericJackson2JsonRedisSerializer for values and hash values
	    redisTemplate.setValueSerializer(new GenericJackson2JsonRedisSerializer());
	    redisTemplate.setHashValueSerializer(new GenericJackson2JsonRedisSerializer());

	    // Enable transaction support if needed
	    redisTemplate.setEnableTransactionSupport(true);
	    redisTemplate.afterPropertiesSet();
	    return redisTemplate;
	}


	@Bean
	public RedisCacheManager cacheManager(RedisConnectionFactory connectionFactory) {
		RedisCacheConfiguration config = RedisCacheConfiguration.defaultCacheConfig();
		return RedisCacheManager.builder(connectionFactory).cacheDefaults(config).build();
	}
	
	@Bean
	public ChannelTopic topic() {
		return new ChannelTopic("pusb:DivaTech");
	}
	
	@Bean
	public MessageListenerAdapter messageListenerAdapter() {
		return new MessageListenerAdapter(new Receiver());
	}
	
	@Bean
	public RedisMessageListenerContainer redisMessageListenerContainer() {
		RedisMessageListenerContainer container = new RedisMessageListenerContainer();
		container.setConnectionFactory(connectionFactory());
		container.addMessageListener(messageListenerAdapter(),topic());
		return container;
	}

}
