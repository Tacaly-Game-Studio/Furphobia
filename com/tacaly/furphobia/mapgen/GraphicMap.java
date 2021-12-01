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
	
	private int wWidth, wHeight;
	
	private VolatileImage graphical_map;
	private Graphics2D graphics;
	
	public GraphicMap(char[][] map, BufferedImage[] tiles, FurComponent component){
		this.base_map = map;
		this.tiles = tiles;
		
		// window dimensions
		this.wWidth = component.getWidth();
		this.wHeight = component.getHeight();
		
		// buffering stuff
		GraphicsConfiguration gc = component.getGraphicsConfiguration();
		this.graphical_map = gc.createCompatibleVolatileImage(
			base_map.length   *tiles[0].getWidth(),
			base_map[0].length*tiles[0].getHeight()
		);
		this.graphics = (Graphics2D) graphical_map.getGraphics();
		generateMap();
	}
	
	public void draw(Graphics2D g){
		g.drawImage(graphical_map, 0, 0, wWidth, wHeight, null);
	}
	
	// it'll hardly be a maintainable code, sorry
	private void generateMap(){
		// this shit will eventually get out of hand
		for(int y=0; y < base_map.length; y++){
			for(int x=0; x < base_map[y].length; x++){
				if(base_map[y][x] == 'O'){
					_draw(x, y, 0);
				}else if(base_map[y][x] == '.'){
					_draw(x, y, 1);
				}else{
					_draw(x, y, 2);
				}
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
