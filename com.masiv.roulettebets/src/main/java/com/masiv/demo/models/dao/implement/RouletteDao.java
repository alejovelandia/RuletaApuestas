package com.masiv.demo.models.dao.implement;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import com.masiv.demo.models.dao.IRouletteDao;
import com.masiv.demo.models.entity.Roulette;

@Repository
public class RouletteDao implements IRouletteDao{

	private static final String ROULETTE_KEY = "ROULETTE";
	
	private RedisTemplate redisTemplate;
	
	private HashOperations hashOperations;
	
	RouletteDao(RedisTemplate redisTemplate){
		this.redisTemplate = redisTemplate;
		hashOperations = redisTemplate.opsForHash();
	}
	
	@Override
	public void save(Roulette roulette) {
		hashOperations.put(ROULETTE_KEY, roulette.getIdRoulette(), roulette);
		
	}
	
	@Override
	public long countAll() {
		return hashOperations.size(ROULETTE_KEY);
	}

	@Override
	public Roulette findById(int id_roulette) {
		return (Roulette) hashOperations.get(ROULETTE_KEY, id_roulette);
	}

	@Override
	public void update(Roulette roulette) {
		save(roulette);
	}

}
