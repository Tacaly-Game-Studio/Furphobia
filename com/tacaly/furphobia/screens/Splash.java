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
		
		BufferedImage tiles = Image.fromFile("com\\tacaly\\furphobia\\res\\map_tiles.png");
		// I *could* make this more better, but its for testing
		BufferedImage[] tileset = new BufferedImage[]{
			Image.getSprite(tiles,  0,  0, 16, 16),
			Image.getSprite(tiles, 16,  0, 16, 16),
			Image.getSprite(tiles, 32,  0, 16, 16)
		};
		
		MapGen ascii = new MapGen(10, 10);
		ascii.printMap();
		map = new GraphicMap(ascii.getMap(), tileset, component);
	}
	
	public void tick(){
		// rabbit.tick();
	}
	public void render(Graphics2D g){
		map.draw(g);
		// rabbit.draw(g);
	}
	
	public void keyDownHandler(int e){}
	public void keyUpHandler(int e){}
}
