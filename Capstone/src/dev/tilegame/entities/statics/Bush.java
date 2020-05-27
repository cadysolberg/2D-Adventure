package dev.tilegame.entities.statics;

import java.awt.Color;
import java.awt.Graphics;

import dev.tilegame.Handler;
import dev.tilegame.gfx.Assets;
import dev.tilegame.items.Item;
import dev.tilegame.tiles.Tile;

public class Bush extends StaticEntity{

	public Bush(Handler handler, float x, float y) {
		super(handler, x, y, Tile.TILEWIDTH, Tile.TILEHEIGHT);
	}

	@Override
	public void tick() {
		
	}
	
	public void die() {
		handler.getWorld().getItemManager().addItem(Item.leafItem.createNew((int) x, (int) y));
	}

	@Override
	public void render(Graphics g) {	
		g.drawImage(Assets.bush, (int)(x - handler.getGameCamera().getxOffset()), (int)(y - handler.getGameCamera().getyOffset()), width, height, null);
		if (health < 10 ) {
			g.setColor(Color.red);
			g.drawRect((int)(x + bounds.x - handler.getGameCamera().getxOffset()),
					(int)(y + bounds.y - handler.getGameCamera().getyOffset()), bounds.width, bounds.height);
		}
	}
	
}
