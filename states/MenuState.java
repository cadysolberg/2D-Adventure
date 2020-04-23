package dev.tilegame.states;

import java.awt.Color;
import java.awt.Graphics;

import dev.tilegame.Handler;

public class MenuState extends State {

	public MenuState(Handler handler) {
		super(handler);
	}

	@Override
	public void tick() {
		//System.out.println(handler.getMouseManager().getMouseX() + "   " + handler.getMouseManager().getMouseY());
		if(handler.getMouseManager().isLeftPressed() && handler.getMouseManager().isRightPressed())
			State.setState(handler.getGame().gameState);
		
	}

	@Override
	public void render(Graphics g) {
		//Test Code
		g.setColor(Color.green);
		g.fillRect(handler.getMouseManager().getMouseX(), handler.getMouseManager().getMouseY(), 10, 10);
		
	}
	
}
