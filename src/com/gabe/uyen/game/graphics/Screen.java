package com.gabe.uyen.game.graphics;

import java.util.Arrays;
import java.util.Random;

import com.gabe.uyen.game.entity.mob.Player;
import com.gabe.uyen.game.level.tile.Tile;

public class Screen {

	public int width, height;
	private Random random = new Random();

	public int[] pixels;
	public final int MAP_SIZE = 64;
	public final int MAP_SIZE_MASK = MAP_SIZE - 1;

	public int xOffset, yOffset;

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

	public void renderTile(int xp, int yp, Tile tile) {
		xp -= xOffset;
		yp -= yOffset;

		for (int y = 0; y < tile.sprite.SIZE; ++y) {
			int ya = y + yp;
			if (ya < 0 || ya >= height) continue;

			for (int x = 0; x < tile.sprite.SIZE; ++x) {
				int xa = x + xp;
				if (xa < 0 || xa >= width) continue;

				pixels[ya * width + xa] = tile.sprite.pixels[y * tile.sprite.SIZE + x];
			}
		}
	}

	public void renderPlayer(int xp, int yp, Sprite sprite) {
		xp -= xOffset;
		yp -= yOffset;

		for (int y = 0; y < 32; ++y) {
			int ya = y + yp;
			if (ya < 0 || ya >= height) continue;

			for (int x = 0; x < 32; ++x) {
				int xa = x + xp;
				if (xa < 0 || xa >= width) continue;

				int playerColor = sprite.pixels[y * 32 + x];
				
				if(playerColor != 0x00ffffff) pixels[ya * width + xa] = playerColor;
			}
		}

	}

	public void setOffset(int xOffset, int yOffset) {
		this.xOffset = xOffset;
		this.yOffset = yOffset;
	}

}
