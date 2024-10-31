package main;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;

import javax.imageio.ImageIO;

/**
 * Object to contain and sort a collection of images and animations
 * 
 * @author williamcheng
 */
public class Images {
	private HashMap<String, BufferedImage> imageCollection;
	private HashMap<String, BufferedImage[]> animationCollection;
	
	/**
	 * Constructor for Images, load all images here
	 */
	public Images(){
		imageCollection = new HashMap<String, BufferedImage>();
		animationCollection = new HashMap<>();
	}
	
	/**
	 * Loads an entire sprite sheet into images, and automatically separates all sprites
	 * into separate assets
	 */
	public void addSpriteSheet(String imgName, int width, int height, int row, int col) {
		this.addImg(imgName);
		BufferedImage sheet = this.getImg(imgName);
		
		for(int r = 0; r < row; r++) {
			for(int c = 0; c < col; c++) {
				imageCollection.put(imgName+ "(" + r + "," + c + ")", 
						sheet.getSubimage(c*64, r*40, width, height));
			}
		}
	}

	/**
	 * adds an image to the collection, finds the file with filename name,
	 * and automatically imports the image to the collection.
	 * 
	 * @param name
	 */
	public void addImg(String name) {
		InputStream is = getClass().getResourceAsStream("/player_sprites.png");
		BufferedImage img;
		/* must use try/catch when reading image, as it might fail */
		try {
			img = ImageIO.read(is);
		} catch (IOException e) {
			e.printStackTrace();
			/* img defaults to null if error */
			img = null;
		} finally {
			try {
				is.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		imageCollection.put(name, img);
	}
	
	/**
	 * removes an image resource from the collection with the name
	 * 
	 * @param name
	 */
	public void removeImage(String name) {
		imageCollection.remove(name);
	}
	
	/**
	 * gets the whole image resource associated with the name
	 * 
	 * @param name
	 * @return
	 */
	public BufferedImage getImg(String name) {
		if (imageCollection.containsKey(name)){
			return imageCollection.get(name);
		} else {
			return null;
		}
	}
	
	/**
	 * gets a section of the image resource associated with the name
	 * @param name
	 * @param x x position of top left corner of sub image
	 * @param y y position of top left corner of sub image
	 * @param w width of sub image
	 * @param h height of sub image
	 * @return
	 */
	public BufferedImage getSubImg(String name, int x, int y, int w, int h) {
		if (imageCollection.containsKey(name)){
			return imageCollection.get(name).getSubimage(x, y, w, h);
		} else {
			return null;
		} 
	}
	
	/**
	 * store sequenced images into an array to represent an animation, 
	 * stores arrays into an "animationCollection" dictionary.
	 * @param sheetName - name of the spriteSheet
	 * @param aniName - name of the animation
	 * @param row - row the animation is located on
	 * @param count - amount of frames of the animation
	 */
	public void createAnimation(String sheetName, String aniName, int row, int count) {
		BufferedImage[] animation = new BufferedImage[count];
		for(int i = 0; i < count; i++) {
			animation[i] = this.getImg(sheetName + "(" + row + "," + i + ")");
		}
		this.animationCollection.put(aniName, animation);
	}
	
	/**
	 * gets the animation array from the collection
	 * @param name
	 * @return
	 */
	public BufferedImage[] getAnimation(String name) {
		return animationCollection.get(name);
	}
}