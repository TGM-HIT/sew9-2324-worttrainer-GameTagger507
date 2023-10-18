package org.example;

import java.io.Serializable;


/**
 * Diese Klasse ist der Grundbaustein eines Wortpaares.
 *
 * @author Emmanuel Akwaonu
 * @version 2023-10-18
 */
public class Wortpaar implements Serializable {
    private final String wort;
    private final String bildUrl;

    //Konstruktor
    public Wortpaar(String wort, String bildUrl) {
        this.wort = wort;
        this.bildUrl = bildUrl;
    }

    //Getter für die URL
    String getBildUrl() {
        return this.bildUrl;
    }

    //Getter für das Wort
    String getWort() {
        return this.wort;
    }

}
