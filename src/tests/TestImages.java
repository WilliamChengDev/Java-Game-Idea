package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import main.Images;

class TestImages{
	private Images images;

	@BeforeAll
	void testImages() {
		try {
			images = new Images();
		} catch(Exception e) {
			fail(e.getMessage());
		}
	}
	
	@Test
	void testGetImage() {
		BufferedImage img = images.getImg("/player_sprites.png");
		BufferedImage expected;
		InputStream is = getClass().getResourceAsStream("/player_sprites.png");
		try {
			expected = ImageIO.read(is);
		} catch (IOException e) {
			e.printStackTrace();
			expected = null;
		}
		assertEquals(expected, img);
	}

}
