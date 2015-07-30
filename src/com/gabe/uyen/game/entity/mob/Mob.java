package com.gabe.uyen.game.entity.mob;

import com.gabe.uyen.game.entity.Entity;
import com.gabe.uyen.game.graphics.Sprite;

public abstract class Mob extends Entity {

	protected Sprite sprite;
	protected int dir = 0;
	protected boolean moving = false;

	public void move(int xMove, int yMove) {
		if (xMove > 0) dir = 1;
		if (xMove < 0) dir = 3;
		if (yMove > 0) dir = 2;
		if (yMove < 0) dir = 0;

		if (!collision(xMove, yMove)) {
			x += xMove;
			y += yMove;
		}
	}

	public void update() {

	}

	public void render() {

	}

	private boolean collision(int xa, int ya) {
		boolean solid = false;

		if (level.getTile((x + xa) / 16, (y + ya) / 16).solid()) solid = true;

		return solid;
	}
}
