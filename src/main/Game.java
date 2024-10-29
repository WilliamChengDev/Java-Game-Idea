package main;

/**
 * Constructs the game, and brings together components of the
 * game to one place.
 * 
 * @author williamcheng
 * @version 0.0.1
 */
public class Game implements Runnable{
	
	private GameWindow gameWindow; //JPanel object for drawing
	private GamePanel gamePanel; //JFrame object, contains JPanel
	private Thread gameThread; // thread for the game loop
	private final int FPS_SET = 120; //set the fps for the game
	
	/**
	 * Constructor for the game, creates JPanel and JFrame 
	 */
	public Game() {
		gamePanel = new GamePanel();
		gameWindow = new GameWindow(gamePanel);
		gamePanel.requestFocus(); //input focus on this gamePanel
		startGameLoop();
	}
	
	/**
	 * starts the game loop a new thread gameThread
	 */
	private void startGameLoop() {
		
		gameThread = new Thread(this);
		gameThread.start();
		
	}

	/**
	 * Contains code that should be run on a separate thread
	 * (game thread), controls and keeps track of refresh rates.
	 */
	@Override
	public void run() {
		
		double timePerFrame = 1000000000.0 / FPS_SET; //time per frame in nanoseconds
		long lastFrameTime = System.nanoTime(); //time of previous refresh
		long timeNow = System.nanoTime(); //current time
		
		int frames = 0; //FPS count
		long lastCheckTime = System.currentTimeMillis(); //last FPS check time		

		while(true){ //infinite loop
			
			timeNow = System.nanoTime(); //keep track of time
			/*
			 * loop for gamePanel refresh
			 */
			if(timeNow - lastFrameTime >= timePerFrame) { //if time for next
				gamePanel.repaint(); //refresh
				lastFrameTime = System.nanoTime(); //update last frame time
				frames++; //add 1 frame to total frames
			}
			
			/*
			 * loop for FPS count
			 */
			if(System.currentTimeMillis() - lastCheckTime >= 1000) { //1s since last check
				lastCheckTime = System.currentTimeMillis(); //reset lastCheckTime
				System.out.println("FPS: " + frames); //display FPS
				frames = 0; //reset frames
			}
			
		}
		
	}
	
}