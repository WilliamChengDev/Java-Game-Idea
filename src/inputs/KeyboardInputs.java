package inputs;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import main.GamePanel;

/**
 * KeyListener object that listens for different keyboard inputs,
 * passed to JPanel objects as KeyListeners.
 * 
 * @author williamcheng
 */
public class KeyboardInputs implements KeyListener {
	
	private GamePanel gamePanel; //JPanel for the game
	/**
	 * constructor for Keyboard Inputs, takes in the gamePanel to access 
	 * the main gamePanel for the game.
	 * 
	 * @param gamePanel
	 */
	public KeyboardInputs(GamePanel gamePanel) {
		this.gamePanel = gamePanel;
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		switch (e.getKeyChar()) {
			case 'a':
				break;
			case 'd':
				break;
			default:
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
	}

}
