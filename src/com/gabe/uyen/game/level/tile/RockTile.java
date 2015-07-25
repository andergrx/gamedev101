package com.gabe.uyen.game.level.tile;

import com.gabe.uyen.game.graphics.Screen;
import com.gabe.uyen.game.graphics.Sprite;

public class RockTile extends Tile {
	
	public RockTile(Sprite sprite) {
		super(sprite);
	}
	
	public void render(int x, int y, Screen screen) {
		screen.renderTile(x << 4, y << 4, this);
	}

	public boolean solid() {
		return true;
	}
}
