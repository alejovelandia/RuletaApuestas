package com.masiv.demo.models.dao;

import java.util.Map;

import com.masiv.demo.models.entity.Roulette;

public interface IRouletteDao {
	
	public void save(Roulette roulette);
	
	public long countAll();
	
	public Roulette findById(int id_roulette);
	
	public void update(Roulette roulette);

}
