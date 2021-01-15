package com.masiv.demo.service;

import org.springframework.stereotype.Service;

import com.masiv.demo.models.entity.Roulette;

@Service
public interface IRouletteService {
	
	public int save();
	
	public boolean activate(int idRoulette); 

}
