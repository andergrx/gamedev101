package com.gabe.uyen.game.level;

import java.util.Random;

public class RandomLevel extends Level {

	private final Random random = new Random();

	public RandomLevel(int width, int height) {
		super(width, height);
		// TODO Auto-generated constructor stub
	}

	protected void generateLevel() {
		for (int y = 0; y < height; ++y) {
			for (int x = 0; x < width; ++x) {
				tiles[y * width + x] = random.nextInt(4);
			}
		}
	}

}