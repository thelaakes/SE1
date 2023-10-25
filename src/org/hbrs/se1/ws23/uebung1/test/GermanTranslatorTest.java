package org.hbrs.se1.ws23.uebung1.test;

import org.hbrs.se1.ws23.uebung1.control.GermanTranslator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class GermanTranslatorTest {

    @Test
    void gAEK1Test() {
        GermanTranslator translator = new GermanTranslator();
        String value = translator.translateNumber(1);
        Assertions.assertEquals(value, "eins");
    }
    @Test
    void uAEK1Test() {
        GermanTranslator translator = new GermanTranslator();
        String value = translator.translateNumber(20);
        Assertions.assertEquals(value, "Übersetzung der Zahl 20 nicht möglich (1.0)");
    }
    @Test
    void uAEK2Test() {
        GermanTranslator translator = new GermanTranslator();
        String value = translator.translateNumber(-10);
        Assertions.assertEquals(value, "Übersetzung der Zahl -10 nicht möglich (1.0)");
    }

    @Test
    void SonderfallTest() {
        GermanTranslator translator = new GermanTranslator();
        String value = translator.translateNumber(0);
        Assertions.assertEquals(value, "Übersetzung der Zahl 0 nicht möglich (1.0)");
    }

    @Test
    void GrenzwertTest() {
        GermanTranslator translator = new GermanTranslator();
        String value = translator.translateNumber(Integer.MAX_VALUE);
        Assertions.assertEquals(value, "Übersetzung der Zahl 2147483647 nicht möglich (1.0)");
    }
    @Test
    void Grenzwert2Test() {
        GermanTranslator translator = new GermanTranslator();
        String value = translator.translateNumber(Integer.MIN_VALUE);
        Assertions.assertEquals(value, "Übersetzung der Zahl -2147483648 nicht möglich (1.0)");
    }


}