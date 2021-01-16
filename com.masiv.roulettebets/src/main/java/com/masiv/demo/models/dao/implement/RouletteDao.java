package com.masiv.demo.models.dao.implement;

import java.util.Map;

import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import com.masiv.demo.models.dao.IRouletteDao;
import com.masiv.demo.models.entity.Roulette;

@Repository
public class RouletteDao implements IRouletteDao{

	private RedisTemplate<Integer, Roulette> redisTemplate;
	
	private HashOperations hashOperations;
	
	RouletteDao(RedisTemplate<Integer, Roulette> redisTemplate){
		this.redisTemplate = redisTemplate;
		hashOperations = redisTemplate.opsForHash();
	}
	
	@Override
	public void save(Roulette roulette) {
		hashOperations.put("ROULETTE", roulette.getIdRoulette(), roulette);
		
	}
	
	@Override
	public Map<String, Roulette> findAll() {
		return hashOperations.entries("ROULETTE");
	}

	@Override
	public Roulette findById(int id_roulette) {
		return (Roulette) hashOperations.get("ROULETTE", id_roulette);
	}

	@Override
	public void update(Roulette roulette) {
		save(roulette);
	}

}
