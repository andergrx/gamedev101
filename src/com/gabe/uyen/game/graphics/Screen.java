package com.gabe.uyen.game.graphics;

import java.util.Arrays;
import java.util.Random;

public class Screen {

	private int width, height;
	private Random random = new Random();

	public int[] pixels;
	public final int MAP_SIZE = 64;
	public final int MAP_SIZE_MASK = MAP_SIZE - 1;

	public int[] tiles = new int[MAP_SIZE * MAP_SIZE];

	public Screen(int width, int height) {
		this.width = width;
		this.height = height;
		pixels = new int[width * height];

		for (int i = 0; i < MAP_SIZE * MAP_SIZE; ++i) {
			tiles[i] = random.nextInt(0xffffff);
		}
	}

	public void clear() {
		Arrays.fill(pixels, 0);
	}

	public void render(int xo, int yo) {
		for (int y = 0; y < height; ++y) {
			int yp = y + yo;
			if(yp < 0 || yp >= height) continue;
			
			for (int x = 0; x < width; ++x) {
				int xp = x + xo;
				if(xp < 0 || xp >= width) continue;
				
				pixels[yp * width + xp] = Sprite.grass.pixels[(x & 15) + (y & 15) * Sprite.grass.SIZE];
			}
		}

	}

}
