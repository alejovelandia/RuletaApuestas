package com.masiv.demo.models.enumerable;

public enum ColorEnum {
	
    ROJO(true), 
    NEGRO(false);

	private boolean par;
	
	ColorEnum(boolean par) {
		this.par = par;
	}

	public boolean isPar() {
		return par;
	}

	public void setPar(boolean par) {
		this.par = par;
	}
}
