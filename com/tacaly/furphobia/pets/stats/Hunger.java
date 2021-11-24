package com.tacaly.furphobia.pets.stats;

public class Hunger{
	private int current;
	private int MAX;
	
	public Hunger(){
		this.current = 6666;
		this.MAX = 10000;
	}
	public int getCurrent(){
		return current;
	}
	public int getMaximum(){
		return MAX;
	}
	public void update(){
		this.current--;
	}
}
