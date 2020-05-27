package dev.tilegame.inventory;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import dev.tilegame.Handler;
import dev.tilegame.gfx.Assets;
import dev.tilegame.gfx.Text;
import dev.tilegame.items.Item;

public class Inventory {
	
	private Handler handler;
	private boolean active = false;
	private ArrayList<Item> inventoryItems;
	
	private int invX = 64, invY = 48, 
			invWidth = 512, invHeight = 384, 
			invListX = invX + 171, 
			invListY = invY + invHeight / 2 + 5,
			invSpacing = 30;
	
	private int invImageX = 452, invImageY = 82,
			invImageWidth = 64, invImageHeight = 64;
	
	private int invCountX = 484, invCountY = 172;
	
	private int selectedItem = 0;
	
	public Inventory(Handler handler) {
		this.handler = handler;
		inventoryItems = new ArrayList<Item>();
		
	/*	addItem(Item.leafItem.createNew(4));
		addItem(Item.rockItem.createNew(6));
		addItem(Item.woodItem.createNew(2));
	*/
		
	}
	
	public void tick() {
		if(handler.getKeyManager().keyJustPressed(KeyEvent.VK_E)) {
			active = !active;
		}
		if(!active) {
			return;	
		}
		
		if(handler.getKeyManager().keyJustPressed(KeyEvent.VK_Z)) {
			selectedItem--;
		}
		if(handler.getKeyManager().keyJustPressed(KeyEvent.VK_Q)) {
			selectedItem++;
		}
		
		if(selectedItem < 0) {
			selectedItem = inventoryItems.size() - 1;
		}
		else if(selectedItem >= inventoryItems.size()) {
			selectedItem = 0;
		}
		
		System.out.println("Inventory:");
		for(Item i : inventoryItems) {
			System.out.println(i.getName() + " - " + i.getCount());
		}
	}
	
	public void render(Graphics g) {
		if(!active) {
			return;
			
			}
		g.drawImage(Assets.invScreen, invX, invY, invWidth, invHeight, null);
		
		//Text.drawString(g, "> Leaf <", invListX, invListY, true, Color.blue, Assets.font28);
		
		int len = inventoryItems.size();
		if(len == 0) {
			return;
		}
		for(int i = -5; i < 6; i++) {
			if(selectedItem + i < 0 || selectedItem + i >= len) {
				continue;
			}
			if(i == 0) {
				Text.drawString(g, " > " +inventoryItems.get(selectedItem + i).getName() + " < ", invListX, invListY + i * invSpacing, true, Color.blue, Assets.font28);
			}
			else {
				Text.drawString(g,inventoryItems.get(selectedItem + i).getName(), invListX, invListY + i * invSpacing, true, Color.cyan, Assets.font28);
			}
			
		}
		
		Item item = inventoryItems.get(selectedItem);
		g.drawImage(item.getTexture(), invImageX, invImageY, invImageWidth, invImageHeight, null);
		Text.drawString(g, Integer.toString (item.getCount()), invCountX, invCountY, true, Color.lightGray, Assets.font28);
	}
	
	//Inventory
	
	public void addItem(Item item) {
		for(Item i : inventoryItems) {
			if(i.getId() == item.getId()) {
				i.setCount(i.getCount() + item.getCount());
				return;
			}
		}
		inventoryItems.add(item);
	}

	public boolean isActive() {
		return active;
	}

	public Handler getHandler() {
		return handler;
	}

	public void setHandler(Handler handler) {
		this.handler = handler;
	}

}
