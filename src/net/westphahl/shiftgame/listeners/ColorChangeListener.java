package net.westphahl.shiftgame.listeners;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

import net.westphahl.shiftgame.gui.GameWindow;

public class ColorChangeListener implements ActionListener {
	
	private Color presetColor = new JButton().getBackground();
	
	@Override
	public void actionPerformed(ActionEvent e) {
		GameWindow gameWin = (GameWindow) 
			((JMenu) 
				((JPopupMenu) 
						((JMenuItem) 
								e.getSource()
						).getParent()
				).getInvoker()
			).getTopLevelAncestor();
		
		if (e.getActionCommand().equals("rot")) {
			gameWin.setColor(Color.red);
		} else if (e.getActionCommand().equals("blau")) {
			gameWin.setColor(Color.blue);
		} else {
			gameWin.setColor(this.presetColor);
		}
	}

}
