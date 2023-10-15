package org.hbrs.se1.ws23.uebung1.control;

/**
 *
 *  TranslatorFactory zur Erzeugung von Translator-Objekten
 *  author: lneft2s
 *
 */
public class TranslatorFactory {
    public static Translator createGermanTranslator() {
        return new GermanTranslator();
    }
}
