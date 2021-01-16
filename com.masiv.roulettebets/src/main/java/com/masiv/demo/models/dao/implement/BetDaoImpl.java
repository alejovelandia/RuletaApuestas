package com.masiv.demo.models.dao.implement;

import java.util.List;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import com.masiv.demo.models.dao.IBetDao;
import com.masiv.demo.models.entity.Bet;

@Repository
public class BetDaoImpl extends BaseDao implements IBetDao{

	private static final String BET_KEY = "BET";

	BetDaoImpl(RedisTemplate redisTemplate) {
		super(redisTemplate);
	}
	
	@Override
	public void save(Bet bet) {
		hashOperations.put(BET_KEY, bet.getIdBet(), bet);
	}
	
	@Override
	public long countAll() {
		return hashOperations.size(BET_KEY);
	}

	@Override
	public List<Bet> findAll(int id_roulette) {
		return hashOperations.values(BET_KEY);
	}
	
}
