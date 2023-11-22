package org.hbrs.se1.ws23.uebung4.Input;

import org.hbrs.se1.ws23.uebung4.control.ContainerException;
import org.hbrs.se1.ws23.uebung4.control.UserStory;

import java.util.Scanner;

public class Eingabe {
    public void startEingabe() throws ContainerException, Exception {
        String strInput = null;

        // Initialisierung des Eingabe-View
        // ToDo: Funktionsweise des Scanners erklären (F3)
        Scanner scanner = new Scanner( System.in );

        while ( true ) {
            // Ausgabe eines Texts zur Begruessung
            System.out.println("UserStory-Tool V1.0 by Julius P. (dedicated to all my friends)");

            System.out.print( "> "  );

            strInput = scanner.nextLine();

            // Extrahiert ein Array aus der Eingabe
            String[] strings = strInput.split(" ");

            // 	Falls 'help' eingegeben wurde, werden alle Befehle ausgedruckt
            if ( strings[0].equals("help") ) {
                System.out.println("Folgende Befehle stehen zur Verfuegung: help, dump....");
            }
            // Auswahl der bisher implementierten Befehle:
            if ( strings[0].equals("dump") ) {
                startAusgabe();
            }
            // Auswahl der bisher implementierten Befehle:
            if ( strings[0].equals("enter") ) {
                // Daten einlesen ...
                // this.addUserStory( new UserStory( data ) ) um das Objekt in die Liste einzufügen.
            }

            if (  strings[0].equals("store")  ) {
                // Beispiel-Code
                UserStory userStory = new UserStory();
                userStory.setId(22);
                this.addUserStory( userStory );
                this.store();
            }
        } // Ende der Schleife
    }
}
