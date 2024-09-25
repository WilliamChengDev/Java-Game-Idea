package main;

import java.awt.Graphics;
import javax.swing.JPanel;
import inputs.KeyboardInputs;


/**
 * GamePanel is an extension of a JPanel object that allows 
 * for objects to be painted on the screen. For GamePanel to
 * show, it has to be added to a GameWindow first.
 * 
 * @author williamcheng
 */
public class GamePanel extends JPanel {
	
	/**
	 * Default constructor for GamePanel. Initializes key listeners.
	 * Graphics are initialized separately in paintComponent,
	 * JPanel's own constructor.
	 */
	public GamePanel() {
		
		/*adds a key listener to the JPanel, takes KeyListener*/
		addKeyListener(new KeyboardInputs()); //from inputs package
		
	}

	/**
	 * Called on initialization of JPanel, used to draw  items
	 * on the screen. Graphics component allows us to draw to
	 * the panel.
	 * 
	 * @param Graphics object
	 */
	public void paintComponent(Graphics g) {
		/*Calls JPanel's (super method) own paintComponent 
		 * object to take care of initialization.*/
		super.paintComponent(g);
		
		g.fillRect(100, 100, 200, 50);
	}
	
}
