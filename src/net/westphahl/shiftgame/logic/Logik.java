package net.westphahl.shiftgame.logic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Logik extends java.lang.Object {

	private List<Integer> nummern;
	private List<Integer> sortNummern;
	private int zaehler;
	private int emptyFieldIndex;
	
	/**
	 * Konstruktor der Spielelogik initialisiert ein Array von Integer-Objekten.
	 * 
	 * Konstruktor der Klasse Initialisiert ein array von Integer-Objekten.
	 * Die Ziffern 1 - 8 werden an zufällig errechneten Positionen gespeichert,
	 * so dass man eine unsortierte Liste erhält. Der letzte Wert im array ist zu
	 * Beginn null Der Zähler wird auf 0 gesetzt
	 */
	public Logik() {
		this.nummern = new ArrayList<Integer>(9);
		for (int i = 1; i < 9; i++) {
			this.nummern.add(new Integer(i));
		}
		
		this.sortNummern = new ArrayList<Integer>(this.nummern);
		Collections.shuffle(this.nummern);
		
		this.emptyFieldIndex = 8;
		this.nummern.add(null);
		this.sortNummern.add(null);
	}
	
	/**
	 * Die Methode getNummern() liefert das Integer-Array, in dem die Ziffern des
	 * Spiels gespeichert sind.
	 * 
	 * @return - Integer[], in dem die Ziffern von links nach recht / oben nach unten
	 * gespeichert sind. Das leere Feld des Spiels wird durch durch den Wert null
	 * repräsentiert.
	 */
	public Integer[] getNummern() {
		return this.nummern.toArray(new Integer[9]);
	}
	
	/**
	 * Die Methode getZaehler() liefert den aktuellen Zählerstand
	 * 
	 * @return - aktueller Zählerstand
	 */
	public Integer getZaehler() {
		return this.zaehler;
	}
	
	/**
	 * Die Methode move() verschiebt das Feld mit der 'ziffer',
	 * falls das Nachbarfeld leer ist.

	 * @param ziffer - zu verschiebende Ziffer
	 * @return - true, wenn eine Verschiebung durchgeführt wurde
	 * 			 false, wenn keine Verschiebung stattgefunden hat
	 */
	public boolean move(Integer ziffer) {
		int zifferIndex;
		int colDist;
		int rowDist;
		
		for(zifferIndex = 0; zifferIndex < this.nummern.size(); zifferIndex++) {
			if (ziffer.equals(this.nummern.get(zifferIndex))) {
				break;
			}
		}
		
		colDist = Math.abs(this.emptyFieldIndex % 3 - zifferIndex % 3);
		rowDist = Math.abs(this.emptyFieldIndex / 3 - zifferIndex / 3);
		
		if ((colDist < 2) && (rowDist < 2) && (colDist != rowDist)) {
			this.nummern.set(this.emptyFieldIndex, ziffer);
			this.nummern.set(zifferIndex, null);
			this.emptyFieldIndex = zifferIndex;
			this.zaehler++;
			return true;
		}
		return false;
	}
	
	/**
	 * Die Methode richtigeReihenfolge()prüft, ob die Ziffern in der richtigen
	 * Reihenfolge 1,2,3,4,5,6,7,8,null im in der Liste stehen.
	 *
	 * @return - true , falls die richtige Reihenfolge erkannt wurde, sonst false
	 */
	public boolean richtigeReihenfolge() {
		if (this.nummern.equals(this.sortNummern)) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * Die Methode toString() liefert die Ziffern des arrays von links nach rechts
	 * Das Leere Feld wird durch das Zeichen '-' codiert.
	 * 
	 * @return - String, in dem die Ziffern der Liste von links nach rechts stehen
	 */
	public String toString() {
		return this.nummern.toString();
	}
}
