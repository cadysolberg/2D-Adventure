package dev.tilegame.tiles;

//Tile 8
import dev.tilegame.gfx.Assets;

public class BorderTile extends Tile {

	public BorderTile(int id) {
		super(Assets.border, id);
		
	}
	
	@Override 
	public boolean isSolid(){
		return true;
	}


}