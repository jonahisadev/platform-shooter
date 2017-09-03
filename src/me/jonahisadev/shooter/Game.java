package me.jonahisadev.shooter;

import com.amittaigames.engine.CoreGame;
import com.amittaigames.engine.graphics.Render;
import com.amittaigames.engine.graphics.Window;
import me.jonahisadev.shooter.block.Block;

public class Game extends CoreGame {
	
	public static void main(String[] args) {
		Window.init("Platform Shooter", 1280, 720, false, new Game());
	}
	
	@Override
	public void init() {
		Map.load("test");
	}
	
	@Override
	public void render(Render render) {
		render.clear(0, 128, 255);
		
		for (Block b : Map.getBlockList()) {
			render.drawRect(b.getRect());
		}
	}
	
	@Override
	public void update(float v) {
	
	}
	
	@Override
	public void cleanUp() {
	
	}
	
}
