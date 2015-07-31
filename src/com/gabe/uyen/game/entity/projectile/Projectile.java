package com.gabe.uyen.game.entity.projectile;

import com.gabe.uyen.game.entity.Entity;
import com.gabe.uyen.game.graphics.Sprite;

public abstract class Projectile extends Entity {
	
	protected final int xOrigin, yOrigin;
	protected double angle;
	protected double nx, ny;
	protected double speed, rateOfFire, range, damage;
	protected Sprite sprite;
		
	public Projectile(int x, int y, double dir) {
		xOrigin = x;
		yOrigin = y;
		angle = dir;
		this.x = x;
		this.y = y;
	}
	
	protected void move() {
	}

}
