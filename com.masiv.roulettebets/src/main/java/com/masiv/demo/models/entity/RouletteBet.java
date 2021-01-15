package com.masiv.demo.models.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import org.springframework.data.redis.core.RedisHash;

import com.masiv.demo.models.enumerable.Color;

@RedisHash("roulette_bet")
public class RouletteBet implements Serializable{
	
	private int idRouletteBet;
	
	private int fkIdRoulette;
	
	private int number;
	
	private Color color;
	
	private BigDecimal amountBet;
	
	private boolean winState;
	
	public int getIdRouletteBet() {
		return idRouletteBet;
	}

	public void setIdRouletteBet(int idRouletteBet) {
		this.idRouletteBet = idRouletteBet;
	}

	public int getFkIdRoulette() {
		return fkIdRoulette;
	}

	public void setFkIdRoulette(int fkIdRoulette) {
		this.fkIdRoulette = fkIdRoulette;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public BigDecimal getAmountBet() {
		return amountBet;
	}

	public void setAmountBet(BigDecimal amountBet) {
		this.amountBet = amountBet;
	}

	public boolean isWinState() {
		return winState;
	}

	public void setWinState(boolean winState) {
		this.winState = winState;
	}

	private static final long serialVersionUID = 1L;
}
