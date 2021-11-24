package com.tacaly.furphobia;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Image{
	public static BufferedImage fromFile(String path){
		BufferedImage sprite = null;
		
		try{
			// creates path to file and loads it as an image
			sprite = ImageIO.read( new File(path) );
		}catch (IOException e){
			System.err.print("image not found:\n\t>" + path + "\0");
		}
		return sprite;
	}
	
	public static BufferedImage getSprite(BufferedImage img, int x, int y, int width, int height){
		return img.getSubimage(x, y, width, height);
	}
}
