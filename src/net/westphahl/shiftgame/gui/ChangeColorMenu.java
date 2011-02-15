package net.westphahl.shiftgame.gui;

import java.awt.Color;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuItem;

import net.westphahl.shiftgame.listeners.ColorChangeListener;

public class ChangeColorMenu extends JMenu {

	private String colors [] = {"rot", "blau", "Voreinstellung"};
	private Color buttonColor;
	private GameWindow gameWin;
	private ActionListener colorListener;
	
	ChangeColorMenu() {
		super("Farbe ändern");
		
		this.gameWin = (GameWindow) this.getTopLevelAncestor();
		this.colorListener = new ColorChangeListener();
		
		for(String color : colors) {
			JMenuItem mItem = new JMenuItem(color);
			mItem.addActionListener(this.colorListener);
			this.add(mItem);
		}
	}
}
