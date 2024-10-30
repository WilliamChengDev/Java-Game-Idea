package models;

/**
 * Object for the main character of the game
 * 
 * @author williamcheng
 */
public class Player extends Sprite{

	public Player(String name, String spriteSheet) {
		super(name, spriteSheet);
		this.skin("/player_sprites.png(0,0)");
	}
	
	public Player(String name, int xPos, int yPos, String spriteSheet) {
		super(name, xPos, yPos, spriteSheet);
		this.skin("/player_sprites.png(0,0)");
	}
	
}