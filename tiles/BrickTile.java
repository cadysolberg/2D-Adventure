package dev.tilegame.tiles;

//Tile 4
import dev.tilegame.gfx.Assets;

public class BrickTile extends Tile {

		public BrickTile(int id) {
			super(Assets.brick, id);
		}
		
		@Override 
		public boolean isSolid(){
			return true;
		}

}

