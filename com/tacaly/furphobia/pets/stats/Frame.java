package com.tacaly.furphobia.pets.stats;

import java.awt.image.BufferedImage;
import java.awt.Graphics2D;

public class Frame{
	private int duration;
	private BufferedImage frame;
	private int w, h; // display width and height
	
	public Frame(BufferedImage frame, int duration, int w, int h){
		this.frame = frame;
		this.duration = duration; // TODO: this should be game_framerate/animation_framerate
		this.w = w;
		this.h = h;
	}
	public BufferedImage getFrame(){
		return frame;
	}
	public int getDuration(){
		return duration;
	}
	public void draw(Graphics2D g, Position pos){
		g.drawImage(
			getFrame(),
			pos.getX(), pos.getY(),
			w, h,
			null
		);
	}
}