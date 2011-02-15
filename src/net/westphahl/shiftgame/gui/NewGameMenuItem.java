package net.westphahl.shiftgame.gui;

import javax.swing.JMenuItem;

import net.westphahl.shiftgame.listeners.NewGameListener;

public class NewGameMenuItem extends JMenuItem {

	public NewGameMenuItem() {
		super("neues Spiel");
		this.addActionListener(new NewGameListener());
	}
}
