package org.hbrs.se1.ws23.uebung4.Output;

public class Ausgabe {
    public void startAusgabe() {

        // Hier möchte Herr P. die Liste mit einem eigenen Sortieralgorithmus sortieren und dann
        // ausgeben. Allerdings weiss der Student hier nicht weiter

        // [Sortierung ausgelassen]
        // Todo: Implementierung Sortierung (F4)

        // Klassische Ausgabe ueber eine For-Each-Schleife
        for (UserStory story : liste) {
            System.out.println(story.toString());
        }

        // [Variante mit forEach-Methode / Streams (--> Kapitel 9, Lösung Übung Nr. 2)?
        //  Gerne auch mit Beachtung der neuen US1
        // (Filterung Projekt = "ein Wert (z.B. Coll@HBRS)" und Risiko >=5
        // Todo: Implementierung Filterung mit Lambda (F5)

    }
}
