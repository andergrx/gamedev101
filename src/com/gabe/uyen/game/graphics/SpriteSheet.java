package com.gabe.uyen.game.graphics;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class SpriteSheet {

	private String path;

	public final int SIZE;
	public int[] pixels;

	public static SpriteSheet spawnLevel = new SpriteSheet("/textures/sheets/map.jpg", 384);
	public static SpriteSheet spawnLevel2 = new SpriteSheet("/textures/sheets/terrain.jpg", 256);
	public static SpriteSheet characters = new SpriteSheet("/textures/monsters.gif", 384);
	public static SpriteSheet projectilePlayer = new SpriteSheet("/textures/sheets/projectiles/Player.png", 48);

	public SpriteSheet(String path, int size) {
		this.path = path;
		SIZE = size;
		pixels = new int[SIZE * SIZE];
		load();
	}

	private void load() {
		try {
			BufferedImage image = ImageIO.read(SpriteSheet.class.getResource(path));
			int w = image.getWidth();
			int h = image.getHeight();
			image.getRGB(0, 0, w, h, pixels, 0, w);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
