package main;

import javax.swing.JFrame;

/**
 * GameWindow class provides a frame using JFrame to house a 
 * GamePanel object. Also initializes settings such as screen
 * resolution, and additional window settings.
 * 
 * @author williamcheng
 */
public class GameWindow extends JFrame {
	
	private static int SCREEN_WIDTH = 400; //width of window
	private static int SCREEN_HEIGHT = 400; //height of window
	private static String GAME_TITLE = "2D Game"; //name of game 
	
	/**
	 * constructor for GameWindow, initializes screen 
	 * resolution and additional settings by constants set. 
	 * 
	 * @param gamePanel
	 */
	public GameWindow(GamePanel gamePanel) {
		
		this.setSize(SCREEN_WIDTH, SCREEN_HEIGHT); //400x400 resolution
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.add(gamePanel); //attaches gamePanel to gameFrame
		this.setTitle(GAME_TITLE); //set window title
		/*setVisible MUST be at the bottom*/
		this.setVisible(true); //show window 
		
	}
	
}
