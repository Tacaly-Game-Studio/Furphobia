package com.tacaly.furphobia.mapgen;

import com.tacaly.furphobia.pets.stats.Position;
import com.tacaly.furphobia.FurComponent;

import java.awt.Graphics2D;
import java.awt.GraphicsConfiguration;
import java.awt.image.VolatileImage;
import java.awt.image.BufferedImage;

public class GraphicMap{
	
	private char[][] base_map;
	private BufferedImage[] tiles;
	
	private VolatileImage graphical_map;
	private Graphics2D graphics;
	
	public GraphicMap(char[][] map, BufferedImage[] tiles, FurComponent component){
		this.base_map = map;
		this.tiles = tiles;
		
		GraphicsConfiguration gc = component.getGraphicsConfiguration();
		this.graphical_map = gc.createCompatibleVolatileImage(component.getWidth(), component.getHeight());
		// this.graphical_map = gc.createCompatibleVolatileImage(100, 100);
		this.graphics = (Graphics2D) graphical_map.getGraphics();
		generateMap();
	}
	
	public void draw(Graphics2D g){
		g.drawImage(graphical_map, 0, 0, null);
	}
	
	// it'll hardly be a maintainable code, sorry
	private void generateMap(){
		// int scaleX = graphical_map.getWidth() / base_map[0].length;
		int scaleX = 2;
		// int scaleY = graphical_map.getHeight()/ tiles[0].getHeight();
		int scaleY = 2;
		System.out.println(scaleX);
		
		int x = 0;
		while(x < base_map.length){
			int y = 0;
			while(y < base_map[x].length){
				if(base_map[y][x] == 'O'){
					graphics.drawImage(
						tiles[0],
						x*tiles[0].getWidth()*scaleX, y*tiles[0].getHeight()*scaleY,
						tiles[0].getWidth()*scaleX  , tiles[0].getHeight()*scaleY,
						null
					);
				}else if(base_map[y][x] == '.'){
					graphics.drawImage(
						tiles[1],
						x*tiles[1].getWidth()*scaleX, y*tiles[1].getHeight()*scaleY,
						tiles[1].getWidth()*scaleX  , tiles[1].getHeight()*scaleY,
						null
					);
				}else{
					graphics.drawImage(
						tiles[2],
						x*tiles[2].getWidth()*scaleX, y*tiles[2].getHeight()*scaleY,
						tiles[2].getWidth()*scaleX  , tiles[2].getHeight()*scaleY,
						null
					);
				}
				y++;
			}
			x++;
		}
		System.out.println("Done drawing");
	}
}
