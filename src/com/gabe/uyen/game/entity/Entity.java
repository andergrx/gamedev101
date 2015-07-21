package com.gabe.uyen.game.entity;

import java.util.Random;

import com.gabe.uyen.game.graphics.Screen;
import com.gabe.uyen.game.level.Level;

public abstract class Entity {
	
	public int x, y;
	
	protected Level level;
	final protected Random random = new Random();
	
	private boolean removed = false;
	
	public void update() {
		
	}
	
	public void render(Screen screen) {
		
	}
	
	public void remove() {
		//Remove from level
		removed = true;
	}
	
	public boolean isRemoved() {
		return removed;
	}

}
