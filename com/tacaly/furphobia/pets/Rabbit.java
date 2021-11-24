package com.tacaly.furphobia.pets;

import com.tacaly.furphobia.Image;
import com.tacaly.furphobia.pets.Pet;
import com.tacaly.furphobia.pets.stats.*;

public class Rabbit extends Pet {
	public Rabbit(String name){
		super(name, "Rabbit");
		setPosition(new Position(100, 100));
		
		// animation stuff
		java.awt.image.BufferedImage img = Image.fromFile("com\\tacaly\\furphobia\\res\\animation_placeholder.png");
		Frame[] frames = new Frame[]{
			new Frame(Image.getSprite(img,  0, 0, 16, 16), 15, 16*4, 16*4),
			new Frame(Image.getSprite(img, 16, 0, 16, 16), 15, 16*4, 16*4)
		};
		Animation anim = new Animation();
		anim.addAnimation("idle", frames);
		anim.playAnimation("idle");
		setAnimation(anim);
		
		setHealth(new Health(10, 10));
		setHunger(new Hunger());
		
	}
	
	public void update(){
		
	}
	public void pet(){
		
	}
}
