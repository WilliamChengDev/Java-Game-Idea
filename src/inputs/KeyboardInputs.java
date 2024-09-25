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
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
		switch(e.getKeyCode()) {
		case KeyEvent.VK_W:
			System.out.println("up");
			gamePanel.changeYDelta(-5);
			break;
		case KeyEvent.VK_A:
			System.out.println("left");
			gamePanel.changeXDelta(-5);
			break;
		case KeyEvent.VK_S:
			System.out.println("down");
			gamePanel.changeYDelta(5);
			break;
		case KeyEvent.VK_D:
			System.out.println("right");
			gamePanel.changeXDelta(5);
			break;
		default:
			break;
		}
		
	}

}
