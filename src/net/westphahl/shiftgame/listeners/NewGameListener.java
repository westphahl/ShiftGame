package net.westphahl.shiftgame.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

import net.westphahl.shiftgame.gui.GameWindow;

public class NewGameListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		GameWindow gWindow = 
			(GameWindow) 
				((JMenu)
					((JPopupMenu) 
						((JMenuItem) e.getSource()).getParent()
					).getInvoker()
				).getTopLevelAncestor();
	
		gWindow.newGame();
	}

}
