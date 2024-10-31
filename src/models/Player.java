package models;

/**
 * Object for the main character of the game
 * 
 * @author williamcheng
 */
public class Player extends Sprite{
	
	private int SPEED = 10; //movement speed
	
	/**
	 * Constructor for the player, sets up sprite object and loads all states from 
	 * sprite sheet into the images object
	 * @param name - name of the Sprite
	 * @param xPos - x position of the sprite
	 * @param yPos - y position of the sprite
	 * @param spriteSheet - sprite images
	 */
	public Player(String name, int xPos, int yPos, String spriteSheet) {
		super(name, xPos, yPos, spriteSheet);
		loadAnimations();
		this.setAni("idleAni"); //default animation on load
	}
	
	/**
	 * Construct animation arrays for the sprite
	 */
	private void loadAnimations() {
		this.getImages().createAnimation("/player_sprites.png", "idleAni", 0, 5);
		this.getImages().createAnimation("/player_sprites.png", "runAni", 1, 6);
	}

	/**
	 * moves the character to the right
	 */
	@Override
	public void moveRight() {
		super.xPos += SPEED;
	}
	
	/**
	 * moves the character to the left
	 */
	@Override
	public void moveLeft() {
	super.xPos -= SPEED;
	}
}