package com.div.subscriber;

import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Receiver implements MessageListener{

	@Override
	public void onMessage(Message message, byte[] pattern) {
		log.info("Message Consumed :: "+message);
	}

}
