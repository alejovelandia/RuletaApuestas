package com.masiv.demo.models.dao;

import com.masiv.demo.models.entity.Roulette;

import java.util.List;

import com.masiv.demo.models.entity.Bet;

public interface IRouletteDao {
	
	public void save(Roulette roulette);
	
	public long countAll();
	
	public Roulette findById(int id_roulette);
	
	public void update(Roulette roulette);
	
	public List<Roulette> findAll();

}
