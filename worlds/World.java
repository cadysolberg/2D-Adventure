package dev.tilegame.worlds;

import java.awt.Graphics;

import dev.tilegame.Game;
import dev.tilegame.Handler;
import dev.tilegame.entities.EntityManager;
import dev.tilegame.entities.creatures.Player;
import dev.tilegame.entities.statics.Bush;
import dev.tilegame.entities.statics.Rock;
import dev.tilegame.entities.statics.Tree;
import dev.tilegame.tiles.Tile;
import dev.tilegame.utils.Utils;

public class World {

	private Handler handler;
	private int width, height;
	private int spawnX, spawnY;
	private int[][] tiles;
	
	//Entity
	private EntityManager entityManager;
	
	public EntityManager getEntityManager() {
		return entityManager;
	}

	public World(Handler handler, String path){
		this.handler = handler;
		entityManager = new EntityManager(handler, new Player(handler, 650, 400));
		entityManager.addEntity(new Tree(handler, 400, 600));
		
		loadWorld(path);
		
		entityManager.getPlayer().setX(spawnX);
		entityManager.getPlayer().setY(spawnY);
	}
	
	public void tick(){
		entityManager.tick();
	}
	
	public void render(Graphics g){
		for(int y = 0;y < height;y++){
			for(int x = 0;x < width;x++){
				getTile(x, y).render(g, (int)(x * Tile.TILEWIDTH - handler.getGameCamera().getxOffset()),
						(int)( y * Tile.TILEHEIGHT - handler.getGameCamera().getyOffset()));
			}
		}
		entityManager.render(g);
	}
	
	public Tile getTile(int x, int y){
		if (x< 0 || y < 0 || x >= width || y >= height)
			return Tile.grassTile;
		
		Tile t = Tile.tiles[tiles[x][y]];
		if(t == null)
			return Tile.dirtTile;
		return t;
	}
	
	//World Render
	private void loadWorld(String path){
		String file = Utils.loadFileAsString(path);
		String[] tokens = file.split("\\s+");
		width = Utils.parseInt(tokens[0]);
		height = Utils.parseInt(tokens[1]);
		spawnX = Utils.parseInt(tokens[2]);
		spawnY = Utils.parseInt(tokens[3]);
		
		tiles = new int[width][height];
		for(int y = 0;y < height;y++){
			for(int x = 0;x < width;x++){
				tiles[x][y] = Utils.parseInt(tokens[(x + y * width) + 4]);
			}
		}
	}
	
	public int getWidth() {
		return width;
	}
	
	public int getHeight() {
		return height;
	}
	
}
