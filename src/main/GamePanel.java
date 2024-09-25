package main;

import java.awt.Graphics;
import javax.swing.JPanel;
import inputs.KeyboardInputs;
import inputs.MouseInputs;


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
	protected int xDelta; //change in x
	protected int yDelta; //change in y
	
	/**
	 * Default constructor for GamePanel. Initializes input listeners.
	 * Graphics are initialized separately in paintComponent,
	 * JPanel's own constructor.
	 */
	public GamePanel() {
		xDelta = 0;
		yDelta = 0;
		
		/*adds a key listener to the JPanel, takes KeyListener*/
		keyboardInputs = new KeyboardInputs(this); //from inputs package
		addKeyListener(keyboardInputs);
		
		/*adds a mouse and mouse motion listener to JPanel*/
		mouseInputs = new MouseInputs();//from inputs package
		addMouseListener(mouseInputs);
		addMouseMotionListener(mouseInputs);
		
	}
	
	/**
	 * changes the xDelta by some value
	 * @param value
	 */
	public void changeXDelta(int value) {
		xDelta += value;
		repaint();
	}
	
	/**
	 * changes the yDelta by some value
	 * @param value
	 */
	public void changeYDelta(int value) {
		yDelta += value;
		repaint();
	}
	
	/**
	 * returns xDelta of GamePanel
	 * @return
	 */
	public int getXDelta() {
		return this.xDelta;
	}
	
	/**
	 * returns yDelta of GamePanel
	 * @return
	 */
	public int getYDelta() {
		return this.yDelta;
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
		
		g.fillRect(100 + xDelta, 100 + yDelta, 200, 50);
	}
	
}
