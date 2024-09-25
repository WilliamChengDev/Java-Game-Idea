package main;

/**
 * Constructs the game, and brings together components of the
 * game to one place.
 * 
 * @author williamcheng
 * @version 0.0.1
 */
public class Game {
	
	private GameWindow gameWindow; //JPanel object for drawing
	private GamePanel gamePanel; //JFrame object, contains JPanel
	
	/**
	 * Constructor for the game, creates JPanel and JFrame 
	 */
	public Game() {
		
		gamePanel = new GamePanel();
		gameWindow = new GameWindow(gamePanel);
		
	}
	
}
