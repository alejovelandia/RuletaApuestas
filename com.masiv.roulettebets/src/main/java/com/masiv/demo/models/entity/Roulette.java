package com.masiv.demo.models.entity;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

@RedisHash("roulette")
public class Roulette implements Serializable{
	
	@Id
	private int idRoulette;
	private boolean state;
	private int winNumber;
	
	public Roulette(int idRoulette) {
		super();
		this.idRoulette = idRoulette;
	}
	
	public int getIdRoulette() {
		return idRoulette;
	}

	public void setIdRoulette(int idRoulette) {
		this.idRoulette = idRoulette;
	}

	public boolean isState() {
		return state;
	}
	
	public void setState(boolean state) {
		this.state = state;
	}
	
	public int getWinNumber() {
		return winNumber;
	}

	public void setWinNumber(int winNumber) {
		this.winNumber = winNumber;
	}

	private static final long serialVersionUID = 1L;
	
}
