package org.hbrs.se1.ws23.uebung3.control;

import org.hbrs.se1.ws23.uebung3.control.ConcreteMember;
import org.hbrs.se1.ws23.uebung3.control.Container;
import org.hbrs.se1.ws23.uebung3.control.ContainerException;
import org.hbrs.se1.ws23.uebung3.persistence.PersistenceException;
import org.hbrs.se1.ws23.uebung3.persistence.PersistenceStrategyMongoDB;
import org.hbrs.se1.ws23.uebung3.view.Client;
import org.hbrs.se1.ws23.uebung3.view.MemberView;

public class main {
    public static void main(String[] args) throws ContainerException, PersistenceException {
        MemberView view = new MemberView();
        Container container = Container.getInstance();
        Client client = new Client();
        container.addMember(new ConcreteMember(55));
        container.load();
        //container.addMember(new ConcreteMember(1));
        client.viewDump();
        //container.store();
    }
}
