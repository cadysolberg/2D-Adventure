package dev.tilegame.tiles;

import dev.tilegame.gfx.Assets;

public class MossBrickTile extends Tile{

	public MossBrickTile(int id) {
		super(Assets.mossBrick, id);
	}
	
	@Override 
	public boolean isSolid(){
		return true;
	}

}
