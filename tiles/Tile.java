package dev.tilegame.tiles;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Tile {
	
	//Tile Settings
	public static Tile[] tiles = new Tile[256];
	public static Tile grassTile = new GrassTile(0);
	public static Tile dirtTile = new DirtTile(1);
	public static Tile stoneTile = new StoneTile(2);
	public static Tile mossStoneTile = new MossStoneTile(3);
	public static Tile brickTile = new BrickTile(4);
	public static Tile mossBrickTile = new MossBrickTile(5);
	public static Tile stoneBrickTile = new StoneBrickTile(6);
	public static Tile mossStoneBrickTile = new MossStoneBrickTile(7);
	public static Tile borderTile = new BorderTile(8);

	
	public static final int TILEWIDTH = 64, TILEHEIGHT = 64;
	
	protected BufferedImage texture;
	protected final int id;
	
	public Tile(BufferedImage texture, int id){
		this.texture = texture;
		this.id = id;
		
		tiles[id] = this;
	}
	
    public void tick(){
		
	}
	
	public void render(Graphics g, int x, int y){
		g.drawImage(texture, x, y, TILEWIDTH, TILEHEIGHT, null);
	}
	
	public boolean isSolid(){
		return false;
	}
	
	public int getId(){
		return id;
	}

}
