package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import main.Game;

class TestGame {

	@Test
	void testGame() {
		
		try{
			new Game();
		} catch (Exception e) {
			fail(e.getMessage());
		}
		
	}

}
