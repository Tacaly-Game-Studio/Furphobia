package com.tacaly.furphobia.pets.stats;

import java.awt.Graphics2D;
import java.util.HashMap;

public class Animation{
	private String current_animation;
	private HashMap<String, Frame[]> frames;
	private int tick, current_frame;
	private boolean paused;
	
	public Animation(){
		this.frames = new HashMap<String, Frame[]>();
		this.current_animation = null;
		
		this.tick = 0;
		this.current_frame = 0;
		this.paused = false;
	}
	
	public void addAnimation(String hash, Frame[] animation){
		if(frames.containsValue(hash)){
			return;
		}
		frames.put(hash, animation);
	}
	public void playAnimation(String animation){
		current_animation = animation;
	}
	
	private Frame[] getCurrentAnimation(){
		return frames.get(current_animation);
	}
	private Frame getCurrentFrame(){
		return getCurrentAnimation()[current_frame];
	}
	
	// animation control
	public void play(){
		this.paused = false;
	}
	public void pause(){
		this.paused = true;
	}
	public void reset(){
		this.tick = 0;
		this.current_frame = 0;
	}
	
	public void update(){
		if(paused){
			return;
		}
		tick++;
		if(tick >= getCurrentFrame().getDuration()){
			tick = 0;
			current_frame++;
			if(current_frame >= getCurrentAnimation().length){
				current_frame = 0;
			}
		}
	}
	
	public void draw(Graphics2D g, Position pos){
		getCurrentFrame().draw(g, pos);
	}
}
