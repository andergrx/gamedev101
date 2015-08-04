package com.gabe.uyen.game.entity.projectile;

import com.gabe.uyen.game.graphics.Screen;
import com.gabe.uyen.game.graphics.Sprite;

public class PlayerProjectile extends Projectile {

	public PlayerProjectile(int x, int y, double dir) {
		super(x, y, dir);
		range = 200;
		speed = 4;
		damage = 20;
		rateOfFire = 15;
		sprite = Sprite.projectilePlayer;

		nx = speed * Math.cos(angle);
		ny = speed * Math.sin(angle);
	}

	public void update() {
		move();
	}

	protected void move() {
		x += nx;
		y += ny;

		if (distance() > range) remove();
		//System.out.println("Distance: " + distance());
	}

	private double distance() {
		double distance = 0;

		distance = Math.sqrt(Math.pow(xOrigin - x, 2) + Math.pow(yOrigin - y, 2));

		return distance;
	}

	public void render(Screen screen) {
		screen.renderProjectile((int) x - 12, (int) y, this);
	}

}
