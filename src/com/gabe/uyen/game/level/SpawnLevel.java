package com.gabe.uyen.game.level;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.gabe.uyen.game.level.tile.Tile;

public class SpawnLevel extends Level {

	//private int[] tiles;

	public SpawnLevel(String path) {
		super(path);
	}

	protected void loadLevel(String path) {
		try {
			BufferedImage image = ImageIO.read(SpawnLevel.class.getResource(path));
			width = image.getWidth();
			height = image.getHeight();
			tiles = new int[width * height];
			image.getRGB(0, 0, width, height, tiles, 0, width);
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Exception: Could not load level file!");
		}
	}

	// Grass = 0xff00
	// Flower = 0xffff00
	// Rock = 0x7f7f00
	protected void generateLevel() {

	}

}
