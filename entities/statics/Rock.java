package dev.tilegame.entities.statics;

import java.awt.Graphics;

import dev.tilegame.Handler;
import dev.tilegame.gfx.Assets;
import dev.tilegame.tiles.Tile;

public class Rock extends StaticEntity{

	public Rock(Handler handler, float x, float y) {
		super(handler, x, y, Tile.TILEWIDTH, Tile.TILEHEIGHT);
	}

	@Override
	public void tick() {
		
	}

	@Override
	public void render(Graphics g) {	
		g.drawImage(Assets.rock, (int)(x - handler.getGameCamera().getxOffset()), (int)(y - handler.getGameCamera().getyOffset()), width, height, null);
	}
	
}
