package dev.tilegame.entities.creatures;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import dev.tilegame.Game;
import dev.tilegame.Handler;
import dev.tilegame.gfx.Animation;
import dev.tilegame.gfx.Assets;

public class Player extends Creature {
	
	//For Animation
	private Animation animDown, animUp, animRight, animLeft; 


	
	public Player(Handler handler, float x, float y) {
		super(handler, x, y, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT);

		
//CUSTOMIZE THIS TO CHARACTER		
		bounds.x = 5;
		bounds.y = 26;
		bounds.width = 21;
		bounds.height = 35;
	
	//For Animation
	animDown = new Animation(500, Assets.player_down);
	animUp = new Animation(500, Assets.player_up);
	animRight = new Animation(500, Assets.player_right);
	animLeft = new Animation(500, Assets.player_left);
	}

	@Override
	public void tick() {
		animDown.tick();
		animUp.tick();
		animRight.tick();
		animLeft.tick();
		getInput();
		move();
		handler.getGameCamera().centerOnEntity(this);
	}
	
	
	//Movement
	private void getInput(){
		xMove = 0;
		yMove = 0;
		
		if(handler.getKeyManager().up)
			yMove = -speed;
		if(handler.getKeyManager().down)
			yMove = speed;
		if(handler.getKeyManager().left)
			xMove = -speed;
		if(handler.getKeyManager().right)
			xMove = speed;
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(getCurrentAnimationFrame(), (int) (x - handler.getGameCamera().getxOffset()), 
				(int) (y - handler.getGameCamera().getyOffset()), width, height, null);
		
		/*g.setColor(Color.red);
		g.drawRect((int)(x + bounds.x - handler.getGameCamera().getxOffset()),
				(int)(y + bounds.y - handler.getGameCamera().getyOffset()), bounds.width, bounds.height);
				*/	
	}
	
	private BufferedImage getCurrentAnimationFrame() {
		if (xMove < 0) {
			return animLeft.getCurrentFrame();	
		}
		else if (xMove > 0) {
			return animRight.getCurrentFrame();
		}
		else if (yMove < 0) {
			return animUp.getCurrentFrame();
		}
		else{
			return animDown.getCurrentFrame();
		}
	}

}