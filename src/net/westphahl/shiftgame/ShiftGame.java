package net.westphahl.shiftgame;

import javax.swing.UIManager;

import net.westphahl.shiftgame.gui.GameWindow;

public class ShiftGame {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
		    /* Set system look and feel */
	        UIManager.setLookAndFeel(
	            UIManager.getSystemLookAndFeelClassName());
	    } 
	    catch (Exception e) {
	    	System.exit(1);
	    }
		new GameWindow();
	}

}
