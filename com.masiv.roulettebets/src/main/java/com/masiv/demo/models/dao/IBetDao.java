package com.masiv.demo.models.dao;

import java.util.List;

import com.masiv.demo.models.entity.Bet;

public interface IBetDao {
	
	public void save(Bet bet);
	
	public long countAll();
	
	public List<Bet> findAll(int idRoulette);
	
}
