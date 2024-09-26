package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import main.GamePanel;

class TestGamePanel {
	
	private static GamePanel gamePanel;
	
	@BeforeAll
	static void newGamePanel() {
		
		try {
			gamePanel = new GamePanel();
		} catch (Exception e) {
			fail(e.getMessage());
		}
		
	}
	
	@Test 
	void testGamePanel() {
		assertEquals(100, gamePanel.getXDelta(), "xDelta was not set to 100");
		assertEquals(100, gamePanel.getYDelta(), "yDelta was not set to 100");
	}

	@Test
	void testChangeXDelta() {
		
		gamePanel.changeXDelta(5);
		assertEquals(5, gamePanel.getXDelta(), "xDelta add was not correct");
		gamePanel.changeXDelta(-5);
		assertEquals(0, gamePanel.getXDelta(), "xDelta subtract was not correct");
		
	}
	
	@Test
	void testChangeYDelta() {
		
		gamePanel.changeYDelta(5);
		assertEquals(5, gamePanel.getYDelta(), "yDelta add was not correct");
		gamePanel.changeYDelta(-5);
		assertEquals(0, gamePanel.getYDelta(), "yDelta subtract was not correct");
		
	}
	
}
