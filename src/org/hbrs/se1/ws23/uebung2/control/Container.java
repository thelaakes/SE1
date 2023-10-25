package org.hbrs.se1.ws23.uebung2.control;

import java.util.ArrayList;
import java.util.Objects;


public class Container{
    private final ArrayList<Member> list = new ArrayList<>();
    public Container() {
        this.list.clear();
    }
    public void addMember(Member member) throws ContainerException {
        if (list.contains(member)) {
            throw new ContainerException("Das Member-Objekt mit der ID [" + member.getID() + "] ist bereits vorhanden!");
        }
        list.add(member);
    }
    public void deleteMember(Integer id) throws ContainerException {
        for (Member member : list) {
            if (Objects.equals(member.getID(), id)) {
                list.remove(member);
                return;
            }
        }
        throw new ContainerException("Das Member-Objekt mit der ID [" + id + "] ist nicht vorhanden!");
    }
    public void dump() {
        for (Member member : list) {
            System.out.println(member.toString());
        }
    }

    public int size() {
        return list.size();
    }
}
