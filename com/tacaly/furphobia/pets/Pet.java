package com.tacaly.furphobia.pets;

// contains Animation, Position, Health and Hunger.java
import com.tacaly.furphobia.pets.stats.*;

import java.awt.Graphics2D;

public abstract class Pet{
	public String name, species;
	public Health health;
	private Position current_position, to_position;
	private Animation animation;
	private Hunger hunger;
	private boolean isVisible, flying;
	private int affection;
	
	public Pet(String name, String species){
		this.name = name;
		this.species = species;
		this.current_position = null;
		this.to_position = null;
		this.animation = null;
		
		this.health = null;
		this.hunger = null;
		
		this.isVisible = true;
		this.flying = false;
		this.affection = 10;
	}
	
	public void show(){
		isVisible = true;
	}
	public void hide(){
		isVisible = false;
	}
	// setters
	protected void setName(String name){
		this.name = name;
	}
	protected void setSpecies(String species){
		this.species = species;
	}
	protected void setPosition(Position position){
		this.current_position = position;
		this.to_position = position;
	}
	protected void setAnimation(Animation animation){
		this.animation = animation;
	}
	protected void setHealth(Health health){
		this.health = health;
	}
	protected void setHunger(Hunger hunger){
		this.hunger = hunger;
	}
	
	// getters
	public Position getPosition(){
		return this.current_position;
	}
	public String getName(){
		return this.name;
	}
	public String getSpecies(){
		return this.species;
	}
	public Health getHealth(){
		return this.health;
	}
	
	public void tick(){
		update();
		animation.update();
		hunger.update();
		health.update(hunger);
		// pet should move to a random point in the screen, always inside the boundaries of what's shown
		/*
		if(flying){
			// character should constantly move up and down
			current_position.levitate();
		}
		*/
		current_position.moveTo(to_position);
	}
	/*
	public void feed(Food food){
		hunger.feed(food);
		animation.playAnimation("feeding");
	}
	*/
	public void draw(Graphics2D g){
		animation.draw(g, current_position);
	}
	
	abstract public void update();
	// abstract public void pet();
}
