package dev.tilegame.gfx;

import java.awt.Image;
import java.awt.image.BufferedImage;

public class Assets {
	
	private static final int width = 32, height = 32;
	
	public static BufferedImage player, enemy, grass, dirt, stone, mossStone, brick, mossBrick, stoneBrick, mossStoneBrick, border, rock, bush, tree;
	public static BufferedImage[] player_left, player_right, player_up, player_down;



	//Tiles
	public static void init(){
		SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/textures/SpriteSheet.png"));
		
		//Player
		player_left = new BufferedImage[2];
		player_right = new BufferedImage[2];
		player_up = new BufferedImage[2];
		player_down = new BufferedImage[2];
		
		player_left[0] = sheet.crop((width*4), 8, width-5, (height*2)-17);
		player_left[1] = sheet.crop((width*5)-5, 8, width-5, (height*2)-17);
		player_right[0] = sheet.crop((width*6)-6, 8, width-5, (height*2)-17);
		player_right[1] = sheet.crop((width*7)-11, 8, width-5, (height*2)-17);
		player_up[0] = sheet.crop((width*6)-8, (height*2)+8, width-5, (height*2)-17);
		player_up[1] = sheet.crop((width*7)-12, (height*2)+8, width-5, (height*2)-17);
		player_down[0] = sheet.crop((width*4), (height*2)+8, width-5, (height*2)-17);
		player_down[1] = sheet.crop((width*5)-5, (height*2)+8, width-5, (height*2)-17); 
		
		//Blocks
	//	enemy = sheet.crop(29, 2, width+1, (height*2)-17);					Set up when actually testable
		grass = sheet.crop(width, height , width, height);
		dirt = sheet.crop(width, 0, width, height);
		stone = sheet.crop(0, height, width, height);
		mossStone = sheet.crop((width*2), 0, width, height);
		brick = sheet.crop(0 , 0, width, height);
		mossBrick = sheet.crop((width*3), height, width, height);
		stoneBrick = sheet.crop((width*3), 0, width, height);
		mossStoneBrick = sheet.crop((width*2), height, width, height);
		border = sheet.crop(0 , (height*2), (width*2), (height*2));
		rock = sheet.crop((width*3), (height*2), width-4, height);
		bush = sheet.crop((width*2), (height*2), width, height);
		tree = sheet.crop(0, (height*4), (width*2)-2, (height*2)-2);
		
		
	}
	
}
