package models;

import java.awt.image.BufferedImage;

import main.Images;

/**
 * Character object includes basic operations for all characters in the 
 * game.
 * 
 * @author williamcheng
 */
public class Sprite implements Model{
	
	private Images images; //collection of sprites
	private BufferedImage look; //current look of sprite
	protected int xPos; //position x
	protected int yPos; //position y
	private String name; //name of character

	/**
	 * constructor for a character, default position 0,0
	 * 
	 * @param String name - name of the character
	 * @param BufferedImage spriteSheet - sprite's images 64x40
	 */
	public Sprite(String name, String spriteSheet) {
		this.name = name;
		this.xPos = 0;
		this.yPos = 0;
		if(spriteSheet != null) { //initialize spriteSheet
			initializeSprites(spriteSheet);			
		}
	}

	/**
	 * constructor with non-default position
	 * @param name - name of sprite
	 * @param xPos - x coordinate of sprite
	 * @param yPos - y coordinate of sprite
	 * @param BufferedImage spriteSheet - images for sprite
	 */
	public Sprite(String name, int xPos, int yPos, String spriteSheet) {
		this.name = name;
		this.xPos = xPos;
		this.yPos = yPos;
		if(spriteSheet != null) {
			initializeSprites(spriteSheet);			
		}
	}
	
	/**
	 * helper constructor method, initializes and loads all sprite
	 * images into Images collection
	 * 
	 * @param String spriteSheet - address to spriteSheet
	 */
	private void initializeSprites(String spriteSheet) {
		images = new Images(); //initialize image store
		images.addSpriteSheet(spriteSheet, 64, 40, 9, 6);
	}
	
	/**
	 * Sets the appearance of the sprite to a certain look
	 * 
	 * @param String name - name of the look
	 */
	public void skin(String name) {
		this.look = images.getImg(name);
	}
	
	/**
	 * returns the current appearance of the sprite
	 * 
	 * @return - BufferedImage object of the current appearance
	 */
	public BufferedImage getSkin() {
		return this.look;
	}
	
	/**
	 * returns the Images object containing all sprite images
	 * @return
	 */
	public Images getImages() {
		return images;
	}
	
	/**
	 * moves the character to the right
	 */
	@Override
	public void moveRight() {
		xPos++;
	}
	
	/**
	 * moves the character to the left
	 */
	@Override
	public void moveLeft() {
		xPos--;
	}

	@Override
	public void jump() {
		// TODO Auto-generated method stub
		
	}

	/**
	 * gets the current x position of the character
	 */
	@Override
	public int xPos() {
		return xPos;
	}
	
	/**
	 * gets the current y position of the character
	 */
	@Override
	public int yPos() {
		return yPos;
	}

	/**
	 * changes/sets the name of the character
	 * @param 
	 */
	@Override
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * returns the name of the character
	 */
	@Override
	public String getName() {
		return name;
	}
	
}