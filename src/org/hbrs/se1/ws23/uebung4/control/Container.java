package org.hbrs.se1.ws23.uebung4.control;

import org.hbrs.se1.ws23.uebung3.control.ContainerException;
import org.hbrs.se1.ws23.uebung3.control.Member;
import org.hbrs.se1.ws23.uebung3.persistence.PersistenceException;
import org.hbrs.se1.ws23.uebung3.persistence.PersistenceStrategy;
import org.hbrs.se1.ws23.uebung3.persistence.PersistenceStrategyStream;

import java.util.ArrayList;
import java.util.Objects;

public class Container {
    private final ArrayList<Member> list = new ArrayList<>();
    private static Container instance = null;
    private PersistenceStrategy<Member> ps = new PersistenceStrategyStream<>();

    // Singleton-Methode, gibt die einzige Instanz des Containers zurück oder erstellt sie
    public static Container getInstance() {
        if (instance == null) {
            instance = new Container(new PersistenceStrategyStream<Member>());
        }
        return instance;
    }

    private Container(PersistenceStrategy<Member> ps) {
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

    public void setPersistenceStrategy(PersistenceStrategy<Member> ps) {
        this.ps = ps;
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
        ps.save(list);
    }

    public void load() throws PersistenceException, ContainerException {
        Container container = Container.getInstance();
        this.list.clear();
        for (
                Member member : ps.load()) {
                container.addMember(member);
        }
    }

}
