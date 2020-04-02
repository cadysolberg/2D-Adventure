package dev.tilegame;

public class Launcher {

	  public static void main (String[] args){
		    Game game = new Game("IDK Yet", 1300, 800);
		    game.start();
		  }
		  
}



/* Smiley Face
 *   g.setColor(Color.darkGray);
    g.fillRect(10, 30, 190, 190);
    g.setColor(Color.white);
    g.fillRect(80, 50, 20, 70);
    g.fillRect(120, 50, 20, 70);
    g.setColor(Color.red);
    g.fillRect(40, 140, 20, 40);
    g.fillRect(160, 140, 20, 40);
    g.fillRect(40, 160, 120, 20);
    
    g.drawString("Hello", 25, 25);
    g.drawString("It's Me", 25, 35);
*/