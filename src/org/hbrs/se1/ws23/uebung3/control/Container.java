package org.hbrs.se1.ws23.uebung3.control;

import org.hbrs.se1.ws23.uebung3.persistence.*;
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
        // Überprüfen, ob ein Member mit derselben ID bereits in der Liste vorhanden ist
        for (Member existingMember : list) {
            if (existingMember.getID().equals(member.getID())) {
                throw new ContainerException("Das Member-Objekt mit der ID [" + member.getID() + "] ist bereits vorhanden!");
            }
        }

        // Wenn keine Duplikate gefunden wurden, füge das Member-Objekt zur Liste hinzu
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

// Gibt ein Member-Objekt aus dem Container anhand seiner ID zurück
    public ArrayList<Member> getCurrentList() {
        return list;
    }

    // Gibt die Anzahl der Member-Objekte im Container zurück
    public int size() {
        return list.size();
    }

    public void store() throws PersistenceException {
        PersistenceStrategy<Member> ps = new PersistenceStrategyStream<Member>();
        ps.save(list);
    }

    public void load() throws PersistenceException, ContainerException {
        PersistenceStrategy<Member> ps = new PersistenceStrategyStream<Member>();
        Container container = Container.getInstance();
        this.list.clear();
        for (
                Member member : ps.load()) {
                container.addMember(member);
        }
    }

}
