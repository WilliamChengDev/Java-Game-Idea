package inputs;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * KeyListener object that listens for different keyboard inputs,
 * passed to JPanel objects as KeyListeners.
 * 
 * @author williamcheng
 */
public class KeyboardInputs implements KeyListener {

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
		System.out.println("a key was pressed");
	}

}
