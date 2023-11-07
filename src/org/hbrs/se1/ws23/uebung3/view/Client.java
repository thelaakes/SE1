package org.hbrs.se1.ws23.uebung3.view;

import org.hbrs.se1.ws23.uebung3.control.ConcreteMember;
import org.hbrs.se1.ws23.uebung3.control.Container;
import org.hbrs.se1.ws23.uebung3.control.ContainerException;

public class Client {
    public Client(Container container, MemberView view) throws ContainerException {

        for (int i = 0; i < 10; i++) {
            ConcreteMember member = new ConcreteMember(i);
            container.addMember(member);
        }
        view.dump(container.getCurrentList());
    }
}
