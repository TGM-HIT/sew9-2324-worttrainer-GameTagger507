package org.example;

import java.io.Serializable;
import java.net.MalformedURLException;
import java.net.URL;


/**
 * Diese Klasse ist der Grundbaustein eines Wortpaares.
 *
 * @author Emmanuel Akwaonu
 * @version 2023-10-18
 */
public class Wortpaar implements Serializable {
    private final String wort;
    private final URL bildUrl;

    //Konstruktor
    public Wortpaar(String wort, String bildUrl) {
        this.wort = wort;
        try {
            this.bildUrl = new URL(bildUrl);
        } catch (MalformedURLException e) {
            throw new RuntimeException("URL nicht valid");
        }
    }

    //Getter für die URL
    URL getBildUrl() {
        return this.bildUrl;
    }

    //Getter für das Wort
    String getWort() {
        return this.wort;
    }

}
