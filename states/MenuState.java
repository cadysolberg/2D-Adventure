package dev.tilegame.states;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import dev.tilegame.Handler;

public class MenuState extends State {
	

	
	Font font = new Font ("Times New Roman", Font.BOLD, 96);
	Font font2 = new Font ("Times New Roman", Font.PLAIN, 48);

	public MenuState(Handler handler) {
		super(handler);

	}

	@Override
	public void tick() {
		//System.out.println(handler.getMouseManager().getMouseX() + "   " + handler.getMouseManager().getMouseY());
		if(handler.getMouseManager().isLeftPressed() || handler.getMouseManager().isRightPressed())
			State.setState(handler.getGame().gameState);
		

	}

	@Override
	public void render(Graphics g) {
		
		g.fillRect(25, 25, 1225, 725);
		g.setColor(Color.white);
		g.fillRect(50, 50, 1175, 675);
		g.setColor(Color.black);
		g.fillRect(75, 75, 1125, 625);
		g.setColor(Color.white);
		g.fillRect(100, 100, 1075, 575);
		g.setColor(Color.black);
		g.fillRect(125, 125, 1025, 85);

		g.setFont(font);
		g.setColor(Color.white);
		g.drawString("Title Here", 300, 200);
	
		g.setFont(font2);
		g.setColor(Color.darkGray);
		g.drawString("Controls:", 300, 300);
		g.drawString("- WASD to move", 300, 400);
		g.drawString("Click to Start", 300, 600);
		
		
		//Test Code
		g.setColor(Color.green);
		g.fillRect(handler.getMouseManager().getMouseX(), handler.getMouseManager().getMouseY(), 10, 10);
		
		
	}
	
}
