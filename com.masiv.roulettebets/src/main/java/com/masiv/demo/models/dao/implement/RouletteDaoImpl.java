package com.masiv.demo.models.dao.implement;

import java.util.List;
import java.util.Map;

import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import com.masiv.demo.models.dao.IRouletteDao;
import com.masiv.demo.models.entity.Roulette;
import com.masiv.demo.models.entity.Bet;

@Repository
public class RouletteDaoImpl extends BaseDao implements IRouletteDao{

	private static final String ROULETTE_KEY = "ROULETTE";
	
	RouletteDaoImpl(RedisTemplate redisTemplate) {
		super(redisTemplate);
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

	@Override
	public List<Roulette> findAll() {
		return hashOperations.values(ROULETTE_KEY);
	}

}
