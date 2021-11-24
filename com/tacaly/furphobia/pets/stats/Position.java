package com.tacaly.furphobia.pets.stats;

public class Position{
	private int x0, y0; // current position
	private int x1, y1; // future position
	
	public Position(int x, int y){
		this.x0 = x;
		this.x1 = x;
		this.y0 = y;
		this.y1 = y;
	}
	
	public int getX(){
		return x0;
	}
	public int getY(){
		return y0;
	}
	public void moveTo(int x, int y){
		this.x1 = x;
		this.y1 = y;
	}
	public void moveTo(Position pos){
		moveTo(pos.getX(), pos.getY());
	}
	
	public void move(int x, int y){
		x0 = x;
		x1 = x;
		y0 = y;
		y1 = y;
	}
	
	public void update(){
		x0 = x1 + (int) Math.ceil((x0 - x1)* (5/6));
		y0 = y1 + (int) Math.ceil((y0 - y1)* (5/6));
	}
}
