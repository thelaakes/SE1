package org.hbrs.se1.ws23.uebung1.control;

import java.util.HashMap;

public class GermanTranslator implements Translator {

	public String date = "Okt/2023"; // Default-Wert

	/**
	 * Methode zur Übersetzung einer Zahl in eine String-Repraesentation
	 */
	public String translateNumber( int number ) {
		// Hashmap für das direkte Mapping von Zahlen auf Strings
		HashMap<Integer, String> germanNumbers = new HashMap<Integer, String>();
		germanNumbers.put(1, "eins");
		germanNumbers.put(2, "zwei");
		germanNumbers.put(3, "drei");
		germanNumbers.put(4, "vier");
		germanNumbers.put(5, "fünf");
		germanNumbers.put(6, "sechs");
		germanNumbers.put(7, "sieben");
		germanNumbers.put(8, "acht");
		germanNumbers.put(9, "neun");
		germanNumbers.put(10, "zehn");

		return germanNumbers.getOrDefault(number, "Übersetzung der Zahl " + number + " nicht möglich (" + Translator.version + ")");
	}

	/**
	 * Objektmethode der Klasse GermanTranslator zur Ausgabe einer Info.
	 */
	public void printInfo(){
		System.out.println( "GermanTranslator v1.9, erzeugt am " + this.date );
	}

	/**
	 * Setzen des Datums, wann der Uebersetzer erzeugt wurde (Format: Monat/Jahr (Beispiel: "Okt/2022"))
	 * Das Datum sollte system-intern durch eine Control-Klasse gesetzt werden und nicht von externen View-Klassen
	 */
	public void setDate( String date ) {
		this.date = date;
	}

}
