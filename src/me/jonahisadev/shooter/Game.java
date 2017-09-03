package me.jonahisadev.shooter;

import com.amittaigames.engine.CoreGame;
import com.amittaigames.engine.graphics.*;
import com.amittaigames.engine.util.Keys;
import me.jonahisadev.shooter.block.Block;
import org.lwjgl.glfw.GLFW;
import org.lwjgl.opengl.GL11;

public class Game extends CoreGame {
	
	private Player player;
	private TexturedRect crosshair;
	
	public static void main(String[] args) {
		Window.enable("anti_alias");
		Window.init("Platform Shooter", 1280, 720, false, new Game());
	}
	
	@Override
	public void init() {
		Map.load("test");
		player = new Player(64, 64);
		
		crosshair = new TexturedRect(0, 0, 32, 32, "/textures/crosshair.png", false);
		Window.setCursorHidden(true);
	}
	
	@Override
	public void render(Render render) {
		// Background
		render.clear(0, 128, 255);
		
		// Blocks
		for (Block b : Map.getBlockList()) {
			render.drawRect(b.getRect());
		}
		
		// Player
		render.drawSprite(player.getMesh());
		
		// Crosshair
		render.drawTexturedRect(crosshair);
	}
	
	@Override
	public void update(float v) {
		// Player flip
		if (Window.getMouseX() < player.getMesh().getX() + (player.getMesh().getWidth() / 2)) {
			player.getMesh().flip(Sprite.FlipMode.HORIZONTAL);
		} else {
			player.getMesh().flip(Sprite.FlipMode.NONE);
		}
		
		// Crosshair Position
		crosshair.setPosition(Window.getMouseX() - 16, Window.getMouseY() - 16);
		
		// Player movement
		if (Window.isKeyDown(Keys.KEY_D)) {
			player.getMesh().translate(player.getSpeed() * v, 0);
		}
		if (Window.isKeyDown(Keys.KEY_A)) {
			player.getMesh().translate(-player.getSpeed() * v, 0);
		}
		if (Window.isKeyDown(Keys.KEY_W)) {
			player.getMesh().translate(0, -player.getSpeed() * v);
		}
		if (Window.isKeyDown(Keys.KEY_S)) {
			player.getMesh().translate(0, player.getSpeed() * v);
		}
		
		// Quit
		if (Window.isKeyDown(Keys.KEY_ESCAPE)) {
			Window.close();
		}
	}
	
	@Override
	public void cleanUp() {
	
	}
	
}
