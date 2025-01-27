package com.div.publisher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.div.domain.ProductVO;

@SuppressWarnings("rawtypes")
@RestController
public class Publisher {
   
	
	@Autowired
	private RedisTemplate<String,Object> redisTemplate;
	@Autowired
	private ChannelTopic channelTopic;
	
	@PostMapping("/publish")
	public String publish(@RequestBody ProductVO productVO) {
		redisTemplate.convertAndSend(channelTopic.getTopic(), productVO);
		return "event pubslished";
	}
}
