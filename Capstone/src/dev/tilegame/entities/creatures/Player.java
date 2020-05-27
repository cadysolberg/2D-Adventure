package dev.tilegame.entities.creatures;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import dev.tilegame.Game;
import dev.tilegame.Handler;
import dev.tilegame.entities.Entity;
import dev.tilegame.gfx.Animation;
import dev.tilegame.gfx.Assets;
import dev.tilegame.inventory.Inventory;

public class Player extends Creature {
	
	//For Animation
	private Animation animDown, animUp, animRight, animLeft; 
	//For Combat
	private long lastAttackTimer, attackCooldown = 0, attackTimer = attackCooldown; 
	
	private Inventory inventory;


	
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
	
	inventory = new Inventory(handler);
	}

	@Override
	public void tick() {
		//Move
		animDown.tick();
		animUp.tick();
		animRight.tick();
		animLeft.tick();
		getInput();
		move();
		handler.getGameCamera().centerOnEntity(this);
		//Attack
		checkAttacks();
		inventory.tick();
	}
	
	private void checkAttacks() {
		attackTimer += System.currentTimeMillis() - lastAttackTimer;
		lastAttackTimer = System.currentTimeMillis();
		if(attackTimer < attackCooldown) {
			return;

		}
		
		if(inventory.isActive()) {
			return;
		}
		
		Rectangle collision = getCollisionBounds(0, 0);
		Rectangle attack = new Rectangle();
		int attackSize = 20;
		attack.width = attackSize;
		attack.height = attackSize;
		
		if(handler.getKeyManager().aUp) {
			attack.x = collision.x + collision.x / 2 - attackSize / 2;
			attack.y = collision.y - attackSize;
		}
		else if(handler.getKeyManager().aDown) {
			attack.x = collision.x + collision.x / 2 - attackSize / 2;
			attack.y = collision.y + collision.height;
		}
		else if(handler.getKeyManager().aLeft) {
			attack.x = collision.x - attackSize;
			attack.y = collision.y + collision.height / 2 - attackSize / 2;
		}
		else if(handler.getKeyManager().aRight) {
			attack.x = collision.x + collision.width;
			attack.y = collision.y + collision.height / 2 - attackSize / 2;
		}
		else {
			return;
		}
		
		attackTimer = 0;
		
		for(Entity e : handler.getWorld().getEntityManager().getEntities()) {
			if(e.equals(this)) {
				continue;
			}
			if(e.getCollisionBounds(0, 0).intersects(attack)) {
				e.hurt(1);
				return;
			}
		}
			
		
	}
	
	
	public void die() {
		System.out.println("You Lose");
	}
	
	
	
	
	//Movement
	private void getInput(){
		xMove = 0;
		yMove = 0;
		
		if(inventory.isActive()) {
			return;
		}
		
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
	
	public void postRender(Graphics g) {
		inventory.render(g);
	}
	
	public Inventory getInventory() {
		return inventory;
	}

	public void setInventory(Inventory inventory) {
		this.inventory = inventory;
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