package com.gabe.uyen.game.level.tile.spawn_level;

import com.gabe.uyen.game.graphics.Screen;
import com.gabe.uyen.game.graphics.Sprite;
import com.gabe.uyen.game.level.tile.Tile;

public class SpawnHedgeTile extends Tile{

	public SpawnHedgeTile(Sprite sprite) {
		super(sprite);
	}

	public boolean solid() {
		return true;
	}

}
