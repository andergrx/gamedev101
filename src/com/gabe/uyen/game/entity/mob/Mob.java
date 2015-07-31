package com.gabe.uyen.game.entity.mob;

import java.util.ArrayList;
import java.util.List;

import com.gabe.uyen.game.entity.Entity;
import com.gabe.uyen.game.entity.projectile.PlayerProjectile;
import com.gabe.uyen.game.entity.projectile.Projectile;
import com.gabe.uyen.game.graphics.Sprite;

public abstract class Mob extends Entity {

	protected Sprite sprite;
	protected int dir = 0;
	protected boolean moving = false;
	
	protected List<Projectile> projectiles = new ArrayList<Projectile>();

	public void move(int xMove, int yMove) {
		if (xMove > 0) dir = 1;
		if (xMove < 0) dir = 3;
		if (yMove > 0) dir = 2;
		if (yMove < 0) dir = 0;

		if (!collision(xMove, 0)) {
			x += xMove;
		}

		if (!collision(0, yMove)) {
			y += yMove;
		}
	}

	public void update() {

	}

	public void render() {

	}

	protected void shoot(int x, int y, double dir) {
		//System.out.println("Angle: " + Math.toDegrees(dir));
		//dir = Math.toDegrees(dir);
		Projectile p = new PlayerProjectile(x,y,dir);
		projectiles.add(p);
		level.add(p);
		
	}

	private boolean collision(int xa, int ya) {
		boolean solid = false;

		for (int c = 0; c < 4; ++c) {
			int xt = ((x + xa) + c % 2 * 14 - 7) >> 4;
			int yt = ((y + ya) + c / 2 * 12 + 3) >> 4;

			if (level.getTile(xt, yt).solid()) solid = true;
		}
		// if (level.getTile((x + xa) / 16, (y + ya) / 16).solid()) solid =
		// true;

		return solid;
	}
}
