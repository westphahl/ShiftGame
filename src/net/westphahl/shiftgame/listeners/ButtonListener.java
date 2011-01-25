package net.westphahl.shiftgame.listeners;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import net.westphahl.shiftgame.gui.GameWindow;

public class ButtonListener implements ActionListener {

	private GameWindow gameWindow;

	public ButtonListener(GameWindow gw) {
		this.gameWindow = gw;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		boolean result = this.gameWindow.getLogik().move(
				Integer.parseInt(e.getActionCommand()));

		if (result) {
			this.gameWindow.drawButtons(true);
			if (this.gameWindow.getLogik().richtigeReihenfolge()) {
				if (JOptionPane.showConfirmDialog(this.gameWindow,
						"Neues Spiel?",
						"Hurra, Gewonnen!",
						JOptionPane.YES_NO_OPTION,
						JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {
					this.gameWindow.newGame();
					this.gameWindow.drawButtons(true);
				} else {
					System.exit(0);
				}
			}
		} else {
			Toolkit.getDefaultToolkit().beep();
		}
	}

}
