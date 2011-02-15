package net.westphahl.shiftgame.gui;

import javax.swing.JMenu;

public class GameMenu extends JMenu {

	private NewGameMenuItem newGameItem = new NewGameMenuItem();
	
	public GameMenu() {
		super("Spielmenü");
		
		this.add(this.newGameItem);
	}

}