package dev.tilegame.states;

import java.awt.Graphics;

import dev.tilegame.Game;
import dev.tilegame.Handler;
import dev.tilegame.entities.creatures.Player;
import dev.tilegame.entities.statics.Bush;
import dev.tilegame.entities.statics.Rock;
import dev.tilegame.entities.statics.Tree;
import dev.tilegame.worlds.World;

public class GameState extends State {
	
	private Player player;
	private World world;
	private Tree tree;
	private Bush bush;
	private Rock rock;
	
	public GameState(Handler handler){
		super(handler);
		world = new World(handler, "res/worlds/world.txt");
		handler.setWorld(world);
		
		//Where stuff spawns
		/*player = new Player(handler, 650, 400);
		tree = new Tree(handler, 100, 100);
		bush = new Bush(handler, 200, 200);
		rock = new Rock(handler, 100, 300);*/

	}
	
	@Override
	public void tick() {
		world.tick();
		/*player.tick();
		tree.tick();
		bush.tick();
		rock.tick();*/
	}

	@Override
	public void render(Graphics g) {
		world.render(g);
		/*player.render(g);
		tree.render(g);
		bush.render(g);
		rock.render(g);*/
	}

}