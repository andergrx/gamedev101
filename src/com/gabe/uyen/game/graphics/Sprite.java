package com.gabe.uyen.game.graphics;

import java.util.Arrays;

public class Sprite {

	public final int SIZE;
	private int x, y;
	private SpriteSheet sheet;

	public int[] pixels;

	public static Sprite grass = new Sprite(16, 5, 3, SpriteSheet.tiles);
	public static Sprite voidSprite = new Sprite(16, 0x1b34f2);
	
	public static Sprite player0 = new Sprite(16, 4, 0, SpriteSheet.characters);
	public static Sprite player1 = new Sprite(16, 3, 3, SpriteSheet.characters);
	public static Sprite player2 = new Sprite(16, 5, 0, SpriteSheet.characters);
	public static Sprite player3 = new Sprite(16, 1, 8, SpriteSheet.characters);

	public Sprite(int size, int x, int y, SpriteSheet sheet) {
		SIZE = size;
		pixels = new int[SIZE * SIZE];

		this.x = x * SIZE;
		this.y = y * SIZE;
		this.sheet = sheet;

		load();
	}

	public Sprite(int size, int color) {
		SIZE = size;
		pixels = new int[SIZE * SIZE];

		setColor(color);
	}

	private void setColor(int color) {
		Arrays.fill(pixels, color);
	}

	private void load() {
		for (int y = 0; y < SIZE; ++y) {
			for (int x = 0; x < SIZE; ++x) {
				pixels[y * SIZE + x] = sheet.pixels[(this.x + x) + (this.y + y) * sheet.SIZE];
			}
		}
	}

}
