package com.masiv.demo.models.dao.implement;

import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;

public abstract class BaseDao {

	protected RedisTemplate redisTemplate;
	
	protected HashOperations hashOperations;
	
	BaseDao(RedisTemplate redisTemplate){
		this.redisTemplate = redisTemplate;
		hashOperations = redisTemplate.opsForHash();
	}
	
}
