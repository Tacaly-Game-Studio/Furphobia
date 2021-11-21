package com.tacaly.furphobia;

import com.tacaly.furphobia.FurComponent;

import javax.swing.JFrame;
import java.awt.image.BufferedImage;

public class Window extends JFrame{
	private int width = 600, height = 500;
	
	public FurComponent component;
	
	public Window (){
		new JFrame();
		setTitle("Furphobia");
		setIconImage(Image.fromFile("com\\tacaly\\furphobia\\res\\placeholder.png"));
		setSize(width, height);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		
		component = new FurComponent(width, height);
		
		setContentPane(component);
		
		setVisible(true);
		component.init();
	}
}
