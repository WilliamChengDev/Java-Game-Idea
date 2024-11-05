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
	private final int UPS_SET = 200; //set the fps for the game
	
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
		double timePerUpdate = 1000000000.0 / UPS_SET; //time per update in nanoseconds

		long previousTime = System.nanoTime(); //time at last check
		
		int frames = 0; //FPS count
		int updates = 0; //UPS count
		long lastCheckTime = System.currentTimeMillis(); //last FPS check time		

		/*updates needed, keeps track of updates missed*/
		double deltaU = 0; 
		/*frames needed, keeps track of frames missed*/
		double deltaF = 0;
		
		while(true){ //infinite loop

			long currentTime = System.nanoTime(); //time now
			
			/* 
			 * will = 1.0 when it is exactly time to update,
			 * will be < 1.0 when not yet updating, 
			 * and will be > 1.0 when it is past time to update.
			 */
			deltaU += (currentTime - previousTime) / timePerUpdate;
			deltaF += (currentTime - previousTime) / timePerFrame;
			previousTime = currentTime; //reset delta
			
			/*
			 * loop for logic tick updates, refreshes when 
			 * the difference of updates has reached 1
			 */
			if(deltaU >= 1) {
				update();
				updates++; //count 1 update
				deltaU--; //subtract one deltaU
			}
			
			/*
			 * loop for gamePanel refresh, refreshes when
			 * the difference of frames has reached 1.
			 */
			if(deltaF >= 1) {
				gamePanel.repaint(); //re-render
				frames++; //count 1 frame
				deltaF--; //subtract one deltaF
			}
			
			/*
			 * loop for FPS | UPS count
			 */
			if(System.currentTimeMillis() - lastCheckTime >= 1000) { //1s since last check
				lastCheckTime = System.currentTimeMillis(); //reset lastCheckTime
				System.out.println("FPS: " + frames + " | UPS: " + updates); //display FPS
				frames = 0; //reset frames
				updates = 0; //reset updates
			}
			
		}
		
	}

	/**
	 * updates to do that rely on tick
	 */
	private void update() {
		gamePanel.updateAnimationTick();
	}
	
}