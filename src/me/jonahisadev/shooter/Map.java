package me.jonahisadev.shooter;

import me.jonahisadev.shooter.block.Block;
import me.jonahisadev.shooter.block.Wall;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

public class Map {

	private static List<Block> list = new ArrayList<>();
	
	public static void load(String name) {
		try {
			BufferedImage img = ImageIO.read(Map.class.getResourceAsStream("/maps/" + name + ".png"));
			
			int rgb;
			int r, g, b;
			for (int x = 0; x < img.getWidth(); x++) {
				for (int y = 0; y < img.getHeight(); y++) {
					rgb = img.getRGB(x, y);
					r = (rgb & 0xFF0000) >> 16;
					g = (rgb & 0x00FF00) >> 8;
					b = (rgb & 0x0000FF);
					
					if (r == 0 && g == 0 && b ==0) {
						list.add(new Wall(x, y));
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static List<Block> getBlockList() {
		return list;
	}
	
}
