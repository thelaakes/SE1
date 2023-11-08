package org.hbrs.se1.ws23.uebung3.view;

import org.hbrs.se1.ws23.uebung3.control.Container;

public class Client {
    Container  container = Container.getInstance();
    MemberView view = new MemberView();
    public Client() {
    }

    public void viewDump() {
        view.dump(container.getCurrentList());
    }
}
