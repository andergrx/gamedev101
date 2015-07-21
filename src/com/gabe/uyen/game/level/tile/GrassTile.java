package com.gabe.uyen.game.level.tile;

import com.gabe.uyen.game.graphics.Screen;
import com.gabe.uyen.game.graphics.Sprite;

public class GrassTile extends Tile {

	public GrassTile(Sprite sprite) {
		super(sprite);
	}
	
	public void render(int x, int y, Screen screen) {
		screen.renderTile(x << 4, y << 4, this);
	}

}