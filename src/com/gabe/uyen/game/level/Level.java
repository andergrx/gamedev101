package com.gabe.uyen.game.level;

import java.util.ArrayList;
import java.util.List;

import com.gabe.uyen.game.entity.Entity;
import com.gabe.uyen.game.entity.projectile.Projectile;
import com.gabe.uyen.game.graphics.Screen;
import com.gabe.uyen.game.level.tile.Tile;

public class Level {

	protected int width, height;
	protected int[] tilesInt;
	protected int[] tiles;
	public static Level spawn = new SpawnLevel("/levels/Spawn.png");

	private List<Entity> entities = new ArrayList<Entity>();
	private List<Projectile> projectiles = new ArrayList<Projectile>();

	public Level(int width, int height) {
		this.width = width;
		this.height = height;

		generateLevel();
	}

	public Level(String path) {
		loadLevel(path);

		generateLevel();
	}

	protected void generateLevel() {

	}

	protected void loadLevel(String path) {

	}

	public List<Projectile> getProjectiles() {
		return projectiles;
	}

	public void update() {
		for (int i = 0; i < entities.size(); ++i) {
			entities.get(i).update();
		}

		for (int i = 0; i < projectiles.size(); ++i) {
			projectiles.get(i).update();
		}
	}

	private void time() {

	}

	public boolean tileCollision(double x, double y, double xa, double ya, int size) {
		boolean solid = false;

		for (int c = 0; c < 4; ++c) {
			double xt = ((x + xa) + c % 2 * size / 2 - 7) / 16;
			double yt = ((y + ya) + c / 2 * size / 2 + 6) / 16;

			if (getTile((int) xt, (int) yt).solid()) solid = true;
		}
		// if (level.getTile((x + xa) / 16, (y + ya) / 16).solid()) solid =
		// true;

		return solid;
	}

	public void render(int xScroll, int yScroll, Screen screen) {
		screen.setOffset(xScroll, yScroll);
		int x0 = xScroll >> 4;
		int x1 = (xScroll + screen.width + 16) >> 4;
		int y0 = yScroll >> 4;
		int y1 = (yScroll + screen.height + 16) >> 4;

		for (int y = y0; y < y1; ++y) {
			for (int x = x0; x < x1; ++x) {
				getTile(x, y).render(x, y, screen);
			}
		}

		for (int i = 0; i < entities.size(); ++i) {
			entities.get(i).render(screen);
		}

		for (int i = 0; i < projectiles.size(); ++i) {
			projectiles.get(i).render(screen);
		}

	}

	public void add(Entity e) {
		entities.add(e);
	}

	public void addProjectile(Projectile p) {
		p.init(this);
		projectiles.add(p);
	}

	public Tile getTile(int x, int y) {
		if (x < 0 || y < 0 || x >= width || y >= height) return Tile.voidTile;
		// if (y * width + x < 0 || y * width + x >= tiles.length) return
		// Tile.voidTile;
		if ((tiles[y * width + x] & 0xffffff) == Tile.SPAWN_GRASS_COLOR) return Tile.spawnGrass;
		if ((tiles[y * width + x] & 0xffffff) == Tile.SPAWN_HEDGE_COLOR) return Tile.spawnHedge;
		if ((tiles[y * width + x] & 0xffffff) == Tile.SPAWN_WATER_COLOR) return Tile.spawnWater;
		if ((tiles[y * width + x] & 0xffffff) == Tile.SPAWN_WALL1_COLOR) return Tile.spawnWall1;
		if ((tiles[y * width + x] & 0xffffff) == Tile.SPAWN_WALL2_COLOR) return Tile.spawnWall2;
		if ((tiles[y * width + x] & 0xffffff) == Tile.SPAWN_FLOOR_COLOR) return Tile.spawnFloor;

		return Tile.voidTile;

	}

}
