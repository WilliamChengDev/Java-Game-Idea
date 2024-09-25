package tests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import main.GamePanel;
import main.GameWindow;

class TestGameWindow{

	@Test
	void testGameWindow() {
		
		try {
			new GameWindow(new GamePanel());
		} catch(Exception e) {
			fail(e.getMessage());
		}

	}

}
