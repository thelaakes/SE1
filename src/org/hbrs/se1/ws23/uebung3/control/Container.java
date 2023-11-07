package org.hbrs.se1.ws23.uebung3.control;

import java.util.ArrayList;
import java.util.Objects;

public class Container {
    private final ArrayList<Member> list = new ArrayList<>();
    private static Container instance = null;

    // Singleton-Methode, gibt die einzige Instanz des Containers zurück oder erstellt sie
    public static Container getInstance() {
        if (instance == null) {
            instance = new Container();
        }
        return instance;
    }

    private Container() {
        // Privater Konstruktor, löscht die Liste der Member-Objekte bei der Initialisierung
        this.list.clear();
    }

    // Fügt ein Member-Objekt zum Container hinzu, wirft eine ContainerException bei Duplikaten
    public void addMember(Member member) throws ContainerException {
        if (list.contains(member)) {
            throw new ContainerException("Das Member-Objekt mit der ID [" + member.getID() + "] ist bereits vorhanden!");
        }
        list.add(member);
    }

    // Löscht ein Member-Objekt aus dem Container anhand seiner ID
    public void deleteMember(Integer id) throws ContainerException {
        for (Member member : list) {
            if (Objects.equals(member.getID(), id)) {
                list.remove(member);
                return;
            }
        }
        throw new ContainerException("Das Member-Objekt mit der ID [" + id + "] ist nicht vorhanden!");
    }

    // Gibt alle Member-Objekte im Container aus
    public void dump() {
        for (Member member : list) {
            System.out.println(member.toString());
        }
    }

    // Gibt die Anzahl der Member-Objekte im Container zurück
    public int size() {
        return list.size();
    }
}
