package com.tacaly.furphobia.mapgen;

public class MapGen{
	public int w, h;
	public int waypoints;
	public char[][] map;
	
	public MapGen(int w, int h){
		this.w = w;
		this.h = h;
		this.waypoints = 0;
		this.map = new char[w][h];
		generateMap();
	}
	public MapGen(int w, int h, int waypoints){
		this.w = w;
		this.h = h;
		this.waypoints = waypoints;
		this.map = new char[w][h];
		generateMap();
	}
	
	private void generateMap(){
		// waypoints where the generated path must cross
		int[][] coords;
		if(waypoints == 0){
			coords = new int[random(w>>2, (w+h)>>2)][2];
		}else{
			coords = new int[waypoints][2];
		}
		
		for(int i=0; i < coords.length; i++){
			coords[i] = makePoint();
		}
		
		// puts landmarks
		for(int i[]: coords){
			map[i[0]][i[1]] = 'O';
		}
		
		// generates paths between the points
		int i=0;
		int x=0, y=0;
		while(i <= coords.length-2){
			x = coords[i][0];
			y = coords[i][1];
			boolean drawing = true;
			while(drawing){
				if(x < coords[i+1][0]){
					x++;
				}else if(x > coords[i+1][0]){
					x--;
				}
				else{
					if(y < coords[i+1][1]){
						y++;
					}else if(y > coords[i+1][1]){
						y--;
					}
				}
				
				char c = map[x][y];
				if( c == 'O'){
				}else{
					map[x][y] = '.';
				}
				drawing = x != coords[i+1][0] || y != coords[i+1][1];
			}
			i++;
		}
	}
	
	private int random(int min, int max){
		return min + (int) Math.floor(Math.random() * (max-min));
	}
	private int[] makePoint(){
		return new int[]{
			random(0, w),
			random(0, h)
		};
	}
	
	// this is passed to the graphical map generator
	public char[][] getMap(){
		return map;
	}
	public void printMap(){
		for(char[] i: map){
			System.out.println(i);
		}
	}
}