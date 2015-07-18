package com.gabe.uyen.game.graphics;

public class Sprite {

	public final int SIZE;
	private int x, y;
	private SpriteSheet sheet;

	public int[] pixels;

	public static Sprite grass = new Sprite(16, 0, 0, SpriteSheet.tiles);

	public Sprite(int size, int x, int y, SpriteSheet sheet) {
		SIZE = size;
		pixels = new int[SIZE * SIZE];

		this.x = x * SIZE;
		this.y = y * SIZE;
		this.sheet = sheet;

		load();
	}

	private void load() {
		for (int y = 0; y < SIZE; ++y) {
			for (int x = 0; x < SIZE; ++x) {
				pixels[y * SIZE + x] = sheet.pixels[(this.x + x) + (this.y + y) * sheet.SIZE];
			}
		}
	}

}
