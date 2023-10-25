package org.hbrs.se1.ws23.uebung2.test;
import org.hbrs.se1.ws23.uebung2.control.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ContainerTest {
    @Test
    void addMemberTest() {
        Container container = new Container();
        Member member = new ConcreteMember(1);
        try {
            container.addMember(member);
        } catch (ContainerException e) {
            fail(e.getMessage());
        }
    }
    @Test
    void addMemberDoubleTest() {
        Container container = new Container();
        Member member = new ConcreteMember(1);
        try {
            container.addMember(member);
            container.addMember(member);
            fail("ContainerException wurde nicht geworfen!");
        } catch (ContainerException e) {
            assertEquals("Das Member-Objekt mit der ID [1] ist bereits vorhanden!", e.getMessage());
        }
    }
    @Test
    void deleteMemberTest() {
        Container container = new Container();
        Member member = new ConcreteMember(1);
        try {
            container.addMember(member);
            assertEquals(1, container.size());
            container.deleteMember(1);
        } catch (ContainerException e) {
            fail(e.getMessage());
        }
       assertEquals(0, container.size());
    }
    @Test
    void deleteMemberNotExistingTest() {
        Container container = new Container();
        try {
            container.deleteMember(1);
            fail("ContainerException wurde nicht geworfen!");
        } catch (ContainerException e) {
            assertEquals("Das Member-Objekt mit der ID [1] ist nicht vorhanden!", e.getMessage());
        }
    }
    @Test
    void dumpTest() {
        Container container = new Container();
        Member member = new ConcreteMember(1);
        try {
            container.addMember(member);
            container.dump();
        } catch (ContainerException e) {
            fail(e.getMessage());
        }
    }
    @Test
    void sizeTest() {
        Container container = new Container();
        Member member = new ConcreteMember(1);
        try {
            container.addMember(member);
            assertEquals(1, container.size());
        } catch (ContainerException e) {
            fail(e.getMessage());
        }
    }

}
