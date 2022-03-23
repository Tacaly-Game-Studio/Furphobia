package com.tacaly.furphobia;

import java.awt.image.BufferedImage;
import java.awt.Graphics2D;

public class Print{
	public static int scale = 1;
	private static int width = 7, height = 9;
	private static BufferedImage[] letters = _loadFont();
	// currently, text is bound to a grid and it can only be monospaced
	
	private static BufferedImage[] _loadFont(){
		BufferedImage font = Image.fromFile("com\\tacaly\\furphobia\\resources\\font.png");
		int rows = font.getWidth() / width;
		int columns = font.getHeight() / height;
		int nchars = rows * columns;
		BufferedImage[] chars = new BufferedImage[nchars];
		
		for(int i=0; i < nchars; i++){
			int _row = i % rows;
			int _column = i / rows;
			chars[i] = font.getSubimage(_row*width, _column*height, width, height);
		}
		return chars;
	}
	
	public static void print(String str, Graphics2D g, int x, int y){
		for(int ch=0; ch < str.length(); ch++){
			g.drawImage(
				letters[str.charAt(ch) - 32],
				x+ ch*width*scale, y*height*scale,
				letters[str.charAt(ch) - 32].getWidth() * scale, letters[str.charAt(ch) - 32].getHeight() * scale,
				null
			);
		}
	}
	public static void println(String s, Graphics2D g, int x, int y){
		String[] str = s.split("\n");
		for(int i=0; i< str.length; i++){
			print(str[i], g, x, y+i);
		}
	}
}
