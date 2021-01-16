package com.masiv.demo.service;

import java.util.List;

import com.masiv.demo.models.entity.Bet;

public interface IBetService {

	public int save(Bet bet);
	
	public int newId();
	
	public List<Bet> findByRouletteWithWinners(int idRoulette, int winnerNumber);
	
}
