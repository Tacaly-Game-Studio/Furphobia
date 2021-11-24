package com.tacaly.furphobia.screens;

import com.tacaly.furphobia.Image;
import com.tacaly.furphobia.Screen;
import com.tacaly.furphobia.FurComponent;
import com.tacaly.furphobia.pets.Rabbit;

import java.awt.image.BufferedImage;
import java.awt.Graphics2D;
import java.awt.Color;

public class Splash implements Screen{
	private FurComponent component;
	private BufferedImage img;
	private int x, y, w, h, dx, dy;
	
	public Splash(FurComponent component){
		this.component = component;
	}
	
	Rabbit rabbit;
	public void init(){
		rabbit = new Rabbit("bun");
	}
	
	public void tick(){
		rabbit.tick();
	}
	public void render(Graphics2D g){
		g.clearRect(0, 0, component.getWidth(), component.getHeight());
		rabbit.draw(g);
	}
	
	public void keyDownHandler(int e){}
	public void keyUpHandler(int e){}
}
