package com.gabe.uyen.game.level.tile;

import com.gabe.uyen.game.graphics.Screen;
import com.gabe.uyen.game.graphics.Sprite;
import com.gabe.uyen.game.level.tile.spawn_level.SpawnFloorTile;
import com.gabe.uyen.game.level.tile.spawn_level.SpawnGrassTile;
import com.gabe.uyen.game.level.tile.spawn_level.SpawnHedgeTile;
import com.gabe.uyen.game.level.tile.spawn_level.SpawnWallTile;
import com.gabe.uyen.game.level.tile.spawn_level.SpawnWaterTile;

public class Tile {
	
	public int x, y;
	public Sprite sprite;
	
	public static Tile grass = new GrassTile(Sprite.grass);
	public static Tile flower = new FlowerTile(Sprite.flower);
	public static Tile rock = new RockTile(Sprite.rock);
	public static Tile voidTile = new VoidTile(Sprite.voidSprite);
	
	public static Tile spawnGrass = new SpawnGrassTile(Sprite.spawnGrass);
	public static Tile spawnHedge = new SpawnHedgeTile(Sprite.spawnHedge);
	public static Tile spawnWater = new SpawnWaterTile(Sprite.spawnWater);
	public static Tile spawnWall1 = new SpawnWallTile(Sprite.spawnWall1);
	public static Tile spawnWall2 = new SpawnWallTile(Sprite.spawnWall2);
	public static Tile spawnFloor = new SpawnFloorTile(Sprite.spawnFloor);
	
	public static final int SPAWN_GRASS_COLOR = 0xff00ff00;
	public static final int SPAWN_HEDGE_COLOR = 0;
	public static final int SPAWN_WATER_COLOR = 0;
	public static final int SPAWN_WALL1_COLOR = 0xff6c6c6c;
	public static final int SPAWN_WALL2_COLOR = 0xff000000;
	public static final int SPAWN_FLOOR_COLOR = 0xff432301;
	
	
	public Tile(Sprite sprite) {
		this.sprite = sprite;
	}
	
	public void render(int x, int y, Screen screen) {
		
	}
	
	public boolean solid() {
		return false;
	}

}
