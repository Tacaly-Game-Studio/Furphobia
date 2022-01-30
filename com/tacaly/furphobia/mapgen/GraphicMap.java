package com.tacaly.furphobia.mapgen;

import com.tacaly.furphobia.pets.stats.Position;
import com.tacaly.furphobia.FurComponent;
import com.tacaly.furphobia.Image;
import com.tacaly.furphobia.mapgen.MapGen;

import java.awt.Graphics2D;
import java.awt.GraphicsConfiguration;
import java.awt.image.VolatileImage;
import java.awt.image.BufferedImage;

public class GraphicMap{
	private String PATH = "com\\tacaly\\furphobia\\resources\\";
	
	private MapGen map;
	private BufferedImage img;
	private BufferedImage[] tiles;
	
	private FurComponent component;
	
	private VolatileImage graphical_map;
	private Graphics2D graphics;
	
	public GraphicMap(MapGen map, FurComponent component){
		this.map = map;
		this.img = new BufferedImage(map.getMap()[0].length, map.getMap().length, BufferedImage.TYPE_INT_RGB);
		this.tiles = new BufferedImage[]{
			Image.fromFile(PATH+"waypoint.png"),
			Image.fromFile(PATH+"path.png"),
			Image.fromFile(PATH+"sea.png"),
			Image.fromFile(PATH+"field.png"),
			Image.fromFile(PATH+"mountain.png")
		};
		
		this.component = component;
		
		paintMap();
	}
	
	public void draw(Graphics2D g){
		g.drawImage(
			img,
			0, 0,
			component.getWidth(), component.getHeight(),
			null
		);
	}
	
	private void paintMap(){
		int color = 0x00_00_00;
		for(int y=0; y < map.getMap().length; y++){
			for(int x=0; x < map.getMap()[y].length; x++){
				color =  (int) (map.getMap()[y][x] * 0xff) << 16;
				color += (int) (map.getMap()[y][x] * 0xff) << 8;
				color += (int) (map.getMap()[y][x] * 0xff);
				img.setRGB(x, y, color);
			}
		}
	}
	private void _draw(int x, int y, int n){
		graphics.drawImage(
			tiles[n],
			x*tiles[n].getWidth(), y*tiles[n].getHeight(),
			null
		);
	}
}
