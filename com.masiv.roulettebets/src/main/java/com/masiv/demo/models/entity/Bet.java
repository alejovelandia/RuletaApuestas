package com.masiv.demo.models.entity;

import java.io.Serializable;
import java.math.BigDecimal;

public class Bet implements Serializable{
	
	private int idBet;
	
	private int fkIdRoulette;
	
	private Integer number;
	
	private String color;
	
	private BigDecimal amountBet;
	
	private int fkIdUser;
	
	private boolean winState;
	
	private BigDecimal winAmount;
	
	public Bet(int fkIdRoulette, Integer number, String color, BigDecimal amountBet, int fkIdUser) {
		super();
		this.fkIdRoulette = fkIdRoulette;
		this.number = number;
		this.color = color;
		this.amountBet = amountBet;
		this.fkIdUser = fkIdUser;
	}
	
	public int getIdBet() {
		return idBet;
	}

	public void setIdBet(int idBet) {
		this.idBet = idBet;
	}

	public int getFkIdRoulette() {
		return fkIdRoulette;
	}

	public void setFkIdRoulette(int fkIdRoulette) {
		this.fkIdRoulette = fkIdRoulette;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public BigDecimal getAmountBet() {
		return amountBet;
	}

	public void setAmountBet(BigDecimal amountBet) {
		this.amountBet = amountBet;
	}

	public int getFkIdUser() {
		return fkIdUser;
	}

	public void setFkIdUser(int fkIdUser) {
		this.fkIdUser = fkIdUser;
	}

	public boolean isWinState() {
		return winState;
	}

	public void setWinState(boolean winState) {
		this.winState = winState;
	}
	
	public BigDecimal getWinAmount() {
		return winAmount;
	}

	public void setWinAmount(BigDecimal winAmount) {
		this.winAmount = winAmount;
	}

	private static final long serialVersionUID = 1L;
}
