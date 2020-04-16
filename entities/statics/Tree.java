package dev.tilegame.entities.statics;

import java.awt.Color;
import java.awt.Graphics;

import dev.tilegame.Handler;
import dev.tilegame.gfx.Assets;
import dev.tilegame.tiles.Tile;

public class Tree extends StaticEntity{

	public Tree(Handler handler, float x, float y) {
		super(handler, x, y, Tile.TILEWIDTH*2, Tile.TILEHEIGHT*2);
		
		bounds.x = 35;
		bounds.y = (int)(height/1.5f);
		bounds.width = width - 80;
		bounds.height = (int)(height - height /1.5f);
		
	}


	@Override
	public void tick() {
		
	}

	@Override
	public void render(Graphics g) {	
		g.drawImage(Assets.tree, (int)(x - handler.getGameCamera().getxOffset()), (int)(y - handler.getGameCamera().getyOffset()), width, height, null);
	
		g.setColor(Color.red);
		g.drawRect((int)(x + bounds.x - handler.getGameCamera().getxOffset()),
				(int)(y + bounds.y - handler.getGameCamera().getyOffset()), bounds.width, bounds.height);
	}
	
	

}
