package dev.tilegame.tiles;

import dev.tilegame.gfx.Assets;

public class MossStoneBrickTile extends Tile{
	
	public MossStoneBrickTile(int id) {
		super(Assets.mossStoneBrick, id);
	}
	
	@Override 
	public boolean isSolid(){
		return true;
	}
	
}
