package net.westphahl.shiftgame.gui;

import javax.swing.JMenuBar;

@SuppressWarnings("serial")
public class MenuBar extends JMenuBar {

	private GameMenu gameMenu = new GameMenu();
	private ChangeColorMenu colorMenu = new ChangeColorMenu();
	
	public MenuBar() {
		this.add(this.gameMenu);
		this.add(this.colorMenu);
	}
}
