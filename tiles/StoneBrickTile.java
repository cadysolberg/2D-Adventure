package dev.tilegame.tiles;

import dev.tilegame.gfx.Assets;

public class StoneBrickTile extends Tile{

	public StoneBrickTile(int id) {
		super(Assets.stoneBrick, id);
	}
	
	@Override 
	public boolean isSolid(){
		return true;
	}

}
