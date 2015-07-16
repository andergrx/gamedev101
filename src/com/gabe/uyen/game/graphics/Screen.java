package com.gabe.uyen.game.graphics;

import java.util.Arrays;

public class Screen {

	private int width, height;

	public int[] pixels;

	public Screen(int width, int height) {
		this.width = width;
		this.height = height;
		pixels = new int[width * height];
	}

	public void clear() {
		Arrays.fill(pixels, 0);
	}

	public void render() {
		for (int y = 0; y < height; ++y) {
			for (int x = 0; x < width; ++x) {
				pixels[y * width + x] = 0xff00ff;
			}
		}

	}

}
