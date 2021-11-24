package com.tacaly.furphobia;

import java.awt.Graphics2D;

// implement this interface to any class that'll be used to show things on screen
public interface Screen{
	public void init();
	public void tick();
	public void render(Graphics2D g);
	
	public void keyDownHandler(int e);
	public void keyUpHandler(int e);
}