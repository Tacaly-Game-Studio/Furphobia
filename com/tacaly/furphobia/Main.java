package com.tacaly.furphobia;

import com.tacaly.furphobia.Window;

public class Main{
	public Window window;
	public Main(){
		javax.swing.SwingUtilities.invokeLater(new Runnable(){
			public void run(){
				window = new Window();
			}
		});
	}
	public static void main(String [] args){
		new Main();
	}
}