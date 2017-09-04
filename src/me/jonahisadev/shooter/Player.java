package me.jonahisadev.shooter;

import com.amittaigames.engine.graphics.Rect;
import com.amittaigames.engine.graphics.Sprite;
import com.amittaigames.engine.graphics.SpriteSheet;
import org.lwjgl.glfw.GLFW;

public class Player {
	
	private Sprite current_mesh;
	private Rect collision;
	
	private Sprite s_running;
	private Sprite s_standing;
	private SpriteState state;
	
	private int run_index = 0;
	private double run_time;
	
	private float speed = 15.0f;
	
	public enum SpriteState {
		STANDING,
		RUNNING,
	}
	
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
		
		state = SpriteState.STANDING;
		current_mesh = s_standing;
	}
	
	public void updateSprite() {
		if (state == SpriteState.RUNNING) {
			double current_time = GLFW.glfwGetTime();
			if (current_time >= run_time + 0.1) {
				if (run_index == 8)
					run_index = 0;
				int y = (int)(Math.floor(run_index / 4));
				int x = (run_index % 4);
				current_mesh.setImageLocation(x, y);
				run_index++;
				run_time = current_time;
			}
		} else {
			current_mesh.setImageLocation(0, 0);
		}
	}
	
	public void setSpriteState(SpriteState state) {
		if (state == SpriteState.STANDING) {
			s_standing.setPosition(current_mesh.getX(), current_mesh.getY());
			current_mesh = s_standing;
		} else if (state == SpriteState.RUNNING && this.state != SpriteState.RUNNING) {
			s_running.setPosition(current_mesh.getX(), current_mesh.getY());
			current_mesh = s_running;
			run_time = GLFW.glfwGetTime();
		}
		this.state = state;
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
