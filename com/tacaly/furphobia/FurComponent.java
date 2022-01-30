package com.tacaly.furphobia;

import com.tacaly.furphobia.screens.Splash;

import javax.swing.JComponent;

import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.event.FocusListener;
import java.awt.event.FocusEvent;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsConfiguration;
import java.awt.image.VolatileImage;

public class FurComponent extends JComponent implements Runnable, KeyListener, FocusListener{
	private int width, height;
	private boolean focused = false;
	private Screen screen;
	private boolean running;
	private Thread main;
	
	public long fps;
	
	public FurComponent(int width, int height){
		this.width = width;
		this.height = height;
		
		this.fps = (long) 1000 / 24;
		
		this.setFocusable(true);
		this.setEnabled(true);
		this.requestFocus();
		addKeyListener(this);
		addFocusListener(this);
	}
	public void init(){
		main = new Thread(this,"game thread");
		toSplash();
		start();
	}
	
	public void start(){
		if(!running){
			running = true;
			main.start();
		}
	}
	
	public void stop(){
		running = false;
		
	}
	
	public void run(){
		GraphicsConfiguration graphicsConfiguration = getGraphicsConfiguration();
		VolatileImage vi = graphicsConfiguration.createCompatibleVolatileImage(width, height);
		Graphics2D gvi   = (Graphics2D) vi.getGraphics();
		Graphics2D g2d   = (Graphics2D) getGraphics();
		
		long timeStart = 0;
		long timeTaken = 0;
		long timeWait = 0;
		int skipped = 0;
		final int SKIP_LIMIT = 1;
		while(running){
			timeStart = System.currentTimeMillis();
			screen.tick();
			
			timeTaken = timeStart - System.currentTimeMillis();
			timeWait = fps - timeTaken;
			
			// skips frames whenever necessary
			if(timeWait > 5 || skipped > SKIP_LIMIT){
				skipped = 0;
				// renders offscreen
				screen.render(gvi);
				// now paints on screen
				g2d.drawImage(vi, 0, 0, null);
				
				timeTaken = timeStart - System.currentTimeMillis();
				timeWait = fps - timeTaken;
			}else{
				System.out.println(timeWait);
				skipped++;
			}
			try{
				Thread.sleep(timeWait);
			}catch(InterruptedException e){
				e.printStackTrace();
			}
		}
	}
	
	public void toSplash(){
		stop();
		screen = new Splash(this);
		screen.init();
		start();
	}
	
	public void focusGained(FocusEvent e){
		focused = true;
	}
	public void focusLost(FocusEvent e){
		focused = false;
	}
	
	@Override
	public void keyPressed(KeyEvent e){
		if(e.getKeyCode() == KeyEvent.VK_ESCAPE){
			System.exit(1);	
		}
		screen.keyDownHandler(e.getKeyCode());
	}
	@Override
	public void keyReleased(KeyEvent e){
		screen.keyUpHandler(e.getKeyCode());
	}
	@Override
	public void keyTyped(KeyEvent e){
	}
}