package org.hbrs.se1.ws23.uebung3.test;

import org.hbrs.se1.ws23.uebung3.control.ConcreteMember;
import org.hbrs.se1.ws23.uebung3.control.Container;
import org.hbrs.se1.ws23.uebung3.control.ContainerException;
import org.hbrs.se1.ws23.uebung3.control.Member;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class ContainerTest {

    @BeforeEach
    public void setup() {
        Container container = Container.getInstance();
    }

    /*Entwickeln sie einen JUnit5-Testfall mit mindestens 4 aussagekräftigen TestMethoden, um ihre Klasse Container hinreichend zu testen. Folgende Testfälle sollten
    dabei zumindest getestet werden (jeder Testfall eine Test-Methode):
    • Keine Strategie von außen gesetzt („Test auf NULL“)
    • Verwendung der Strategie „PersistenceStrategyMongoDB“
    • Fehlerhafte Location des Files, in dem Streams ihre Objekte abspeichern (Tipp:
    FileStreams mögen keine Directories ;-))
    • „Round-Trip-Test“: Objekt hinzufügen, Liste persistent abspeichern, Objekt aus
    Container löschen und Liste wieder einladen. Nach jedem Schritt den Zustand des
    Containers testen!*/

    //Tests sind noch nicht implementiert
}