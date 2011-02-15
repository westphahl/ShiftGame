package net.westphahl.shiftgame.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;

import net.westphahl.shiftgame.listeners.ButtonListener;
import net.westphahl.shiftgame.logic.Logik;

@SuppressWarnings("serial")
public class GameWindow extends JFrame {

	private JButton[] spielButtons = new JButton[9];
	private Logik logik = new Logik();
	private ButtonListener buttonListener = new ButtonListener(this);
	private JLabel blankField = new JLabel();
	private JMenuBar menuBar = new MenuBar();
	private StatusDialog statusDialog;
	
	public GameWindow() {
		/* Titel "Verschiebespiel" setzen*/
		this.setTitle("Verschiebespiel");
		
		/* GridLayout verwenden */
		this.setLayout(new GridLayout(3, 3));
		this.setJMenuBar(this.menuBar);
		/* Fenstergröße soll nicht änderbar sein */
		this.setResizable(false);
		this.blankField.setSize(70, 70);
		
		for (int i = 1; i < spielButtons.length; i++) {
			this.spielButtons[i - 1] = new JButton(Integer.toString(i));
			this.spielButtons[i - 1].setPreferredSize(new Dimension(70, 70));
			this.spielButtons[i - 1].setActionCommand(Integer.toString(i));
			this.spielButtons[i - 1].addActionListener(this.buttonListener);
		}
		
		this.drawButtons();
		this.pack();
		this.setVisible(true);
		
		this.addComponentListener(new ComponentAdapter() {
			public void componentMoved(ComponentEvent e) {
				GameWindow gw = (GameWindow) e.getSource();
				gw.statusDialog.setPosition();
		 	}});

		this.statusDialog = new StatusDialog(this);
	}
	
	public Logik getLogik() {
		return this.logik;
	}
	
	public StatusDialog getDialog() {
		return this.statusDialog;
	}
	
	public void setColor(Color c) {
		for (int i = 1; i < spielButtons.length; i++) {
			this.spielButtons[i - 1].setBackground(c);
		}
		this.repaint();
	}
	
	public void drawButtons() {
		this.getContentPane().removeAll();
		for (Integer i : this.logik.getNummern()) {
			if (i != null) {
				this.add(this.spielButtons[i-1], i);
			} else {
				this.add(this.blankField);
			}
		}
		this.repaint();
		this.pack();
	}
	
	public void newGame() {
		this.logik = new Logik();
		this.statusDialog.setZaehler();
		this.drawButtons();
	}
}
