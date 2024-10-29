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
	
}
