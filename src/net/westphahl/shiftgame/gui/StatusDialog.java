package net.westphahl.shiftgame.gui;

import java.awt.BorderLayout;
import java.awt.Point;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class StatusDialog extends JDialog {
	
	private JTextField zaehler = new JTextField();
	private GameWindow gameWindow;
	
	StatusDialog(GameWindow gw) {
		super(gw, "Status");
		this.gameWindow = gw;
		
		this.setLayout(new BorderLayout());
		this.add(new JLabel("Anzahl der Züge:"), BorderLayout.NORTH);
		
		this.zaehler.setEditable(false);
		this.add(this.zaehler);
		this.setZaehler();
		
		this.setPosition();
		
		this.pack();
		this.setVisible(true);
	}
	
	public void setZaehler() {
		this.zaehler.setText(Integer.toString(this.gameWindow.getLogik().getZaehler()));
	}
	
	public void setPosition() {
		Point bounds = this.gameWindow.getLocation();
		bounds.x += this.gameWindow.getWidth() + 10;
		this.setLocation(bounds);
	}
}
