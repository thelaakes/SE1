package org.hbrs.se1.ws23.uebung3.view;

import org.hbrs.se1.ws23.uebung3.control.ConcreteMember;
import org.hbrs.se1.ws23.uebung3.control.Container;
import org.hbrs.se1.ws23.uebung3.control.ContainerException;

public class main {
    public static void main(String[] args) throws ContainerException {
        MemberView view = new MemberView();
        Container container = Container.getInstance();
        Client client = new Client(container, view);
    }
}
