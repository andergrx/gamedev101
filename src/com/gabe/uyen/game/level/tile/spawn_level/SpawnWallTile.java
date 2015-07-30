package com.gabe.uyen.game.level.tile.spawn_level;

import com.gabe.uyen.game.graphics.Sprite;
import com.gabe.uyen.game.level.tile.Tile;

public class SpawnWallTile extends Tile {

	public SpawnWallTile(Sprite sprite) {
		super(sprite);
	}

	public boolean solid() {
		return true;
	}

}
