package org.hbrs.se1.ws23.uebung3.view;

import org.hbrs.se1.ws23.uebung3.control.Container;
import org.hbrs.se1.ws23.uebung3.control.Member;

import java.util.ArrayList;

public class MemberView {

    // Gibt alle Member-Objekte im Container aus
    public void dump(ArrayList<Member> list) {
        for (Member member : list) {
            System.out.println(member.toString());
        }
    }
}
