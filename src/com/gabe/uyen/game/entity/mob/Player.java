package com.gabe.uyen.game.entity.mob;

import com.gabe.uyen.game.Game;
import com.gabe.uyen.game.entity.projectile.PlayerProjectile;
import com.gabe.uyen.game.entity.projectile.Projectile;
import com.gabe.uyen.game.graphics.Screen;
import com.gabe.uyen.game.graphics.Sprite;
import com.gabe.uyen.game.input.Keyboard;
import com.gabe.uyen.game.input.Mouse;

public class Player extends Mob {

	private Keyboard input;
	private Sprite sprite;
	private int anim = 0;
	private boolean walking = false;
	
	private int fireRate = 0;
	
	public Player(Keyboard input) {
		this.input = input;
		sprite = Sprite.player_up;
	}

	public Player(int x, int y, Keyboard input) {
		this.x = x;
		this.y = y;
		this.input = input;
		sprite = Sprite.player_up;
		fireRate = PlayerProjectile.FIRE_RATE;
	}

	private void updateShooting() {

		if (Mouse.getButton() == 1 && fireRate == 0) {
			double dx = Mouse.getX() - Game.getWindowWidth() / 2;
			double dy = Mouse.getY() - Game.getWindowHeight() / 2;
			double dirAngle = Math.atan2(dy, dx);
			shoot(x, y, dirAngle);
			fireRate = PlayerProjectile.FIRE_RATE;
		}
	}

	private void clear() {
		for (int i = 0; i < level.getProjectiles().size(); ++i) {
			Projectile p = level.getProjectiles().get(i);
			if (p.isRemoved()) level.getProjectiles().remove(i);
		}
	}

	public void update() {
		int xa = 0, ya = 0;

		if(fireRate > 0) fireRate--;
		
		if (anim < 65536) ++anim;
		else anim = 0;

		if (input.up) --ya;
		if (input.down) ++ya;
		if (input.left) --xa;
		if (input.right) ++xa;

		if (xa != 0 || ya != 0) {
			move(xa, ya);
			walking = true;
		} else {
			walking = false;
		}

		clear();
		updateShooting();
	}

	public void render(Screen screen) {
		if (dir == 0) {
			sprite = Sprite.player_up;
			if (walking) {
				if (anim % 20 > 10) {
					sprite = Sprite.player_up_1;
				} else {
					sprite = Sprite.player_up_2;
				}
			}
		} else if (dir == 1) {
			sprite = Sprite.player_right;
			if (walking) {
				if (anim % 20 > 10) {
					sprite = Sprite.player_right_1;
				} else {
					sprite = Sprite.player_right_2;
				}
			}
		} else if (dir == 2) {
			sprite = Sprite.player_down;
			if (walking) {
				if (anim % 20 > 10) {
					sprite = Sprite.player_down_1;
				} else {
					sprite = Sprite.player_down_2;
				}
			}
		} else if (dir == 3) {
			sprite = Sprite.player_left;
			if (walking) {
				if (anim % 20 > 10) {
					sprite = Sprite.player_left_1;
				} else {
					sprite = Sprite.player_left_2;
				}
			}
		}

		screen.renderPlayer(x - 16, y - 16, sprite);
	}
}
