package com.tacaly.furphobia.pets.stats;

public class Health{
	// <current> is the value to be checked if healths needs to show a value
	// <actual> is what <current> value will eventually be
	private int current, actual, maximum;
	
	public Health(int actual, int maximum){
		this.current = actual;
		this.actual = actual;
		this.maximum = maximum;
	}
	public void setActual(int actual){
		this.actual = actual;
	}
	public void setMaximum(int max){
		this.maximum = max;
	}
	
	public int getCurrentHealth(){
		return current;
	}
	public int getMaximum(){
		return this.maximum;
	}
	
	public void heal(int amount){
		actual += amount;
	}
	
	public void update(Hunger hunger){
		if(hunger.getCurrent() >= hunger.getMaximum()/2){
			actual++;
		}
		lerp();
	}
	// for gui animation purposes
	private void lerp(){
		actual =  current + (int) Math.floor((current - actual) * 0.9);
	}
}
