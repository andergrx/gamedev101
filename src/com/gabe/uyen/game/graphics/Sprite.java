package com.gabe.uyen.game.graphics;

import java.util.Arrays;

public class Sprite {

	public final int SIZE;
	private int x, y;
	private SpriteSheet sheet;

	public int[] pixels;

	public static Sprite grass = new Sprite(16, 16, 4, SpriteSheet.spawnLevel);
	public static Sprite flower = new Sprite(16, 21, 15, SpriteSheet.spawnLevel);
	public static Sprite rock = new Sprite(16, 12, 4, SpriteSheet.spawnLevel);
	public static Sprite voidSprite = new Sprite(16, 0x1b34f2);
	
	//Spawn Level sprites
	
	public static Sprite spawnGrass = new Sprite(16, 7, 2, SpriteSheet.spawnLevel);
	public static Sprite spawnHedge = new Sprite(16, 16, 12, SpriteSheet.spawnLevel);
	public static Sprite spawnWater = new Sprite(16, 0, 6, SpriteSheet.spawnLevel);
	public static Sprite spawnWall1 = new Sprite(16, 7, 0, SpriteSheet.spawnLevel2);
	public static Sprite spawnWall2 = new Sprite(16, 0, 1, SpriteSheet.spawnLevel2);
	public static Sprite spawnFloor = new Sprite(16, 6, 5, SpriteSheet.spawnLevel2);
	
	//Player sprites
	private final static int PLAYER_POSITION_X = 7;
	private final static int PLAYER_POSITION_Y = 0;

	public static Sprite player_up = new Sprite(32, PLAYER_POSITION_X, PLAYER_POSITION_Y + 3, SpriteSheet.characters);
	public static Sprite player_up_1 = new Sprite(32, PLAYER_POSITION_X - 1, PLAYER_POSITION_Y + 3, SpriteSheet.characters);
	public static Sprite player_up_2 = new Sprite(32, PLAYER_POSITION_X + 1, PLAYER_POSITION_Y + 3, SpriteSheet.characters);

	public static Sprite player_down = new Sprite(32, PLAYER_POSITION_X, PLAYER_POSITION_Y, SpriteSheet.characters);
	public static Sprite player_down_1 = new Sprite(32, PLAYER_POSITION_X - 1, PLAYER_POSITION_Y, SpriteSheet.characters);
	public static Sprite player_down_2 = new Sprite(32, PLAYER_POSITION_X + 1, PLAYER_POSITION_Y, SpriteSheet.characters);

	public static Sprite player_left = new Sprite(32, PLAYER_POSITION_X, PLAYER_POSITION_Y + 1, SpriteSheet.characters);
	public static Sprite player_left_1 = new Sprite(32, PLAYER_POSITION_X - 1, PLAYER_POSITION_Y + 1, SpriteSheet.characters);
	public static Sprite player_left_2 = new Sprite(32, PLAYER_POSITION_X + 1, PLAYER_POSITION_Y + 1, SpriteSheet.characters);

	public static Sprite player_right = new Sprite(32, PLAYER_POSITION_X, PLAYER_POSITION_Y + 2, SpriteSheet.characters);
	public static Sprite player_right_1 = new Sprite(32, PLAYER_POSITION_X - 1, PLAYER_POSITION_Y + 2, SpriteSheet.characters);
	public static Sprite player_right_2 = new Sprite(32, PLAYER_POSITION_X + 1, PLAYER_POSITION_Y + 2, SpriteSheet.characters);
	
	//Projectile sprites
	public static Sprite projectilePlayer = new Sprite(16,0,0,SpriteSheet.projectilePlayer);

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
