package dev.tilegame.entities.statics;

import dev.tilegame.Handler;
import dev.tilegame.entities.Entity;
import dev.tilegame.tiles.Tile;

public abstract class StaticEntity extends Entity {

	public StaticEntity(Handler handler, float x, float y, int width, int height) {
		super(handler, x, y, Tile.TILEWIDTH, Tile.TILEHEIGHT);
	}
	

}
