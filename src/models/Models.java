package models;

import java.util.HashMap;

/**
 * Collection of all the Sprites in the game
 */
public class Models {
	
	public static HashMap<String, Sprite> models;
	private Player player; //playable character
	
	/**
	 * constructor for models, initialize all sprites here
	 */
	public Models() {
		
		models = new HashMap<String, Sprite>();
		this.player = new Player("player", 100, 100, "/player_sprites.png");
		addSprite(player);
		
	}
	
	/**
	 * add a sprite to the collection
	 * @param s
	 */
	public void addSprite(Sprite s) {
		models.put(s.getName(), s);
	}
	
	/**
	 * gets the Sprite by name
	 * @param name
	 */
	public Sprite getSprite(String name) {
		return models.get(name);
	}
	
	/**
	 * removes a sprite from the collection
	 * 
	 * @param name
	 */
	public void removeSprite(String name) {
		models.remove(name);
	}
}