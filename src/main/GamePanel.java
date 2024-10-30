package main;

import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JPanel;
import inputs.KeyboardInputs;
import inputs.MouseInputs;
import models.Models;
import models.Sprite;


/**
 * GamePanel is an extension of a JPanel object that allows 
 * for objects to be painted on the screen. For GamePanel to
 * show, it has to be added to a GameWindow first.
 * 
 * @author williamcheng
 */
public class GamePanel extends JPanel {
	
	private MouseInputs mouseInputs; //inputs for the mouse
	private KeyboardInputs keyboardInputs; //inputs for keys pressed
	private Models models;
	/**
	 * Default constructor for GamePanel. Initializes input listeners.
	 * Graphics are initialized separately in paintComponent,
	 * JPanel's own constructor.
	 */
	public GamePanel() {
		
		this.setPanelSize(); //set playable area size
		
		this.models = new Models(); //load all characters
		
		/*adds a key listener to the JPanel, takes KeyListener*/
		keyboardInputs = new KeyboardInputs(this); //from inputs package
		addKeyListener(keyboardInputs);
		
		/*adds a mouse and mouse motion listener to JPanel*/
		mouseInputs = new MouseInputs(this);//from inputs package
		addMouseListener(mouseInputs);
		addMouseMotionListener(mouseInputs);
		
	}
	
	/**
	 * Sets the size of the JPanel object, not setting window size in 
	 * JFrame since that will include the top bar height if initialized
	 * in JFrame. 
	 */
	private void setPanelSize() {
		Dimension size = new Dimension(1280, 800); //resolution for 32 bit
		this.setMinimumSize(size); //only takes dimension object
		this.setMaximumSize(size);
		this.setPreferredSize(size);
	}

	/**
	 * Called on initialization of JPanel, used to draw  items
	 * on the screen. Graphics component allows us to draw to
	 * the panel. Method used to update the game panel!! 
	 * 
	 * @param Graphics object
	 */
	public void paintComponent(Graphics g) {
		/*Calls JPanel's (super method) own paintComponent 
		 * object to take care of initialization.*/
		super.paintComponent(g);
		/* img, xpos, ypos, width, height, observer */
		g.drawImage(models.getSprite("player").getSkin(), 
				models.getSprite("player").xPos(), 
				models.getSprite("player").yPos(),
				128, 80, null);
	}
	
}
