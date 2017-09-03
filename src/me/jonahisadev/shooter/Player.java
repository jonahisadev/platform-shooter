package me.jonahisadev.shooter;

import com.amittaigames.engine.graphics.Rect;
import com.amittaigames.engine.graphics.Sprite;
import com.amittaigames.engine.graphics.SpriteSheet;

public class Player {
	
	private Sprite current_mesh;
	private Rect collision;
	
	private Sprite s_running;
	private Sprite s_standing;
	
	private float speed = 15.0f;
	
	public Player(int x, int y) {
		// Running
		SpriteSheet ss = new SpriteSheet("/textures/player_running.png", 32, 32, 0, false);
		ss.createSprite(x, y, 64, 64, 0, 0);
		s_running = ss.getSpriteByIndex(0);
		s_running.setCustomRender(true);
		
		// Standing
		ss = new SpriteSheet("/textures/player_standing.png", 32, 32, 0, false);
		ss.createSprite(x, y, 64, 64, 0, 0);
		s_standing = ss.getSpriteByIndex(0);
		s_standing.setCustomRender(true);
		
		current_mesh = s_standing;
	}
	
	public Sprite getMesh() {
		return current_mesh;
	}
	
	public Rect getCollision() {
		return collision;
	}
	
	public float getSpeed() {
		return speed;
	}
	
}
