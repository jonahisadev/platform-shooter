package me.jonahisadev.shooter.block;

import com.amittaigames.engine.graphics.Rect;

public abstract class Block {
	
	protected Rect rect;
	
	public static final float SIZE = 20.0f;
	
	public Block(int x, int y) {
		this.rect = new Rect(x * SIZE, y * SIZE, SIZE, SIZE);
	}
	
	public Rect getRect() {
		return rect;
	}
	
}
