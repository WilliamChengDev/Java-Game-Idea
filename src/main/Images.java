package main;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;

import javax.imageio.ImageIO;

/**
 * Object to contain and sort a collection of images
 * 
 * @author williamcheng
 */
public class Images {
	private HashMap<String, BufferedImage> imageCollection;
	
	/**
	 * Constructor for Images, load all images here
	 */
	public Images(){
		imageCollection = new HashMap<String, BufferedImage>();
//		this.addSpriteSheet("/player_sprites.png", 
//							64, 40, 9, 6); //64x40 based sheet
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
	
}