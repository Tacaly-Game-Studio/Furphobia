package com.tacaly.furphobia.screens;

import com.tacaly.furphobia.Image;
import com.tacaly.furphobia.Screen;
import com.tacaly.furphobia.FurComponent;

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
	
	public void init(){
		this.img = Image.fromFile("com\\tacaly\\furphobia\\res\\placeholder.png");
		this.x = 0;
		this.y = 0;
		this.w = 50;
		this.h = 50;
		this.dx = 3;
		this.dy = 3;
	}
	
	public void tick(){
		x += dx;
		y += dy;
		if(x < 0 && dx < 0 || x+w > component.getWidth() && dx > 0){
			dx *= -1;
		}
		if(y < 0 && dy < 0 || y+h > component.getHeight() && dy > 0){
			dy *= -1;
		}
	}
	public void render(Graphics2D g){
		g.clearRect(0, 0, component.getWidth(), component.getHeight()); // remember to delete, use another method
		g.drawImage(
			img,
			x, y,
			w, h,
			null
		);
	}
	
	public void keyDownHandler(int e){}
	public void keyUpHandler(int e){}
}
