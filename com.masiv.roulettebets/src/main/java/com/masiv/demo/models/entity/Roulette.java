package com.masiv.demo.models.entity;

import java.io.Serializable;

public class Roulette implements Serializable{
	
	private int idRoulette;
	private boolean state;
	
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
	
	private static final long serialVersionUID = 1L;
	
}
