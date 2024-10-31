package models;

/**
 * Object for the main character of the game
 * 
 * @author williamcheng
 */
public class Player extends Sprite{
	
	private int SPEED = 5; //movement speed

	public Player(String name, String spriteSheet) {
		super(name, spriteSheet);
		this.skin("/player_sprites.png(0,0)");
	}
	
	public Player(String name, int xPos, int yPos, String spriteSheet) {
		super(name, xPos, yPos, spriteSheet);
		this.skin("/player_sprites.png(0,0)");
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