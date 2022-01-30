package com.tacaly.furphobia.screens;

import com.tacaly.furphobia.mapgen.MapGen;
import com.tacaly.furphobia.mapgen.GraphicMap;
import com.tacaly.furphobia.Image;

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
	GraphicMap map;
	public void init(){
		// rabbit = new Rabbit("bun");
		
		MapGen mapgen = new MapGen(64, 64);
		mapgen.makeNoise();
		
		map = new GraphicMap(mapgen, component);
	}
	int count = 0;
	public void tick(){
		// to see if program gets stuck in something
		// count++;
		if(count > 24){
			count = 0;
			System.out.println("loop!");
		}
		
	}
	public void render(Graphics2D g){
		map.draw(g);
	}
	
	public void keyDownHandler(int e){}
	public void keyUpHandler(int e){}
}
