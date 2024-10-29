package main;

import java.awt.Color;
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
	private float xDelta; //change in x
	private float yDelta; //change in y
	private float xDir = 1f; //x direction for rect
	private float yDir = 1f; //y direction for rect
	private int frames; //fps count
	private long lastCheck; //last time fps was checked
	private Color rectColor = new Color(168, 60, 77);	
	/**
	 * Default constructor for GamePanel. Initializes input listeners.
	 * Graphics are initialized separately in paintComponent,
	 * JPanel's own constructor.
	 */
	public GamePanel() {
		xDelta = 100;
		yDelta = 100;
		
		/*adds a key listener to the JPanel, takes KeyListener*/
		keyboardInputs = new KeyboardInputs(this); //from inputs package
		addKeyListener(keyboardInputs);
		
		/*adds a mouse and mouse motion listener to JPanel*/
		mouseInputs = new MouseInputs(this);//from inputs package
		addMouseListener(mouseInputs);
		addMouseMotionListener(mouseInputs);
		
	}
	
	/**
	 * changes the xDelta by some value
	 * @param value
	 */
	public void changeXDelta(int value) {
		xDelta += value;
	}
	
	/**
	 * changes the yDelta by some value
	 * @param value
	 */
	public void changeYDelta(int value) {
		yDelta += value;
	}
	
	/**
	 * returns xDelta of GamePanel
	 * @return
	 */
	public float getXDelta() {
		return this.xDelta;
	}
	
	/**
	 * returns yDelta of GamePanel
	 * @return
	 */
	public float getYDelta() {
		return this.yDelta;
	}
	
	/**
	 * sets the position of the rectangle to a coordinate
	 * @param x
	 * @param y
	 */
	public void setRectPos(int x, int y) {
		this.xDelta = x;
		this.yDelta = y;
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
		
		updateRectangle(); //update rect position
		g.setColor(rectColor);
		g.fillRect((int) xDelta, (int) yDelta, 200, 50);
	
	}

	/**
	 * updates the position of the rectangle per refresh
	 */
	private void updateRectangle() {
		xDelta += xDir;
		/*
		 * reverses the x direction rectangle is moving in when
		 * rectangle goes out of screen.
		 */
		if(xDelta > 400 || xDelta < 0) {
			xDir *= -1;
			rectColor = getRndColor();
		}
		/*
		 * reverses the y direction rectangle is moving in when
		 * rectangle goes out of screen.
		 */
		yDelta += yDir;
		if(yDelta > 400 || yDelta < 0) {
			yDir *= -1;
			rectColor = getRndColor();
		}
	}

	/*
	 * returns a Color object with a random rgb value
	 */
	private Color getRndColor() {
		Color rndColor = new Color(
				(int) (Math.random()*255), 
				(int) (Math.random()*255), 
				(int) (Math.random()*255)
				);
		return rndColor;
	}
	
}
