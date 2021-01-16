package com.masiv.demo.service;

import com.masiv.demo.models.entity.Roulette;

public interface IRouletteService {
	
	public int save();
	
	public Roulette findById(int idRoulette);
	
	public boolean activate(int idRoulette);
	
	public int newId();
	
	public boolean validateExist(int idRoulette);
	
	public int getWinerNumber();
	
}
